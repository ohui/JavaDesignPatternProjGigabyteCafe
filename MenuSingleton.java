/*
 * This is our all important class that will have everything inside it. 
 */

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;


public class MenuSingleton {
	private static MenuSingleton uniqueInstance = new MenuSingleton(); //immediately create the instance
	FoodTypeList foodTypeList = new FoodTypeList();	//we store the food types here just like Appetizer, Main Dish, Dessert
	BeverageTypeList beverageList = new BeverageTypeList(); //store the beverage type which are soda and long drink 
	FoodMenu foodMenu= new FoodMenu(); //This is where we actually store the food objects the user added to the menu
	BeverageMenu beverageMenu = new BeverageMenu();	//Store the custom beverage object the user created
	MenuItemFactory foodFactory = new FoodFactory(); 	//Create the Food Factory to create our Food type objects
	MenuItemFactory beverageFactory = new BeverageFactory();	//Create the Beverage Factory to create our Beverage type objects
	NumberFormat formatter = NumberFormat.getCurrencyInstance();	//help format the price correctly
	OrderFactory orderFactory = new OrderFactory();	//produce out custom orders 
	ArrayList<CustomerOrder> listOfOrders = new ArrayList<CustomerOrder>(); //store the custom orders in an ArrayList
	int orderNumID= 1; //This is a unique ID that increments as we create more new orders. No two orders should have the same ID
	boolean keepGoing = true; //keep our loop going 
	String userInputStr; //store user input here
	Scanner inputScanner = new Scanner(System.in); 	//scan in the user input 	

	private MenuSingleton(){} //private so we can't instantiate a new singleton anywhere in our program
	
	public static MenuSingleton getInstance(){
		return uniqueInstance; 
	}
	
	/**
	 * The displayAllTypes() displays the food types and beverage types our menu items can handle.
	 * Here in our program we have 
	 * "Appetizer" "Main Dish" "Dessert" "Soda" "Long Drink"
	 */
	public void displayAllTypes(){
		
		
		Iterator beverageTypeIterator = beverageList.createIterator();
		Iterator foodTypeIterator = foodTypeList.createIterator();
		
		System.out.print("( ");
		while (foodTypeIterator.hasNext()) {
			String itemType = (String)foodTypeIterator.next();
			System.out.print("\"" + itemType + "\" ");
		}
		while (beverageTypeIterator.hasNext()) {
			String itemType = (String)beverageTypeIterator.next();
			System.out.print("\"" + itemType + "\" ");
		}
		System.out.print(") ");
	}//end displayAllTypes
	
	/**
	 * This method will check that the user has entered a type that 
	 * is a correct type such as Appetizer, Dessert, Soda, etc. and return 
	 * either a “Food” or “Beverage” string or null if user types in something incorrect.
	 * 
	 * @param type
	 * @return String
	 */
	public String isFoodOrBeverage (String type){
		//
		
		Iterator beverageTypeIterator = beverageList.createIterator();
		Iterator foodTypeIterator = foodTypeList.createIterator();
		
		while (foodTypeIterator.hasNext()) { //Iterate through the food types...
			String itemType = (String)foodTypeIterator.next();
			if (type.equals(itemType)){
				return "Food"; 
			}
		}
		while (beverageTypeIterator.hasNext()) { //Iterate through the bevearge types...
			String itemType = (String)beverageTypeIterator.next();
			if (type.equals(itemType)){
				return "Beverage"; 
			}
		}
		return "None"; 
	}//end isFoodOrBeverage
	
	/**
	 * This method is how we add items to the menu. We will first ask 
	 * if the item is a food or beverage. Afterwards 
	 * we get the required information and go to either foodFactory or
	 * beverageFactory to create the new menu item.
	 */
	public void createNewMenuItem(){

		
		boolean incorrectType = true; 
		String itemType = null;
		while(incorrectType){
			//Keep asking/looping until we do get the correct Type 
			System.out.println("\nWhat kind of item is it?");
			displayAllTypes();
			System.out.print("\nPlease enter one of the types above without the quotes: ");
			itemType = inputScanner.nextLine();
			String result = isFoodOrBeverage(itemType); //Find out if Type is either food or beverage
			
			if (result.equals("Food") ){
				Food newFood = foodFactory.getFood(itemType);
				addToFoodMenu(newFood);
				incorrectType = false;
			} else if (result.equals("Beverage")){
				Beverage newBeverage = beverageFactory.getBeverage(itemType);
				addToBeverageMenu(newBeverage);
				incorrectType = false;
			}else {
				//User input an incorrect type, display warning
				System.out.println("WARNING: Please enter a valid item type here.");
			}
		}
	}//end createNewMenuItem
	
