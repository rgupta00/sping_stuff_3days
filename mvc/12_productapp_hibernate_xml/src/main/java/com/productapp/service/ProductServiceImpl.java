package com.productapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.dao.ProductDao;
import com.productapp.entities.Product;
import com.productapp.exception.ProductNotFoundException;
import com.productapp.util.MyLogger;

//productServiceImpl
@Service(value = "ps") // BL=FR+ NFR(tx mgt,sec, logging , cahing ... AOP)
@Transactional	//It use Around advice ...
public class ProductServiceImpl implements ProductService {

	// @Autowired: field vs setter vs Constructor inject
	// if dep is mandatory: go for ctr injection
	// id dep may be there may not be threre-- setter inject

	private ProductDao productDao;

	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	@MyLogger
	@Override
	public List<Product> getAll() {
		// hey raj u have to calculate how much time this code is using to exected and
		// put that into a log file log4j

		List<Product> list = productDao.getAll().stream().filter(p -> p.isAvailable() == true)
				.collect(Collectors.toList());

		return list;

	}

	@Override
	public Product getById(Integer id) {
		Product product= productDao.getById(id);
		if(product==null)
			throw new ProductNotFoundException("product with id "+ id +" is not found");
		return product;
	}

	@Override
	public Product addProduct(Product product) {
		return productDao.addProduct(product);
	}

	@Override
	public Product deleteProduct(Integer id) {
		return productDao.deleteProduct(id);
	}

	@Override
	public Product updateProduct(Integer id, Product product) {
		return productDao.updateProduct(id, product);
	}

}
