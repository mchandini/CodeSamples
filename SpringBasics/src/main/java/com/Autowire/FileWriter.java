package com.Autowire;

public class FileWriter implements IWriter {
	
	@Override
	public void write(String string) {
		System.out.println("in file writer: " + string);
	}

}
