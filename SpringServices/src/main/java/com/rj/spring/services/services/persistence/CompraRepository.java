package com.rj.spring.services.services.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rj.spring.services.services.domain.Purchase;
import com.rj.spring.services.services.domain.repository.PurchaseRepository;
import com.rj.spring.services.services.persistence.crud.CompraCrudRepository;
import com.rj.spring.services.services.persistence.entity.Compra;
import com.rj.spring.services.services.persistence.mapper.PurchaseMapper;

@Repository
public class CompraRepository implements PurchaseRepository {

	@Autowired
	private CompraCrudRepository compraCrudRepository;

	@Autowired
	PurchaseMapper mapper;

	@Override
	public List<Purchase> getAll() {
		return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
	}

	@Override
	public Optional<List<Purchase>> getByClient(String clientId) {
		return compraCrudRepository.findByIdCliente(clientId).map(compras -> mapper.toPurchases(compras));
	}

	@Override
	public Purchase save(Purchase purchase) {

		Compra compra = mapper.toCompra(purchase);
		compra.getProductos().forEach(pro -> pro.setCompra(compra));

		return mapper.toPurchase(compraCrudRepository.save(compra));
	}

}
