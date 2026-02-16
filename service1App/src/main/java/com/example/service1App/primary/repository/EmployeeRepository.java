package com.example.service1App.primary.repository;


import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.service1App.primary.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	Optional<Employee> findByEmail(String email);

}
