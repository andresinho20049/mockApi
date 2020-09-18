package com.andre.mockapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.andre.mockapi")
public class MockApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockApiApplication.class, args);
	}

}
