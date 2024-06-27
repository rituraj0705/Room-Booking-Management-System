package com.rbms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"com.rbms"})
@EntityScan("com.rbms.model")
public class RoomBookingManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomBookingManagementSystemApplication.class, args);
	}

}
