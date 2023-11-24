package com.intelix.sofka.app.service.imp;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.intelix.sofka.app.document.Account;
import com.intelix.sofka.app.document.Customer;
import com.intelix.sofka.app.dto.AccountDto;
import com.intelix.sofka.app.dto.ResposeAccount;
import com.intelix.sofka.app.servicio.IAccountService;

@Service
public class AccountServiceImp implements IAccountService {

	private final MongoTemplate mongoTemplate;

	public AccountServiceImp(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public List<ResposeAccount> findAll() {

		MatchOperation matchActive = Aggregation.match(new Criteria("active").is(true));
		ProjectionOperation project = Aggregation.project("id", "balance", "active", "customer.name");

		Aggregation aggregation = Aggregation.newAggregation(project, matchActive);

		return mongoTemplate.aggregate(aggregation, Account.class, ResposeAccount.class).getMappedResults();

	}

	@Override
	public Account findById(String id) {
		return mongoTemplate.findById(id, Account.class);
	}

	@Override
	public Account createAccount(AccountDto accountDto) {
		if (accountDto.getBalance().compareTo(new BigDecimal(100)) > 0) {
			return mongoTemplate.save(Account.createAccount().active(true).balance(accountDto.getBalance())
					.customer(Customer.createCustomer().id(accountDto.getCustomer().getId())
							.direction(accountDto.getCustomer().getDirection()).name(accountDto.getCustomer().getName())
							.phone(accountDto.getCustomer().getPhone()).type(1).build())
					.build());
		} else {
			return mongoTemplate.save(Account.createAccount().active(true).balance(accountDto.getBalance())
					.customer(Customer.createCustomer().id(accountDto.getCustomer().getId())
							.direction(accountDto.getCustomer().getDirection()).name(accountDto.getCustomer().getName())
							.phone(accountDto.getCustomer().getPhone()).type(2).build())
					.build());
		}
	}

}
