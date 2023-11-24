package com.intelix.sofka.app.entitys;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/* no es una buena practica */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_customer")
	private Customer customer;

	private BigDecimal balance;

	private Boolean active;

	public Account() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Account id(long id) {
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
