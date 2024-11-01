package com.rcarvajal.app.service.function;

import com.rcarvajal.app.service.function.dto.FunctionRequest;
import com.rcarvajal.app.service.function.mapper.FunctionRequestMapper;
import com.rcarvajal.app.service.function.service.BotService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.function.Function;


@Component
public class BotFunction implements Function<FunctionRequest, ResponseEntity<String>> {

    private final BotService botService;
    private final FunctionRequestMapper requestMapper;

    public BotFunction(BotService botService, FunctionRequestMapper requestMapper) {
        this.botService = botService;
        this.requestMapper = requestMapper;
    }

    @Override
    public ResponseEntity<String> apply(FunctionRequest request) {
        return requestMapper.getBody(request).map(body -> {
            botService.sendMessage(body);
            return ResponseEntity.ok("Execute");
        }).orElse(ResponseEntity.badRequest().build());
    }
}
