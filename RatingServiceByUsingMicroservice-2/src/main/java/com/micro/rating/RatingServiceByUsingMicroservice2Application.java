package com.micro.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RatingServiceByUsingMicroservice2Application {

	public static void main(String[] args) {
		SpringApplication.run(RatingServiceByUsingMicroservice2Application.class, args);
	}

}
