package com.musala.bedrones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
public class BeDronesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeDronesApplication.class, args);
	}

}
