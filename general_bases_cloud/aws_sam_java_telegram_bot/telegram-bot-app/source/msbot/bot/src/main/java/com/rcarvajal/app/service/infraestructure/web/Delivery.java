package com.rcarvajal.app.service.infraestructure.web;


import com.rcarvajal.app.service.function.dto.BodyRequest;
import reactor.core.publisher.Mono;

public interface Delivery {
    Mono<String> send(BodyRequest bodyRequest);

    Mono<String> deleteWebhook();
}
