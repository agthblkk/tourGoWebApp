package com.example.tourgowebappfinalversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.tourgowebappfinalversion.Database",
"com.example.tourgowebappfinalversion.Controllers"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
