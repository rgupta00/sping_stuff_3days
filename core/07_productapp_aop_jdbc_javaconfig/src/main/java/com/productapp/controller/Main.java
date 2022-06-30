package com.productapp.controller;
import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.productapp.config.AppConfig;
import com.productapp.dao.Product;
import com.productapp.service.ProductService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
//		ProductService productService=(ProductService) applicationContext.getBean("ps");
		ProductService productService= 
				applicationContext.getBean("ps", ProductService.class);
		List<Product> list=productService.getAll();
		list.forEach(p-> System.out.println(p));
		
		//Product product=productService.getById(4);
	}
}
