package com.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPP implements BeanFactoryPostProcessor {

	//BeanFactory is min version of ApplicationContext
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
			throws BeansException {
		System.out.println("BeanFactoryPostProcessor......postProcessBeanFactory() method is called...");
		//this method have power to change the behaviour of the bean
		
		BeanDefinition beanDefinition=beanFactory.getBeanDefinition("foo");
		MutablePropertyValues propValue=beanDefinition.getPropertyValues();
		
		propValue.addPropertyValue("fooVal", "fooVal new value is assined using BeanFactoryPostProcessor");
		
	}
}







