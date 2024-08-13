package com.danzaseimily.app.services.routers;

import com.danzaseimily.app.services.dtos.PaymentDto;
import com.danzaseimily.app.services.dtos.ResponseDto;
import com.danzaseimily.app.services.handlers.PaymentHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class PaymentRouter {
    @Bean
    @RouterOperation(path = "/api/v1/payment", produces = MediaType.APPLICATION_JSON_VALUE, beanClass = PaymentHandler.class, beanMethod = "create", method = RequestMethod.POST, operation = @Operation(operationId = "create", tags = "Crear un pago", requestBody = @RequestBody(required = true, description = "Pago", content = @Content(schema = @Schema(implementation = PaymentDto.class))), responses = {
            @ApiResponse(responseCode = "201", description = "Pago creado satisfactoriamente", content = @Content(schema = @Schema(implementation = ResponseDto.class))),}))
    public RouterFunction<ServerResponse> create(PaymentHandler handler) {
        return RouterFunctions.route(RequestPredicates.POST("/api/v1/payment"), handler::create);
    }

}
