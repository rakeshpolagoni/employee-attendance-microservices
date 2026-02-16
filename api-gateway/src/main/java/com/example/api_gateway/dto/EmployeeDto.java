package com.example.api_gateway.dto;

public class EmployeeDto {
	private Long id;
	private String email;
	private String password;
	public EmployeeDto() {
		
	}
	
	public EmployeeDto(Long id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setEmployeeId(Long employeeId) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
