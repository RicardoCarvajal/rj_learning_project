package com.intelix.sofka.app.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intelix.sofka.app.dto.AccountDto;
import com.intelix.sofka.app.response.Response;
import com.intelix.sofka.app.servicio.IAccountService;

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

		return ResponseEntity.ok(Response.createResponse().data(accountService.findAll()).status("200")
				.message("Lista encontrada").build());

	}

	@GetMapping("/{id}")
	public ResponseEntity<Response> getAccount(@PathVariable String id) {

		return ResponseEntity.ok(Response.createResponse().data(accountService.findById(id)).status("200")
				.message("Cuenta encontrada").build());

	}

	@PostMapping
	public ResponseEntity<Response> createAccount(@RequestBody @Valid @NotNull AccountDto accountDto) {

		return ResponseEntity.created(URI.create("/api/account")).body(Response.createResponse()
				.data(accountService.createAccount(accountDto)).status("201").message("Cuenta creada").build());

	}

}
