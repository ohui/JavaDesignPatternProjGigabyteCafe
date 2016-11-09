import java.util.Scanner;

public class MainMenuProgram {

	/**
	 * This function displays all the menu options that
	 * allows us to add and edit menu items and manage
	 * customer orders.
	 */
	public static void displayCommands(){

		System.out.println("Welcome to the Gigabyte Cafe Menu System.\nBelow are your options with the system.");
		System.out.println("\nMenu Options");
		System.out.println("1) Add Item: Food or Beverages");
		System.out.println("2) Edit Menu Item");
		System.out.println("3) Delete Menu Item");
		System.out.println("4) Display Both the Food and Beverage Menus");
		System.out.println("\nOrdering Options");
		System.out.println("5) Create An Order");
		System.out.println("6) Edit An Order: Edit information about orders");
		System.out.println("7) Finish Order: Deletes an order from list");
		System.out.println("8) Display Current Orders");
		System.out.println("\nPress x to exit the program");
	}

	/**
	 * This is where our main program starts here.
	 * @param args
	 */
	public static void main(String[] args) {

		MenuSingleton restaurantMenu = MenuSingleton.getInstance();	//create the singleton
		Scanner inputScanner = new Scanner(System.in);	//Scanner for input
		String command; //Store what the user will type in at the main menu command prompt
		boolean keepGoing = true;	//keep loop going throughout program
		displayCommands();//Display the menu options before we start our loop.

		while (keepGoing){
			System.out.print("\nMAIN MENU: Your Command (0 for menu, x to quit program) >>: "); //This is out command prompt
			command = inputScanner.nextLine(); //Scan in and store what the user typed

			if (command.equals("")){
				//user hit enter with no input. Display a warning.
				System.out.println("WARNING: Please enter a valid command. Press 0 for Menu Options");
				}
			 else {

				switch (command.charAt(0)){ 	//Get the first character of what the user typed.
				case '0':
					displayCommands();
					break;

				case 'x':
					keepGoing = false;	//This exits the loop and therefore the program
					break;

				case '1':
					restaurantMenu.createNewMenuItem(); //add food and beverage items to the menu
					break;

				case '2':
					restaurantMenu.enableEditMenu();	//Bring up the Edit Menu to start editing the items currently on the menu
					break;

				case '3':
					restaurantMenu.deleteMenuItem();	//Bring up the Delete Option to remove something off the menu
					break;

				case '4':
					restaurantMenu.displayCurrentMenus();	//Display what's on the menu currently
					break;

				case '5':
					restaurantMenu.createNewOrder();	//Start an order
					break;
				case '6':
					restaurantMenu.editAnOrder();	//Edit an order if there was a mistake
					break;
				case '7':
					restaurantMenu.deleteOrder();	//Display all the orders and remove one of them if the order is finished/delivered
					break;
				case '8':
					restaurantMenu.displayAllOrders();	//Displays all orders with unique ID's that are currently being made
					break;

				 default:
					 System.out.println("WARNING: Please enter a valid command. Press 0 for Menu Options.");
					 break;

				}
			}

		}
		inputScanner.close();
		System.out.println("Exiting Program..Thank you!");
	}

}
