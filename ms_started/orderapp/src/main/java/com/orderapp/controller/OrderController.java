package com.orderapp.controller;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.orderapp.dto.Coupon;
import com.orderapp.dto.Customer;
import com.orderapp.dto.Order;
import com.orderapp.dto.OrderRequest;
import com.orderapp.dto.Product;

@RestController
public class OrderController {

	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping(path = "orders")
	public ResponseEntity<Order> bookOrder( @RequestBody OrderRequest orderRequest){
		
		int customerId=orderRequest.getCid();
		int productId=orderRequest.getPid();
		int qty=orderRequest.getQty();
		String discountCoupon=orderRequest.getDiscountCoupon();
		
		//we are calling customer ms using resttemplate
		Customer customer=restTemplate
				.getForObject("http://localhost:8081/customerapp/customers/"+customerId, Customer.class);
		
		//we are calling product ms using resttemplate
		Product product=restTemplate
				.getForObject("http://localhost:8082/productapp/products/"+productId, Product.class);
		
		//we are calling discount coupon ms using resttemplate
		
		Coupon coupon=restTemplate
				.getForObject("http://localhost:8085/couponapp/coupons/"+discountCoupon, Coupon.class);
		int discountPercentage=coupon.getDiscount();
		
		double totalPriceCalculated= product.getPrice()*qty*(100-discountPercentage)/100;
		
		Order order=new Order(UUID.randomUUID().toString(), 
				totalPriceCalculated, LocalDate.now(), customer, product);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(order);
	}
	
	
}







