/*
 * This is a concrete class DeliveryOrder that will also hold 
 * customer order information. It extends the NormalOrder class
 * because it's the same as a Normal Order except a delivery would
 * need an address and phone number. It also implements the 
 * CustomerOrder interface. 
 */


public class DeliveryOrder extends NormalOrder implements CustomerOrder{
	String address; //store the address as a string
	String phoneNumber; //store the phone number as a string
	
	/**
	 * This constructor sets its type to "Delivery"
	 * and returns the DeilveryOrder object. 
	 */
	public DeliveryOrder(){
		type = "Delivery";
	}
	
	/**
	 * This method returns the address of where
	 * the delivery should go to.
	 * @return String
	 */
	public String getAddress(){
		return address;
	}
	
	/**
	 * This method sets/updates the address of the 
	 * customer order. 
	 * @param address
	 */
	public void setAddress(String address){
		this.address= address;
	}
	
	/**
	 * This method returns the phone number the 
	 * delivery person should call when nearing the address 
	 * @return String
	 */
	public String getPhoneNumber(){
		return phoneNumber;
	}
	
	/**
	 * This method allows us to update or change the phone
	 * number in the delivery order. 
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
}
