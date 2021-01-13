package com.HostelManagement.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HostelManagementApiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(HostelManagementApiApplication.class, args);
	}

}
