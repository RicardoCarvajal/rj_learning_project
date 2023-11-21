package com.intelix.sofka.app.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intelix.sofka.app.request.RequestMovement;
import com.intelix.sofka.app.response.Response;
import com.intelix.sofka.app.servicios.imp.AccountServiceImp;
import com.intelix.sofka.app.servicios.imp.ConsumeCommissionServicesImp;
import com.intelix.sofka.app.servicios.imp.ConsumeServicesImp;

@RestController
@RequestMapping("/api/buys")
public class ConsumeController {

	private final ConsumeServicesImp consumeServicesImp;
	private final ConsumeCommissionServicesImp consumeCommissionServicesImp;
	private final AccountServiceImp accountServiceImp;

	public ConsumeController(ConsumeServicesImp depositServicesImp,
			ConsumeCommissionServicesImp depositCommissionServicesImp, AccountServiceImp accountServiceImp) {
		this.consumeServicesImp = depositServicesImp;
		this.consumeCommissionServicesImp = depositCommissionServicesImp;
		this.accountServiceImp = accountServiceImp;
	}

	@PutMapping()
	public ResponseEntity<Response> doDepositOffice(@RequestBody RequestMovement movement) {

		if (accountServiceImp.findAccountById(movement.getAccount().get_id()).isPresent()) {
			return ResponseEntity.ok(Response.createResponse().setStatus("200").setMessage("Cuenta actualizada")
					.setAccount(consumeServicesImp.generateConsume(
							accountServiceImp.findAccountById(movement.getAccount().get_id()).get(), movement))
					.build());
		}

		return ResponseEntity.notFound().build();

	}

	@PutMapping("/commission")
	public ResponseEntity<Response> doDepositAtm(@RequestBody RequestMovement movement) {

		if (accountServiceImp.findAccountById(movement.getAccount().get_id()).isPresent()) {
			return ResponseEntity.ok(Response.createResponse().setStatus("200").setMessage("Cuenta actualizada")
					.setAccount(consumeCommissionServicesImp.generateConsume(
							accountServiceImp.findAccountById(movement.getAccount().get_id()).get(), movement))
					.build());
		}

		return ResponseEntity.notFound().build();

	}

}
