package com.demo;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {
	public static void main(String[] args) {

		//AbstractApplicationContext vs ApplicationContext , shutdown hook
		AbstractApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("demo.xml");
		applicationContext.registerShutdownHook();
		//you need to tell spring to register shut down hook so that i care about destruction phase of the bean
		//AbstractApplicationContext is aka ApplicationContext which have a function that can be called to regiester shut downhook
		Foo foo=applicationContext.getBean("foo", Foo.class);
		System.out.println("$$$$$$$$$$$$$$$$$$$$");
		System.out.println(foo.getFooVal());
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$");
	}

}
