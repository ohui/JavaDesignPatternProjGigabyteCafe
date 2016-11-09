/*
 * The BeverageTypeList class is the same. It will hold the different 
 * types of beverages (Soda, Long Drink) in an ArrayList. 
 */

import java.util.ArrayList;

public class BeverageTypeList implements Container{
	ArrayList<String> ListOfBeverageTypes; //store our types here
	 
	/**
	 * This constructor initializes the ArrayList<String> for us
	 * and adds Soda and Long Drink as a type
	 */
	public BeverageTypeList() {
		ListOfBeverageTypes = new ArrayList<String>();
		addItem("Soda");
		addItem("Long Drink");
	}

	/**
	 * This method adds another type to the ArrayList
	 * @param name
	 */
	public void addItem(String name){
		ListOfBeverageTypes.add(name);
	}
  
	/**
	 * This method creates the Iterator so we can iterate through 
	 * all the different types of beverages there are
	 * @return Iterator
	 */
	public Iterator createIterator() {
		//create the iterator for the beverage menu
		return new ArrayListIterator(ListOfBeverageTypes);
	}
}
