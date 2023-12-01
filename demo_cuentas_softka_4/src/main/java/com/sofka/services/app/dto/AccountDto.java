package com.sofka.services.app.dto;

import java.math.BigDecimal;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
	// @NotNull(message = "[CUENTA] [id] Campo Requerido: Id.")
	private String id;

	@Valid
	@NotNull(message = "[CUENTA] [Cliente] Campo Requerido: La Cuenta debe poseer información del Cliente.")
	private CustomerDto customer;

	@DecimalMin(value = "0.00", inclusive = true, message = "[CUENTA] [saldo_Global] El Saldo Inicial deber ser mayor o igual a 0.00")
	@DecimalMax(value = "1000000.00", inclusive = true, message = "[CUENTA] [saldo_Global] El Saldo Inicial deber ser menor o igual a 1000000.00")
	// @Digits(integer = 7, fraction = 2, message = "[CUENTA] [saldo_Global] El
	// Formato del Saldo debe ser 7 digitos enteros y 2 decimales")
	private BigDecimal globalBalance;

}
