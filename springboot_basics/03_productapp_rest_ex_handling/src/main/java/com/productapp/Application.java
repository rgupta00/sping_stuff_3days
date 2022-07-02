package com.productapp;

import java.math.BigDecimal;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.entity.Product;
import com.productapp.service.ProductService;
//Spring boot :jpa is spec behind hiberate : 
//sessionfactory vs EntityManagerFactory		session EntityManger

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Product product1 = new Product("laptop", new BigDecimal(67000), true);
		Product product2 = new Product("mouse", new BigDecimal(670), true);
		Product product3 = new Product("HP printer", new BigDecimal(17000), true);
		Product product4 = new Product("Mobile", new BigDecimal(6700), true);

//		productService.addProduct(product1);
//		productService.addProduct(product2);
//		productService.addProduct(product3);
//		productService.addProduct(product3);
		System.out.println("---------inserted------------");
	}

}
