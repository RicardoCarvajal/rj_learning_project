package com.intelix.sofka.app.servicios;

import com.intelix.sofka.app.documents.Account;
import com.intelix.sofka.app.request.RequestMovement;

public interface ConsumeService {

	public Account generateConsume(Account account, RequestMovement movement);

}
