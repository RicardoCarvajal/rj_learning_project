package com.rj.applications.service.domain.useCase;

import com.rj.applications.service.domain.mapper.ProductMapper;
import com.rj.applications.service.drivenAdapter.entity.Producto;
import com.rj.applications.service.entryPoint.dto.ProductDto;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetProductUseCase {

    private final ReactiveMongoTemplate mongoTemplate;

    private final ProductMapper productMapper;


    public GetProductUseCase(ReactiveMongoTemplate mongoTemplate, ProductMapper productMapper) {
        this.mongoTemplate = mongoTemplate;
        this.productMapper = productMapper;
    }

    public Flux<ProductDto> get() {
        return mongoTemplate.findAll(Producto.class).map(productMapper::toDto);
    }

}
