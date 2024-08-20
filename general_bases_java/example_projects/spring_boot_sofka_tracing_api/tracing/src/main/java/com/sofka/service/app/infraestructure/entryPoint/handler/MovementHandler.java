package com.sofka.service.app.infraestructure.entryPoint.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.sofka.service.app.domain.useCase.GetAllMovementErrorUseCase;
import com.sofka.service.app.domain.useCase.GetAllMovementProductUseCase;
import com.sofka.service.app.domain.useCase.GetAllMovementSaleMayorUseCase;
import com.sofka.service.app.domain.useCase.GetAllMovementSaleRetailUseCase;
import com.sofka.service.app.domain.useCase.GetAllMovementUseCase;

import reactor.core.publisher.Mono;

@Component
public class MovementHandler {

	private final GetAllMovementUseCase getAllMovementUseCase;

	private final GetAllMovementErrorUseCase getAllMovementErrorUseCase;

	private final GetAllMovementProductUseCase getAllMovementProductUseCase;

	private final GetAllMovementSaleRetailUseCase getAllMovementSaleRetailUseCase;

	private final GetAllMovementSaleMayorUseCase getAllMovementSaleMayorUseCase;

	public MovementHandler(GetAllMovementUseCase getAllMovementUseCase,
			GetAllMovementErrorUseCase getAllMovementErrorUseCase,
			GetAllMovementProductUseCase getAllMovementProductUseCase,
			GetAllMovementSaleRetailUseCase getAllMovementSaleRetailUseCase,
			GetAllMovementSaleMayorUseCase getAllMovementSaleMayorUseCase) {
		this.getAllMovementUseCase = getAllMovementUseCase;
		this.getAllMovementErrorUseCase = getAllMovementErrorUseCase;
		this.getAllMovementProductUseCase = getAllMovementProductUseCase;
		this.getAllMovementSaleRetailUseCase = getAllMovementSaleRetailUseCase;
		this.getAllMovementSaleMayorUseCase = getAllMovementSaleMayorUseCase;
	}

	public Mono<ServerResponse> get(ServerRequest request) {

		return getAllMovementUseCase.get().collectList().flatMap(list -> {
			return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(list);
		});

	}

	public Mono<ServerResponse> getError(ServerRequest request) {

		return getAllMovementErrorUseCase.getError().collectList().flatMap(list -> {
			return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(list);
		});

	}

	public Mono<ServerResponse> getMovementProduct(ServerRequest request) {

		String id = request.pathVariable("id");

		return getAllMovementProductUseCase.getMovementProduct(id).collectList().flatMap(list -> {
			return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(list);
		});

	}

	public Mono<ServerResponse> getMovementSaleRetail(ServerRequest request) {

		return getAllMovementSaleRetailUseCase.getSale().collectList().flatMap(list -> {
			return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(list);
		});

	}

	public Mono<ServerResponse> getMovementSaleMayor(ServerRequest request) {

		return getAllMovementSaleMayorUseCase.getSale().collectList().flatMap(list -> {
			return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(list);
		});

	}

}
