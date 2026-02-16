package com.example.service1App.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service1App.primary.model.Employee;
import com.example.service1App.archive.model.EmployeeExit;
import com.example.service1App.archive.repository.EmployeeExitRepository;
import com.example.service1App.primary.repository.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeExitController {
	
	@Autowired
	private EmployeeRepository repo;
	
	@Autowired
	private EmployeeExitRepository repo1;
	
	@PostMapping("/exit")
	public String employeeExit(@RequestBody Employee emp) {
		Employee e=repo.findByEmail(emp.getEmail()).orElse(null);
		if(e==null) {
			return "employee not found";
		}
		EmployeeExit ex=new EmployeeExit();
		ex.setEmployeeId(e.getId());
		ex.setEmail(e.getEmail());
		
		ex.setExitDay(LocalDateTime.now());
		repo1.save(ex);
		
		
		
		return "";
	}
	
	
	

}
