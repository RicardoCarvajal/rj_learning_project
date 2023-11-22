package com.intelix.sofka.app.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intelix.sofka.app.factory.AccountFactory;
import com.intelix.sofka.app.request.RequestAccount;
import com.intelix.sofka.app.response.Response;
import com.intelix.sofka.app.servicios.imp.AccountServiceImp;

@RestController
@RequestMapping("/api/account")
public class AccountController {

	private final AccountServiceImp accountServiceImp;

	public AccountController(AccountServiceImp accountServiceImp) {
		this.accountServiceImp = accountServiceImp;
	}

	@PostMapping
	public ResponseEntity<Response> createAccount(@RequestBody RequestAccount request) {

		AccountFactory factory = new AccountFactory(request);

		Response response = Response.createResponse().setAccount(accountServiceImp.createAccount(factory.getAccount()))
				.setMessage("Cuenta creada").setStatus("200").build();

		return ResponseEntity.ok(response);

	}

}
