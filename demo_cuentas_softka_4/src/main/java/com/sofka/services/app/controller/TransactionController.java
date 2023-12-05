package com.sofka.services.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sofka.services.app.dto.TransactionDto;
import com.sofka.services.app.service.ITransactionService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@AllArgsConstructor
@RestController
@RequestMapping("Transacciones")
public class TransactionController {

	private final ITransactionService transactionService;

	@GetMapping(value = "/listar_transacciones")
	public Flux<TransactionDto> listTransactions() {
		return transactionService.findAll();
	}

}
