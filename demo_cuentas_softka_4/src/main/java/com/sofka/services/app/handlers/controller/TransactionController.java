package com.sofka.services.app.handlers.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sofka.services.app.dto.DepositDto;
import com.sofka.services.app.dto.TransactionDto;
import com.sofka.services.app.service.ITransactionService;
import com.sofka.services.app.service.utils.DepositType;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("Transacciones")
public class TransactionController {

	private final ITransactionService transactionService;

	@GetMapping(value = "/listar_transacciones")
	public Flux<TransactionDto> listTransactions() {
		return transactionService.findAll();
	}

	@PostMapping(value = "/Crear/Deposito/Cajero")
	public Mono<DepositDto> proccesDepositATM(@RequestBody DepositDto deposit) {

		return transactionService.proccesDeposit(deposit.getIdAccount(), DepositType.CAJERO, deposit.getAmount());
	}

	@PostMapping(value = "/Crear/Deposito/Sucursal")
	public Mono<DepositDto> proccesDepositBank(@RequestBody DepositDto deposit) {
		return transactionService.proccesDeposit(deposit.getIdAccount(), DepositType.SUCURSAL, deposit.getAmount());

	}

	@PostMapping(value = "/Crear/Deposito/OtraCuenta")
	public Mono<DepositDto> proccesDepositOtherAccount(@RequestBody DepositDto deposit) {
		return transactionService.proccesDeposit(deposit.getIdAccount(), DepositType.OTRA_CUENTA, deposit.getAmount());
	}

}
