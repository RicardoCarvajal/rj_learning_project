package com.rj.applications.service.router;

import com.rj.applications.service.domain.useCase.CreateProductUseCase;
import com.rj.applications.service.domain.useCase.GetProductTransactionDto;
import com.rj.applications.service.domain.useCase.GetProductUseCase;
import com.rj.applications.service.entryPoint.dto.ProductDto;
import com.rj.applications.service.entryPoint.handler.ProductHandler;
import com.rj.applications.service.entryPoint.router.ProductRouter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


class RoutersTests {

    GetProductUseCase getProductUseCase;

    GetProductTransactionDto getProductTransactionDto;

    CreateProductUseCase createProductUseCase;


    private WebTestClient client;

    @BeforeEach
    void setUp() {
        getProductUseCase = Mockito.mock(GetProductUseCase.class);
        getProductTransactionDto = Mockito.mock(GetProductTransactionDto.class);
        createProductUseCase = Mockito.mock(CreateProductUseCase.class);
        ProductHandler handler = new ProductHandler(getProductUseCase, getProductTransactionDto, createProductUseCase);
        RouterFunction<ServerResponse> router = new ProductRouter().getProducts(handler);
        client = WebTestClient.bindToRouterFunction(router).build();
    }

    @Test
    void getProductsTest() {

        List<ProductDto> list = new ArrayList<>();
        ProductDto product_a = new ProductDto();
        product_a.setCode("8055232434");
        product_a.setStock("884");
        product_a.setName("PLATOS PARA REFRIGERIOS");
        product_a.setDescription("PLATOS PARA REFRIGERIOS DE ACTIVIDADES");
        product_a.setRetailPrice(new BigDecimal(123));
        product_a.setMayorPrice(new BigDecimal(120));

        ProductDto product_b = new ProductDto();
        product_b.setCode("440731239");
        product_b.setStock("23");
        product_b.setName("Zapatilla Para Mujer Talla 39");
        product_b.setDescription("Zapatilla Para Mujer Talla 39");
        product_b.setRetailPrice(new BigDecimal(32));
        product_b.setMayorPrice(new BigDecimal(30));

        list.add(product_a);
        list.add(product_b);

        Mockito.when(getProductUseCase.get()).thenReturn(Flux.fromIterable(list));

        client.get().uri("/api/products").accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.size").isEqualTo(2)
                .jsonPath("$.status").isEqualTo(200);

        Mockito.verify(getProductUseCase).get();
    }

    @Test
    void createProductTest() {

    }

}
