package com.intelix.sofka.app.documents;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Account {

	@Id
	private String _id;
	private String idClient;
	private String nameClient;
	private BigDecimal balance;
	private Integer type;

	public Account(String idClient, String nameClient, BigDecimal balance, Integer type) {
		this.idClient = idClient;
		this.nameClient = nameClient;
		this.balance = balance;
		this.type = type;
	}

	public Account() {

	}

}
