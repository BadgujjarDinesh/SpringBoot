package com.example.SpringRestApi.EmployeeController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringRestApi.DAO.EmployeeDAO;
import com.example.SpringRestApi.Entity.Employee;

@RestController
@RequestMapping("/company")
public class EmployeeController {
	@Autowired
	EmployeeDAO empdao;
	
	/* save employee in the database*/
	
	@PostMapping("/Employees")
	public Employee createEmployee(@Validated @RequestBody Employee emp) {
		return empdao.save(emp);
	}
	
	/* get all  employee from the database*/
	
	@GetMapping("/Employees")
	public List<Employee> getAllEmployees() {
		return empdao.findAll();
	}
	
	/* get employee by empid*/
	@GetMapping("/Employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long empid){
		Employee emp= empdao.findEmployeeById(empid);
		
		return ResponseEntity.ok().body(emp);
		
		
		
	}
	
	/* update an employee by empid */
	@PutMapping("/Employees/{id}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long empid, @Validated @RequestBody Employee empdetails){
			Employee emp = empdao.findEmployeeById(empid);
			
			if(emp==null) {
				return ResponseEntity.notFound().build();
			}
			emp.setName(empdetails.getName());
			emp.setDesignation(empdetails.getDesignation());
			emp.setExpertise(empdetails.getExpertise());
			
			Employee updateEmployee =empdao.save(emp);
			return ResponseEntity.ok().body(updateEmployee);
			
			
		}
	
	
	/* delete an employee */
	@DeleteMapping("/Employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empid){
		Employee emp =empdao.findEmployeeById(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		empdao.delete(emp);
		return ResponseEntity.ok().build();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	

}
