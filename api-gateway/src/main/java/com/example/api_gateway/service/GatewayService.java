package com.example.api_gateway.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api_gateway.client.AttendanceClient;
import com.example.api_gateway.client.EmployeeClient;
import com.example.api_gateway.dto.AttendanceRequest;
import com.example.api_gateway.dto.EmployeeDto;
import com.example.api_gateway.security.JwtUtil;

@Service
public class GatewayService {
	@Autowired
	private EmployeeClient client;
	@Autowired
	private AttendanceClient attendanceclient;
	@Autowired
	private JwtUtil jwtutil;
	public String markAttendance(EmployeeDto emp) {
		EmployeeDto e=client.getByEmployeeEmail(emp.getEmail());
		if(e==null) {
			return "Employee not found";
			
		}
		if(!emp.getPassword().equals(e.getPassword())) {
			return "enter correct password";
		}
		String token=jwtutil.generateToken(emp.getEmail());
		AttendanceRequest ar=new AttendanceRequest();
		ar.setEmployeeId(e.getId());
		ar.setStatus("present");
		ar.setLogin(LocalDateTime.now());
		
		attendanceclient.markLogin(ar);
		return "log in successfull: "+token;
		
	}

}
