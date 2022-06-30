package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.config.AppConfig;

public class Main {
	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		Passanger passanger = (Passanger) applicationContext.getBean("p");

		passanger.travel();

	}

}
