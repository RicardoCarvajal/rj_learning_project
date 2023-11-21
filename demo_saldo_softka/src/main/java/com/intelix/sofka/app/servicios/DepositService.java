package com.intelix.sofka.app.servicios;

import com.intelix.sofka.app.documents.Account;
import com.intelix.sofka.app.request.RequestMovement;

public interface DepositService {

	public Account generateDeposit(Account account, RequestMovement movement);

}
