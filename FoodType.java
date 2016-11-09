/*
 * This is the FoodType superclass that is abstract 
 * because we won't need objects based off this class. 
 * This class contains all the common variables and methods
 * that will be used across all food objects. 
 * Appetizer, MainDish, and Dessert class inherits from this class. 
 */

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;


public abstract class FoodType {
	String type;	//specifies the type the object is. Either appetizer, main dish, or dessert
	String name;	//name of food
	int calCount;	//calorie count
	double price;	//price of food
	NumberFormat formatter = NumberFormat.getCurrencyInstance();
	int userInputNum;	//used to store user input where number is expect
	String userIntputStr;	//used to store user input where a string is expected
	Scanner inputScanner = new Scanner(System.in);	//scan in user input
	
	/**
	 * This returns what type of food it is
	 * (Main Dish, Appetizer, Dessert) 
	 * @return String
	 */
	public String getType() {
		return type;
	}

	/**
	 * This method allows us to change the type of
	 * food it is. 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * This method returns the name of the food. 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method takes in the string name and 
	 * replaces the food's name with it.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method returns the calorie 
	 * count of the food. 
	 * @return int
	 */
	public int getCalCount() {
		return calCount;
	}

	/**
	 * This method updates the calorie count of 
	 * the food. 
	 * @param calCount
	 */
	public void setCalCount(int calCount) {
		this.calCount = calCount;
	}

	/**
	 * This method returns the price of the 
	 * food item. 
	 * @return double
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * This method updates the price of the food
	 * item. 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
}
