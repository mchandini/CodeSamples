package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Product;

@Service
public class ProductService {
	
	List<Product> productsList = new ArrayList<Product>();
	
	
	public ProductService() {
		super();
		//sample products
		Product p1 = new Product(101,"Monitor");
		Product p2 = new Product(111,"CPU");
		productsList.add(p1);
		productsList.add(p2);
	}	
	
	public List<Product> getAllProductList() {
		return productsList;
	}
	
	public Product getProductById(int id) {
		Product product = new Product();
		for (Product p : productsList) {
			if(p.getId() == id) {
				product = p;
				break;
			}
		}
		return product;
	}

	public void addProductToList(int id, String name) {
		Product newProduct = new Product(id, name);
		productsList.add(newProduct);
	}
}
