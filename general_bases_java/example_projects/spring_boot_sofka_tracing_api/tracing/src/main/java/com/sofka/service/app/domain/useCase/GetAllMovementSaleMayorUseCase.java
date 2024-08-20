package com.sofka.service.app.domain.useCase;

import org.springframework.stereotype.Service;

import com.sofka.service.app.infraestructure.drivenAdapter.entity.Movimiento;
import com.sofka.service.app.infraestructure.drivenAdapter.repository.IMovimientoRepository;

import reactor.core.publisher.Flux;

@Service
public class GetAllMovementSaleMayorUseCase implements IGetAllMovementSale {

	private final IMovimientoRepository iMovimientoRepository;

	public GetAllMovementSaleMayorUseCase(IMovimientoRepository iMovimientoRepository) {
		this.iMovimientoRepository = iMovimientoRepository;
	}

	@Override
	public Flux<Movimiento> getSale() {
		return iMovimientoRepository.findAllByEsErrorFalseAndTipoProcesoAndTipoVenta("VENTA", "MAYOR");
	}

}
