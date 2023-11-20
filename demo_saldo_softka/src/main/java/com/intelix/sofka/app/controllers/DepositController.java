package com.intelix.sofka.app.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intelix.sofka.app.models.BankAccount;
import com.intelix.sofka.app.response.Response;
import com.intelix.sofka.app.response.ResponseLombok;
import com.intelix.sofka.app.servicios.imp.DepositAcountServicesImp;
import com.intelix.sofka.app.servicios.imp.DepositAtmServicesImp;
import com.intelix.sofka.app.servicios.imp.DepositOfficeServicesImp;

@RestController
@RequestMapping("/api/deposit")
public class DepositController {

	@Autowired
	private DepositOfficeServicesImp depositOfficeServicesImp;

	@Autowired
	private DepositAtmServicesImp depositAtmServicesImp;

	@Autowired
	private DepositAcountServicesImp depositAcountServicesImp;

	@Autowired
	private BankAccount bankAccount;

	@PostMapping("/office/{amount}")
	public ResponseEntity<ResponseLombok> doDepositOffice(@PathVariable BigDecimal amount) {
		System.out.println(amount);

		return ResponseEntity.ok(ResponseLombok.builder().amount(amount).status("200")
				.balance(depositOfficeServicesImp.generateDeposit(amount)).message("Listo").build());
	}

	@PostMapping("/atm/{amount}")
	public ResponseEntity<Response> doDepositAtm(@PathVariable BigDecimal amount) {
		System.out.println(amount);

		Response response = Response.createResponse().setAmount(amount)
				.setBalance(depositAtmServicesImp.generateDeposit(amount)).setStatus("200").setMessage("Listo papá")
				.build();

		return ResponseEntity.ok(response);

	}

	@PostMapping("/acount/{amount}")
	public ResponseEntity<BigDecimal> doDepositAcount(@PathVariable BigDecimal amount) {
		System.out.println(amount);
		return ResponseEntity.ok(depositAcountServicesImp.generateDeposit(amount));

	}

}
