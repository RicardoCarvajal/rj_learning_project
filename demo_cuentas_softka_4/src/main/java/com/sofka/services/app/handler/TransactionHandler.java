package com.sofka.services.app.handler;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.sofka.services.app.dto.DepositDto;
import com.sofka.services.app.dto.TransactionDto;
import com.sofka.services.app.service.ITransactionService;
import com.sofka.services.app.service.utils.DepositType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class TransactionHandler {

	private final ITransactionService transactionService;

	private final Validator validator;

	public TransactionHandler(ITransactionService transactionService, Validator validator) {
		this.transactionService = transactionService;
		this.validator = validator;
	}

	public Mono<ServerResponse> listTransaction(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(transactionService.findAll(),
				TransactionDto.class);
	}

	public Mono<ServerResponse> createTransaction(ServerRequest request) {
		Mono<DepositDto> deposit = request.bodyToMono(DepositDto.class);

		return deposit.flatMap(d -> {

			Errors errors = new BeanPropertyBindingResult(d, DepositDto.class.getName());
			validator.validate(d, errors);
			if (errors.hasErrors()) {
				return Flux.fromIterable(errors.getFieldErrors())
						.map(fieldError -> "El campo " + fieldError.getField() + " " + fieldError.getDefaultMessage())
						.collectList().flatMap(list -> ServerResponse.badRequest().bodyValue(list));
			} else {

				return transactionService
						.proccesDeposit(d.getIdAccount(), DepositType.valueOf(d.getType()), d.getAmount())
						.flatMap(adb -> ServerResponse.created(URI.create("/api/transaction"))
								.contentType(MediaType.APPLICATION_JSON).bodyValue(adb));
			}

		});

	}

}
