package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
	
	private List<Product> productsList = new ArrayList<Product>();

	public List<Product> getProductsList() {
		return productsList;
	}

	public void setProductsList(List<Product> productsList) {
		this.productsList = productsList;
	}

}
