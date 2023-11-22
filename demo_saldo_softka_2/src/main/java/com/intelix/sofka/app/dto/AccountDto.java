package com.intelix.sofka.app.dto;

import java.math.BigDecimal;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Validated
public class AccountDto {

	@NotNull(message = "El id del cliente no debe ser nulo")
	@NotEmpty(message = "El id del cliente no debe estar en blanco")
	private String idClient;

	@NotNull(message = "El nombre del cliente no debe ser nulo")
	@NotEmpty(message = "El nombre del cliente no debe estar en blanco")
	private String nameClient;

	@NotNull(message = "La cuenta se debe crear con saldo")
	private BigDecimal balance;

	@NotNull(message = "El tipo de cliente no debe ser nulo")
	@Max(value = 2, message = "Ingrese un numero entre 1 y 2")
	@Min(value = 1, message = "Ingrese un numero entre 1 y 2")
	private Integer type;

	public AccountDto() {

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

}
