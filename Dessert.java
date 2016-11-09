/*
 * Dessert class. It has name, calorie count, price and an appetizer description. 
 * It inherits the common variables and methods from FoodType superclass. 
 */

public class Dessert extends FoodType implements Food {
	
	String appDescription; //stores the description 
	
	/**
	 * This constructor creates the Dessert object once we're given all the
	 * required name, appetizer description, calorie count, and price.
	 * 
	 * @param name
	 * @param appDescription
	 * @param calCount
	 * @param price
	 */
	public Dessert (String name, String appDescription, int calCount, double price){
		type = "Dessert";
		this.name = name;
		this.calCount = calCount;
		this.price  = price;
		this.appDescription = appDescription; 
	}
	

	/**
	 * This method returns the appetizer description that comes with the dessert.
	 * 
	 * @return String
	 */
	public String getAppDescription() {
		//return the appetizer description
		return appDescription;
	}

	/**
	 * This method changes the appetizer description that comes with the dessert.  
	 * 
	 * @param appDescription
	 */
	public void setAppDescription(String appDescription) {
		//set the appetizer description to the one passed in
		this.appDescription = appDescription;
	}

	/**
	 * This method displays all the information about the dessert. One example is ...
	 *   
	 *   Dessert 
	 *   Name: <Name>
	 *   Appetizer Description: <Appetizer Description>
	 *   Calorie Count: 123
	 *   Price: $100.00
	 */
	public void display() {
		//displays all the properties of the Dessert object
		
		System.out.println("Dessert ");
		System.out.println("Name: "+ name);
		System.out.println("Appetizer Description: "+ appDescription);
		System.out.println("Calorie Count: "+ calCount);
		System.out.println("Price: "+ formatter.format(price)+"\n");
	}

	
	/**
	 * This method shows us our options to edit our Dessert's information
	 * One example is ...
	 *   
	 *   0. Exit Editing
	 *   1. Edit Name: <Name>
	 *   2. Edit Appetizer Description: <Appetizer Description>
	 *   3. Edit Calorie Count: 123
	 *   4. Edit Price: $100.00
	 */
	public void editItem(){
		
		System.out.println("0. Exit Editing");
		System.out.println("1. Edit Name: "+ name);
		System.out.println("2. Edit Appetizer Description: "+ appDescription);
		System.out.println("3. Edit Calorie Count: "+ calCount);
		System.out.println("4. Edit Price: "+ formatter.format(price)+"\n");
		
		System.out.print("Please enter which option (0-4) that you would to do: ");
		
		userInputNum = Integer.parseInt(inputScanner.nextLine()); //scan in the user's choice
		
		System.out.println();
		switch (userInputNum){
		case 0: 
			//User does not want to edit. Exit.
			
			System.out.println("Exiting item edit section.");
			break; 
		case 1:
			//User wants to edit the name
			
			System.out.println("Old Name: " + getName());
			System.out.print("Please enter new name: ");
			setName(inputScanner.nextLine());
			System.out.println("Name has been changed. ");
			break;
		case 2:
			//User wants to change the appetizer description
			
			System.out.println("Old Appetizer Description: " + getAppDescription());
			System.out.print("Please enter new appetizer Description: ");
			setAppDescription(inputScanner.nextLine());
			System.out.println("Appetizer has been changed. ");
			break;
		case 3: 
			//User wants to change the calorie count
			
			System.out.println("Old Calorie Count: " + getCalCount());
			System.out.print("Please enter new Calorie Count: ");
			setCalCount(Integer.parseInt(inputScanner.nextLine()));
			System.out.println("Calorie count has been changed. ");
			break;
		case 4: 
			//User wants to change the price
			
			System.out.println("Old Price: " + formatter.format(price));
			System.out.print("Please enter new Price: ");
			setPrice(Double.parseDouble(inputScanner.nextLine()));
			System.out.println("Price has been changed. ");
			break; 
		default:
			System.out.println("Invalid Response. Exiting item edit section.");
			break; 
		}
	}
	
}
