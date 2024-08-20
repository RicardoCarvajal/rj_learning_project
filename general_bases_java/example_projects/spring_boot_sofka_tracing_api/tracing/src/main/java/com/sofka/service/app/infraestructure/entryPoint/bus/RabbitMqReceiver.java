package com.sofka.service.app.infraestructure.entryPoint.bus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.sofka.service.app.conf.RabbitConf;
import com.sofka.service.app.infraestructure.drivenAdapter.entity.Movimiento;
import com.sofka.service.app.infraestructure.drivenAdapter.repository.IMovimientoRepository;
import com.sofka.service.app.infraestructure.entryPoint.dto.MovementProductDto;
import com.sofka.service.app.infraestructure.entryPoint.dto.MovementSaleDto;

import reactor.rabbitmq.Receiver;

@Component
public class RabbitMqReceiver implements CommandLineRunner {

	Logger log = LoggerFactory.getLogger(RabbitMqReceiver.class);

	private final Receiver receiver;

	private final Gson gson;

	private final IMovimientoRepository iMovimientoRepository;

	public RabbitMqReceiver(Receiver receiver, Gson gson, IMovimientoRepository iMovimientoRepository) {
		this.receiver = receiver;
		this.gson = gson;
		this.iMovimientoRepository = iMovimientoRepository;

	}

	@Override
	public void run(String... args) throws Exception {

		receiver.consumeAutoAck(RabbitConf.QUEUES).doOnNext(message -> {

			MovementSaleDto m = gson.fromJson(new String(message.getBody()), MovementSaleDto.class);
			log.info("Consumiendo: " + new String(message.getBody()) + " de cola 1");

			Movimiento movimiento = new Movimiento();

			if (m.getIsError() != null) {
				movimiento = Movimiento.building().idObjeto(m.getIdObject()).tipoProceso(m.getTypeProcess())
						.descripcion(m.getDescription()).fecha(m.getDate()).objeto(m.getObjects())
						.esError(m.getIsError()).tipoVenta(m.getTypeSale()).build();
			} else {
				movimiento = Movimiento.building().idObjeto(m.getIdObject()).tipoProceso(m.getTypeProcess())
						.descripcion(m.getDescription()).fecha(m.getDate()).objeto(m.getObjects()).esError(false)
						.tipoVenta(m.getTypeSale()).build();
			}

			iMovimientoRepository.save(movimiento).subscribe();

		}).subscribe();

		receiver.consumeAutoAck(RabbitConf.QUEUEP).doOnNext(message -> {

			MovementProductDto m = gson.fromJson(new String(message.getBody()), MovementProductDto.class);
			log.info("Consumiendo: " + new String(message.getBody()) + " de cola 2");

			Movimiento movimiento = new Movimiento();

			if (m.getIsError() != null) {
				movimiento = Movimiento.building().idObjeto(m.getIdObject()).tipoProceso(m.getTypeProcess())
						.descripcion(m.getDescription()).fecha(m.getDate()).objeto(m.getObjects())
						.esError(m.getIsError()).cantidad(m.getQuantity()).build();
			} else {
				movimiento = Movimiento.building().idObjeto(m.getIdObject()).tipoProceso(m.getTypeProcess())
						.descripcion(m.getDescription()).fecha(m.getDate()).objeto(m.getObjects()).esError(false)
						.cantidad(m.getQuantity()).build();
			}

			iMovimientoRepository.save(movimiento).subscribe();

		}).subscribe();

	}
}
