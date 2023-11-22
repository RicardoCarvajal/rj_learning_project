package com.intelix.sofka.app.servicios.imp;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.intelix.sofka.app.documents.Account;
import com.intelix.sofka.app.repository.AccountRepository;
import com.intelix.sofka.app.servicios.AccountService;

@Service
public class AccountServiceImp implements AccountService {

	private final AccountRepository accountRepository;

	public AccountServiceImp(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public Account createAccount(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Optional<Account> findAccountById(String id) {
		return accountRepository.findById(id);
	}

	@Override
	public Optional<Account> findAllBy_idAndBalanceGreaterThan(String _id, BigDecimal balance) {
		return accountRepository.findAllBy_idAndBalanceGreaterThan(_id, balance);
	}

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account updateAccount(Account account) {
		return accountRepository.save(account);
	}

}
