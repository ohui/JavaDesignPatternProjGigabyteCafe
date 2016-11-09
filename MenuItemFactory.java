/*
 * This interface tells the factories what they will be producing. It has the getFood() and 
 * getBeverage() method.  These methods take in a string to know which specific menu 
 * item they're creating (Appetizer, Main Dish, Dessert, Soda, Long Drink) and each return their 
 * respective category types(Either a Food or Beverage type). Any factory that implements this 
 * interface must now create either objects from the Food category or Beverage category.
 */
public interface MenuItemFactory {
	
	/**
	 * If the user entered a food type, then the String variable food 
	 * will have either "Appetizer", "Main Dish", or "Dessert". 
	 * We then return a Food object. 
	 * 
	 * @param food
	 * @return Food
	 */
	abstract Food getFood(String food);
	
	
	/**
	 * If the user entered a beverage type, then the String variable beverage
	 * will have either "Soda" or "Long Dish"
	 * We then return a Beverage object. 
	 * 
	 * @param beverage
	 * @return Beverage
	 */
	abstract Beverage getBeverage(String beverage); 
}
