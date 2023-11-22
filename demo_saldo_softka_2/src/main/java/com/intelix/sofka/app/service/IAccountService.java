package com.intelix.sofka.app.service;

import java.util.List;
import java.util.Optional;

import com.intelix.sofka.app.dto.AccountDto;
import com.intelix.sofka.app.entity.Account;

public interface IAccountService {

	public List<Account> findAll();

	public Optional<Account> findById(String id);

	public Optional<Account> createAccount(AccountDto accountDto);

}
