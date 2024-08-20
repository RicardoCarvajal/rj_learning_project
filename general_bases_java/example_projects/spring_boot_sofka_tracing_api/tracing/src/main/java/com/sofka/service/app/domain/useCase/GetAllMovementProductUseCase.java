package com.sofka.service.app.domain.useCase;

import org.springframework.stereotype.Service;

import com.sofka.service.app.infraestructure.drivenAdapter.entity.Movimiento;
import com.sofka.service.app.infraestructure.drivenAdapter.repository.IMovimientoRepository;

import reactor.core.publisher.Flux;

@Service
public class GetAllMovementProductUseCase {

	private final IMovimientoRepository iMovimientoRepository;

	public GetAllMovementProductUseCase(IMovimientoRepository iMovimientoRepository) {
		this.iMovimientoRepository = iMovimientoRepository;
	}

	public Flux<Movimiento> getMovementProduct(String idProduct) {
		return iMovimientoRepository.findAllByEsErrorFalseAndTipoProcesoAndIdObjeto("PRODUCT", idProduct);
	}

}
