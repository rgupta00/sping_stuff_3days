package com.customer.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.customer.dto.CustomerData;
//SQL vs JPQL(OO version of SQL): @Query
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	//i want to get all customer based on eamilId
	@Query(nativeQuery = false, value = "select c from Customer c where c.emailId=:emailId")
	public Customer getCustomerByEmail(@Param("emailId") String emailId);
	
	@Query(nativeQuery = false, value = "select c.name from Customer c where c.emailId=:emailId")
	public String getCustomerNameByEmail(@Param("emailId") String emailId);
	
	@Query(nativeQuery = false, value = "select new com.customer.dto.CustomerData( c.emailId,c.name ) from Customer c where c.emailId=:emailId")
	public CustomerData getCustomerNameAndEmail(@Param("emailId") String emailId);
	
	//update operation
	//u want to update a customer records : email if id=
	
	@Query(nativeQuery = false, value = "update Customer c set c.emailId=:emailId where c.customerId=:customerId")
	@Modifying
	@Transactional
	public void updateEmail(@Param("emailId") String emailId, @Param("customerId") Integer customerId);
	
	@Query(nativeQuery = false, value = "delete from Customer c where c.emailId=:emailId")
	@Modifying
	@Transactional
	public void deleteCustomerEmail(@Param("emailId") String emailId);
}







