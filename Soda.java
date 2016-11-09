/*
 * Soda class. It has a name, price, and calorie count. 
 * It inherits the common variables and methods from BeverageType superclass.
 */

public class Soda extends BeverageType implements Beverage {
	int calCount;  //store calorie count as an integer
	
	/**
	 * This constructor returns a Soda object once we're
	 * passed in the name, calorie count, and price of it.
	 * 
	 * @param name
	 * @param calCount
	 * @param price
	 */
	public Soda (String name, int calCount, double price){
		type = "Soda";
		this.name = name;
		this.calCount = calCount;
		this.price = price;
	}

	/**
	 * This method returns the calorie count of the soda. 
	 * 
	 * @return int
	 */
	public int getCalCount() {
		return calCount;
	}

	/**
	 * This method changes the calorie count of the soda. 
	 * 
	 * @param calCount
	 */
	public void setCalCount(int calCount) {
		this.calCount = calCount;
	}

	/**
	 * This method displays information about the soda. 
	 * One example is...
	 * 
	 *  Soda
	 *  Name: <Name>
	 *  Calorie Count: 1234
	 *  Price: $1.00
	 */
	public void display() {
		
		System.out.println("Soda");
		System.out.println("Name: "+ name);
		System.out.println("Calorie Count: "+ calCount);
		System.out.println("Price: "+ formatter.format(price) +"\n");
	}
	
	/**
	 * This method brings up options the user can see so properties
	 * of the soda can be changed. 
	 * One example is...
	 * 
	 * 0. Exit Editing
	 * 1. Edit Name: <Name>
	 * 2. Edit Calorie Count: 1234
	 * 3. Edit Price: $1.00
	 */
	public void editItem(){
		
		System.out.println("0. Exit Editing");
		System.out.println("1. Edit Name: "+ name);
		System.out.println("2. Edit Calorie Count: "+ calCount);
		System.out.println("3. Edit Price: "+ formatter.format(price)+"\n");
		System.out.print("Please enter which option (0-3) that you would to do: ");
		
		userInputNum = Integer.parseInt(inputScanner.nextLine());	//scan in the user's choice
		System.out.println();
		switch (userInputNum){
		case 0: 
			//User wants to exit
			
			System.out.println("Exiting item edit section.");
			break; 
		case 1:
			//User wants to change the name 
			
			System.out.println("Old Name: " + getName());
			System.out.print("Please enter new name: ");
			setName(inputScanner.nextLine());
			System.out.println("Name has been Changed. ");
			break;
		case 2: 
			//User wants to change the calorie count
			
			System.out.println("Old Calorie Count: " + getCalCount());
			System.out.print("Please enter new Calorie Count: ");
			setCalCount(Integer.parseInt(inputScanner.nextLine()));
			System.out.println("Calorie count has been changed.");
			break;
		case 3: 
			//User wants to change the price
			
			System.out.println("Old Price: " + formatter.format(price));
			System.out.print("Please enter new Price: ");
			setPrice(Double.parseDouble(inputScanner.nextLine()));
			System.out.println("Price has been changed.");
			break; 
		default:
			System.out.println("Invalid Response. Exiting item edit section.");
			break; 
		}
	}

}
