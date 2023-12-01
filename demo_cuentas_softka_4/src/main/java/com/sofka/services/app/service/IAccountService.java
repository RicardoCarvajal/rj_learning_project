package com.sofka.services.app.service;

import com.sofka.services.app.dto.AccountDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAccountService {

	Mono<AccountDto> createAccount(AccountDto p_Cuenta);

	Flux<AccountDto> findAll();
}
