package com.rj.spring.services.services.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rj.spring.services.services.domain.Product;
import com.rj.spring.services.services.domain.repository.ProductRepository;
import com.rj.spring.services.services.persistence.crud.ProductoCrudRepository;
import com.rj.spring.services.services.persistence.entity.Producto;
import com.rj.spring.services.services.persistence.mapper.ProductMapper;

@Repository
public class ProductoRepository implements ProductRepository {

	@Autowired
	private ProductoCrudRepository productoCrudRepository;

	@Autowired
	private ProductMapper productMapper;

	public List<Product> getAll() {
		List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
		return productMapper.toProducts(productos);
	}

	@Override
	public Optional<List<Product>> getByCategory(int idCategory) {
		List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategory);
		return Optional.of(productMapper.toProducts(productos));
	}

	@Override
	public Optional<List<Product>> getScarseProducts(int quantity) {
		Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,
				true);
		return productos.map(product -> productMapper.toProducts(product));
	}

	@Override
	public Optional<Product> getProduct(int idProduct) {
		Optional<Producto> producto = productoCrudRepository.findById(idProduct);
		return producto.map(pro -> productMapper.toProduct(pro));
	}

	@Override
	public Product save(Product product) {
		Producto producto = productoCrudRepository.save(productMapper.toProducto(product));
		return productMapper.toProduct(producto);
	}

	@Override
	public void delete(int idProduct) {
		productoCrudRepository.deleteById(idProduct);
	}

}
