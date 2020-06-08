package com.funtionalInterfaceSampleCode;


public class ClassOne implements FunctionalInterfaceCode{

	//override abstract method of interface
	@Override
	public void firstMethod() {
		System.out.println("abstract method implemented in class one");		
	}
	
	//override default method of interface
	@Override
	public void thirdMethod() {
		System.out.println("default method implemented in class one");
	}
}
