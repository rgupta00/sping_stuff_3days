package com.productapp.controller;
import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.productapp.dao.Product;
import com.productapp.service.ProductService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("products.xml");
		
//		ProductService productService=(ProductService) applicationContext.getBean("ps");
		ProductService productService= applicationContext.getBean("ps", ProductService.class);
		List<Product> list=productService.getAll();
		list.forEach(p-> System.out.println(p));
		
		//Product product=productService.getById(4);
	}
}
