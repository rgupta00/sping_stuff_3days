package com.productappclient.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.productappclient.dto.Product;
import com.productappclient.service.ProductServiceProxy;

@RestController
public class ProductClientUsingOpenFeignController {
	
	@Autowired
	private ProductServiceProxy productServiceProxy; 
	
	@GetMapping(path = "getallproduct-v2")
	public ResponseEntity<List<Product>> getAll(){
		return productServiceProxy.getAllProducts();
	}
	
	@GetMapping(path = "getallproduct-v2/{id}")
	public ResponseEntity<Product> getAnProduct(@PathVariable int id){
		return productServiceProxy.getAnProduct(id);
	}
	
	
	
}
