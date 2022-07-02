package com.productapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.productapp.entity.Product;
import com.productapp.exception.ProductNotFoundException;

@Repository
@Primary
public class ProductDaoImpl implements ProductDao {

	private EntityManager em;

	@Autowired
	public ProductDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Product> getAll() {
		return em.createQuery("select p from Product p", Product.class).getResultList();
	}

	@Override
	public Product getById(Integer id) {
		Product product = em.find(Product.class, id);
		if (product == null)
			throw new ProductNotFoundException("product with id " + id + " is not found");
		return product;
	}

	@Override
	public Product addProduct(Product product) {
		em.persist(product);
		
		return product;
	}

	@Override
	public Product deleteProduct(Integer id) {
		Product productToDelete = getById(id);
		em.remove(productToDelete);
		return productToDelete;
	}

	@Override
	public Product updateProduct(Integer id, Product product) {
		Product productToUpdate = getById(id);
		productToUpdate.setAvailable(product.isAvailable());
		productToUpdate.setPrice(product.getPrice());
		em.merge(productToUpdate);
		return productToUpdate;
	}

}
