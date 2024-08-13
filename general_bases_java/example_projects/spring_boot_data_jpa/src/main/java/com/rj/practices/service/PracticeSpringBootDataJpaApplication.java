package com.rj.practices.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
public class PracticeSpringBootDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeSpringBootDataJpaApplication.class, args);
	}

}
