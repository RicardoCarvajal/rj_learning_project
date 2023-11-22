package com.intelix.sofka.app.service.imp;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.intelix.sofka.app.conf.PropertiesConf;
import com.intelix.sofka.app.dto.MovementDto;
import com.intelix.sofka.app.entity.Account;
import com.intelix.sofka.app.repository.IAccountRepository;
import com.intelix.sofka.app.service.IDepositService;

@Service("DepositServiceAtmImp")
public class DepositServiceAtmImp implements IDepositService {

	private final IAccountRepository iaAccountRepository;

	private final PropertiesConf propertiesConf;

	public DepositServiceAtmImp(IAccountRepository iaAccountRepository, PropertiesConf propertiesConf) {
		this.iaAccountRepository = iaAccountRepository;
		this.propertiesConf = propertiesConf;
	}

	@Override
	public Optional<Account> generateDeposit(MovementDto movement) {

		movement.setCommission(new BigDecimal(propertiesConf.getAmountAtm()));

		return this.iaAccountRepository.uptadeById(movement);
	}

}