	/**
	 * The displayCurrentMenus() method shows us what is stored in
	 * both the Food Menu and Beverage Menu using iterators 
	 */
	public void displayCurrentMenus(){
		
		if (!menuHasSomething()){
			return; 
		}
		
		Iterator foodMenuIterator = foodMenu.createIterator();
		Iterator beverageMenuIterator = beverageMenu.createIterator();
		
		int i =1;
		if (foodMenuIterator.hasNext()){
			System.out.println("\n========Food Menu========");
			while (foodMenuIterator.hasNext()) {
				Food food = (Food)foodMenuIterator.next();
				System.out.print(i+ ") "); food.display();
				i++;
			}
		}
		if (beverageMenuIterator.hasNext()){
			System.out.println("========Beverage Menu========");
			while (beverageMenuIterator.hasNext()) {
				Beverage beverage= (Beverage)beverageMenuIterator.next();
				System.out.print(i+ ") "); beverage.display();
				i++;
			}
		}
	}//end displayCurrentMenus
	
	/**
	 * This method allows us to add a food newItem to the Food Menu
	 * @param newItem
	 */
	public void addToFoodMenu(Food newItem){
		foodMenu.addItem(newItem);
	} 
	
	/**
	 * This method adds the newItem to the Beverage Menu
	 * @param newItem
	 */
	public void addToBeverageMenu(Beverage newItem){
		beverageMenu.addItem(newItem);
	}
	
	/**
	 * This method checks that there exist at least one item in either
	 * the food or beverage menu. Returns true if there's something
	 * or False if nothing was found. 
	 * @return boolean
	 */
	public boolean menuHasSomething(){
		
		if (foodMenu.size() == 0 && beverageMenu.size() == 0){
			System.out.println("Sorry. Menus are currently empty. Please try again later");
			return false;
		} else {
			return true;
		}
	}//end menuHasSomething
	
