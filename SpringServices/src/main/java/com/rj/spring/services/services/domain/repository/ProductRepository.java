package com.rj.spring.services.services.domain.repository;

import java.util.List;
import java.util.Optional;

import com.rj.spring.services.services.domain.Product;

public interface ProductRepository {

	public List<Product> getAll();

	public Optional<List<Product>> getByCategory(int idCategory);

	public Optional<List<Product>> getScarseProducts(int quantity);

	public Optional<Product> getProduct(int idProduct);

	public Product save(Product product);

	public void delete(int idProduct);

}
