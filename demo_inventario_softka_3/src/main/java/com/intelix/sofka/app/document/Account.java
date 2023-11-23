package com.intelix.sofka.app.document;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("accounts")
public class Account {

	@Id
	private String id;
	private Customer customer;
	private BigDecimal balance;
	private Boolean active;

	public Account() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	/* Builder */

	public static Account createAccount() {
		return new Account();
	}

	public Account id(String id) {
		this.id = id;
		return this;
	}

	public Account customer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public Account balance(BigDecimal balance) {
		this.balance = balance;
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
