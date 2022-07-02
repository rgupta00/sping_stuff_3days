package com.productapp.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.productapp" })
@EnableAspectJAutoProxy
@EnableTransactionManagement // <tx:annotation-driven transaction-manager="transactionManager" />
@Import(DbConfig.class)
public class AppConfig {

	@Bean
	LocalSessionFactoryBean getLocalSessionFactoryBean(DataSource dataSource) {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(dataSource);
		lsfb.setPackagesToScan("com.productapp.entities");
		lsfb.setHibernateProperties(getProperties());
		return lsfb;
	}

	private Properties getProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");

		return properties;
	}

	@Bean
	HibernateTransactionManager getHibernateTransactionManager(SessionFactory factory) {
		HibernateTransactionManager htmx = new HibernateTransactionManager();
		htmx.setSessionFactory(factory);
		return htmx;
	}
}
