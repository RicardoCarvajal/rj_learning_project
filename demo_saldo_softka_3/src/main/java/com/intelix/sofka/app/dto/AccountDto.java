package com.intelix.sofka.app.dto;

import java.math.BigDecimal;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
public class AccountDto {

	@Valid
	@NotNull(message = "El cliente no debe ser nulo")
	private CustomerDto customer;

	@NotNull(message = "La cuenta se debe crear con saldo")
	private BigDecimal balance;

	public AccountDto() {

	}

	public CustomerDto getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}
