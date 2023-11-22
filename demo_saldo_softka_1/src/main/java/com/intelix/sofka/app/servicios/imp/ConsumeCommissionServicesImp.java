package com.intelix.sofka.app.servicios.imp;

import org.springframework.stereotype.Service;

import com.intelix.sofka.app.documents.Account;
import com.intelix.sofka.app.repository.AccountRepository;
import com.intelix.sofka.app.request.RequestMovement;
import com.intelix.sofka.app.servicios.ConsumeService;

@Service
public class ConsumeCommissionServicesImp implements ConsumeService {

	private final AccountRepository accountRepository;

	public ConsumeCommissionServicesImp(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public Account generateConsume(Account account, RequestMovement movement) {
		account.setBalance(account.getBalance().add(movement.getAmount()).subtract(movement.getCommission()));
		return accountRepository.save(account);
	}

}
