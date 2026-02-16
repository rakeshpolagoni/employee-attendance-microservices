package com.example.service1App.archive.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeExit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long employeeId;
	private LocalDateTime exitDay;
	private String email;
	
	public EmployeeExit() {
		
	}
	
	public EmployeeExit(Long id,Long employeeId, LocalDateTime exitDay, String email) {
		this.id = id;
		this.employeeId = employeeId;
		this.exitDay = exitDay;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public LocalDateTime getExitDay() {
		return exitDay;
	}
	public void setExitDay(LocalDateTime exitDay) {
		this.exitDay = exitDay;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
