package com.sofka.services.app.configuration;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.rabbitmq.RabbitFlux;
import reactor.rabbitmq.Receiver;
import reactor.rabbitmq.ReceiverOptions;
import reactor.rabbitmq.Sender;
import reactor.rabbitmq.SenderOptions;

@Configuration
public class RabbitConf {

	public static final String QUEUE_NAME = "sofkaBank-transactions-1";
	public static final String QUEUE_NAME_2 = "sofkaBank-transactions-2";
	public static final String EXCHANGE_NAME = "transactions-exchange";
	public static final String ROUTING_KEY_NAME = "transactions.routing.key";

	@Value("${app.rabbit.URL}")
	public String uri_name;

	@Bean
	public AmqpAdmin amqpAdmin() {
		System.out.println(uri_name);
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(URI.create(uri_name));
		var amqpAdmin = new RabbitAdmin(connectionFactory);

		var exchange = new TopicExchange("transactions-exchange");
		var queue = new Queue(QUEUE_NAME, true, false, false);
		var queue2 = new Queue(QUEUE_NAME_2, true, false, false);
		amqpAdmin.declareExchange(exchange);
		amqpAdmin.declareQueue(queue);
		amqpAdmin.declareQueue(queue2);
		amqpAdmin.declareBinding(BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_NAME));
		amqpAdmin.declareBinding(BindingBuilder.bind(queue2).to(exchange).with(ROUTING_KEY_NAME));

		return amqpAdmin;
	}

	@Bean
	public Mono<Connection> connMono() throws KeyManagementException, NoSuchAlgorithmException, URISyntaxException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		System.out.println(uri_name);
		connectionFactory.setUri(uri_name);
		connectionFactory.useNio();
		return Mono.fromCallable(() -> connectionFactory.newConnection());
	}

	@Bean
	public SenderOptions senderOptions(Mono<Connection> connMono) {
		return new SenderOptions().connectionMono(connMono).resourceManagementScheduler(Schedulers.boundedElastic());
	}

	@Bean
	public Sender sender(SenderOptions senderOptions) {
		return RabbitFlux.createSender(senderOptions);
	}

	@Bean
	public ReceiverOptions receiverOptions(Mono<Connection> connectionMono) {
		return new ReceiverOptions().connectionMono(connectionMono);
	}

	@Bean
	public Receiver receiver(ReceiverOptions receiverOptions) {
		return RabbitFlux.createReceiver(receiverOptions);
	}
}
