package com.Annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {

	public static void main(String[] args) {

		//create context object
		// parameter is the path of bean config file
		//context <===> spring container
		ApplicationContext context = new ClassPathXmlApplicationContext("com/Annotations/beanConfig.xml");
				
		//get bean
		Logger logger = (Logger)context.getBean("logger");
		
		//use bean
		logger.consoleWrite("worked");
		logger.FileWrite("worked");
		
		//close context
		((ClassPathXmlApplicationContext)context).close();
		
	}

}
