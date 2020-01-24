package com.Annotations;

public class FileLog implements ILogger {
	public void write(String string) {
		System.out.println("in file: "+string);
	}
}
