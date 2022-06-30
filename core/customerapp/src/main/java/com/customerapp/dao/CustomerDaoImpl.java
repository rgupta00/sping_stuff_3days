package com.customerapp.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao{
	private HashMap<Integer, Customer> customersMap;
	private int counter=0;
	public CustomerDaoImpl() {
		customersMap=new HashMap<Integer, Customer>();
		customersMap.put(1, new Customer(1, "raj@gmail.com", "raj", LocalDate.of(1980, Month.APRIL, 11), true));
		customersMap.put(2,  new Customer(2, "ekta@gmail.com", "ekta", LocalDate.of(1982, Month.MAY, 11), true));
		customersMap.put(3, new Customer(3, "gunika@gmail.com", "gunika", LocalDate.of(2011, Month.MAY, 11), true));
		
		counter=3;
		
		
	}
	@Override
	public List<Customer> getAll() {
		return new ArrayList<Customer>(customersMap.values());
	}

	@Override
	public Customer getById(Integer id) {
		
		return customersMap.get(id);
	}

	@Override
	public Customer addCustomer(Customer customer) {
		++counter;
		customer.setId(counter);
		customersMap.put(counter,customer );
		return customer;
	}

	@Override
	public Customer deleteCustomer(Integer id) {
		Customer customerToDelete=null;
		if(customersMap.containsKey(id)) {
			customerToDelete=customersMap.get(id);
			customersMap.remove(id);
		}
		return customerToDelete;
	}

	@Override
	public Customer updateCustomer(Integer id, Customer customer) {
		Customer customerToUpdate=null;
		if(customersMap.containsKey(id)) {
			customerToUpdate=customersMap.get(id);
			customerToUpdate.setEmail(customer.getEmail());
			customerToUpdate.setActive(customer.isActive());
			customersMap.put(id, customerToUpdate);
		}
		return customerToUpdate;

	}

}
