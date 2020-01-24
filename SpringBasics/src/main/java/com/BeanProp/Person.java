//setter injection eg;
package com.BeanProp;

public class Person {
	
	//properties
	private int id;
	private String name;
	
	//setters
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void getPersonDetails() {
		System.out.println("Person details:\nid: "+ id + "\nname: " + name);
		//System.out.println("Address of the person with id: " + id + " is " +  address.getAddressDetails());
	}
}
