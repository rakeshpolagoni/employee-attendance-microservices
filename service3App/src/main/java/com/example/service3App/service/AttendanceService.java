package com.example.service3App.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.service3App.client.EmployeeClient;
import com.example.service3App.dto.EmployeeDto;
import com.example.service3App.model.Attendance;
import com.example.service3App.repository.AttendanceRepository;

@Service
public class AttendanceService {
	
	@Autowired
	public EmployeeClient client;
	
	@Autowired
	public AttendanceRepository repo;
	
	
	public String sessionLogout(EmployeeDto e) {
		EmployeeDto em=client.getByEmployeeEmail(e.getEmail());
		if(em==null) {
			return "Employee not found";
			
		}
		Attendance att=repo.getByEmployeeId(em.getId());
		if(att==null) {
			return "Login first";
		}
		att.setLogout(LocalDateTime.now());
		repo.save(att);
		return "Log out suucessfull";
	}
	

}
