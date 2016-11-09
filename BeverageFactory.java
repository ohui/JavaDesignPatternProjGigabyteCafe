/*
 * BeverageFactory produces/returns either a Soda or Long Drink 
 * class object. Depending on which one of these two the
 * user wants, we ask certain questions to create the object.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class BeverageFactory implements MenuItemFactory{
	
	
	
	/**
	 * The beverageFactory should not return any food type objects so we return a null
	 * @param String
	 * @return null
	 */
	public Food getFood(String food) {
		return null;
	}

	
	/**
	 * Based on the type in String beverage (Soda, Long Drink), we will ask the user to 
	 * enter the rest of the details to create the beverage objects
	 * @param String
	 * @return Beverage
	 */
	public Beverage getBeverage(String beverage) {
		
		
		Scanner inputScanner = new Scanner(System.in);	//Get scanner ready for user input
		String name;	//store the name
		int calCount;	//store the calorie count
		double price;	//store the price
		ArrayList<String> ingredList = new ArrayList<String>();	//Array list to store all the ingredients
		int i = 1;	//increases to get the number of ingredients
		boolean keepGoing = true;	//keep looping to ask the user something until we get valid input
		String ingredient;	//Store the ingredient
		
		if (beverage == null){
			return null;
		}
		System.out.println();
		if (beverage.equals("Soda")){
			//If we're adding a Soda to the menu...
			
			System.out.println("Please enter information below for the Soda.");
			System.out.print("Enter Name: ");	
			name = inputScanner.nextLine();
			System.out.print("Enter Calorie Count: ");
			calCount = Integer.parseInt(inputScanner.nextLine());
			System.out.print("Enter Price: ");
			price = Double.parseDouble(inputScanner.nextLine()) ;
			System.out.println("Soda "+ "\"" + name +"\""+ " has been added to the Beverage Menu. Thank you.");
			return new Soda(name, calCount, price);
			
		} else if (beverage.equals("Long Drink")){
			//If we're add a Long Drink to the menu...
			
			System.out.println("Please enter information below for the Long Drink.");
			System.out.print("Enter Name: ");
			name = inputScanner.nextLine();
			while (keepGoing) {
				//Store each ingredient into the ArrayList
				
				System.out.print("Enter Ingredient #" + i + ": (0 to quit) ");
				ingredient = inputScanner.nextLine();
				if (ingredient.equals("0")) {
					//User has entered all the ingredients, so quit
					break;
				}
				ingredList.add(ingredient);
				i++;
			}
			System.out.print("Enter Price: ");
			price = Double.parseDouble(inputScanner.nextLine()) ;
			System.out.println("Long Drink "+ "\"" + name +"\""+ " has been added to the Beverage Menu. Thank you.");
			return new LongDrink(name, ingredList, price);
		}
		return null;
	}
}
