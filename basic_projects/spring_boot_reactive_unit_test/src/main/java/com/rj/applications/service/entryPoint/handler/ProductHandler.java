package com.rj.applications.service.entryPoint.handler;

import com.rj.applications.service.domain.useCase.CreateProductUseCase;
import com.rj.applications.service.domain.useCase.GetProductTransactionDto;
import com.rj.applications.service.domain.useCase.GetProductUseCase;
import com.rj.applications.service.entryPoint.dto.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProductHandler {

    private final GetProductUseCase getProductUseCase;

    private final GetProductTransactionDto getProductTransactionDto;

    private final CreateProductUseCase createProductUseCase;

    public ProductHandler(GetProductUseCase getProductUseCase, GetProductTransactionDto getProductTransactionDto, CreateProductUseCase createProductUseCase) {
        this.getProductUseCase = getProductUseCase;
        this.getProductTransactionDto = getProductTransactionDto;
        this.createProductUseCase = createProductUseCase;
    }

    public Mono<ServerResponse> get(ServerRequest request) {
        return getProductUseCase.get().collectList().flatMap(list -> {
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("status", HttpStatus.OK.value());
            response.put("data", list);
            response.put("size", list.size());
            return ServerResponse.ok().bodyValue(response);
        });
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        Mono<ProductDto> monoProductDto = request.bodyToMono(ProductDto.class);

        return monoProductDto.flatMap(productDto -> {
            return createProductUseCase.create(productDto).flatMap(id -> {
                return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(id);
            });
        });

    }

    public Mono<ServerResponse> getProductTransaction(ServerRequest request) {

        String id = request.queryParam("id").orElse("");
        Integer quantity = Integer.valueOf(request.queryParam("quantity").orElse("0"));

        return getProductTransactionDto.get(id, quantity).flatMap(p -> {
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("status", HttpStatus.OK.value());
            response.put("data", p);
            return ServerResponse.ok().bodyValue(response);
        });
    }

}
