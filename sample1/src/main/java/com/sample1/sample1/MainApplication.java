package com.sample1.sample1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.sample1") 
public class MainApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);

	}
}
