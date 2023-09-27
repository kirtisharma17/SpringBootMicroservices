package com.micro.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HotelServiceByUsingMicroservice1Application {

	public static void main(String[] args) {
		SpringApplication.run(HotelServiceByUsingMicroservice1Application.class, args);
	}

}
