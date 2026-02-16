package com.example.service1App.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service1App.primary.model.Employee;
import com.example.service1App.primary.repository.EmployeeRepository;



@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repo;
	
	
	@PostMapping("/register")
	public String registerEmployeee(@RequestBody Employee e) {
		repo.save(e);
		return "Employee registration succesfull";
		
	}
	
	@GetMapping("/employeeId/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		return repo.findById(id).orElse(null);
		
	}
	
	@GetMapping("/employeeEmail/{email}")
	public Employee getEmployeeByEmail(@PathVariable String email) {
		System.out.println(email);
		
		return repo.findByEmail(email).orElse(null);
	}
	
	
	

}
