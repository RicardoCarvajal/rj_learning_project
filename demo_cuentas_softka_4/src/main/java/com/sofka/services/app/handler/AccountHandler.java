package com.sofka.services.app.handler;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.sofka.services.app.dto.AccountDto;
import com.sofka.services.app.service.IAccountService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class AccountHandler {

	private final IAccountService accountService;

	private final Validator validator;

	public AccountHandler(IAccountService accountService, Validator validator) {
		this.accountService = accountService;
		this.validator = validator;
	}

	public Mono<ServerResponse> listAccount(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(accountService.findAll(),
				AccountDto.class);
	}

	public Mono<ServerResponse> createAccount(ServerRequest request) {
		Mono<AccountDto> account = request.bodyToMono(AccountDto.class);

		return account.flatMap(a -> {

			Errors errors = new BeanPropertyBindingResult(a, AccountDto.class.getName());
			validator.validate(a, errors);
			if (errors.hasErrors()) {
				return Flux.fromIterable(errors.getFieldErrors())
						.map(fieldError -> "El campo " + fieldError.getField() + " " + fieldError.getDefaultMessage())
						.collectList().flatMap(list -> ServerResponse.badRequest().bodyValue(list));
			} else {

				return accountService.createAccount(a)
						.flatMap(adb -> ServerResponse.created(URI.create("/api/v2/productos/"))
								.contentType(MediaType.APPLICATION_JSON).bodyValue(adb));
			}

		});

	}

}
