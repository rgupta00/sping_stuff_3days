package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.productapp.entity.Product;
import com.productapp.repo.ProductRepo;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	@Override
	public List<Product> getAll() {
		return productRepo.findAll();
	}

	//getAll Sorted AsPer Name
	@Override
	public List<Product> getAllSortedAsPerName(String field) {
		return productRepo.findAll(Sort.by(Sort.Direction.ASC, field));
	}
	//find Products With Pagination
	@Override
	public Page<Product> findProductsWithPagination(int offSet, int pageSize) {
		Page<Product> productsPage= productRepo.findAll(PageRequest.of(offSet, pageSize));
		return productsPage;
	}
	//find Products With Pagination And Sorting
	@Override
	public Page<Product> findProductsWithPaginationAndSorting
						(int offSet, int pageSize, String field) {
		Page<Product> productsPage= productRepo
					.findAll(PageRequest.of(offSet, pageSize).withSort(Sort.by(field)));
		return productsPage;
	}

}






