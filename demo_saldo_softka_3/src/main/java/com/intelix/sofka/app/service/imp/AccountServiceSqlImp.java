package com.intelix.sofka.app.service.imp;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.intelix.sofka.app.dto.AccountDto;
import com.intelix.sofka.app.entitys.Account;
import com.intelix.sofka.app.entitys.Customer;
import com.intelix.sofka.app.repository.AccountRepository;
import com.intelix.sofka.app.servicio.IAccountServiceSql;

@Service
public class AccountServiceSqlImp implements IAccountServiceSql {

	private final AccountRepository accountRepository;

	public AccountServiceSqlImp(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account createAccount(AccountDto accountDto) {

		if (accountDto.getBalance().compareTo(new BigDecimal(100)) > 0) {

			return accountRepository.save(Account.createAccount().balance(accountDto.getBalance()).active(true)
					.customer(Customer.createCustomer().id(accountDto.getCustomer().getId())
							.direction(accountDto.getCustomer().getDirection()).name(accountDto.getCustomer().getName())
							.phone(accountDto.getCustomer().getPhone()).type("1").build())
					.build());

		}

		return accountRepository.save(Account.createAccount().balance(accountDto.getBalance()).active(true)
				.customer(Customer.createCustomer().id(accountDto.getCustomer().getId())
						.direction(accountDto.getCustomer().getDirection()).name(accountDto.getCustomer().getName())
						.phone(accountDto.getCustomer().getPhone()).type("2").build())
				.build());

	}

}
