package com.rj.applications.service.entryPoint.router;

import com.rj.applications.service.entryPoint.handler.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ProductRouter {

    @Bean
    public RouterFunction<ServerResponse> getProducts(ProductHandler productHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/api/products"), productHandler::get);
    }

    @Bean
    RouterFunction<ServerResponse> createProduct(ProductHandler productHandler) {
        return RouterFunctions.route(RequestPredicates.POST("/api/product"), productHandler::create);
    }

    @Bean
    RouterFunction<ServerResponse> getProductTransaction(ProductHandler productHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/api/product/transaction"), productHandler::getProductTransaction);
    }
}
