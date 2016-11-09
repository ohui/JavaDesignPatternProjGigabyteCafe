/*
 * The BeverageMenuIterator implements the methods of the Iterator interface. 
 * The constructor takes in the ArrayList from the client, the BeverageMenu Class. Then 
 * it'll store that ArrayList inside the ArrayList variable beverageList. 
 */

import java.util.ArrayList;

public class BeverageMenuIterator implements Iterator{

	private ArrayList<Beverage> beverageList; //store the beverages in the ArrayList
	int position = 0; //store current position in arrayList 
	
	/**
	 * This is our constructor that sets the object's ArrayList to
	 * the one passed in, bevergaeList
	 * @param beverageList
	 */
	public BeverageMenuIterator(ArrayList<Beverage> beverageList){
		this.beverageList = beverageList; 
	}

	/**
	 * This method returns a Beverage object of where we are at 
	 * in the ArrayList
	 * @return Beverage
	 */
	public Beverage next() {
		//returns the beverage object
		Beverage beverageItem = beverageList.get(position);
		position = position + 1;
		return beverageItem;
	}
 
	/**
	 * This returns true or false if there is a next object
	 * @return boolean
	 */
	public boolean hasNext() {
		//checks if there is an object after the current one
		if (position >= beverageList.size()) {
			return false;
		} else {
			return true;
		}
	}
	
}
