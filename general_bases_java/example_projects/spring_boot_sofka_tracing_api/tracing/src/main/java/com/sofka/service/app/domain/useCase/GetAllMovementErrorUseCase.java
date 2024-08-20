package com.sofka.service.app.domain.useCase;

import org.springframework.stereotype.Service;

import com.sofka.service.app.infraestructure.drivenAdapter.entity.Movimiento;
import com.sofka.service.app.infraestructure.drivenAdapter.repository.IMovimientoRepository;

import reactor.core.publisher.Flux;

@Service
public class GetAllMovementErrorUseCase {

	private final IMovimientoRepository iMovimientoRepository;

	public GetAllMovementErrorUseCase(IMovimientoRepository iMovimientoRepository) {
		this.iMovimientoRepository = iMovimientoRepository;
	}

	public Flux<Movimiento> getError() {
		return iMovimientoRepository.findAllByEsError(true);
	}

}
