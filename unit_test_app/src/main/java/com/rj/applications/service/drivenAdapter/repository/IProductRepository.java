package com.rj.applications.service.drivenAdapter.repository;

import com.rj.applications.service.drivenAdapter.entity.Producto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IProductRepository extends ReactiveMongoRepository<Producto, String> {
}
