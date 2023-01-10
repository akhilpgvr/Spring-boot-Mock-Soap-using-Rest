package com.sample.trails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sample.trails"})
public class TrailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrailsApplication.class, args);
	}

}