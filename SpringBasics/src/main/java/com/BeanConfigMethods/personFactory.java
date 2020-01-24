package com.BeanConfigMethods;

public class personFactory {
	
	//factory method which create and returns the object
	public Person createPerson(int id, String name) {
		return new Person(id,name);
	}

}
