package com.example.service3App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Service3AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(Service3AppApplication.class, args);
    }
}
