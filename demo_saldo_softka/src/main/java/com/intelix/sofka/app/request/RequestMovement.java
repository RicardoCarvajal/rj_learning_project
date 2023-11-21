package com.intelix.sofka.app.request;

import java.math.BigDecimal;

import com.intelix.sofka.app.documents.Account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestMovement {

	private Account account;
	private BigDecimal amount;
	private BigDecimal commission;

}
