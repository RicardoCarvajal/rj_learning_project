package com.rj.practices.service.app.repositorys;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.rj.practices.service.app.documents.SaleProduct;

public interface SaleProductRepository extends ReactiveMongoRepository<SaleProduct, String> {

}
