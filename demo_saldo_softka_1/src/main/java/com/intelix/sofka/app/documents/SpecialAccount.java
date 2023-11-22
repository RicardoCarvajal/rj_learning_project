package com.intelix.sofka.app.documents;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpecialAccount extends Account {

	private Integer creditsDays;

	public SpecialAccount(String idClient, String nameClient, BigDecimal balance, Integer type) {
		super(idClient, nameClient, balance, type);
		this.creditsDays = 30;
	}

}
