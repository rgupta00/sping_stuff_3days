package com.demo;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {
	public static void main(String[] args) {

		//AbstractApplicationContext vs ApplicationContext , shutdown hook
		AbstractApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("demo.xml");
		applicationContext.registerShutdownHook();
		Product product=(Product) applicationContext.getBean("p");
		System.out.println(product);
	}

}
