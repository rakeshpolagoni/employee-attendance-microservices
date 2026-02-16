package com.example.api_gateway.dto;

import java.time.LocalDateTime;

public class AttendanceRequest {
	
	private LocalDateTime login;
	private LocalDateTime logout;
	private String status;
	private Long employeeId;
	public AttendanceRequest() {
		
	}
	public AttendanceRequest(LocalDateTime login,LocalDateTime logout,String status,Long employeeId) {
		this.login=login;
		this.logout=logout;
		this.status=status;
		this.employeeId=employeeId;
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
		this.employeeId=employeeId;
	}
	

}
