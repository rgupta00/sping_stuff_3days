package com.productapp.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.entity.Product;
import com.productapp.service.ProductService;

@RestController // @Controller + @ResponseBody(trigger the parser jackson parser: java<--> json
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	// ----------getting all products----------------
	@GetMapping(path = "products")
	public List<Product> getAllProducts() {
		return productService.getAll();
	}
	//@PathVariable vs @RequestParam
	//http://localhost:9020/productapp/products/43/reviews/1========@PathVariable
	//http://localhost:9020/productapp/products?start=10&end=20======@RequestParam
	
	// ----------getting one product as per id----------------
	@GetMapping(path = "products/{pid}")
	public Product getAnProduct(@PathVariable(value = "pid") int id) {
		return productService.getById(id);
	}
	
	// ----------deleting one product as per id----------------
	@DeleteMapping(path = "products/{pid}")
	public Product deleteAnProduct(@PathVariable(value = "pid") int id) {
		return productService.deleteProduct(id);
	}
	
	//what i expect : i expect that client will send json that ---> java object parser , to trigger parser
	//@RequestBody is used to trigger parser to convert json ---> json
	@PostMapping(path = "products")
	public Product postAnProduct( @RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	
	@PutMapping(path = "products/{pid}")
	public Product updatedProduct( @RequestBody Product product,
			@PathVariable(value = "pid") int id) {
		return productService.updateProduct(id, product);
	}
	
}






