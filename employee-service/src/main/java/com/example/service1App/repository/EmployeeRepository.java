package com.example.service1App.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.service1App.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  
}
