package com.productapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@ComponentScan(basePackages = "com.productapp")
@EnableAspectJAutoProxy
public class AppConfig {

}
