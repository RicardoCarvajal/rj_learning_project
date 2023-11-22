package com.intelix.sofka.app.entity;

import java.math.BigDecimal;

public class Account {

	private String id;
	private String idClient;
	private String nameClient;
	private BigDecimal balance;
	private Integer type;
	private Boolean active;

	public Account() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	/* Patron builder */

	public static Account createAccount() {
		return new Account();
	}

	public Account id(String id) {
		this.id = id;
		return this;
	}

	public Account idClient(String idClient) {
		this.idClient = idClient;
		return this;
	}

	public Account nameClient(String nameClient) {
		this.nameClient = nameClient;
		return this;
	}

	public Account balance(BigDecimal balance) {
		this.balance = balance;
		return this;
	}

	public Account type(Integer type) {
		this.type = type;
		return this;
	}

	public Account active(Boolean active) {
		this.active = active;
		return this;
	}

	public Account build() {
		return this;
	}

}
