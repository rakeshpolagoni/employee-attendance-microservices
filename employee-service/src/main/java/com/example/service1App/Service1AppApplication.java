package com.example.service1App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Service1AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(Service1AppApplication.class, args);
	}

}
