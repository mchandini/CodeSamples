package com.funtionalInterfaceSampleCode;

//includes functional interface feature
public class Demo {

	public static void main(String[] args) {

		ClassOne oneObj = new ClassOne();
		ClassTwo twoObj = new ClassTwo();
		
		//default and abstract method calls
		oneObj.firstMethod();
		oneObj.thirdMethod();
		
		twoObj.firstMethod();
		twoObj.thirdMethod();
		
		//static method call
		FunctionalInterfaceCode.secondMethod();
	}
}
