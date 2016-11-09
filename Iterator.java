/*
 * The first step when using the Iterator Pattern is to create the Iterator Interface.
 * It's the heart and soul of the Iterator design pattern. It has the hasNext()
 *  method that returns a boolean to see if there is another element in the collection. 
 *  The next() method returns a general Object which will have whatever that element is. 
 */

public interface Iterator {
	
	/**
	 * This method checks if there is an item 
	 * next in the list and returns either
	 * true or false boolean. 
	 * @return boolean
	 */
	boolean hasNext(); 
	
	
	/**
	 * This method returns the object of the current
	 * position. 
	 * @return Object
	 */
	Object next(); 
}
