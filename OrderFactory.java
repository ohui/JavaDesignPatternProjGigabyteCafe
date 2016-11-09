/*
 * This is a concrete class OrderFactory that follows the 
 * Factory Design pattern. It has only one method getCustomerOrder()
 * that returns either a NormalOrder or DeliveryOrder depending on 
 * what was passed into the method. 
 */
public class OrderFactory  {
	
	/**
	 * This takes in an string orderType and if orderType is 
	 * either Normal or Delivery, we create a NormalOrder or
	 * DeliveryObject, respectively.  
	 * 
	 * @param orderType
	 * @return CustomerOrder
	 */
	public CustomerOrder getCustomerOrder(String orderType){
		
		CustomerOrder customerOrder = null; 
		if (orderType.equals("Normal")){
			customerOrder =  new NormalOrder();
			
		} else if (orderType.equals("Delivery")){
			customerOrder = new DeliveryOrder();
		}
		return customerOrder;
	}
}
