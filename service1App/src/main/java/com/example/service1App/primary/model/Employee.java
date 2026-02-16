package com.example.service1App.primary.model;



import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@NotBlank
	@Schema(description = "Employee email",requiredMode = Schema.RequiredMode.REQUIRED)
	private String email;
	
	@NotBlank
	@Schema(description = "Employee email",requiredMode = Schema.RequiredMode.REQUIRED)
	private String password;  
	
	public Employee() {
		
	}
	public Employee(Long id,String name, String email,String password) {
		this.id=id;
		this.email=email;
		this.password=password;
		this.name=name;
		
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
