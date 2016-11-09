/*
 * This is a concrete class NormalOrder that will hold 
 * customer order information. It implements the CustomerOrder
 * interface. 
 */

import java.text.NumberFormat;
import java.util.ArrayList;

public class NormalOrder implements CustomerOrder{
	String type;		//store the type 
	ArrayList<String> listOfItems; //holds the names of items order
	double total;	//stores the total cost as user continues to order
	int numID;	//holds a unique ID of the order
	NumberFormat formatter = NumberFormat.getCurrencyInstance();	//formats the price for us
	
	/**
	 * Constructor returns a NormalOrder object after 
	 * it sets its type to "Normal"
	 */
	public NormalOrder(){
		type = "Normal";
	}
	
	/**
	 * Constructor returns a NormalOrder object after
	 * being passed in the unique ID, list that contains the 
	 * items ordered, and the total price. 
	 * 
	 * @param numID
	 * @param list
	 * @param total
	 */
	public NormalOrder(int numID, ArrayList<String> list, double total){
		this.numID = numID; 
		listOfItems = list;
		this.total= total;
	}
	
	/**
	 * This method returns what type of order this is. 
	 * 
	 * @return String
	 */
	public String getType(){
		return type; 
	}
	
	/**
	 * This method returns the total cost of the order. 
	 * 
	 * @return double
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * This method returns the list of items that were 
	 * ordered in an ArrayList object. 
	 * 
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getListOfItems() {
		return listOfItems;
	}
	
	/**
	 * This method updates the total of the order
	 * @param total
	 */
	public void setTotal(double total){
		this.total = total;
	}
	
	/**
	 * This method sets or changes the list of items 
	 * ordered to newList that is passed in. 
	 * 
	 * @param newList
	 */
	public void setListOfItems(ArrayList<String> newList) {
		this.listOfItems= newList; 
	}
	
	/**
	 * This method returns the unique ID of the order.
	 * 
	 * @return int
	 */
	public int getNumID() {
		return numID;
	}
	
	/**
	 * This method changes the ID of the order.
	 * 
	 * @param numID
	 */
	public void setNumID(int numID){
		this.numID = numID; 
	}
	
	/**
	 * This method goes through the order and displays 
	 * the items that were ordered. One example would be..
	 * 
	 * ID# 1	Total: $25.00	Items Ordered: Pizza, Cheesecake, Pepsi
	 * 
	 */
	public void displayItemsOrdered() {
		boolean firstItem = true; 
		for (String s: listOfItems){
			if (firstItem){
				firstItem = false;
				System.out.print(s); //prints the first item without comma
				continue; 
			}
			System.out.print(", "+ s);
		}
		
	}
}
