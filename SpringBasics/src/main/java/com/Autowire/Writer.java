package com.Autowire;

public class Writer {
	
	//autowire will use the object type mentioned to create the object
	private LogWriter logWriter;
	private FileWriter fileWriter;
	
	//default constructor
	public Writer() {
		
	}
	
	//constructor to use auto-wire property byConstructor
	public Writer(LogWriter logWriter , FileWriter fileWriter) {
		//System.out.println("in constructor");
		this.logWriter = logWriter;
		this.fileWriter = fileWriter;
	}
		
	public void setLogWriter(LogWriter logWriter) {
		this.logWriter = logWriter;
	}
	public void setFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}
	public void logWrite(String string) {
		logWriter.write(string);
	}
	public void fileWrite(String string) {
		fileWriter.write(string);
	}
	
	
	//object name should be same as the bean id/name value to use byName
	private IWriter logWriter1;
	private IWriter fileWriter1;
	public void setLogWriter1(LogWriter logWriter1) {
		this.logWriter1 = logWriter1;
	}	
	public void setFileWriter1(FileWriter fileWriter1) {
		this.fileWriter1 = fileWriter1;
	}
	public void logWrite1(String string) {
		logWriter1.write(string);
	}
	public void fileWrite1(String string) {
		fileWriter1.write(string);
	}
}
