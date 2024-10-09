package com.ReUseTech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.ReUseTech.model")
@EnableJpaRepositories(basePackages = "com.ReUseTech.repositories")
public class ReUseTechApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReUseTechApplication.class, args);
	}

}