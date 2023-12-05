package com.sofka.services.app.reciver;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.sofka.services.app.configuration.RabbitConf;
import com.sofka.services.app.dto.DepositDto;
import com.sofka.services.app.entity.Reverso;
import com.sofka.services.app.entity.Transaccion;
import com.sofka.services.app.repository.IAccountRepository;
import com.sofka.services.app.repository.IRevertRepository;
import com.sofka.services.app.repository.ITransactionRepository;

import reactor.rabbitmq.Receiver;

@Component
public class RabbitMqReceiver implements CommandLineRunner {

	@Autowired
	private Receiver receiver;

	@Autowired
	private Gson gson;

	private final ITransactionRepository transactionRepository;
	private final IAccountRepository accountReporitory;
	private final IRevertRepository iRevertRepository;

	public RabbitMqReceiver(ITransactionRepository transactionRepository, IAccountRepository accountReporitory,
			IRevertRepository iRevertRepository) {
		this.transactionRepository = transactionRepository;
		this.accountReporitory = accountReporitory;
		this.iRevertRepository = iRevertRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		// #############COLA1
		receiver.consumeAutoAck(RabbitConf.QUEUE_NAME).flatMap(message -> {

			DepositDto d = gson.fromJson(new String(message.getBody()), DepositDto.class);
			System.out.println("Consumiendo: " + new String(message.getBody()) + " de cola 1");

			return accountReporitory.findByid(d.getIdAccount()).map(c -> {
				return new Transaccion(c, d.getAmount(), c.getSaldo_global().subtract(d.getAmount()),
						c.getSaldo_global(), BigDecimal.ZERO, "REVERSO");
			});
		}).flatMap(t -> {
			return transactionRepository.save(t);
		}).subscribe();

		// #############COLA2
		receiver.consumeAutoAck(RabbitConf.QUEUE_NAME_2).flatMap(message -> {

			DepositDto d = gson.fromJson(new String(message.getBody()), DepositDto.class);
			System.out.println("Consumiendo: " + new String(message.getBody()) + " de cola 2");

			Reverso reverso = new Reverso();
			reverso.setId_cuenta(d.getIdAccount());
			reverso.setMonto_reverso(d.getAmount().negate());

			return iRevertRepository.save(reverso);

		}).subscribe();

	}
}
