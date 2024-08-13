package com.rj.applications.service.domain.useCase;

import com.rj.applications.service.domain.mapper.ProductMapper;
import com.rj.applications.service.drivenAdapter.entity.Producto;
import com.rj.applications.service.drivenAdapter.repository.IProductRepository;
import com.rj.applications.service.entryPoint.dto.ProductDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateProductUseCase {

    private final IProductRepository productRepository;


    private final ProductMapper productMapper;

    public CreateProductUseCase(IProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Mono<String> create(ProductDto product) {
        return this.productRepository.save(productMapper.fromDto(product)).map(Producto::get_id);
    }

}
