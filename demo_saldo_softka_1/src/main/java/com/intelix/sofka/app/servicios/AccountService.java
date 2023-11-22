package com.intelix.sofka.app.servicios;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.intelix.sofka.app.documents.Account;

public interface AccountService {

	public Account createAccount(Account account);

	public Account updateAccount(Account account);

	public Optional<Account> findAccountById(String id);

	public List<Account> findAll();

	Optional<Account> findAllBy_idAndBalanceGreaterThan(String _id, BigDecimal balance);

}
