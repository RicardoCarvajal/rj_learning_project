package com.intelix.challenge.app.repositorys;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.intelix.challenge.app.documents.Sale;
import com.intelix.challenge.app.documents.SaleProduct;

public interface SaleRepository extends MongoRepository<Sale, String> {

	@Aggregation(pipeline = { "{'$unwind': { 'path': '$items' }}",
			"{ '$project': { 'items.name': 1, 'items.quantity': 1, _id: 0 } }",
			"{'$group': {'_id': {name: '$items.name'}, 'count': {'$sum': '$items.quantity'}}}",
			"{'$project': {_id: 0, productName: '$_id.name', quantity: '$count'}}" })
	Optional<List<SaleProduct>> getReport();

}
