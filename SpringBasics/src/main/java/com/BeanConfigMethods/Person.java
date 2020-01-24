//init and destroy methods
package com.BeanConfigMethods;

public class Person {
	
	//properties
	private int id;
	private String name;

	//constructor
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Person() {
		
	}
	
	public void getPersonDetails() {
		System.out.println("Person details:\nid: "+ id + "\nname: " + name);
	}
	
	//create method will be called on object creation
	public void onCreate() {
		System.out.println("in create method");
	}
	
	//factory method will be called by bean to create and return the object
	public static Person getInstance(int id, String name) {
		System.out.println("in factoryMethod method with params");
		return new Person(id,name);
	}
	
	//destroy method will be called on bean destruction
	public void onDestroy() {
		System.out.println("in destroy method");
	}
}
