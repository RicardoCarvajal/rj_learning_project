package com.intelix.sofka.app.service.imp;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.intelix.sofka.app.document.Account;
import com.intelix.sofka.app.dto.MovementDto;
import com.intelix.sofka.app.servicio.IDepositService;

@Service("DepositServiceImp")
public class DepositServiceImp implements IDepositService {

	@Override
	public Optional<Account> generateDeposit(MovementDto movement) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
