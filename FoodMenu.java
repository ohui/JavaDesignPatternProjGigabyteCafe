/*
 * The FoodMenu class is what actually holds the Food objects when the user inputs 
 * food to our menu that the customer can order. It will store them in an ArrayList. 
 */
import java.util.ArrayList;

public class FoodMenu implements Container{
	
	private ArrayList<Food> foodMenu; //store the food objects in an ArrayList
	
	/**
	 * This constructor initializes the ArrayList so we can
	 * begin to populate it and then we return the FoodMenu object.
	 */
	public FoodMenu() {
		foodMenu = new ArrayList<Food>();
	}
	
	/**
	 * This returns the number of items currently on 
	 * the food menu.
	 * @return int
	 */
	public int size(){
		return foodMenu.size();
	}
	 

	/**
	 * This method adds a food item to the ArrayList.
	 * @param name
	 */
	public void addItem(Food name){
		foodMenu.add(name);
	}
	
	/**
	 * This method returns a Food object once we're given 
	 * the index position on the ArrayList which is our menu.
	 * @param index
	 * @return Food
	 */
	public Food getFoodAtIndex(int index){
		return foodMenu.get(index);
	}
	
	/**
	 * This gives us the name of the Food object at that 
	 * index location in the ArrayList. 
	 * @param index 
	 * @return String
	 */
	public String getNameAtIndex(int index){
		return foodMenu.get(index).getName();
	}

	/**
	 * This removes a Food item off our ArrayList
	 * based off the index position. 
	 * @param index
	 */
	public void deleteItem(int index){
		foodMenu.remove(index);
	}
	
	/**
	 * This creates the Iterator for us so we can iterate
	 * through the entire Food Menu 
	 * @return Iterator
	 */
	public Iterator createIterator() {
		//creates an iterator to iterate through the menu
		return new FoodMenuIterator(foodMenu);
	}
}
