package com.Annotations;

import javax.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Logger {

	//1) @Autowired for properties
	@Autowired
	
	//@Qualifier will specify the bean if there is any ambiguity
	//@Qualifier("useThis")
	private ILogger consoleLog;
	//private ConsoleLog consoleLog;
	
	//if bean dependency is not required, use required=false
	//in this case bean presence is not required in context.xml file
	@Autowired(required=false)
	private FileLog fileLog;
	
	@Autowired
	private ConsoleLog loggerObj;
	
	//2)can also write @Autowired for the constructor
	/*@Autowired
	public Logger(ConsoleLog consoleLog , FileLog fileLog) {
		this.consoleLog = consoleLog;
		this.fileLog = fileLog;
	}*/
	
	/*3)no need of setters when we use @Autowired but it work for setters too
	@Autowired
	public void setConsoleLog(ConsoleLog consoleLog) {
		this.consoleLog = consoleLog;
	}
	@Autowired
	public void setFileLog(FileLog fileLog) {
		this.fileLog = fileLog;
	}
	*/
	
	@Autowired
	//@Value is used for hardcoding the values through annotation
	//#{_______} will be used to get any dynamic content
	public void consoleWrite(@Value("#{'SPEL: '+'Spring Expression Language'}") String string) {
		consoleLog.write(string);
		loggerObj.write("bean created automatically");
	}
	public void FileWrite(String string) {
		if(fileLog != null) {
			fileLog.write(string);
		}		
	}
	
	/* currently below annotations are not available in the program
	@PostConstruct
	public void init() {
		System.out.println("in init");
	}	
	@PreDestroy
	public void destroy() {
		System.out.println("in destroy");
	}
	*/
}
