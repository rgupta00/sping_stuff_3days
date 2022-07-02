package com.productapp.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dao.ProductDao;
import com.productapp.dto.ProductDto;
import com.productapp.entity.Product;
import com.productapp.service.ProductService;
import com.productapp.util.ConversionUtil;

@RestController
public class ProductController {

	private ProductService productService;

	public ProductController() {
	}

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	/*
	 * 
	 * Spring boot + jpa+ basic crud operations + ResponseEntity
	 * 
	 * ResponseEntity is a bag which hold 2 things : data + http status code
	 */

	@GetMapping(path = "products", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.ok(productService.getAll());
	}

	@GetMapping(path = "products/{pid}")
	public ResponseEntity<Product> getAnProduct(@PathVariable(value = "pid") int id) {
		return new ResponseEntity<Product>(productService.getById(id), HttpStatus.OK);
	}

	@DeleteMapping(path = "products/{pid}")
	public ResponseEntity<Void> deleteAnProduct(@PathVariable(value = "pid") int id) {
		productService.deleteProduct(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	/*
	 * 400 401 403
	 */
	// @Valid : will trigger some ex MethodArgumentNotValidException
	// 2. i have to define a hander for it
	@PostMapping(path = "products")
	public ResponseEntity<Product> postAnProduct(@Valid @RequestBody ProductDto productDto) {
		Product product = ConversionUtil.convertToProduct(productDto);

		Product productAdded = productService.addProduct(product);

		return ResponseEntity.status(HttpStatus.CREATED).body(productAdded);
	}

	@PutMapping(path = "products/{pid}")
	public ResponseEntity<Product> updatedProduct(@Valid @RequestBody ProductDto productDto,
			@PathVariable(value = "pid") int id) {
		Product product = ConversionUtil.convertToProduct(productDto);
		return ResponseEntity.ok(productService.updateProduct(id, product));
	}

}
