package com.intelix.sofka.app.dto;

import java.math.BigDecimal;

public class ResposeAccount {

	private String id;
	private String name;
	private BigDecimal balance;
	private Boolean active;

	public ResposeAccount() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
