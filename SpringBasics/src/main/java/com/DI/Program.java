package com.DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.IOC.Coach;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create context object
		// parameter is the path of bean config file
		//context <===> spring container
		ApplicationContext context = new ClassPathXmlApplicationContext("com/DI/BeanContext.xml");
				
		//get bean
		Person person = (Person)context.getBean("person");
		//Address address = (Address)context.getBean("address");
								
		//use bean
		//address.getAddressDetails();
		person.getPersonDetails();
				
		//close context
		((ClassPathXmlApplicationContext)context).close();
	}

}
