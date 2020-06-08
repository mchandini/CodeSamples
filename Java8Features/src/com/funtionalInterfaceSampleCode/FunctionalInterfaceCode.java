package com.funtionalInterfaceSampleCode;

//annotation is not mandatory to add default/static methods
//even if add new default/static methods 
//no need to implement in all the classes which implements the functional interface
@FunctionalInterface
public interface FunctionalInterfaceCode {

	//abstract method
	public void firstMethod();
	
	//static method def
	//cant be overridden
	static void secondMethod() {
		System.out.println("in static method of functinal interface");
	}
	
	//default method def
	//can be overridden
	default public void thirdMethod() {
		System.out.println("in default method of functional interface");
	}

}
