package com.intelix.sofka.app.decorator;

import com.intelix.sofka.app.documents.Account;

public class PrintFooterDecorator extends PrintDecorator {

	public PrintFooterDecorator(IPrintTicket iPrintTicket) {
		super(iPrintTicket);
	}

	@Override
	public void printBody(Account a) {
		iPrintTicket.printBody(a);
		printFooter(a);
	}

	public void printFooter(Account a) {
		System.out.println("Cliente fino");
	}

}
