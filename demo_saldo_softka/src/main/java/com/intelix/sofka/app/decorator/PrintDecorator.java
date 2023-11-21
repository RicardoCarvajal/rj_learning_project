package com.intelix.sofka.app.decorator;

import com.intelix.sofka.app.documents.Account;

public class PrintDecorator implements IPrintTicket {

	protected IPrintTicket iPrintTicket;

	public PrintDecorator(IPrintTicket iPrintTicket) {
		this.iPrintTicket = iPrintTicket;
	}

	@Override
	public void printBody(Account a) {
		iPrintTicket.printBody(a);
	}

}
