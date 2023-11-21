package com.intelix.sofka.app.documents;

import java.math.BigDecimal;

public class NormalAccount extends Account {

	public NormalAccount(String idClient, String nameClient, BigDecimal balance, Integer type) {
		super(idClient, nameClient, balance, type);
	}

}
