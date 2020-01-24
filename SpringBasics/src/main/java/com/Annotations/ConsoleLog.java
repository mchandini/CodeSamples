package com.Annotations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//to use a particular child class on parent bean creation
//@Qualifier("useThis")

//for automatic bean creation no need of bean declaration in xml
@Component
public class ConsoleLog implements ILogger {

	public void write(String string) {
		System.out.println("in console: "+string);
	}
}
