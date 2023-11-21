package com.intelix.sofka.app.factory;

import java.math.BigDecimal;

import com.intelix.sofka.app.documents.Account;
import com.intelix.sofka.app.documents.NormalAccount;
import com.intelix.sofka.app.documents.SpecialAccount;
import com.intelix.sofka.app.request.RequestAccount;

public class AccountFactory {

	Account account;

	public AccountFactory(RequestAccount account) {
		switch (account.getType()) {
		case 1: {

			this.account = new SpecialAccount(account.getIdClient(), account.getNameClient(), BigDecimal.ZERO,
					account.getType());
			break;
		}
		case 2: {

			this.account = new NormalAccount(account.getIdClient(), account.getNameClient(), BigDecimal.ZERO,
					account.getType());
			break;
		}
		default:
			this.account = new NormalAccount(account.getIdClient(), account.getNameClient(), BigDecimal.ZERO,
					account.getType());
			break;
		}

	}

	public Account getAccount() {
		return this.account;
	}

}
