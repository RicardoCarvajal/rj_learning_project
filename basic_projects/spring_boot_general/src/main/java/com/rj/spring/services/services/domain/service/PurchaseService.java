package com.rj.spring.services.services.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rj.spring.services.services.domain.Purchase;
import com.rj.spring.services.services.domain.repository.PurchaseRepository;

@Service
public class PurchaseService {

	@Autowired
	PurchaseRepository purchaseRepository;

	public List<Purchase> getAll() {
		return purchaseRepository.getAll();
	}

	public Optional<List<Purchase>> getByClient(String clientId) {
		return purchaseRepository.getByClient(clientId);
	}

	public Purchase save(Purchase purchase) {
		return purchaseRepository.save(purchase);
	}

}
