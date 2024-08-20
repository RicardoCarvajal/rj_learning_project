package com.intelix.challenge.app.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelix.challenge.app.documents.Sale;
import com.intelix.challenge.app.repositorys.SaleRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class SaleService {

	SaleRepository saleRepository;

	@Autowired
	public SaleService(SaleRepository saleRepository) {
		this.saleRepository = saleRepository;
	}

	public List<Sale> findAllDocuments() {
		return saleRepository.findAll();
	}

	public Sale save(Sale sale) {
		return saleRepository.save(sale);
	}

	public void calculateTotal() {
		findAllDocuments().forEach(sale -> {
			Double amount = sale.getProducts().stream().mapToDouble(p -> (p.getPrice().doubleValue() * p.getQuantity()))
					.sum();
			sale.setTotal(new BigDecimal(amount).setScale(2, RoundingMode.HALF_UP));
			log.debug("Total de venta: " + sale.get_id() + " es: " + sale.getTotal());
			save(sale);
		});
	}

}
