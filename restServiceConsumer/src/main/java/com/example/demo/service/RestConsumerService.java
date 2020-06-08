package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestConsumerService {
	
	RestTemplate restTemplate = new RestTemplate();
	
	public String getProducts() {
		
		String response = restTemplate.getForObject("http://localhost:8888/products",
				String.class);
		return response;
	}

}
