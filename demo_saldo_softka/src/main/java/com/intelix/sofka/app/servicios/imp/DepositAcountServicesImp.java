package com.intelix.sofka.app.servicios.imp;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelix.sofka.app.models.BankAccount;
import com.intelix.sofka.app.servicios.DepositServices;

@Service
public class DepositAcountServicesImp implements DepositServices {

	private final BankAccount bankAccount;

	@Autowired
	public DepositAcountServicesImp(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public BigDecimal generateDeposit(BigDecimal amount) {

		bankAccount.setBalance(bankAccount.getBalance().subtract(new BigDecimal(1.5)));
		bankAccount.setBalance(bankAccount.getBalance().add(amount));
		System.out.println(bankAccount.getBalance());
		return bankAccount.getBalance();
	}

}
