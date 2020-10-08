package com.example.SpringRestApi.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringRestApi.Entity.Employee;
import com.example.SpringRestApi.Repository.EmployeeRepository;

@Service
public class EmployeeDAO {
	
	@Autowired
	EmployeeRepository employeerepository;
	
	public Employee save(Employee emp) {
		return employeerepository.save(emp);
	}
	
	public List<Employee> findAll(){
		return employeerepository.findAll();
	}
	
	public Employee findEmployeeById(Long empid) {
		// TODO Auto-generated method stub
		Employee emp = employeerepository.findById(empid).get();
		return emp;
	}
	
	
	public Employee delete(Employee emp) {
		Employee emp1 = findEmployeeById(emp.getId());
		if(emp1!=null) {
			employeerepository.delete(emp);
		}
		
		return emp;
		
	}

	

}
