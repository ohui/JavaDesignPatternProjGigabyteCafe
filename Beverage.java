/*
 * This is the Beverage Interface that has the common methods all 
 * beverage type menu items are expected to have. 
 * This interface is important because our client, MainMenuProgram,
 * is now decoupled from the specific Soda and LongDrink objects 
 * we're creating and using. 
 */

public interface Beverage {
	public void display(); //displays custom information about the beverage product
	public String getName(); //return name 
	public double getPrice(); //return price
	public String getType(); //return the type
	public void editItem();  //allow us to edit the Beverage object
}
