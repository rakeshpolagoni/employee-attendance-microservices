package com.example.api_gateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.api_gateway.dto.AttendanceRequest;

@FeignClient(name="attendance-service",url="http://localhost:8083")
public interface AttendanceClient {
	
	@PostMapping("/attendance/login")
	void markLogin(@RequestBody AttendanceRequest request);

}
