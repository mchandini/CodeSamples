package com.IOC;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create context object
		// parameter is the path of bean config file
		//context <===> spring container
		ApplicationContext context = new ClassPathXmlApplicationContext("com/IOC/ApplicationContext.xml");
		
		//get bean
		//Casting the specific class object to implemented interface object as context file decides which class object the bean is referring to
		Coach selectedCoach = (Coach)context.getBean("myCoach");
		
		//use bean
		System.out.println(selectedCoach.getDailyWorkout());

		
		//close context
		((ClassPathXmlApplicationContext)context).close();
	}

}
