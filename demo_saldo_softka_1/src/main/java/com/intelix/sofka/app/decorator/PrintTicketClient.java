package com.intelix.sofka.app.decorator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.intelix.sofka.app.documents.Account;

public class PrintTicketClient implements IPrintTicket {

	@Override
	public void printBody(Account a) {
		System.out.println("-------------------------------------");
		System.out.println("Documento de cobro de mantenimiento");
		System.out.println("cliente " + a.getNameClient());
		System.out.println("Cobro " + new BigDecimal(0.2).setScale(2, RoundingMode.HALF_UP));
		System.out.println("saldo " + a.getBalance());
		System.out.println("-------------------------------------");
	}

}
