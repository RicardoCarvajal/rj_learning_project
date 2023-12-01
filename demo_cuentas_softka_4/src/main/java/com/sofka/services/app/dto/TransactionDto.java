package com.sofka.services.app.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

	private String id;
	private AccountDto account;
	private BigDecimal amountTransaction;
	private BigDecimal initBalence;
	private BigDecimal finalBalance;
	private BigDecimal transactionCost;
	private String type;

}
