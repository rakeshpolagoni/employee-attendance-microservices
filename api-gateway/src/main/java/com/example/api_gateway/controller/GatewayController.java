package com.example.api_gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_gateway.dto.EmployeeDto;
import com.example.api_gateway.service.GatewayService;

@RestController
@RequestMapping("/auth")
public class GatewayController {
	
	@Autowired
	private GatewayService service;
	
	@PostMapping("/login")
	public String markAttenndace(@RequestBody EmployeeDto employee) {
		return service.markAttendance(employee);
		
	}
	
	
	
	

}
