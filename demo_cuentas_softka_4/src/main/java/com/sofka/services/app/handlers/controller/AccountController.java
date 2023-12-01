package com.sofka.services.app.handlers.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sofka.services.app.dto.AccountDto;
import com.sofka.services.app.service.IAccountService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Validated
@RestController
@RequestMapping("Cuentas")
public class AccountController {

	private final IAccountService accountService;

	@PostMapping(value = "/Crear")
	public Mono<AccountDto> Crear_Cuenta(@Valid @RequestBody AccountDto p_cuenta) {
		return accountService.createAccount(p_cuenta);
	}

	@GetMapping(value = "/listar_cuentas")
	public Flux<AccountDto> listar_cuentas() {
		return accountService.findAll();
	}

}
