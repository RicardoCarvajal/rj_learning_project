package com.rcarvajal.app.service.function.service;

import com.rcarvajal.app.service.function.dto.BodyRequest;
import reactor.core.publisher.Mono;

public interface BotService {
    Mono<String> sendMessage(BodyRequest request);
}
