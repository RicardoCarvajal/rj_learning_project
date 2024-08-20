package com.sofka.service.app.infraestructure.entryPoint.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.sofka.service.app.infraestructure.drivenAdapter.entity.Movimiento;
import com.sofka.service.app.infraestructure.entryPoint.handler.MovementHandler;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Configuration
public class MovementRouter {

	@Bean
	@RouterOperation(path = "/api/movement", produces = MediaType.APPLICATION_JSON_VALUE, beanClass = MovementHandler.class, beanMethod = "get", method = RequestMethod.GET, operation = @Operation(operationId = "get", tags = "Caso de uso obtener movimientos", responses = {
			@ApiResponse(responseCode = "200", description = "Movimientos encontrados", content = @Content(schema = @Schema(implementation = Movimiento.class))) }))
	public RouterFunction<ServerResponse> getProducts(MovementHandler movementHandler) {
		return route(GET("/api/movement"), movementHandler::get);
	}

	@Bean
	@RouterOperation(path = "/api/movement/error", produces = MediaType.APPLICATION_JSON_VALUE, beanClass = MovementHandler.class, beanMethod = "getError", method = RequestMethod.GET, operation = @Operation(operationId = "getError", tags = "Caso de uso obtener movimientos con errores", responses = {
			@ApiResponse(responseCode = "200", description = "Movimientos encontrados con errores", content = @Content(schema = @Schema(implementation = Movimiento.class))) }))
	public RouterFunction<ServerResponse> getError(MovementHandler movementHandler) {
		return route(GET("/api/movement/error"), movementHandler::getError);
	}

	@Bean
	@RouterOperation(path = "/api/movement/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE, beanClass = MovementHandler.class, beanMethod = "getMovementProduct", method = RequestMethod.GET, operation = @Operation(operationId = "getMovementProduct", tags = "Caso de uso obtener movimientos de productos", responses = {
			@ApiResponse(responseCode = "200", description = "Movimientos encontrados con errores", content = @Content(schema = @Schema(implementation = Movimiento.class))) }))
	public RouterFunction<ServerResponse> getProduct(MovementHandler movementHandler) {
		return route(GET("/api/movement/product/{id}"), movementHandler::getMovementProduct);
	}

	@Bean
	@RouterOperation(path = "/api/movement/sale/retail", produces = MediaType.APPLICATION_JSON_VALUE, beanClass = MovementHandler.class, beanMethod = "getMovementSaleRetail", method = RequestMethod.GET, operation = @Operation(operationId = "getMovementSaleRetail", tags = "Caso de uso obtener movimientos de ventas al detal", responses = {
			@ApiResponse(responseCode = "200", description = "Movimientos encontrados con errores", content = @Content(schema = @Schema(implementation = Movimiento.class))) }))
	public RouterFunction<ServerResponse> getSaleRetail(MovementHandler movementHandler) {
		return route(GET("/api/movement/sale/retail"), movementHandler::getMovementSaleRetail);
	}

	@Bean
	@RouterOperation(path = "/api/movement/sale/mayor", produces = MediaType.APPLICATION_JSON_VALUE, beanClass = MovementHandler.class, beanMethod = "getMovementSaleMayor", method = RequestMethod.GET, operation = @Operation(operationId = "getMovementSaleMayor", tags = "Caso de uso obtener movimientos de ventas al mayor", responses = {
			@ApiResponse(responseCode = "200", description = "Movimientos encontrados con errores", content = @Content(schema = @Schema(implementation = Movimiento.class))) }))
	public RouterFunction<ServerResponse> getSaleMayor(MovementHandler movementHandler) {
		return route(GET("/api/movement/sale/mayor"), movementHandler::getMovementSaleMayor);
	}

}
