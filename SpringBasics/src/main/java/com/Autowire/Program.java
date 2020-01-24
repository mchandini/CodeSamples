package com.Autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.IOC.Coach;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create context object
		// parameter is the path of bean config file
		//context <===> spring container
		ApplicationContext context = new ClassPathXmlApplicationContext("com/Autowire/BeanContext.xml");
				
		//get bean
		Writer writerByType = (Writer)context.getBean("writerByType");
		Writer writerByName = (Writer)context.getBean("writerByName");
		Writer writerByConstructor = (Writer)context.getBean("writerByConstructor");
		Writer writerByDefault = (Writer)context.getBean("writerByDefault");
								
		//use bean
		writerByType.fileWrite("By Type");
		writerByType.logWrite("By Type");
		
		writerByName.fileWrite1("By Name");
		writerByName.logWrite1("By Name");
		
		writerByConstructor.fileWrite("By Constructor");
		writerByConstructor.logWrite("By Constructor");
		
		System.out.println("default option");
		writerByDefault.fileWrite1("By default");
		writerByDefault.logWrite1("By default");
		
				
		//close context
		((ClassPathXmlApplicationContext)context).close();
	}

}
