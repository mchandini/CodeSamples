//constructor injection eg;
package com.DI;

public class Address {

	private String street;
	private String city;
	
	//Bean will call the constructor and provides the argument values while creating the Address class object
	public Address(String street, String city) {
		this.street = street;
		this.city = city;
	}
	
	public void getAddressDetails(){
		System.out.println("Street: "+street+"  City: "+city);
		//return "Street: "+street+"  City: "+city;
	}
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + "]";
	}
	
}
