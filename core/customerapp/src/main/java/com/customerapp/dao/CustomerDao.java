package com.customerapp.dao;
import java.util.*;
public interface CustomerDao {
	public List<Customer> getAll();
	public Customer getById(Integer id );
	public Customer addCustomer(Customer customer);
	public Customer deleteCustomer(Integer id );
	public Customer updateCustomer(Integer id, Customer customer );
}
