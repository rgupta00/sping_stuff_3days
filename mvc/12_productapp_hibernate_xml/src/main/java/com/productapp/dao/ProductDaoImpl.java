package com.productapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.productapp.entities.Product;
import com.productapp.exception.ProductNotFoundException;

@Repository
@Primary
public class ProductDaoImpl implements ProductDao {

	private SessionFactory factory;

	@Autowired
	public ProductDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}

	// helper method
	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public List<Product> getAll() {
		return getSession().createQuery("select p from Product p", Product.class).getResultList();
	}

	@Override
	public Product getById(Integer id) {
		Product product = getSession().get(Product.class, id);
		if (product == null)
			throw new ProductNotFoundException("product with id " + id + " is not found");
		return product;
	}

	@Override
	public Product addProduct(Product product) {
		//start the tx
		getSession().save(product);
		//commit the trx
		
		//rollback :(
		return product;
	}

	@Override
	public Product deleteProduct(Integer id) {
		Product productToDelete = getById(id);
		getSession().delete(productToDelete);
		return productToDelete;
	}

	@Override
	public Product updateProduct(Integer id, Product product) {
		Product productToUpdate = getById(id);
		productToUpdate.setAvailable(product.isAvailable());
		productToUpdate.setPrice(product.getPrice());

		getSession().merge(productToUpdate);

		return productToUpdate;
	}

}
