package com.productapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.exceptions.ProductAppException;
import com.productapp.model.dao.Product;
import com.productapp.model.dao.ProductRepository;

@Service
@Transactional
public class ProuductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAll() {
		return productRepository.findAll();
	}

	@Override
	public Product addProduct(Product product) {
		productRepository.save(product);
		return product;
	}

	@Override
	public Product deleteProduct(int id) {
		Product productToDelete=getById(id);
		productRepository.delete(productToDelete);
		return productToDelete;
	}

	@Override
	public Product getById(int id) {
		Product product=productRepository.findById(id)
				.orElseThrow(()-> new ProductAppException("product not found"));
		return product;
	}

	@Override
	public Product updateProduct(int id, double price) {
		Product productToUpdate=getById(id);
		productToUpdate.setPrice(price);
		productRepository.save(productToUpdate);
		return productToUpdate;
	}

}