	/**
	 * This method first displays the current items on the Food and
	 * Beverage Menu and asks the user what he or she wants to order.
	 * If the user enters 0, then the user wishes to stop ordering. 
	 * An ArrayList is used to store these item names and is returned. 
	 * 
	 * @return ArrayList<String> 
	 */
	public ArrayList<String> startOrderingOffMenu(){
		
		System.out.println();
		ArrayList<String> orders = new ArrayList<String>();
		Iterator foodMenuIterator = foodMenu.createIterator();
		Iterator beverageMenuIterator = beverageMenu.createIterator();
		
		System.out.println("ID#    Item");
		System.out.println("---- --------------");
		
		int i =1;
		if (foodMenuIterator.hasNext()){
			while (foodMenuIterator.hasNext()) { //iterate through the food menu and display them
				Food food = (Food)foodMenuIterator.next();
				System.out.println("#"+i+ ") "+ food.getType()+ ": " + food.getName() +" "+ food.getPrice());
				i++;
			}
		}
		int j = i; 
		if (beverageMenuIterator.hasNext()){
			while (beverageMenuIterator.hasNext()) { //iterate through the beverage menu and display them
				Beverage beverage= (Beverage)beverageMenuIterator.next();
				System.out.println("#"+j+ ") "+ beverage.getType() + ": " + beverage.getName() + " " + beverage.getPrice()); 
				j++;
			}
		}
		
		double total =0.0; //this keeps track of our total cost as customer orders more
		
		while (true){
			System.out.print("\nPlease type the ID of item customer is ordering (0 to exit): ");
			int itemID = Integer.parseInt(inputScanner.nextLine());
			
			if (itemID == 0){
				//If the user enters 0, then he/she wants to stop ordering. 
				//Break. and display the items ordered along with the cost
				
				System.out.println("\nSummary \nOrder ID# "+ orderNumID); 
				i = 1; 
				System.out.println("----------------");
				for (String s2: orders){
					System.out.println(i+ ") "+s2 + " ");
					i++;
				}
				System.out.println("Order total is "+ formatter.format(total)); //This displays the total cost
				break;
				
			} else {
				//If the user hasn't entered 0 yet...
				
				if (itemID > (foodMenu.size() + beverageMenu.size()) || itemID<0 ){
					//user entered an item ID too big or a negative value
					//Display warning.
					System.out.println("Item ID is out of bounds.");
					
				} else {
					//user entered valid number 
					
					if (itemID <= foodMenu.size() && (foodMenu.size()!=0)){
						//calculate the offset to get the correct food name off the food Menu
						
						Food food = foodMenu.getFoodAtIndex(itemID-1); 
						orders.add(food.getName()); 
						total += food.getPrice(); //Calculate the total 
						
					} else {
						//Below if-else statement calculates the offset
						//to get the beverage item off the beverage menu. 
			
						if (foodMenu.size()==0){
							itemID--; 
						}else {
							itemID = itemID - foodMenu.size()-1; 
						}
						
						Beverage beverage = beverageMenu.getBeverageAtIndex(itemID);
						orders.add(beverage.getName());
						total +=beverage.getPrice();
					}
					System.out.print("Items Ordered so far: "); 
					boolean firstItem = true; 
					
					for (String s: orders){
						if (firstItem){
							firstItem = false;
							System.out.print(s); //displays all the items ordered so far...
							continue; 
						}
						System.out.print(", "+ s);
					}
					System.out.println("\nCurrent total is "+ formatter.format(total)); //Shows the current total 
				}
			}
		}
		String totalStr = Double.toString(total); 	//Used to store the total (of type double) as a String
													//We will extract and remove this total afterwards
		orders.add(totalStr);
		return orders; 
	}//end startOrdering
	
