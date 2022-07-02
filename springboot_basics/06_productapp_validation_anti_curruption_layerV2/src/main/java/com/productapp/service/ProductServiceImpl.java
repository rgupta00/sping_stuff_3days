package com.productapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.dao.ProductDao;
import com.productapp.dto.ProductDto;
import com.productapp.entity.Product;
import com.productapp.exception.ProductNotFoundException;
import com.productapp.util.ConversionUtil;
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
	public List<ProductDto> getAll() {
		// hey raj u have to calculate how much time this code is using to exected and
		// put that into a log file log4j

		List<ProductDto> list = productDao.getAll().
					stream()
					.filter(p -> p.isAvailable() == true)
					.map(ConversionUtil::convertToProductDto)
				.collect(Collectors.toList());

		return list;

	}

	@Override
	public ProductDto getById(Integer id) {
		Product product= productDao.getById(id);
		if(product==null)
			throw new ProductNotFoundException("product with id "+ id +" is not found");
		return null;
	}

	@Override
	public ProductDto addProduct(ProductDto product) {
		// productDao.addProduct(product);
		 return null;
	}

	@Override
	public ProductDto deleteProduct(Integer id) {
		// productDao.deleteProduct(id);
		return null;
	}

	@Override
	public ProductDto updateProduct(Integer id, ProductDto product) {
		// productDao.updateProduct(id, product);
		return null;
	}

}
