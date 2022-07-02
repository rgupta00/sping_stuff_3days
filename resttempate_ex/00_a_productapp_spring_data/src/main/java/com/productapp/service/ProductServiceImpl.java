package com.productapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.dao.ProductDao;
import com.productapp.entity.Product;
import com.productapp.exception.ProductNotFoundException;
import com.productapp.util.MyLogger;

@Service(value = "ps")
@Transactional
public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	@MyLogger
	@Override
	public List<Product> getAll() {

		List<Product> list = productDao.findAll().stream().filter(p -> p.isAvailable() == true)
				.collect(Collectors.toList());

		return list;

	}

	@Override
	public Product getById(Integer id) {
		Optional<Product> productOpt = productDao.findById(id);

		return productOpt.orElseThrow(() -> new ProductNotFoundException("product with id " + id + " is not found"));
	}

	@Override
	public Product addProduct(Product product) {
		productDao.save(product);
		return product;
	}

	@Override
	public Product deleteProduct(Integer id) {
		Product productToDelete = getById(id);
		productDao.delete(productToDelete);
		return productToDelete;
	}

	@Override
	public Product updateProduct(Integer id, Product product) {
		Product productToUpdate = getById(id);
		productToUpdate.setAvailable(product.isAvailable());
		productToUpdate.setPrice(product.getPrice());
		// save and update: same method: save
		productDao.save(productToUpdate);

		return productToUpdate;
	}

}
