package com.app.Taller3AYGO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class AppServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppServiceApplication.class, args);
	}

}
