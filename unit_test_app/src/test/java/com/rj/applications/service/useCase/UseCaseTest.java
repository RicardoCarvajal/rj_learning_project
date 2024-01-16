package com.rj.applications.service.useCase;

import com.rj.applications.service.domain.mapper.ProductMapper;
import com.rj.applications.service.domain.useCase.CreateProductUseCase;
import com.rj.applications.service.domain.useCase.GetProductTransactionDto;
import com.rj.applications.service.drivenAdapter.entity.Producto;
import com.rj.applications.service.drivenAdapter.repository.IProductRepository;
import com.rj.applications.service.entryPoint.dto.ProductDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UseCaseTest {


    private GetProductTransactionDto getProductTransactionDto;
    private CreateProductUseCase createProductUseCase;
    @Mock
    private IProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @BeforeEach
    void setUp() {
        createProductUseCase = new CreateProductUseCase(productRepository, productMapper);
        getProductTransactionDto = new GetProductTransactionDto(productRepository, productMapper);
    }

    @Test
    public void create() {

        ProductDto productDto = new ProductDto();
        productDto.setCode("440731239");
        productDto.setStock("23");
        productDto.setName("Zapatilla Para Mujer Talla 39");
        productDto.setDescription("Zapatilla Para Mujer Talla 39");
        productDto.setRetailPrice(new BigDecimal(32));
        productDto.setMayorPrice(new BigDecimal(30));

        Producto productoDb = new Producto();

        productoDb.set_id("65907b1a11e25555328e9cdb");
        productoDb.setCodigo("440731239");
        productoDb.setExistencia("23");
        productoDb.setNombre("Zapatilla Para Mujer Talla 39");
        productoDb.setDescripcion("Zapatilla Para Mujer Talla 39");
        productoDb.setPercioDetal(new BigDecimal(32));
        productoDb.setPercioMayor(new BigDecimal(30));

        when(productRepository.save(Mockito.any())).thenReturn(Mono.just(productoDb));

        var result = createProductUseCase.create(productDto);

        StepVerifier.create(result).assertNext(id -> {
            assertEquals("65907b1a11e25555328e9cdb", id);
        }).verifyComplete();

        Mockito.verify(productRepository).save(Mockito.any());
    }

    @Test
    public void get() {

        Producto productoDb = new Producto();

        productoDb.set_id("65907b1a11e25555328e9cdb");
        productoDb.setCodigo("440731239");
        productoDb.setExistencia("23");
        productoDb.setNombre("Zapatilla Para Mujer Talla 39");
        productoDb.setDescripcion("Zapatilla Para Mujer Talla 39");
        productoDb.setPercioDetal(new BigDecimal(32));
        productoDb.setPercioMayor(new BigDecimal(30));

        when(productRepository.findById(Mockito.anyString())).thenReturn(Mono.just(productoDb));

        var result = getProductTransactionDto.get("65907b1a11e25555328e9cdb", 18);

        StepVerifier.create(result).assertNext(product -> {
            assertEquals(new BigDecimal(540), product.getTotalCost());
        }).verifyComplete();


        Mockito.verify(productRepository).findById(Mockito.anyString());

    }


}
