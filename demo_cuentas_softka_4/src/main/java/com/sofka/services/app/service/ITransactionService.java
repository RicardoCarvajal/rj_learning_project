package com.sofka.services.app.service;

import java.math.BigDecimal;

import com.sofka.services.app.dto.DepositDto;
import com.sofka.services.app.dto.TransactionDto;
import com.sofka.services.app.service.utils.DepositType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITransactionService {

	Mono<DepositDto> proccesDeposit(String idAccount, DepositType type, BigDecimal amount);

	Flux<TransactionDto> findAll();
}
