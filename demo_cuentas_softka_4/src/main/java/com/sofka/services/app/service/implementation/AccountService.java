package com.sofka.services.app.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofka.services.app.dto.AccountDto;
import com.sofka.services.app.dto.CustomerDto;
import com.sofka.services.app.entity.Cliente;
import com.sofka.services.app.entity.Cuenta;
import com.sofka.services.app.repository.IAccountRepository;
import com.sofka.services.app.service.IAccountService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service()
public class AccountService implements IAccountService {

	@Autowired
	IAccountRepository accountRepository;

	@Override
	public Mono<AccountDto> createAccount(AccountDto accountDto) {

		Cuenta cuenta = new Cuenta(accountDto.getId(), accountDto.getGlobalBalance(),
				new Cliente(accountDto.getCustomer().getId(), accountDto.getCustomer().getName()));

		return accountRepository.save(cuenta).map(c -> {
			return new AccountDto(c.getId(), new CustomerDto(c.getCliente().getId(), c.getCliente().getNombre()),
					c.getSaldo_global());
		});

	}

	@Override
	public Flux<AccountDto> findAll() {
		return accountRepository.findAll().map(c -> {
			return new AccountDto(c.getId(), new CustomerDto(c.getCliente().getId(), c.getCliente().getNombre()),
					c.getSaldo_global());

		});

	}
}
