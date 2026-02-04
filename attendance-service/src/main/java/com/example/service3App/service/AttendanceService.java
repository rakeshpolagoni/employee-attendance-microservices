package com.example.service3App.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.service3App.client.EmployeeClient;
import com.example.service3App.dto.EmployeeDto;
import com.example.service3App.exception.EmployeeNotFoundException;
import com.example.service3App.exception.EmployeeServiceDownException;
import com.example.service3App.model.Attendance;
import com.example.service3App.repository.AttendanceRepository;

import feign.FeignException;
import jakarta.servlet.http.HttpServletRequest;

import java.lang.RuntimeException;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository repository;

    @Autowired
    private HttpServletRequest request;

    public Attendance markAttendance(Attendance attendance) {

        
        String employeeIdHeader = request.getHeader("X-Employee-Id");

        if (employeeIdHeader == null) {
            throw new RuntimeException("Employee identity missing");
        }

        Long employeeId = Long.valueOf(employeeIdHeader);

        attendance.setEmployeeId(employeeId);
        return repository.save(attendance);
    }
}
