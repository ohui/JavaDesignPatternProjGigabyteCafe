/*
 * An important interface in the Iterator pattern is the Container interface. 
 * We have four "collection" classes that hold different types of data related to 
 * creating our menu: FoodTypeList, BeverageTypeList, FoodMenu and BeverageMenu. 
 * They all use ArrayList to hold their information. They all will implement
 * the Container interface so that they can create iterators for the data they hold.
 */

public interface Container {
   public Iterator createIterator(); //create the iterator to go through the list
}