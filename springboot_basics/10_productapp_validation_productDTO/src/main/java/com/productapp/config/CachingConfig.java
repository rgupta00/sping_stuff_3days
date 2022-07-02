package com.productapp.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//1. apply @EnableCaching to enable caching in service layer 
@EnableCaching
@Configuration
public class CachingConfig {
	//2. conifigre a in memory cache ConcurrentMapCacheManager vs...
	@Bean
	public CacheManager cacheManager(){
		ConcurrentMapCacheManager cacheManager=new ConcurrentMapCacheManager("products");
		return cacheManager;
		
	}
}
