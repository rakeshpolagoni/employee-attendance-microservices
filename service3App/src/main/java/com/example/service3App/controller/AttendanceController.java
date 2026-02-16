package com.example.service3App.controller;

import java.time.LocalDateTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service3App.dto.EmployeeDto;
import com.example.service3App.model.Attendance;
import com.example.service3App.service.AttendanceService;
import com.example.service3App.repository.AttendanceRepository;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
	
	@Autowired
	private AttendanceService service;
	
	@Autowired
	private AttendanceRepository repo;
	
	@PostMapping("/login")
	public void logIn(@RequestBody Attendance att) {
		Attendance attendance=new Attendance();
		
		attendance.setStatus(att.getStatus());
		attendance.setLogin(att.getLogin());
		attendance.setEmployeeId(att.getEmployeeId());
		repo.save(attendance);
		
		
		
	}
	
	@PostMapping("/logout")
	public String logOut(@RequestBody EmployeeDto employee) {
		return service.sessionLogout(employee);
	}
	
	
	

}
