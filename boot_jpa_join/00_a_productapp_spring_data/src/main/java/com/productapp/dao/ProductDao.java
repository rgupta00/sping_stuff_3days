package com.productapp.dao;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productapp.entity.Product;
@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{
	
	public Optional<Product> findById(Integer id);
	public List<Product> findByName(String name);
}
