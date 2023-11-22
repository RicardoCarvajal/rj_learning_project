package com.intelix.sofka.app.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intelix.sofka.app.dto.AccountDto;
import com.intelix.sofka.app.entity.Account;
import com.intelix.sofka.app.response.Response;
import com.intelix.sofka.app.service.IAccountService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/account")
public class AccountController {

	private final IAccountService accountService;

	public AccountController(IAccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping
	public ResponseEntity<Response> getAll() {
		List<Account> accounts = accountService.findAll();
		if (accounts != null && !accounts.isEmpty()) {
			return ResponseEntity
					.ok(Response.createResponse().data(accounts).status("200").message("Lista encontrada").build());
		} else {

			return ResponseEntity.badRequest()
					.body(Response.createResponse().data(null).status("400").message("Ups!! algo salio mal").build());

		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<Response> getAccount(@PathVariable String id) {
		Optional<Account> account = accountService.findById(id);
		if (!account.isEmpty()) {
			return ResponseEntity
					.ok(Response.createResponse().data(account).status("200").message("Cuenta encontrada").build());
		} else {
			return ResponseEntity.badRequest()
					.body(Response.createResponse().data(null).status("400").message("Ups!! algo salio mal").build());
		}

	}

	@PostMapping
	public ResponseEntity<Response> createAccount(@RequestBody @Valid @NotNull AccountDto accountDto) {
		Optional<Account> account = accountService.createAccount(accountDto);
		if (!account.isEmpty()) {
			return ResponseEntity.created(URI.create("/api/account"))
					.body(Response.createResponse().data(account).status("201").message("Cuenta creada").build());
		} else {
			return ResponseEntity.badRequest()
					.body(Response.createResponse().data(null).status("400").message("Ups!! algo salio mal").build());
		}

	}

}
