package com.rj.applications.service.domain.useCase;

import com.rj.applications.service.domain.mapper.ProductMapper;
import com.rj.applications.service.drivenAdapter.repository.IProductRepository;
import com.rj.applications.service.entryPoint.dto.ProductTransactionDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
public class GetProductTransactionDto {

    private final IProductRepository productRepository;

    private final ProductMapper productMapper;

    public GetProductTransactionDto(IProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Mono<ProductTransactionDto> get(String idProduct, Integer quantity) {
        return productRepository.findById(idProduct).map(producto -> {
            ProductTransactionDto productDto = new ProductTransactionDto();
            productDto.setProduct(productMapper.toDto(producto));
            productDto.setQuantity(quantity);
            if (quantity >= 12) {
                productDto.setPrice(producto.getPercioMayor());
            } else {
                productDto.setPrice(producto.getPercioDetal());
            }
            productDto.setTotalCost(productDto.getPrice().multiply(new BigDecimal(quantity)));
            return productDto;
        });
    }

}
