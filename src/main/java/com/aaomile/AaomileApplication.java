package com.aaomile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.aaomile", "Config"})
public class AaomileApplication {

	public static void main(String[] args) {
		SpringApplication.run(AaomileApplication.class, args);
	}

}
