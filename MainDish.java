/*
 * Main Dish class. It has name, ingredient list, calorie count, side dish and price. 
 * It inherits the common variables and methods from FoodType superclass. 
 */

import java.util.ArrayList;

public class MainDish extends FoodType implements Food{
	
	private ArrayList<String> ingredList= new ArrayList<String>(); //stores the ingredients to make the main dish
	String sideDish; //stores a side dish
	
	/**
	 * This constructor creates the Main Dish object that will be added into the
	 * Food Menu once we are given the name, ingredient list, side dish, calorie
	 * count and price
	 * 
	 * @param name
	 * @param ingredList
	 * @param sideDish
	 * @param calCount
	 * @param price
	 * 
	 * @return MainDish
	 */
	public MainDish (String name, ArrayList<String> ingredList, String sideDish,  int calCount, double price){
		type = "Main Dish";
		this.name = name;
		this.ingredList = ingredList;
		this.calCount = calCount;
		this.sideDish  = sideDish;
		this.price  = price;
	}
	
	/**
	 * This method returns the Main Dish's ingredient list
	 * in an ArrayList object. 
	 * 
	 * @return ArrayList<String> 
	 */
	public ArrayList<String> getIngredList(){
		return ingredList;
	}
	
	/**
	 * This method allows us to change the ingredient list
	 * of the Main Dish with the new ingredList passed in. 
	 *  
	 * @param ingredList
	 */
	public void setIngredList(ArrayList<String> ingredList) {
		this.ingredList = ingredList;
	}
	
	/**
	 * This method returns the name of the side dish that
	 * comes with the Main Dish.   
	 * 
	 * @return String
	 */
	public String getSideDish() {
		return sideDish;
	}

	/**
	 * This method changes the side dish's name of the 
	 * Main Dish. 
	 * 
	 * @param sideDish
	 */
	public void setSideDish(String sideDish) {
		this.sideDish = sideDish;
	}
	
	/**
	 * This method asks the user for the Main Dish's 
	 * ingredient List and stores it in an ArrayList 
	 * which is later returned. 
	 * 
	 * @return ArrayList<String>
	 */
	public ArrayList<String> askForNewIngredList(){
		
		String ingredient; 
		ArrayList<String> newIngredList = new ArrayList<String>();
		int i =1; 

		boolean keepGoing = true; 
		while (keepGoing) {
			//User enters the ingredients until 0 is entered
			
			System.out.print("Enter Ingredient #" + i + ": (0 to quit) ");
			ingredient = inputScanner.nextLine();
			if (ingredient.equals("0")) {
				//If 0 is entered, then we have all the ingredients, quit
				break;
			}
			newIngredList.add(ingredient);
			i++;
			
		}
		return newIngredList; 
	}

	/**
	 * This method displays all the information of the 
	 * Main Dish. One example is...
	 * 
	 * Main Dish
	 * Name: <Name>
	 * Ingredients: 1) <Ingredient 1  2) <Ingredient 2>  
	 * Side Dish <Side Dish>
	 * Calorie Count: 1234
	 * Price: $10.00
	 * 
	 * @return ArrayList<String>
	 */
	public void display() {
		
		System.out.println("Main Dish");
		System.out.println("Name: "+ name);
		System.out.print("Ingredients: "); //Display the ingredients in a for loop
		for (int i =0; i < ingredList.size(); i++){
			System.out.print((i+1) + ") "+ingredList.get(i)+ "  ");
		}
		System.out.println("\nSide Dish "+ sideDish);
		System.out.println("Calorie Count: "+ calCount);
		System.out.println("Price: "+ formatter.format(price) + "\n");
	}
	
	/**
	 * This method asks the user for what properties should be changed
	 * about the Main Dish. One example is...
	 * 
	 * 0. Exit Editing
	 * 1. Edit Name: <Name>
	 * 2. Edit Ingredients: 1) <Ingredient 1   2) <Ingredient 2>   
	 * 3. Edit Side Dish: <Side Dish>4. Edit Calorie Count: 1234
	 * 5. Edit Price: $10.00
	 * 
	 */
	public void editItem(){
		
		System.out.println("0. Exit Editing");
		System.out.println("1. Edit Name: "+ name);
		System.out.print("2. Edit Ingredients: "); //Display the ingredients
		for (int i =0; i < ingredList.size(); i++){
			System.out.print((i+1) + ") "+ingredList.get(i)+ "   ");
		}
		System.out.println("\n3. Edit Side Dish: "+ getSideDish());
		System.out.println("4. Edit Calorie Count: "+ calCount);
		System.out.println("5. Edit Price: "+ formatter.format(price)+"\n");
		
		System.out.print("Please enter which option (0-5) that you would to do: ");
		
		userInputNum = Integer.parseInt(inputScanner.nextLine()); //scan in the user's choice
		System.out.println();
		switch (userInputNum){
		case 0: 
			//User wants to exit
			
			System.out.println("Exiting item edit section.");
			break; 
		case 1:
			//User want to change the name of the Main Dish
			
			System.out.println("Old Name: " + getName());
			System.out.print("Please enter new name: ");
			setName(inputScanner.nextLine());
			System.out.println("Name has been changed.");
			break;
		case 2:
			//User wants to change the ingredient list
			
			setIngredList(askForNewIngredList());
			System.out.println("Ingredient list has been changed.");
			break;
		case 3: 
			//User wants to change the side dish
			
			System.out.println("Old Side Dish: " + getSideDish());
			System.out.print("Please enter new side dish: ");
			setSideDish(inputScanner.nextLine());
			System.out.println("Side dish has been changed.");
			break; 
		case 4: 
			//User wants to edit the calorie count
			
			System.out.println("Old Calorie Count: " + getCalCount());
			System.out.print("Please enter new Calorie Count: ");
			setCalCount(Integer.parseInt(inputScanner.nextLine()));
			System.out.println("Calorie count has been changed.");
			break;
		case 5:
			System.out.println("Old Price: " + formatter.format(price));
			System.out.print("Please enter new Price: ");
			setPrice(Double.parseDouble(inputScanner.nextLine()));
			System.out.println("Price has been changed.");
			break; 
		default:
			System.out.println("Invalid Response. Exiting item edit section.");
			break; 
		}
	}
	
}
