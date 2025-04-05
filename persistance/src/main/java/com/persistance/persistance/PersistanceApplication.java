package com.persistance.persistance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.persistance", "com.persistance.persistance"})
public class PersistanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersistanceApplication.class, args);
	}

}
