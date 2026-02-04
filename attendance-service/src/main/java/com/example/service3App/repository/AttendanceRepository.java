package com.example.service3App.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.service3App.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
