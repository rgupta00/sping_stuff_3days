package com.studentapp.repo;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.studentapp.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{
	
	//JPQL
	@Query("select s from Student s where s.email=?1")
	Optional<Student> getStudentByEmail(String email);
	
	@Query("select s.firstName from Student s where s.email=?1")
	String getStudentNameByEmail(String email);
	
	//SQL
	@Query(value = "select * from student_table s where s.email=?1", nativeQuery = true)
	Student getStudentByEmailNativeQuery(String email);
	
	@Query(value = "select * from student_table s where s.email=:email", nativeQuery = true)
	Student getStudentByEmailNativeQueryUsingParam(@Param("email")  String email);
	
	List<Student> findByFirstName(String firstName);
	List<Student> findByFirstNameContaining(String firstName);
	List<Student> findByLastName(String firstName);
	List<Student> findByLastNameNotNull();
	List<Student> findByFirstNameAndLastName(String firstName, String lastName);
	
}
