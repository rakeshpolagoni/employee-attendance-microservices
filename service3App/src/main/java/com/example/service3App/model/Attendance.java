package com.example.service3App.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Attendance {
	@Id
	@GeneratedValue
	private Long id;
	private LocalDateTime login;
	private LocalDateTime logout;
	private String status;
	
	private Long employeeId;
	
	public Attendance() {
		
	}
	public Attendance(Long id,LocalDateTime login,LocalDateTime logout, String status,Long employeeId) {
		this.id=id;
		this.login=login;
		this.logout=logout;
		this.status=status;
		this.employeeId=employeeId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getLogin() {
		return login;
	}

	public void setLogin(LocalDateTime login) {
		this.login = login;
	}

	public LocalDateTime getLogout() {
		return logout;
	}

	public void setLogout(LocalDateTime logout) {
		this.logout = logout;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
	
	
	

}
