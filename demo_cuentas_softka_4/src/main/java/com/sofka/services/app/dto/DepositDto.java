package com.sofka.services.app.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepositDto {

	@NotNull
	@NotEmpty
	private String idAccount;

	@NotNull
	private BigDecimal amount;

	@NotNull
	@NotEmpty
	private String type;

}
