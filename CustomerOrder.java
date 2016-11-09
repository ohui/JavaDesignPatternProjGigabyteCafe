/*
 * This is the interface that our NormalOrder and DeliveryOrder
 * class will implement. There are getters and setters for the 
 * numID, total (cost), and listOfItem (items ordered). 
 */

import java.util.ArrayList;

public interface CustomerOrder {

	/**
	 * This will return an ArrayList where it'll contain 
	 * the list of items ordered by the customer
	 * @return ArrayList<String>
	 */
	ArrayList<String> getListOfItems(); 
	
	/**
	 * This method returns the id of the oder
	 * @return int
	 */
	int getNumID(); 
	
	/**
	 * This method allows us to set the ID of an order
	 * @param numID
	 */
	void setNumID(int numID); //change the id of the order
	
	/**
	 * This returns the string of what type of order it is
	 * @return String
	 */
	String getType();  
	
	/**
	 * This updates the total of an Order if we need to
	 * @param total
	 */
	void setTotal(double total); 
	
	/**
	 * This returns the total cost of the order
	 * @return double
	 */
	double getTotal(); //returns the total cost of the order
	
	/**
	 * This method sets/changes the List of Items that were ordered 
	 * @param list
	 */
	void setListOfItems(ArrayList<String> list); 
	
	/**
	 * Depending on what type of order it is, we have to display the 
	 * information inside each Customer Order
	 */
	void displayItemsOrdered(); 
}