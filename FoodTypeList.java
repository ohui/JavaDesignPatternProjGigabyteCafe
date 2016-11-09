/*
 * The FoodTypeList class will hold information about the different types of 
 * food (Appetizer, Main Dish, Dessert) in an ArrayList. 
 */

import java.util.ArrayList;

public class FoodTypeList implements Container{
	ArrayList<String> ListOfFoodTypes; //stores the food types inside an ArrayList
	 
	/**
	 * This constructor initializes the ArrayList and
	 * adds the three food types that were given: 
	 * Appetizer, Main Dish, and Dessert. 
	 * @return FoodTypeList
	 */
	public FoodTypeList() {
		ListOfFoodTypes = new ArrayList<String>();
		addItem("Appetizer");	
		addItem("Main Dish");
		addItem("Dessert");
	}

	/**
	 * This method allows us to add more types to
	 * the ArrayList. 
	 * @param name
	 */
	public void addItem(String name){
		ListOfFoodTypes.add(name);
	}
  
	/**
	 * This method returns an Iterator to the 
	 * ArrayList to give us all the food types. 
	 * @param Iterator
	 */
	public Iterator createIterator() { 
		return new ArrayListIterator(ListOfFoodTypes);
	}
}
