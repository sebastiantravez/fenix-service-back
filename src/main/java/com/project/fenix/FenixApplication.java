package com.project.fenix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FenixApplication {

	public static void main(String[] args) {
		SpringApplication.run(FenixApplication.class, args);
	}

}
