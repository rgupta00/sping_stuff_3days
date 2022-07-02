package com.empapp.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.empapp.entities.Service;
@Repository
public interface ServiceRepository extends CrudRepository<Service, Integer> {

}