	/**
	 * The method createNewOrder() is exactly what it sounds. The user will 
	 * be asked if this is a normal order or delivery type order. Afterwards, 
	 * we call startOrderingOffMenu() to get the ArrayList of items names ordered.
	 * If it's a delivery type order, then we ask for the address and phone number after.
	 */
	public void createNewOrder(){
		
		System.out.println();
		ArrayList<String> orderInfo;
		String orderType= null;
		double total; 
		if ((foodMenu.size()==0) && (beverageMenu.size()==0)){
			System.out.println("Sorry. No items to display. Please add something first before creating an order.");
			return;
		}
		
		keepGoing = true;
		while(keepGoing){
			System.out.print("What type of Order is this? (\"Delivery\" or \"Normal\" without the quotes): ");
			orderType = inputScanner.nextLine();
			if (orderType.equals("Normal") || orderType.equals("Delivery") ){
				break;
			} else {
				System.out.println("Please enter a valid order type.");
			}
		}
			if (orderType.equals("Normal")){
				CustomerOrder normalOrder = orderFactory.getCustomerOrder("Normal");
				orderInfo = startOrderingOffMenu();
				total = Double.parseDouble(orderInfo.get(orderInfo.size()-1));
				if (total == 0.0){
					System.out.println("Warning: Cannot add blank order. Returing to Main Menu.");
				} else {
					normalOrder.setTotal(total);
					orderInfo.remove(orderInfo.size()-1);
					normalOrder.setListOfItems(orderInfo);
					normalOrder.setNumID(orderNumID++);
					listOfOrders.add(normalOrder);
				}
			} else{
				CustomerOrder deliveryOrder = orderFactory.getCustomerOrder("Delivery");
				orderInfo = startOrderingOffMenu();
				total = Double.parseDouble(orderInfo.get(orderInfo.size()-1));
				if (total == 0.0){
					System.out.println("Warning: Cannot add blank order. Returing to Main Menu.");
				} else {
					deliveryOrder.setTotal(total);
					orderInfo.remove(orderInfo.size()-1);
					deliveryOrder.setListOfItems(orderInfo);
					deliveryOrder.setNumID(orderNumID++);
					System.out.println();
					System.out.print("What is the address?: ");
					String address = inputScanner.nextLine();
					System.out.print("What is a reachable phone number?: ");
					String phoneNumber = inputScanner.nextLine();
					((DeliveryOrder)deliveryOrder).setAddress(address);			//Dynamic Binding
					((DeliveryOrder)deliveryOrder).setPhoneNumber(phoneNumber);
					listOfOrders.add(deliveryOrder);
				}
			}
		System.out.println("Order has been added.");
	}//end createNewOrder
	
	
	/**
	 * We call displayAllOrders() which displays all the 
	 * orders currently in the listOfOrders arrayList. 
	 * 
	 * An example is...
	 * 
	 * ========Current Orders========
	 * ID# 1	Total: $11.50	Items Ordered: Pizza, Pepsi, Pepsi
	 * ID# 2	Total: $11.50	Items Ordered: Cheesecake, Sprite
	 */
	public void displayAllOrders(){
		
		if (listOfOrders.size()==0){
			System.out.println("There are currently no orders in the system. ");
			System.out.println("Returning to Main Menu...");
			return;
		}
		
		System.out.println("\n========Current Orders========");
		
		for (int i =0; i < listOfOrders.size(); i++){
			System.out.print("ID# "+ listOfOrders.get(i).getNumID() + "\tTotal: "+ formatter.format(listOfOrders.get(i).getTotal()) + "\tItems Ordered: " );
			listOfOrders.get(i).displayItemsOrdered(); 
			if ((listOfOrders.get(i).getType()).equals("Delivery")){
				System.out.print ("         Phone Number: "+((DeliveryOrder)listOfOrders.get(i)).getPhoneNumber());
				System.out.print ("  Address: "+((DeliveryOrder)listOfOrders.get(i)).getAddress());
			}
			System.out.println();
		}
	}//end displayAllOrders

	
	/**
	 * This method displays all the items that are currently on the Food and Beverage menu. 
	 * The user is asked to type in the number id to select the one that will be deleted. 
	 */
	public void deleteMenuItem(){
		
		if (!menuHasSomething()){
			System.out.println("Returning to Main Menu...");
			return;
		}
		displayCurrentMenus();
		
		System.out.print("Enter the item ID (top left of each item) you want to delete (0 to quit): ");
		
		int itemID = Integer.parseInt(inputScanner.nextLine());
		
		if (itemID == 0){
			System.out.println("No deletion was made. Returning...");
			return; 
		}
		
		if (itemID > (foodMenu.size() + beverageMenu.size()) || itemID <0 || itemID < 0){
			System.out.println("ID is out of bounds. Please try again later.");
			return; 
		}
		
		if (itemID <= (foodMenu.size()) && (foodMenu.size()!=0)){
			
			System.out.print("Are you sure you want to delete \""+ foodMenu.getFoodAtIndex(itemID-1).getName() + "\"? Y for Yes, N for No: ");
			userInputStr = inputScanner.nextLine(); 
			
			if (userInputStr.equals("Y")){
				foodMenu.deleteItem(itemID-1);
				System.out.println("Item has been deleted.");
				return;
			} else if (userInputStr.equals("N")){
				System.out.println("Deletion skipped.");
				return;
			} else {
				System.out.println("Please enter a valid answer. \"Y\" or \"N\" without quotes. Returning to Main Menu.");
				return;
			}
			
		} else {
			if (foodMenu.size()==0){
				itemID--; 
			}else {
				itemID = itemID - foodMenu.size()-1;
			}
			
			System.out.print("Are you sure you want to delete \""+ beverageMenu.getBeverageAtIndex(itemID).getName() + "\"? Y for Yes, N for No: ");
			userInputStr = inputScanner.nextLine(); 
			
			if (userInputStr.equals("Y")){
				beverageMenu.deleteItem(itemID);
				System.out.println("Item has been deleted.");
				return;
			} else if (userInputStr.equals("N")){
				System.out.println("Deletion skipped.");
				return;
			} else {
				System.out.println("Please enter a valid answer. \"Y\" or \"N\" without quotes. Returning to Main Menu.");
				return;
			}
		}
	}//end deleteMenuItem
	
