package com.sofka.services.app.dto;

import java.math.BigDecimal;

import jakarta.validation.Valid;
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

	private String id;

	@Valid
	@NotNull(message = "[CUENTA] [Cliente] Campo Requerido: La Cuenta debe poseer información del Cliente.")
	private CustomerDto customer;

	@NotNull(message = "[CUENTA] [Saldo] Campo Requerido: La Cuenta debe poseer saldo.")
	private BigDecimal globalBalance;

}
