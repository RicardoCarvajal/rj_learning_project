package com.intelix.sofka.app.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.intelix.sofka.app.documents.Account;

public interface AccountRepository extends MongoRepository<Account, String> {

	Optional<Account> findAllBy_idAndBalanceGreaterThan(String _id, BigDecimal balance);

}
