package com.rcarvajal.app.service.functions;

import com.rcarvajal.app.service.functions.dto.FunctionRequest;
import com.rcarvajal.app.service.functions.service.BotService;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class BotFunction implements Function<FunctionRequest, String> {

    private final BotService botService;

    public BotFunction(BotService botService) {
        this.botService = botService;
    }

    @Override
    public String apply(FunctionRequest request) {
        return botService.getString(request);
    }
}
