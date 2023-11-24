package com.intelix.sofka.app.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intelix.sofka.app.dto.AccountDto;
import com.intelix.sofka.app.response.Response;
import com.intelix.sofka.app.servicio.IAccountServiceSql;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/sql/account")
public class AccountSqlController {

	private final IAccountServiceSql accountService;

	public AccountSqlController(IAccountServiceSql accountService) {
		this.accountService = accountService;
	}

	@PostMapping
	public ResponseEntity<Response> createAccount(@RequestBody @Valid @NotNull AccountDto accountDto) {

		return ResponseEntity.created(URI.create("/api/sql/account")).body(Response.createResponse()
				.data(accountService.createAccount(accountDto)).status("201").message("Cuenta creada").build());

	}

}
