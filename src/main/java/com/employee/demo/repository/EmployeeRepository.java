package com.employee.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.demo.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	
	 String findById(int id);

}