package com.productapp;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.entity.Product;
import com.productapp.service.ProductService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
//Spring boot :jpa is spec behind hiberate : 
//sessionfactory vs EntityManagerFactory		session EntityManger
@OpenAPIDefinition(info=@Info(title="product store application Inc", version = "2.2",description = "We sell every house hold maxxx"))
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

	//?
	// ref https://www.baeldung.com/spring-custom-validation-message-source
	
//	@Bean
//	public MessageSource messageSource() {
//	    ReloadableResourceBundleMessageSource messageSource
//	      = new ReloadableResourceBundleMessageSource();
//	    
//	    messageSource.setBasename("classpath:ValidationMessages1.properties");
//	    messageSource.setDefaultEncoding("UTF-8");
//	    return messageSource;
//	}
//	
//	@Bean
//	public LocalValidatorFactoryBean getValidator() {
//	    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
//	    bean.setValidationMessageSource(messageSource());
//	    return bean;
//	}
}
