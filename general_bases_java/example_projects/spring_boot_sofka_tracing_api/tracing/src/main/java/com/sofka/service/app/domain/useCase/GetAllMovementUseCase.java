package com.sofka.service.app.domain.useCase;

import org.springframework.stereotype.Service;

import com.sofka.service.app.infraestructure.drivenAdapter.entity.Movimiento;
import com.sofka.service.app.infraestructure.drivenAdapter.repository.IMovimientoRepository;

import reactor.core.publisher.Flux;

@Service
public class GetAllMovementUseCase {

	private final IMovimientoRepository iMovimientoRepository;

	public GetAllMovementUseCase(IMovimientoRepository iMovimientoRepository) {
		this.iMovimientoRepository = iMovimientoRepository;
	}

	public Flux<Movimiento> get() {
		return iMovimientoRepository.findAll();
	}

}
