package com.intelix.sofka.app.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intelix.sofka.app.request.RequestMovement;
import com.intelix.sofka.app.response.Response;
import com.intelix.sofka.app.servicios.imp.AccountServiceImp;
import com.intelix.sofka.app.servicios.imp.DepositCommissionServicesImp;
import com.intelix.sofka.app.servicios.imp.DepositServicesImp;

@RestController
@RequestMapping("/api/deposit")
public class DepositController {

	private final DepositServicesImp depositServicesImp;
	private final DepositCommissionServicesImp depositCommissionServicesImp;
	private final AccountServiceImp accountServiceImp;

	public DepositController(DepositServicesImp depositServicesImp,
			DepositCommissionServicesImp depositCommissionServicesImp, AccountServiceImp accountServiceImp) {
		this.depositServicesImp = depositServicesImp;
		this.depositCommissionServicesImp = depositCommissionServicesImp;
		this.accountServiceImp = accountServiceImp;
	}

	@PutMapping()
	public ResponseEntity<Response> doDepositOffice(@RequestBody RequestMovement movement) {

		if (accountServiceImp.findAccountById(movement.getAccount().get_id()).isPresent()) {
			return ResponseEntity.ok(Response.createResponse().setStatus("200").setMessage("Cuenta actualizada")
					.setAccount(depositServicesImp.generateDeposit(
							accountServiceImp.findAccountById(movement.getAccount().get_id()).get(), movement))
					.build());
		}

		return ResponseEntity.notFound().build();

	}

	@PutMapping("/commission")
	public ResponseEntity<Response> doDepositAtm(@RequestBody RequestMovement movement) {

		if (accountServiceImp.findAccountById(movement.getAccount().get_id()).isPresent()) {
			return ResponseEntity.ok(Response.createResponse().setStatus("200").setMessage("Cuenta actualizada")
					.setAccount(depositCommissionServicesImp.generateDeposit(
							accountServiceImp.findAccountById(movement.getAccount().get_id()).get(), movement))
					.build());
		}

		return ResponseEntity.notFound().build();

	}

}
