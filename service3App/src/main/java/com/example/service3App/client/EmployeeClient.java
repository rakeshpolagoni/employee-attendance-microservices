package com.example.service3App.client;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.service3App.dto.EmployeeDto;

@FeignClient(name="employee-service",url="http://localhost:8082")
public interface EmployeeClient {
	
	@GetMapping("/employees/employeeEmail/{email}")
	EmployeeDto getByEmployeeEmail(@PathVariable("email") String email);

}
