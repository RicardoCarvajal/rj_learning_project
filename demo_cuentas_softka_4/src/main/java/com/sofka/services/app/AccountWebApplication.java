package com.sofka.services.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.rabbitmq.Receiver;

@SpringBootApplication
public class AccountWebApplication implements CommandLineRunner {

	private final Receiver receiver;

	public AccountWebApplication(Receiver receiver) {
		this.receiver = receiver;
	}

	public static void main(String[] args) {
		SpringApplication.run(AccountWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