	/**
	 * This method lists all the orders with their order information and unique ID’s. 
	 * Then the user is asked to enter the ID and we remove that order from the list
	 * if it is valid. 
	 */
	public void deleteOrder(){
		
		if (listOfOrders.size()==0){
			//There are no orders in the list
			
			System.out.println("There are currently no orders in the system. ");
			System.out.println("Returning to Main Menu...");
			return; 
		}
		
		System.out.println("\n Current Orders still in the system\n-----------------------------");
		displayAllOrders();
		System.out.print("Enter the Order ID (very left) you want to delete (0 to exit): ");
		
		int numID = Integer.parseInt(inputScanner.nextLine());
		
		if (numID == 0){
			//User wants to exit 
			System.out.println("No deletion was made. Returning...");
			return; 
		}
		
		if (numID > orderNumID || numID < 0){
			//User type an invalid ID
			System.out.println("ID is out of bounds. Please try again later.");
			return; 
		}
		
		for (int i =0; i < listOfOrders.size(); i++){
			if (numID == listOfOrders.get(i).getNumID()){ 
				System.out.print("Are you sure you want to delete Order ID# "+ numID + " ? Y for Yes, N for No: ");
				//We want to confirm before deleting the order out of the list.
				//There is no way to get it back. 
				
				userInputStr = inputScanner.nextLine(); 
				
				if (userInputStr.equals("Y")){
					listOfOrders.remove(i);
					System.out.println("ID# "+ numID + " has been deleted.");
					return;
				} else if (userInputStr.equals("N")){
					System.out.println("Deletion skipped.");
					return;
				} else {
					System.out.println("Please enter a valid answer. \"Y\" or \"N\" without quotes. Returning to Main Menu.");
					return;
				}
			}
		}
		System.out.println("Could not find ID. Please try again later.");
	}//end deleteOrder
	
	
	/**
	 * This method starts by displaying all the orders currently in the 
	 * system and asking the user for a specific ID of an existing order to edit.
	 * We call findOrderByIndex() to find that customer order. We will return to the
	 * main menu if the number ID entered is invalid.
	 */
	public void editAnOrder(){
		
		if (listOfOrders.size()==0){
			//There are no orders on the list.
			
			System.out.println("There are currently no orders in the system. ");
			System.out.println("Returning to Main Menu...");
			return; 
		}
		System.out.println("\nOrders you can edit");
		System.out.println("=======================");
		displayAllOrders(); 
		
		System.out.print("\nPlease enter the ID number(very left) of order you want to edit (0 to exit): ");
		
		int orderID = Integer.parseInt(inputScanner.nextLine());
		if (orderID == 0){
			System.out.println("No edit was made. Returning...");
			return; 
		}
		if (orderID < 0){
			System.out.println("Invalid ID. No edit was made. Returning...");
			return; 
		}
		
		CustomerOrder targetOrder;
		targetOrder = findOrderByID(orderID);
		
		if (targetOrder!=null){
			ArrayList<String> orderInfo; 
			
			if (targetOrder.getType().equals("Normal")){
				//Restart ordering items off the menu for the normal order
				//and this new list of items will replace that normal order
				
				System.out.println("\nReordering....");
				orderInfo = startOrderingOffMenu();
				double total = Double.parseDouble(orderInfo.get(orderInfo.size()-1));
				targetOrder.setTotal(total);
				orderInfo.remove(orderInfo.size()-1);
				targetOrder.setListOfItems(orderInfo);
				
			} else {
				//Show options for editing delivery order
				
				String address = ((DeliveryOrder)targetOrder).getAddress();
				String phoneNumber = ((DeliveryOrder)targetOrder).getPhoneNumber(); 
				System.out.println("\nWhat would you like to edit?");
				System.out.println("0) Exit ");
				System.out.println("1) Edit Items ordered ");
				System.out.println("2) Edit Address: " + address);
				System.out.println("3) Edit Phone Number: "+ phoneNumber);
				System.out.print("Please enter which option (0-3) that you would to do: ");
				int userInputInt= Integer.parseInt(inputScanner.nextLine());
				switch (userInputInt){
				case 0:
					//User wants to exit
					System.out.println("No changes were made. Returning...");
					break;
				case 1:
					//User wants to reorder the items 
					
					System.out.println("\nReordering....");
					orderInfo = startOrderingOffMenu();
					double total = Double.parseDouble(orderInfo.get(orderInfo.size()-1));
					targetOrder.setTotal(total);
					orderInfo.remove(orderInfo.size()-1);
					targetOrder.setListOfItems(orderInfo);
					break; 
				case 2:
					//User wants to edit the address
					System.out.println("Old Address: "+ address);
					System.out.print("Please enter the new address: ");
					((DeliveryOrder)targetOrder).setAddress(inputScanner.nextLine()); 
					break; 
				case 3:
					//User wants to edit the phone number
					
					System.out.println("Old Phone Number: "+ phoneNumber);
					System.out.print("Please enter the new Phone Number: ");
					((DeliveryOrder)targetOrder).setPhoneNumber(inputScanner.nextLine());
					break; 
				default:
					System.out.println("Invalid response. Returing to Main Menu...");
					break; 
				}
			}
			System.out.println("Order has been updated.");
			
		} else {
			System.out.println("Unable to find order. Please try again later. Returning to Main Menu...");
		}
	}//end editAnOrder
	
