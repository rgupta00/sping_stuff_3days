package com.productappclient.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.productappclient.dto.Product;

@FeignClient(name = "productservice", url = "http://localhost:8050/productapp/products")
public interface ProductServiceProxy {

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts();

	@GetMapping(path = "{pid}")
	public ResponseEntity<Product> getAnProduct(@PathVariable(value = "pid") int id);

	@DeleteMapping(path = "{pid}")
	public ResponseEntity<Void> deleteAnProduct(@PathVariable(value = "pid") int id);

	@PostMapping
	public ResponseEntity<Product> postAnProduct( @RequestBody Product product);

	@PutMapping(path = "{pid}")
	public ResponseEntity<Product> updatedProduct(@RequestBody Product product, @PathVariable(value = "pid") int id);
}
