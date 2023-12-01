package com.sofka.services.app.drivenAdapter.bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.sofka.services.app.configuration.RabbitConf;

import reactor.core.publisher.Mono;
import reactor.rabbitmq.OutboundMessage;
import reactor.rabbitmq.Sender;

@Component
public class RabbitMqSender {

	@Autowired
	private Sender sender;

	@Autowired
	private Gson gson;

	public void senderData(Object object) {
		sender.send(Mono.just(new OutboundMessage(RabbitConf.EXCHANGE_NAME, RabbitConf.ROUTING_KEY_NAME,
				gson.toJson(object).getBytes()))).subscribe(System.out::println);
	}

}
