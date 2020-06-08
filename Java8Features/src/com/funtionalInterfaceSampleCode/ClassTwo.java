package com.funtionalInterfaceSampleCode;

public class ClassTwo extends ClassOne{

	//override abstract method of interface
	@Override
	public void firstMethod() {
		System.out.println("abstract method implemented in class two");
	}
	
	//override default method of interface
	@Override
	public void thirdMethod() {
		System.out.println("default method implemented in class two");
	}
}
