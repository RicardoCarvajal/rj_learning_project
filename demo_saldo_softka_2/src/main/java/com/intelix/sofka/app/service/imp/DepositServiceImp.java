package com.intelix.sofka.app.service.imp;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.intelix.sofka.app.dto.MovementDto;
import com.intelix.sofka.app.entity.Account;
import com.intelix.sofka.app.repository.IAccountRepository;
import com.intelix.sofka.app.service.IDepositService;

@Service("DepositServiceImp")
public class DepositServiceImp implements IDepositService {

	private final IAccountRepository iaAccountRepository;

	public DepositServiceImp(IAccountRepository iaAccountRepository) {
		this.iaAccountRepository = iaAccountRepository;
	}

	@Override
	public Optional<Account> generateDeposit(MovementDto movement) {

		return this.iaAccountRepository.uptadeById(movement);
	}

}
