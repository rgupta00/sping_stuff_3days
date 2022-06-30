package com.productapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class ProductDaoJdbcImplV2 implements ProductDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ProductDaoJdbcImplV2(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Product> getAll() {
		return jdbcTemplate.query("select * from product_table", new ProductRowMapper());
	}

	@Override
	public Product getById(Integer id) {
		return jdbcTemplate.queryForObject("select * from product_table where id=?", new ProductRowMapper(), id);
	}

	@Override
	public Product addProduct(Product product) {
		String INSERT_SQL = "insert into product_table(name, price, isAvailable) values(?,?,?)";
		int update = jdbcTemplate.update(INSERT_SQL,
				new Object[] { product.getName(), product.getPrice(), product.isAvailable() });

		return null;
	}

	@Override
	public Product deleteProduct(Integer id) {

		int update = jdbcTemplate.update("delete from product_table where id=?", id);

		return null;
	}

	@Override
	public Product updateProduct(Integer id, Product product) {
		int update = jdbcTemplate
				.update("update product_table set price=?, isAvailable=? where id=?", 
						new Object[] { product.getPrice(), product.isAvailable(),
								product.getId() });
		
		return null;
	}

}
