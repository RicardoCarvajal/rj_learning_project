package com.rj.spring.services.services.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rj.spring.services.services.domain.Purchase;
import com.rj.spring.services.services.domain.service.PurchaseService;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	PurchaseService purchaseService;

	@GetMapping("/all")
	public ResponseEntity<List<Purchase>> getAll() {
		return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/client/{idClient}")
	public ResponseEntity<List<Purchase>> getByClient(@PathVariable("idClient") String clientId) {

		return purchaseService.getByClient(clientId).map(pur -> new ResponseEntity<>(pur, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/save")
	public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {

		return new ResponseEntity<Purchase>(purchaseService.save(purchase), HttpStatus.CREATED);
	}

}
