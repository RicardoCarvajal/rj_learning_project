package com.rj.spring.services.services.domain.repository;

import java.util.List;
import java.util.Optional;

import com.rj.spring.services.services.domain.Purchase;

public interface PurchaseRepository {

	List<Purchase> getAll();

	Optional<List<Purchase>> getByClient(String clientId);

	Purchase save(Purchase purchase);

}
