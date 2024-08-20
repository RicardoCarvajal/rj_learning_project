package com.sofka.service.app.domain.useCase;

import com.sofka.service.app.infraestructure.drivenAdapter.entity.Movimiento;

import reactor.core.publisher.Flux;

@FunctionalInterface
public interface IGetAllMovementSale {

	public Flux<Movimiento> getSale();

}
