package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.service.RestConsumerService;

//this program covers rest service consumer logic
//get and add product details
//and logs to files using log4j

//run "restServiceProvider" program as spring boot app 
//which is the service provider for this program
@SpringBootApplication
public class RestServiceConsumerApplication {

	private static Logger log = LoggerFactory.getLogger(RestServiceConsumerApplication.class);
    
	public static void main(String[] args) {
	    
		SpringApplication.run(RestServiceConsumerApplication.class, args);
		
		RestConsumerService service = new RestConsumerService();
		System.out.println(service.getProducts());
	    
	    //by default below msgs will be logged
	    log.info("Info Message!");
	    log.warn("Warn Message!");
	    log.error("Error Message!");
	    //log.fatal("Fatal Message!");
	}

}
