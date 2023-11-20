package com.intelix.sofka.app.servicios.imp;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelix.sofka.app.models.BankAccount;
import com.intelix.sofka.app.servicios.DepositServices;

@Service
public class DepositOfficeServicesImp implements DepositServices {

	private final BankAccount bankAccount;

	@Autowired
	public DepositOfficeServicesImp(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public BigDecimal generateDeposit(BigDecimal amount) {
		bankAccount.setBalance(bankAccount.getBalance().add(amount));
		System.out.println(bankAccount.getBalance());
		return bankAccount.getBalance();
	}

}
