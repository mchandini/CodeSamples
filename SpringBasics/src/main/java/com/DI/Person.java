//setter injection eg;
package com.DI;

public class Person {
	
	//properties
	private int id;
	private String name;
	
	private Address address;
	
	//setters
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

	public void getPersonDetails() {
		System.out.println("Person details:\nid: "+ id + "\nname: " + name + "\naddress: " + address);
		//System.out.println("Address of the person with id: " + id + " is " +  address.getAddressDetails());
	}
}
