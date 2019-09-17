package com.mingyin.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceBApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceBApplication.class, args);
	}
}