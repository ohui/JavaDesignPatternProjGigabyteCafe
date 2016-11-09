/*
 * Long Drink class. It has a name, price, and ingredient list. 
 * It inherits the common variables and methods from BeverageType superclass.
 */

import java.util.ArrayList;

public class LongDrink extends BeverageType implements Beverage{
	
	ArrayList<String> ingredList = new ArrayList<String>();//stores the ingredients for our Long Drink
	
	/**
	 * This constructor creates the LongDrink object for us that 
	 * has the essential information about the long drink: 
	 * name, ingredient list, and the price. 
	 * 
	 * @param name
	 * @param ingredList
	 * @param price
	 */
	public LongDrink(String name, ArrayList<String> ingredList,double price){
		this.name = name;
		this.price = price;
		this.ingredList = ingredList;
		type = "Long Drink";
	}

	/**
	 * This method returns the ingredient list in 
	 * an ArrayList format. 
	 * 
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getIngredList() {
		return ingredList;
	}


	/**
	 * This method sets or updates the current ingredient list
	 * with the one that is passed in. 
	 * 
	 * @param ingredList
	 */
	public void setIngredList(ArrayList<String> ingredList) {
		this.ingredList = ingredList;
	}
	
	/**
	 * This method is about the same as when the user is 
	 * entering  the ingredient list for the first time.
	 * This list is then returned. 
	 * 
	 * @return ArrayList<String>
	 */
	public ArrayList<String> askForNewIngredList(){
		//
		
		boolean keepGoing = true; 
		String ingredient; 
		ArrayList<String> newIngredList = new ArrayList<String>();
		int i =1; 
		while (keepGoing) {
			//Keep asking the user for the ingredients until 0 is entered.
			
			System.out.print("Enter Ingredient #" + i + ": (0 to quit) ");
			ingredient = inputScanner.nextLine();
			if (ingredient.equals("0")) {
				//User has entered all the ingredients. Break.
				break;
			}
			newIngredList.add(ingredient);
			i++;
			
		}
		return newIngredList; 
	}

	/**
	 * This method displays all the information about the Long Drink.
	 * One example is...
	 * 
	 * Long Drink
	 * Name: <Name>
	 * Ingredients: 1) <Ingredient 1>  2) <Ingredient 2>  
	 * Price: $123.00
	 * 
	 */

	public void display() {
		//display all properties of the Long Drink 

		System.out.println("Long Drink");
		System.out.println("Name: "+ name);
		System.out.print("Ingredients: ");
		for (int i =0; i < ingredList.size(); i++){
			System.out.print((i+1) + ") "+ingredList.get(i)+ "  ");
		}
		System.out.println("\nPrice: "+ formatter.format(price)+"\n");
	}
	
	/**
	 * This method allows to user to update the information inside
	 * the long drink. We give them options and they can choose which
	 * property to edit. One example is...
	 * 
	 * 0. Exit Editing
	 * 1. Edit Name: <Name>
	 * 2. Edit Ingredients: 1) <Ingredient 1>   2) <Ingredient 2>   
	 * 3. Edit Price: $123.00
	 *
	 */

	public void editItem(){
		
		System.out.println("0. Exit Editing");
		System.out.println("1. Edit Name: "+ name);
		System.out.print("2. Edit Ingredients: ");
		for (int i =0; i < ingredList.size(); i++){ //Display all the ingredients in a for loop
			System.out.print((i+1) + ") "+ingredList.get(i)+ "   ");
		}
		System.out.println("\n3. Edit Price: "+ formatter.format(price)+"\n");
		
		System.out.print("Please enter which option (0-3) that you would to do: ");
		
		userInputNum = Integer.parseInt(inputScanner.nextLine()); //scan in the user's choice
		System.out.println();
		switch (userInputNum){
		case 0: 
			//User wants to edit
			
			System.out.println("Exiting item edit section.");
			break; 
		case 1:
			//User wants to edit the name
			
			System.out.println("Old Name: " + getName());
			System.out.print("Please enter new name: ");
			setName(inputScanner.nextLine());
			System.out.println("Name has been changed. ");
			break;
		case 2:
			//User wants to update the ingredients
			
			setIngredList(askForNewIngredList());
			System.out.println("Ingredient list has been chagned.");
			break;
		case 3: 
			//User wants to change the price 
			
			System.out.println("Old Price: " + formatter.format(price));
			System.out.print("Please enter new Price: ");
			setPrice(Double.parseDouble(inputScanner.nextLine()));
			System.out.println("Price has been changed");
			break; 
		default:
			System.out.println("Invalid Response. Exiting item edit section.");
			break; 
		}
	}
}
