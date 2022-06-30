package com.productapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
@Configuration
@PropertySource("classpath:db.properties") // it is used to load the prop file
public class DbConfigV2 {

	@Autowired
	private Environment environment;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl(environment.getProperty("jdbc.url"));
		ds.setPassword(environment.getProperty("jdbc.password"));
		ds.setDriverClassName(environment.getProperty("jdbc.driver"));
		ds.setUsername(environment.getProperty("jdbc.username"));

		return ds;
	}
}
