package com.rj.spring.services.services.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rj.spring.services.services.domain.Product;
import com.rj.spring.services.services.domain.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public List<Product> getAll() {
		return productRepository.getAll();
	}

	public Optional<List<Product>> getByCategory(int idCategory) {
		return productRepository.getByCategory(idCategory);
	}

	public Optional<List<Product>> getScarseProducts(int quantity) {
		return productRepository.getScarseProducts(quantity);
	}

	public Optional<Product> getProduct(int idProduct) {
		return productRepository.getProduct(idProduct);
	}

	public Product save(Product product) {
		return productRepository.save(product);
	}

	public boolean delete(int idProduct) {
		return getProduct(idProduct).map(p -> {
			productRepository.delete(idProduct);
			return true;
		}).orElse(false);

	}

}
