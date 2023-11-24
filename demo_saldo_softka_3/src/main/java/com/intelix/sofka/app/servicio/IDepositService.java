package com.intelix.sofka.app.servicio;

import java.util.Optional;

import com.intelix.sofka.app.document.Account;
import com.intelix.sofka.app.dto.MovementDto;

public interface IDepositService {

	public Optional<Account> generateDeposit(MovementDto movement);

}
