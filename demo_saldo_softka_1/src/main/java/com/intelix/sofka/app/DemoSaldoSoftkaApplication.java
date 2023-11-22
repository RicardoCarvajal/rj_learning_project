package com.intelix.sofka.app;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

import com.intelix.sofka.app.decorator.IPrintTicket;
import com.intelix.sofka.app.decorator.PrintFooterDecorator;
import com.intelix.sofka.app.decorator.PrintTicket;
import com.intelix.sofka.app.decorator.PrintTicketClient;
import com.intelix.sofka.app.documents.Account;
import com.intelix.sofka.app.servicios.imp.AccountServiceImp;
import com.intelix.sofka.app.singleton.Printer;

@SpringBootApplication
public class DemoSaldoSoftkaApplication implements CommandLineRunner {

	private final AccountServiceImp accountServiceImp;

	public DemoSaldoSoftkaApplication(AccountServiceImp accountServiceImp) {
		this.accountServiceImp = accountServiceImp;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoSaldoSoftkaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		job();
	}

	@Scheduled(cron = "*/5 * * * * *")
	public void job() {

		List<Account> accounts = accountServiceImp.findAll();

		accounts.forEach(a -> {
			if (a.getBalance().compareTo(BigDecimal.ZERO) > 0) {
				a.setBalance(a.getBalance().subtract(new BigDecimal(0.2)).setScale(2, RoundingMode.HALF_UP));
				accountServiceImp.updateAccount(a);
				Printer printer = Printer.getInstance();
				System.out.println(printer);
				System.out.println(printer.getConn());

				if (a.getType() == 1) {
					IPrintTicket print = new PrintTicketClient();
					IPrintTicket printFooter = new PrintFooterDecorator(print);

					printFooter.printBody(a);
				} else {
					PrintTicket p = new PrintTicket();
					IPrintTicket print = new PrintTicketClient();
					print.printBody(a);

				}

			}
		});

	}

}
