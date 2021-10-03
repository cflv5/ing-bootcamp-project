package com.ing.citizenapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CitizenApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitizenApiApplication.class, args);
	}

}
