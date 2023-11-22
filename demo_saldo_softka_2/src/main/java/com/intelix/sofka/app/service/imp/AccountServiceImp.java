package com.intelix.sofka.app.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.intelix.sofka.app.dto.AccountDto;
import com.intelix.sofka.app.entity.Account;
import com.intelix.sofka.app.repository.IAccountRepository;
import com.intelix.sofka.app.service.IAccountService;

@Service
public class AccountServiceImp implements IAccountService {

	private final IAccountRepository iaAccountRepository;

	public AccountServiceImp(IAccountRepository iaAccountRepository) {
		super();
		this.iaAccountRepository = iaAccountRepository;
	}

	@Override
	public List<Account> findAll() {
		return iaAccountRepository.findAll();
	}

	@Override
	public Optional<Account> findById(String id) {
		return iaAccountRepository.findById(id);
	}

	@Override
	public Optional<Account> createAccount(AccountDto accountDto) {
		return iaAccountRepository
				.create(Account.createAccount().id(String.valueOf(iaAccountRepository.findAll().size() + 1))
						.active(true).balance(accountDto.getBalance()).idClient(accountDto.getIdClient())
						.nameClient(accountDto.getNameClient()).type(accountDto.getType()).build());
	}

}
