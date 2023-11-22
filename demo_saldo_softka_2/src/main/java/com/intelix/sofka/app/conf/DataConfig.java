package com.intelix.sofka.app.conf;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.intelix.sofka.app.entity.Account;

@Component
public class DataConfig {

	private List<Account> accounts = new ArrayList<>();

	public DataConfig() {
		this.accounts.add(Account.createAccount().id("1").idClient("V16772439").nameClient("Ricardo Carvajal").type(1)
				.active(true).balance(new BigDecimal(785)).build());
		this.accounts.add(Account.createAccount().id("2").idClient("V21032652").nameClient("Emily Reina").type(1)
				.active(true).balance(new BigDecimal(1752)).build());
		this.accounts.add(Account.createAccount().id("3").idClient("V18524652").nameClient("Angelica carvajal").type(1)
				.active(true).balance(new BigDecimal(3752)).build());
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

}
