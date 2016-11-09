/*
 * FoodFactory produces/returns either an Appetizer, MainDish, or 
 * Dessert type object. Depending on which one of these three the
 * user wants, we ask certain questions to create the object.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class FoodFactory implements MenuItemFactory {

	/**
	 * Based on the type in String food (Appetizer, Main Dish, Dessert), we will ask the user to 
	 * enter the rest of the details to create the food product
	 * @param String
	 * @return Food
	 */
	public Food getFood(String food) {
		//given a food type, we ask the questions to fill out the required data 
		//to create the final concrete object
		
		Scanner inputScanner = new Scanner(System.in);	//Get scanner ready for user input
		String name;	//store the name
		int calCount;	//store the calorie count
		double price;	//store the price
		ArrayList<String> ingredList = new ArrayList<String>();	//Array list to store all the ingredients
		String sideDish;	//store side dish for Main Dish types
		String appDescription;	//store appetizer description for desserts
		int i = 1;	//increases to get the number of ingredients
		boolean keepGoing = true;	//keep looping to ask the user something until we get valid input
		String ingredient;	//Store the ingredient
		System.out.println();
		
		if (food.equals("Appetizer")){
			//If we're adding an Appetizer to the menu...
			
			System.out.println("Please enter information below for the Appetizer.");
			System.out.print("Enter Name: ");
			name = inputScanner.nextLine();
			
			while (keepGoing) {
				System.out.print("Enter Ingredient #" + i + ": (0 to quit) ");
				ingredient = inputScanner.nextLine();
				if (ingredient.equals("0")) {
					break;
				}
				ingredList.add(ingredient);
				i++;
			}
			System.out.print("Enter Calorie Count: ");
			calCount = Integer.parseInt(inputScanner.nextLine());
			System.out.print("Enter Price: ");
			price = Double.parseDouble(inputScanner.nextLine()) ;
			System.out.println(name+ " has been added to the Food Menu. Thank you.");
			return new Appetizer(name, ingredList, calCount, price);
			
		} else if (food.equals("Main Dish")){
			//If we're adding in a new Main Dish...
			
			System.out.println("Please enter information below for the Main Dish.");
			System.out.print("Enter Name: "); 
			name = inputScanner.nextLine();

			while (keepGoing) {
				//add ingredients to list as user types them
				
				System.out.print("Enter Ingredient #" + i + ": (0 to quit) ");
				ingredient = inputScanner.nextLine();
				if (ingredient.equals("0")) {
					//user has entered all the ingredients
					break;
				}
				ingredList.add(ingredient);
				i++;
			}

			System.out.print("Enter Side Dish: ");
			sideDish = inputScanner.nextLine();
			System.out.print("Enter Calorie Count: ");
			calCount = Integer.parseInt(inputScanner.nextLine());
			System.out.print("Enter Price: ");
			price = Double.parseDouble(inputScanner.nextLine());
			System.out.println("Main Dish \"" +name+ "\" has been added to the Food Menu. Thank you.");
			return new MainDish(name, ingredList, sideDish, calCount, price);
			
			
		}else if (food.equals("Dessert")){
			//If we want to add a Dessert...
			
			System.out.println("Please enter information below for the Dessert.");
			System.out.print("Enter Name: ");
			name = inputScanner.nextLine();
			System.out.print("Enter Appetizer Description: ");
			appDescription = inputScanner.nextLine();
			System.out.print("Enter Calorie Count: ");
			calCount = Integer.parseInt(inputScanner.nextLine());
			System.out.print("Enter Price: ");
			price = Double.parseDouble(inputScanner.nextLine()) ;
			System.out.println("Dessert \""+name+ "\" has been added to the Food Menu. Thank you.");
			return new Dessert(name,appDescription, calCount, price);
		} else {
			System.out.println("System Error. Cannot Create Item.");
		}
		return null;
	}

	
	/**
	 * The FoodFactory should not produce any Beverage products so we return a null 
	 * @param String
	 * @return null
	 */
	public Beverage getBeverage(String beverage) {
		return null;
	}

}
