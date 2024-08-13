package com.danzaseimily.app.services.routers;

import com.danzaseimily.app.services.dtos.ResponseDto;
import com.danzaseimily.app.services.handlers.AccountHandler;
import com.danzaseimily.app.services.models.Account;
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
public class AccountRouter {

    @Bean
    @RouterOperation(path = "/api/v1/account/{id}", produces = MediaType.APPLICATION_JSON_VALUE, beanClass = AccountHandler.class, beanMethod = "get", method = RequestMethod.GET, operation = @Operation(operationId = "get", tags = "Obtener una cuenta en especifica", responses = {
            @ApiResponse(responseCode = "200", description = "Cuenta encontrada", content = @Content(schema = @Schema(implementation = ResponseDto.class))),}))
    public RouterFunction<ServerResponse> get(AccountHandler handler) {
        return RouterFunctions.route(RequestPredicates.GET("/api/v1/account/{id}"), handler::get);
    }

    @Bean
    @RouterOperation(path = "/api/v1/account", produces = MediaType.APPLICATION_JSON_VALUE, beanClass = AccountHandler.class, beanMethod = "create", method = RequestMethod.POST, operation = @Operation(operationId = "create", tags = "Crear una cuenta", requestBody = @RequestBody(required = true, description = "Cuenta", content = @Content(schema = @Schema(implementation = Account.class))), responses = {
            @ApiResponse(responseCode = "201", description = "Cuenta creada satisfactoriamente", content = @Content(schema = @Schema(implementation = ResponseDto.class))),}))
    public RouterFunction<ServerResponse> create(AccountHandler handler) {
        return RouterFunctions.route(RequestPredicates.POST("/api/v1/account"), handler::create);
    }

    @Bean
    @RouterOperation(path = "/api/v1/account/img/{id}", produces = MediaType.APPLICATION_JSON_VALUE, beanClass = AccountHandler.class, beanMethod = "uploadIMG", method = RequestMethod.PUT, operation = @Operation(operationId = "create", tags = "Crear una cuenta", responses = {
            @ApiResponse(responseCode = "201", description = "Cuenta actualizada satisfactoriamente", content = @Content(schema = @Schema(implementation = ResponseDto.class))),}))
    public RouterFunction<ServerResponse> uploadImg(AccountHandler handler) {
        return RouterFunctions.route(RequestPredicates.PUT("/api/v1/account/img/{id}"), handler::uploadIMG);
    }

}
