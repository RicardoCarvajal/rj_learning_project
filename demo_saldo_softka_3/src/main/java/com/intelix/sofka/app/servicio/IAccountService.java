package com.intelix.sofka.app.servicio;

import java.util.List;

import com.intelix.sofka.app.document.Account;
import com.intelix.sofka.app.dto.AccountDto;
import com.intelix.sofka.app.dto.ResposeAccount;

public interface IAccountService {

	public List<ResposeAccount> findAll();

	public Account findById(String id);

	public Account createAccount(AccountDto accountDto);

}
