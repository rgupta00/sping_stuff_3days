package com.productapp.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.entity.Product;
import com.productapp.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	//get all product
	@GetMapping(path = "products")
	public List<Product>getAll(){
		return productService.getAll();
	}
	
	//@RequestParam ?name=raj&city=new delhi   vs @PathVariable /{id}///
	@GetMapping(path = "products-sorted")
	public List<Product>getAllSorted(@RequestParam(name = "field")String field){
		return productService.getAllSortedAsPerName(field);
	}
	
	//http://localhost:8080/products-page?offSet=2&pageSize=5
	//get product sorted by some key: (int offSet, int pageSize)
	@GetMapping(path = "products-page")
	public Page<Product>getAllPages(@RequestParam(name = "offSet")int offSet,
			@RequestParam(name = "pageSize")int pageSize ){
		return productService.findProductsWithPagination(offSet, pageSize);
	}
	
	//http://localhost:8080/products-page-sorted?offSet=2&pageSize=50&field=quantity
	@GetMapping(path = "products-page-sorted")
	public Page<Product> findProductsWithPaginationAndSorting(
			@RequestParam(name = "offSet") int offSet, 
			@RequestParam(name = "pageSize") int pageSize,
			@RequestParam(name = "field") String field) {
		Page<Product>page=productService.findProductsWithPaginationAndSorting(offSet, pageSize, field);
		return page;
	}
}







