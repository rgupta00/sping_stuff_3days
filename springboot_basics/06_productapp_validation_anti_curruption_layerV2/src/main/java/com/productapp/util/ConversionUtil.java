package com.productapp.util;

import com.productapp.dto.ProductDto;
import com.productapp.entity.Product;

public class ConversionUtil {

	public static ProductDto convertToProductDto(Product product) {
		ProductDto dto = new ProductDto();
		dto.setAvailable(product.isAvailable());
		dto.setId(product.getId());
		dto.setName(product.getName());
		dto.setPrice(product.getPrice());
		return dto;
	}

	public static Product convertToProduct(ProductDto productDto) {
		Product product = new Product();
		product.setAvailable(productDto.isAvailable());
		product.setId(productDto.getId());
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		return product;
	}

}
