/*
 * The FoodMenuIterator implements the methods of the Iterator interface. 
 * The constructor takes in the ArrayList from the client, the FoodMenu Class. Then 
 * it'll store that ArrayList inside the ArrayList variable foodMenu. 
 */

import java.util.ArrayList;

public class FoodMenuIterator implements Iterator{
	private ArrayList<Food> foodMenu; //how we store our food
	int position = 0; //stores the current position of where we are in the ArrayList
	
	/**
	 * This constructor points to the ArrayList that is 
	 * passed in and returns the FoodMenu object
	 * @param foodMenu
	 */
	public FoodMenuIterator(ArrayList<Food> foodMenu){
		this.foodMenu = foodMenu; 
	}

	/**
	 * This method returns a Food object of where we are at 
	 * in the ArrayList
	 * @return Food
	 */
	public Food next() {
		Food food = foodMenu.get(position);
		position = position + 1;
		return food;
	}

	/**
	 * This returns true or false if there is more food 
	 * in the ArrayList
	 * @return boolean
	 */
	public boolean hasNext() {
		if (position >= foodMenu.size()) {
			return false;
		} else {
			return true;
		}
	}
	
}
