/*
 * The BeverageMenu class is what actually holds the Beverage objects when the user inputs 
 * food to our menu that the customer can order. It will store them in an ArrayList. 
 */

import java.util.ArrayList;

public class BeverageMenu implements Container{
	
	ArrayList<Beverage> beverageMenu; //store the beverage items in an ArrayList
	
	/**
	 * returns the size of the menu so far
	 * @return int
	 */
	public int size(){
		
		return beverageMenu.size();
	}
	 
	/**
	 * Our constructor initialize ArrayList
	 * @return BeverageMenu
	 */
	public BeverageMenu() {
		beverageMenu = new ArrayList<Beverage>();
	}

	/**
	 * This method allows us to add a beverage to the ArrayList
	 * @param name
	 */
	public void addItem(Beverage name)
	{
		//add to the ArrayList
		beverageMenu.add(name);
	}
	
	/**
	 * This method returns a beverage object at an index of ArrayList
	 * @param index
	 * @return Beverage
	 */
	public Beverage getBeverageAtIndex(int index){
		return beverageMenu.get(index);
	}
	
	/**
	 * This gets us the name only based on index of ArrayList
	 * @param index
	 * @return String
	 */
	public String getNameAtIndex(int index){
		return beverageMenu.get(index).getName();
	}
	
	/**
	 * This method allows us to delete an item off the ArrayList
	 * once we're given the index position
	 * @param index
	 */
	public void deleteItem(int index){
		beverageMenu.remove(index);
	}

	/**
	 * This method returns an iterator  to go through the menu 
	 * @return Iterator
	 */
	public Iterator createIterator() {
		return new BeverageMenuIterator(beverageMenu);
	}
}
