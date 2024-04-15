package com.managehotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ManageHotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageHotelApplication.class, args);
	}

}
