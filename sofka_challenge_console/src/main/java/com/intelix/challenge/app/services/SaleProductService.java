package com.intelix.challenge.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelix.challenge.app.documents.SaleProduct;
import com.intelix.challenge.app.repositorys.SaleProductRepository;
import com.intelix.challenge.app.repositorys.SaleRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class SaleProductService {

	SaleProductRepository saleProductRepository;
	SaleRepository saleRepository;

	@Autowired
	public SaleProductService(SaleProductRepository saleProductRepository, SaleRepository saleRepository) {
		this.saleProductRepository = saleProductRepository;
		this.saleRepository = saleRepository;
	}

	public List<SaleProduct> saveDocuments(List<SaleProduct> product) {
		return saleProductRepository.saveAll(product);
	}

	public void createCollections() {
		saleRepository.getReport().ifPresentOrElse(lista -> saveDocuments(lista),
				() -> System.out.println("Lista no encontrada"));
	}

}
