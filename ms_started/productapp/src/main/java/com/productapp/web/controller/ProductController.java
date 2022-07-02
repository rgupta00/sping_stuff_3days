package com.productapp.web.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.dao.Product;
import com.productapp.model.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(path = "products")
	public ResponseEntity<List<Product>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
	}
	
	@GetMapping(path = "products/{id}")
	public ResponseEntity<Product> getAnProduct(@PathVariable(name = "id")int id) {
		return ResponseEntity.status(HttpStatus.OK).body(productService.getById(id));
	}
	
	
	@DeleteMapping(path = "products/{id}")
	public ResponseEntity<Void> deleteAnProduct(@PathVariable(name = "id")int id) {
		 productService.deleteProduct(id);
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	
	@PostMapping(path = "products")
	public ResponseEntity<Product> addAnProduct(@RequestBody  Product product) {
		 productService.addProduct(product);
		 return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
	
	
	@PutMapping(path = "products/{id}")
	public ResponseEntity<Product> udateAnProduct(@PathVariable(name = "id")int id,@RequestBody  Product product ) {
		Product updatedProduct= productService.updateProduct(id, product.getPrice());
		return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
	}
	
}








