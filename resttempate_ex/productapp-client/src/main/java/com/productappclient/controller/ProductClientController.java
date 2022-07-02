package com.productappclient.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.productappclient.dto.Product;

@RestController
public class ProductClientController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@GetMapping(path = "getallproduct")
	public List<Product> getAll(){
		List<Product> list=restTemplate
				.getForObject("http://localhost:8050/productapp/products", List.class);
		return list;
	}

}
