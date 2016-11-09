/*
 * Appetizer Class. It has name, ingredient list, calorie count, and price. 
 * It inherits the common variables and methods from FoodType superclass. 
 */

import java.util.ArrayList;


public class Appetizer extends FoodType implements Food {
	
	private ArrayList<String> ingredList = new ArrayList<String>(); //stores the ingredients to make the appetizer
	
	/**
	 * This is the constructor that takes in the name, ingredient list, calorie count and price
	 * and creates the Appetizer object. 
	 * 
	 * @param name
	 * @param ingredList
	 * @param calCount
	 * @param price
	 */
	public Appetizer (String name, ArrayList<String> ingredList, int calCount, double price){
		this.name = name;
		this.ingredList = ingredList;
		this.calCount = calCount;
		this.price  = price;
		type = "Appetizer";
	}
	
	/**
	 * Returns the ingredient list 
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getIngredList() {
		//returns the ingredient list
		return ingredList;
	}

	/**
	 * Sets or changes the ingredient list 
	 * @param ArrayList<String>
	 */
	public void setIngredList(ArrayList<String> ingredList) {
		this.ingredList = ingredList;
	}

	/**
	 * Displays all the properties of the appetizer
	 * It'll look something like ...
	 * 
	 * Appetizer
	 * Name: <Name>
	 * Ingredients: 1) <Ingredient1>  2) <Ingredient2>  
	 * Calorie Count: 10
	 * Price: $10.00
	 */
	public void display() {
		
		System.out.println("Appetizer");
		System.out.println("Name: "+ name);
		System.out.print("Ingredients: ");
		for (int i =0; i < ingredList.size(); i++){
			System.out.print((i+1) + ") "+ingredList.get(i)+ "  ");
		}
		System.out.println("\nCalorie Count: "+ calCount);
		System.out.println("Price: "+ formatter.format(price)+"\n");
	}
	
	/**
	 * Same as setting up the ingredient list for the first time 
	 * when creating item. We ask the user to input the new ingredient
	 *  list This will get passed in to setIngredList inside editItem()
	 * @return ArrayList<String> 
	 */
	public ArrayList<String> askForNewIngredList(){
		
		String ingredient; 
		ArrayList<String> newIngredList = new ArrayList<String>();
		int i =1; 

		boolean keepGoing = true; 
		while (keepGoing) {
			//keep asking for ingredient
			
			System.out.print("Enter Ingredient #" + i + ": (0 to quit) ");
			ingredient = inputScanner.nextLine();
			if (ingredient.equals("0")) {
				//if user types 0, then quit
				break;
			}
			newIngredList.add(ingredient);
			i++;
		}
		return newIngredList; 
	}
	
	/**
	 * Display the options to edit and see which property use wants to edit
	 * It'll display something like...
	 * 
	 * 0. Exit Editing
	 * 1. Edit Name: <Name>
	 * 2. Edit Ingredients: 1) <Ingredient1>   2) <Ingredient2>   
	 * 3. Edit Calorie Count: 10
	 * 4. Edit Price: $10.00
	 */
	public void editItem(){
		
		System.out.println("0. Exit Editing");
		System.out.println("1. Edit Name: "+ name);
		System.out.print("2. Edit Ingredients: ");
		for (int i =0; i < ingredList.size(); i++){
			System.out.print((i+1) + ") "+ingredList.get(i)+ "   ");
		}
		System.out.println("\n3. Edit Calorie Count: "+ calCount);
		System.out.println("4. Edit Price: "+ formatter.format(price)+"\n");
		
		System.out.print("Please enter which option (0-4) that you would to do: ");
		
		userInputNum = Integer.parseInt(inputScanner.nextLine()); //scan in the user's choice
		System.out.println();
		switch (userInputNum){
		case 0: 
			//user wants to exit
			
			System.out.println("Exiting item edit section.");
			break; 
		case 1: 
			//Edit the name
			
			System.out.println("Old Name: " + getName());
			System.out.print("Please enter new name: ");
			setName(inputScanner.nextLine());
			System.out.println("Name has been changed. ");
			break;
		case 2:
			//Replace the ingredient list
			
			setIngredList(askForNewIngredList());
			System.out.println("Ingredient list has been changed. ");
			break;
		case 3: 
			//Change the calorie count
			
			System.out.println("Old Calorie Count: " + getCalCount());
			System.out.print("Please enter new Calorie Count: ");
			setCalCount(Integer.parseInt(inputScanner.nextLine()));
			System.out.println("Calorie count has been changed.");
			break;
		case 4: 
			//Change the price
			
			System.out.println("Old Price: " + formatter.format(price));
			System.out.print("Please enter new Price: ");
			setPrice(Double.parseDouble(inputScanner.nextLine()));
			System.out.println("Price has been changed. ");
			break; 
		default:
			System.out.println("Invalid Response. Exiting item edit section.");
			break; 
		}
	}
}
