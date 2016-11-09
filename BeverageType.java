/*
 * This is the abstract BeverageType superclass. It's abstract because
 * there will be no need to instantiate objects off this class.
 * This class contains all the common variables and methods
 * that will be used across all beverage objects. 
 * Soda and LongDrink class inherits from this superclass.  
 */

import java.text.NumberFormat;
import java.util.Scanner;

public abstract class BeverageType {
	String type;	//specifies the type the object is. Either appetizer, main dish, or dessert
	String name;	//name of food
	double price;	//price of food
	NumberFormat formatter = NumberFormat.getCurrencyInstance();
	int userInputNum;	//used to store user input where number is expect
	String userIntputStr;	//used to store user input where a string is expected
	Scanner inputScanner = new Scanner(System.in);	//scan in user input
	
	/**
	 * This returns a String to say what type of Beverage it is
	 * @return String
	 */
	public String getType() {
		return type;
	}

	/**
	 * This allows us to change the type if we have to
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * This method returns a string with the name of the beverage
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method sets the name of our beverage
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method returns the price of our beverage 
	 * @return double
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Once we're passed in the price, we can change
	 * the price of beverage 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
}
