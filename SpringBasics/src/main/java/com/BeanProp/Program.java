package com.BeanProp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.IOC.Coach;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create context object
		// parameter is the path of bean config file
		//context <===> spring container
		ApplicationContext context = new ClassPathXmlApplicationContext("com/BeanProp/BeanContext.xml");
				
		//get bean
		Person person1 = (Person)context.getBean("singleton1");
		Person person2 = (Person)context.getBean("singleton1");
		
//		Person person3 = (Person)context.getBean("request"); //no bean scope is defined for "request"
//		Person person4 = (Person)context.getBean("request");
		
		Person person5 = (Person)context.getBean("prototype");
		Person person6 = (Person)context.getBean("prototype");
		
//		Person person7 = (Person)context.getBean("session");	//no bean scope is defined for "session"
//		Person person8 = (Person)context.getBean("session");
								
		//use bean
		//singleton bean refer to the same object for all object creations
		System.out.println("singleton");
		person1.getPersonDetails();
		person1.setName("name changed");
		person2.getPersonDetails();
		
		//prototype bean will create new objects for all object creations
		System.out.println("prototype");
		person5.getPersonDetails();
		person5.setName("name changed");
		person6.getPersonDetails();

				
		//close context
		((ClassPathXmlApplicationContext)context).close();
	}

}