	/**
	 * This method returns a customer order when a target ID is
	 * passed it. If it is invalid, then null is returned. 
	 * 
	 * @param targetID
	 * @return CustomerOrder
	 */
	public CustomerOrder findOrderByID(int targetID){
		//Because each order has a unique ID, we can pass in the ID and return the customerOrder object
		
		CustomerOrder result = null;
		for (int i =0; i < listOfOrders.size(); i++){
			if (listOfOrders.get(i).getNumID()==targetID){
				result = listOfOrders.get(i); 
				break;
			}
		}
		return result; 
	}//end CustomerOrder
	
	/**
	 * The enableEditMenu() allows us to edit menu items. We display all 
	 * the items on the menu and ask the user the id of the item on the 
	 * menu to edit. We find the menu item and call the editItem() on that object. 
	 */
	public void enableEditMenu(){
		
		if (!menuHasSomething()){
			System.out.println("Returning to Main Menu...");
			return;
		}

		Iterator foodMenuIterator = foodMenu.createIterator(); 	//create the iterators...
		Iterator beverageMenuIterator = beverageMenu.createIterator(); 
		
		System.out.println("\nID  Item");
		System.out.println("---  --------------");
		
		int i =1;
		if (foodMenuIterator.hasNext()){
			while (foodMenuIterator.hasNext()) { //use the iterators to iterate through all the food items
				Food food = (Food)foodMenuIterator.next();
				System.out.println("#"+i+ ") "+ food.getType()+ ": " + food.getName() +"  "+formatter.format(food.getPrice()) );
				i++;
			}
		}
		int j = i; 
		if (beverageMenuIterator.hasNext()){ //use the iterators to iterate through all the beverage items
			while (beverageMenuIterator.hasNext()) {
				Beverage beverage= (Beverage)beverageMenuIterator.next();
				System.out.println("#"+j+ ") "+ beverage.getType() + ": " + beverage.getName()  +"  "+ formatter.format(beverage.getPrice()) ); 
				j++;
			}
		}
		
		System.out.print("\nPlease enter the ID number(very left) of item you want to edit (0 to exit): ");
		
		int itemID = Integer.parseInt(inputScanner.nextLine());
		
		if (itemID == 0){
			//user wants to exit here
			System.out.println("No edit was made. Returning...");
			return; 
		}
		
		if (itemID > (foodMenu.size() + beverageMenu.size()) || itemID < 0 ){
			//user entered something invalid
			System.out.println("ID is out of bounds. Please try again later.");
			return; 
		}
		
		System.out.println("\nEditing Section");
		System.out.println("=====================");
		
		if (itemID <= (foodMenu.size()) && (foodMenu.size()!=0)){
			//Calculate the offset to get the Food off the Food Menu
			foodMenu.getFoodAtIndex(itemID-1).editItem();
		} else {
			//Calculate the offset to get the Beverage off the Beverage Menu
			if (foodMenu.size()==0){
				itemID--; 
			}else {
				itemID = itemID - foodMenu.size()-1;
			}
			beverageMenu.getBeverageAtIndex(itemID).editItem();
		}
	}//end enableEditMenu
	
}
