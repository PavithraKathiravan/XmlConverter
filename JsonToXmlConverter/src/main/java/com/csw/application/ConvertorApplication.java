package com.csw.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.csw" })
public class ConvertorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConvertorApplication.class, args);
	}

}
