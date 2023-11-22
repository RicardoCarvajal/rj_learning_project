package com.intelix.sofka.app.repository;

import java.util.List;
import java.util.Optional;

import com.intelix.sofka.app.dto.MovementDto;
import com.intelix.sofka.app.entity.Account;

public interface IAccountRepository {

	List<Account> findAll();

	Optional<Account> findById(String id);

	Optional<Account> create(Account account);

	Optional<Account> uptadeById(MovementDto Movement);

}
