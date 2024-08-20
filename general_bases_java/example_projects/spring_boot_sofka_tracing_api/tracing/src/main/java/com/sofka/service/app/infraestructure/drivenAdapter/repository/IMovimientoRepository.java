package com.sofka.service.app.infraestructure.drivenAdapter.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.sofka.service.app.infraestructure.drivenAdapter.entity.Movimiento;

import reactor.core.publisher.Flux;

public interface IMovimientoRepository extends ReactiveMongoRepository<Movimiento, String> {

	public Flux<Movimiento> findAllByEsError(boolean esError);

	public Flux<Movimiento> findAllByEsErrorFalseAndTipoProcesoAndIdObjeto(String tipo, String idObject);

	public Flux<Movimiento> findAllByEsErrorFalseAndTipoProcesoAndTipoVenta(String tipo, String tipoVenta);

}
