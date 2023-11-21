package com.intelix.sofka.app.servicios.imp;

import org.springframework.stereotype.Service;

import com.intelix.sofka.app.documents.Account;
import com.intelix.sofka.app.repository.AccountRepository;
import com.intelix.sofka.app.request.RequestMovement;
import com.intelix.sofka.app.servicios.DepositService;

@Service
public class DepositServicesImp implements DepositService {

	private final AccountRepository accountRepository;

	public DepositServicesImp(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public Account generateDeposit(Account account, RequestMovement movement) {
		account.setBalance(account.getBalance().add(movement.getAmount()));
		return accountRepository.save(account);
	}

}
