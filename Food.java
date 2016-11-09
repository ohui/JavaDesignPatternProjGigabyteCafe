/*
 * This is the Food Interface that has the common methods all 
 * food type menu items are expected to have. 
 * This interface is important because our client, MainMenuProgram,
 * is now decoupled from the specific Appetizer, MainDish, and Dessert objects 
 * we're creating and using. 
 */

public interface Food {
	
	/**
	 * This method displays information about the food product
	 */
	public void display(); 
	
	/**
	 * This method returns the name of our food 
	 * @return String
	 */
	public String getName(); 
	
	/**
	 * This method gives us the price of the food
	 * @return double
	 */
	public double getPrice(); 
	
	/**
	 * This method tells us what type of food it is
	 * @return String
	 */
	public String getType(); 
	
	/**
	 * This method allows us to edit the Food's properties
	 */
	public void editItem(); 
}
