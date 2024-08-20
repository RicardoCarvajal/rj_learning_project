package com.intelix.challenge.app.repositorys;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.intelix.challenge.app.documents.SaleProduct;

public interface SaleProductRepository extends MongoRepository<SaleProduct, String> {

}
