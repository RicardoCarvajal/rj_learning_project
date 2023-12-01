package com.intelix.sofka.app.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;

import com.intelix.sofka.app.document.Account;
import com.intelix.sofka.app.dto.ResposeAccount;

@DataMongoTest
public class AggregationAccountTest {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	public void accountAggregationTest() {

		MatchOperation matchActive = Aggregation.match(new Criteria("active").is(true));
		ProjectionOperation project = Aggregation.project("id", "balance", "active", "customer.name");

		Aggregation aggregation = Aggregation.newAggregation(project, matchActive);

		List<ResposeAccount> result = mongoTemplate.aggregate(aggregation, Account.class, ResposeAccount.class)
				.getMappedResults();

		assertThat(result).isNotEmpty();

		result.forEach(a -> {
			assertTrue(a.getActive());
		});
	}

}
