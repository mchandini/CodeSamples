package com.Autowire;

public class LogWriter implements IWriter {

	@Override
	public void write(String string) {
		System.out.println("in log writer: " + string);
	}
}
