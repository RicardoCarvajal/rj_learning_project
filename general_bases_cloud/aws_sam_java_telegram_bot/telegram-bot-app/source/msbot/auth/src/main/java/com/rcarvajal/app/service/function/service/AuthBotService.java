package com.rcarvajal.app.service.function.service;

import com.rcarvajal.app.service.function.dto.AuthResponse;
import com.rcarvajal.app.service.function.dto.FunctionRequest;
import reactor.core.publisher.Mono;

public interface AuthBotService {
    Mono<AuthResponse> validateToken(FunctionRequest request);
}
