package com.rcarvajal.app.service.function;

import com.rcarvajal.app.service.function.dto.FunctionRequest;
import com.rcarvajal.app.service.function.mapper.FunctionRequestMapper;
import com.rcarvajal.app.service.function.service.BotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.function.Function;


@Slf4j
@Component
public class BotFunction implements Function<Mono<FunctionRequest>, Mono<ResponseEntity<String>>> {

    private final BotService botService;
    private final FunctionRequestMapper requestMapper;

    public BotFunction(BotService botService, FunctionRequestMapper requestMapper) {
        this.botService = botService;
        this.requestMapper = requestMapper;
    }

    @Override
    public Mono<ResponseEntity<String>> apply(Mono<FunctionRequest> request) {
        return request.flatMap(requestMapper::getBody).flatMap(botService::sendMessage).map(s -> {
            return ResponseEntity.ok("Response: " + s);
        }).onErrorResume(e -> {
            log.error("UPS!!! Algo malo paso {}", e.getMessage());
            return Mono.just(ResponseEntity.internalServerError().body(e.getMessage()));
        });
    }
}
