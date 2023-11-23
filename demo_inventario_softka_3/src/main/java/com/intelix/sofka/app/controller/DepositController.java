package com.intelix.sofka.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intelix.sofka.app.document.Account;
import com.intelix.sofka.app.dto.MovementDto;
import com.intelix.sofka.app.response.Response;
import com.intelix.sofka.app.servicio.IDepositService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/deposit")
public class DepositController {

	@Qualifier("DepositServiceImp")
	@Autowired
	private IDepositService iDepositService;

	@Qualifier("DepositServiceAtmImp")
	@Autowired
	private IDepositService iDepositServiceAtm;

	@PutMapping
	public ResponseEntity<Response> generateDeposit(@RequestBody @Valid MovementDto movement) {

		Optional<Account> account = iDepositService.generateDeposit(movement);

		return ResponseEntity
				.ok(Response.createResponse().data(account).status("200").message("Cuenta actualizada").build());

	}

	@PutMapping("/atm")
	public ResponseEntity<Response> generateAtmDeposit(@RequestBody @Valid MovementDto movement) {

		Optional<Account> account = iDepositServiceAtm.generateDeposit(movement);

		return ResponseEntity
				.ok(Response.createResponse().data(account).status("200").message("Cuenta actualizada").build());

	}

}
