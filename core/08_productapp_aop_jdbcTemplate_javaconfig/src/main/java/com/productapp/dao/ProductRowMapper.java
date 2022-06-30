package com.productapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductRowMapper implements RowMapper<Product> {
	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		//spring how map rs to Product object
		
		Product product=new Product();
		product.setId(rs.getInt(1));
		product.setName(rs.getString(2));
		product.setPrice(rs.getBigDecimal(3));
		
		product.setAvailable(rs.getBoolean(4));
		return product;
	}

}
