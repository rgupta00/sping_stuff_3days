package com.customer.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// JpaRepository: u dont have to write curd operaetion 
//JpaRepository > CrudRepository
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	//how to create customized methods 
	//find by email id
	public Optional<Customer> findByEmailId(String emailId);
	public Optional<Customer> findByEmailIdAndName(String emailId, String name);
	
	public Optional<Customer> findByEmailIdOrName(String emailId, String name);
	
	public List<Customer> findByEmailIdNull();
	
	public List<Customer> findByNameLike(String pattern);// ra 
	
	public List<Customer> findByDateOfBirthAfter(LocalDate localDate);
	
	public List<Customer> findByDateOfBirthBefore(LocalDate localDate);
	
	//i want customer records but it should arrrange as per there dob in desc
	public List<Customer> findByNameOrderByDateOfBirthDesc(String name);
	
}
