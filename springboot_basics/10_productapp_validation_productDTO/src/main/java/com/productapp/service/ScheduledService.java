package com.productapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ScheduledService {

	private ProductService productService;

	@Autowired
	public ScheduledService(ProductService productService) {
		this.productService = productService;
	}

	@Scheduled(initialDelay = 5000, fixedRate = 15000)
	public void fixedRateJob() {
		productService.evictCache();
		log.info("invalation of caching just happens");
	}
}
