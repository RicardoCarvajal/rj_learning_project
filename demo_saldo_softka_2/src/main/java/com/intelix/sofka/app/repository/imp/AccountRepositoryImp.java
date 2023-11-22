package com.intelix.sofka.app.repository.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.intelix.sofka.app.conf.DataConfig;
import com.intelix.sofka.app.dto.MovementDto;
import com.intelix.sofka.app.entity.Account;
import com.intelix.sofka.app.repository.IAccountRepository;

@Repository
public class AccountRepositoryImp implements IAccountRepository {

	private final DataConfig dataConfig;

	public AccountRepositoryImp(DataConfig dataConfig) {
		this.dataConfig = dataConfig;
	}

	@Override
	public List<Account> findAll() {
		return this.dataConfig.getAccounts();
	}

	@Override
	public Optional<Account> findById(String id) {
		return this.dataConfig.getAccounts().stream().filter(a -> a.getId().equalsIgnoreCase(id)).findFirst();
	}

	@Override
	public Optional<Account> create(Account account) {
		this.dataConfig.getAccounts().add(account);
		return this.dataConfig.getAccounts().stream().filter(a -> a.getId().equalsIgnoreCase(account.getId()))
				.findFirst();
	}

	@Override
	public Optional<Account> uptadeById(MovementDto movement) {

		this.dataConfig.getAccounts().forEach(a -> {
			if (a.getId().equalsIgnoreCase(movement.getIdAccount())) {
				a.setBalance(a.getBalance().add(movement.getAmount()).subtract(movement.getCommission()));
			}
		});

		return this.dataConfig.getAccounts().stream().filter(a -> a.getId().equalsIgnoreCase(movement.getIdAccount()))
				.findFirst();
	}

}
