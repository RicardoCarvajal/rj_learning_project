package com.intelix.sofka.app.dto;

import java.math.BigDecimal;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Validated
public class MovementDto {

	@NotEmpty(message = "El id de la cuenta no debe estar en blanco")
	@NotNull(message = "El id de la cuenta no debe ser nulo")
	private String idAccount;

	@NotNull(message = "El monto del deposito no puede ser nulo")
	private BigDecimal amount;

	private BigDecimal commission;

	public MovementDto() {

	}

	public String getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(String idAccount) {
		this.idAccount = idAccount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getCommission() {
		return commission;
	}

	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}

}
