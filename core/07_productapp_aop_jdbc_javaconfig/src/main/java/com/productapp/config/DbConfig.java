package com.productapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
//@Configuration
//@PropertySource("classpath:db.properties") // it is used to load the prop file
public class DbConfig {

	@Value("${jdbc.url}")
	private String url;

	@Value("${jdbc.username}")
	private String username;

	@Value("${jdbc.password}")
	private String password;

	@Value("${jdbc.driver}")
	private String driver;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl(url);
		ds.setPassword(password);
		ds.setDriverClassName(driver);
		ds.setUsername(username);

		return ds;
	}
}
