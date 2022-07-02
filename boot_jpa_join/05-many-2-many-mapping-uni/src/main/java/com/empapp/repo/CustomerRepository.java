package com.empapp.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.empapp.entities.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
