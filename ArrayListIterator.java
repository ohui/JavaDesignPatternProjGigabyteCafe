/*
 * The ArrayListIterator is similar to how FoodMenuIterator and BeverageMenuIterator works. 
 * It implements the Iterator interface so it can iterate through the ArrayLists. 
 * FoodMenu and BeverageMenu are both clients of ArrayListIterator because they 
 * use an ArrayList of String objects for their container. 

 */
import java.util.ArrayList;

public class ArrayListIterator implements Iterator{
	ArrayList<String> List; //points to the ArrayList
	int position = 0; //stores the current position while iterating
 
	/**
	 * This is the constructor that takes in an ArrayList<String> 
	 * so it can iterate through it
	 * @param list
	 */
	public ArrayListIterator(ArrayList<String> list) {
		List =list;
	}
	

	/**
	 * This method returns the String object of where we are at 
	 * in the ArrayList
	 * @return String
	 */
	public String next() {
		String Item = (String) List.get(position);
		position = position + 1;
		return Item;
	}
 
	/**
	 * This returns true or false if there is a next object
	 * @return boolean
	 */
	public boolean hasNext() {
		if (position >= List.size()) {
			return false;
		} else {
			return true;
		}
	}
}
