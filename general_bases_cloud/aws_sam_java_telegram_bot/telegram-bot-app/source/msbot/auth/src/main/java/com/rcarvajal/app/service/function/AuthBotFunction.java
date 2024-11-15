package com.rcarvajal.app.service.function;

import com.rcarvajal.app.service.function.dto.AuthResponse;
import com.rcarvajal.app.service.function.dto.FunctionRequest;
import com.rcarvajal.app.service.function.service.implementation.AuthBotServicePrimary;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Slf4j
@Component
public class AuthBotFunction implements Function<Mono<FunctionRequest>, Mono<AuthResponse>> {

    private final AuthBotServicePrimary authBotService;

    public AuthBotFunction(AuthBotServicePrimary authBotService) {
        this.authBotService = authBotService;
    }


    @Override
    public Mono<AuthResponse> apply(Mono<FunctionRequest> request) {
        return request.flatMap(authBotService::validateToken).onErrorResume(e -> {
            log.error("Error validating token, {}", e.getMessage());
            return Mono.error(new Exception("Unauthorized"));
        });
    }
}
