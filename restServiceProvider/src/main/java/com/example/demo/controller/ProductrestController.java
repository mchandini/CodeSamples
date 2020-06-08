package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductrestController {
	
	ProductService service = new ProductService();

	//curl cmd: curl GET http://localhost:8888/products
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return service.getAllProductList();
	}
	
	//curl cmd: curl GET http://localhost:8888/product?id=<id>
	//returns first match of id in the list
	// return{id:0,name=null} if id is not present in the list
	@GetMapping("/product")
	public Product getProductById(@RequestParam(name="id") int id) {	
		return service.getProductById(id);	
	}
	
	//curl cmd: curl POST -d "id=<id>&name=<name>" curl GET http://localhost:8888/addProduct
	@PostMapping("/addProduct")
	public String addProduct(@RequestParam(name="id") int id, @RequestParam(name="name") String name) {
		try {
			service.addProductToList(id, name);
			return "added successfully";
		} catch(Exception e) {
			return "error: "+e;
		}
	}
}
