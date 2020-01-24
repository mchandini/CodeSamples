package com.BeanConfigMethods;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.IOC.Coach;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create context object
		// parameter is the path of bean config file
		//context <===> spring container
		ApplicationContext context = new ClassPathXmlApplicationContext("com/BeanConfigMethods/BeanConfig.xml");
				
		//get bean
		Person person = (Person)context.getBean("person");
		Person personF = (Person)context.getBean("personF");
		
		//use bean
		person.getPersonDetails();
		personF.getPersonDetails();
	
		//close context
		((ClassPathXmlApplicationContext)context).close();
	}

}
