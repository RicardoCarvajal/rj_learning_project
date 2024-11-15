package com.rcarvajal.app.service.function.service.implementation;

import com.rcarvajal.app.service.conf.ConfProperties;
import com.rcarvajal.app.service.function.dto.AuthResponse;
import com.rcarvajal.app.service.function.dto.FunctionRequest;
import com.rcarvajal.app.service.function.dto.PolicyDocument;
import com.rcarvajal.app.service.function.dto.Statement;
import com.rcarvajal.app.service.function.service.AuthBotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@Primary
public class AuthBotServicePrimary implements AuthBotService {

    private final ConfProperties confProperties;

    public AuthBotServicePrimary(ConfProperties confProperties) {
        this.confProperties = confProperties;
    }

    public Mono<AuthResponse> validateToken(FunctionRequest request) {
        if (request.getAuthorizationToken().equalsIgnoreCase(confProperties.getWebHookToken())) {
            log.info("{} Token is valid", request.getAuthorizationToken());
            return Mono.just(AuthResponse.builder()
                    .policyDocument(PolicyDocument.builder()
                            .statement(Statement.builder()
                                    .resource(request.getMethodArn())
                                    .effect("Allow")
                                    .build())
                            .build())
                    .build());
        }
        log.info("{} Token is NOT valid", request.getAuthorizationToken());
        return Mono.just(AuthResponse.builder()
                .policyDocument(PolicyDocument.builder()
                        .statement(Statement.builder()
                                .resource(request.getMethodArn())
                                .effect("Deny")
                                .build())
                        .build())
                .build());
    }
}
