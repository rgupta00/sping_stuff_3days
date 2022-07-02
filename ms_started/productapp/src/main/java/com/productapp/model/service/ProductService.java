package com.productapp.model.service;
import java.util.*;

import com.productapp.model.dao.Product;
public interface ProductService {
	public List<Product>getAll();
	public Product addProduct(Product product);
	public Product deleteProduct(int id);
	public Product getById(int id);
	public Product updateProduct(int id, double price);
}
