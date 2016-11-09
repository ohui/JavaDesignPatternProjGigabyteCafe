Gigabyte Cafe
=========

This is a project I did for my Java Design Patterns class. 

The objective of this assignment is to develop an application capable of managing and facilitating customer orders, both food and drink, at Gigabyte Café. The application would need to interact with two separate menus, one for food and one for beverages.

### Four design patterns were used:
- Abstract Factory
- Factory
- Singleton
- Iterator


### Compilation of code
```
javac *

```


### Example Run
```
$ java MainMenuProgram

Welcome to the Gigabyte Cafe Menu System.
Below are your options with the system.

Menu Options
1) Add Item: Food or Beverages
2) Edit Menu Item
3) Delete Menu Item
4) Display Both the Food and Beverage Menus

Ordering Options
5) Create An Order
6) Edit An Order: Edit information about orders
7) Finish Order: Deletes an order from list
8) Display Current Orders

Press x to exit the program

MAIN MENU: Your Command (0 for menu, x to quit program) >>: 1

What kind of item is it?
( "Appetizer" "Main Dish" "Dessert" "Soda" "Long Drink" )
Please enter one of the types above without the quotes: Main Dish

Please enter information below for the Main Dish.
Enter Name: Pizza
Enter Ingredient #1: (0 to quit) Cheese
Enter Ingredient #2: (0 to quit) Tomato Sauce
Enter Ingredient #3: (0 to quit) 0
Enter Side Dish: Bread Sticks
Enter Calorie Count: 700
Enter Price: 10
Main Dish "Pizza" has been added to the Food Menu. Thank you.

MAIN MENU: Your Command (0 for menu, x to quit program) >>: 2

ID  Item
---  --------------
#1) Main Dish: Pizza  $10.00

Please enter the ID number(very left) of item you want to edit (0 to exit): 1

Editing Section
=====================
0. Exit Editing
1. Edit Name: Pizza
2. Edit Ingredients: 1) Cheese   2) Tomato Sauce
3. Edit Side Dish: Bread Sticks
4. Edit Calorie Count: 700
5. Edit Price: $10.00

Please enter which option (0-5) that you would to do: 4

Old Calorie Count: 700
Please enter new Calorie Count: 950
Calorie count has been changed.

MAIN MENU: Your Command (0 for menu, x to quit program) >>: 1

What kind of item is it?
( "Appetizer" "Main Dish" "Dessert" "Soda" "Long Drink" )
Please enter one of the types above without the quotes: Soda

Please enter information below for the Soda.
Enter Name: Pepsi
Enter Calorie Count: 150
Enter Price: .75
Soda "Pepsi" has been added to the Beverage Menu. Thank you.

MAIN MENU: Your Command (0 for menu, x to quit program) >>: 4

========Food Menu========
1) Main Dish
Name: Pizza
Ingredients: 1) Cheese  2) Tomato Sauce
Side Dish Bread Sticks
Calorie Count: 950
Price: $10.00

========Beverage Menu========
2) Soda
Name: Pepsi
Calorie Count: 150
Price: $0.75


MAIN MENU: Your Command (0 for menu, x to quit program) >>: 5

What type of Order is this? ("Delivery" or "Normal" without the quotes): Normal

ID#    Item
---- --------------
#1) Main Dish: Pizza 10.0
#2) Soda: Pepsi 0.75

Please type the ID of item customer is ordering (0 to exit): 1
Items Ordered so far: Pizza
Current total is $10.00

Please type the ID of item customer is ordering (0 to exit): 2
Items Ordered so far: Pizza, Pepsi
Current total is $10.75

Please type the ID of item customer is ordering (0 to exit): 2
Items Ordered so far: Pizza, Pepsi, Pepsi
Current total is $11.50

Please type the ID of item customer is ordering (0 to exit): 0

Summary
Order ID# 1
----------------
1) Pizza
2) Pepsi
3) Pepsi
Order total is $11.50
Order has been added.

MAIN MENU: Your Command (0 for menu, x to quit program) >>: 8

========Current Orders========
ID# 1	Total: $11.50	Items Ordered: Pizza, Pepsi, Pepsi

MAIN MENU: Your Command (0 for menu, x to quit program) >>: x
Exiting Program..Thank you!
```
