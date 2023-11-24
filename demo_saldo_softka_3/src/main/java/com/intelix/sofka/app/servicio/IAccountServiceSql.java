package com.intelix.sofka.app.servicio;

import java.util.List;

import com.intelix.sofka.app.dto.AccountDto;
import com.intelix.sofka.app.entitys.Account;

public interface IAccountServiceSql {

	public List<Account> findAll();

	public Account findById(String id);

	public Account createAccount(AccountDto accountDto);

}
