package com.example.SpringRestApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringRestApi.Entity.Employee;

public interface  EmployeeRepository extends JpaRepository<Employee, Long> {
	
	 

}
