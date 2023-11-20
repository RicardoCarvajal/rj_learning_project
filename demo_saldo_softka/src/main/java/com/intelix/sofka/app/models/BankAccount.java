package com.intelix.sofka.app.models;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class BankAccount {

	private BigDecimal balance = new BigDecimal(100);

}
