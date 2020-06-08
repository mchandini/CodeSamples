package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.RestServiceConsumerApplication;
import com.example.demo.domain.Product;
import com.example.demo.service.RestConsumerService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class RestConsumerController {
	
	private static Logger log = LoggerFactory.getLogger(RestServiceConsumerApplication.class);

	@RequestMapping("/productDetails")
	public String homeController(ModelMap model) {
		RestConsumerService service = new RestConsumerService();
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<Product> productsList = mapper.readValue(service.getProducts(), new TypeReference<List<Product>>(){});	
			
			model.addAttribute("responseList", productsList);
			productsList.forEach(System.out::println);
			log.info("get product details call sucess!!!");
		} catch(Exception e) {
			System.out.println(e);
		}
		return "productDetails";
	}
	
	@RequestMapping("/")
	public String indexController() {
		return "index";
	}
	
	@RequestMapping("/addProduct")
	public String addProductLink() {
		return "addProductForm";
	}
	
}
