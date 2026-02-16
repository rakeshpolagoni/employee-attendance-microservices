package com.example.api_gateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.api_gateway.dto.EmployeeDto;

@FeignClient(name="attendace-service",url="http://localhost:8082")
public interface EmployeeClient {
	
	@GetMapping("/employees/employeeEmail/{email}")
	EmployeeDto getByEmployeeEmail(@PathVariable("email") String email);

}
