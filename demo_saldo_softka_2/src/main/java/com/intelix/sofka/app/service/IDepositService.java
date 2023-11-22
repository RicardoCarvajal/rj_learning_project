package com.intelix.sofka.app.service;

import java.util.Optional;

import com.intelix.sofka.app.dto.MovementDto;
import com.intelix.sofka.app.entity.Account;

public interface IDepositService {

	public Optional<Account> generateDeposit(MovementDto movement);

}
