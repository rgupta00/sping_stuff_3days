package com.productapp.service;

import java.util.List;

import com.productapp.dto.ProductDto;
import com.productapp.entity.Product;

public interface ProductService {
	public List<ProductDto> getAll();
	public ProductDto getById(Integer id );
	public ProductDto addProduct(ProductDto product);
	public ProductDto deleteProduct(Integer id );
	public ProductDto updateProduct(Integer id, ProductDto product );
}
