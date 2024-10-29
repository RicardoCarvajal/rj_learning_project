package com.rcarvajal.app.service.app.function;

import com.rcarvajal.app.service.app.function.dto.FunctionRequest;
import com.rcarvajal.app.service.app.function.service.BotService;

import java.util.function.Function;

public class BotFunction implements Function<FunctionRequest,String> {

    private final BotService botService;

    public BotFunction(BotService botService) {
        this.botService = botService;
    }

    @Override
    public String apply(FunctionRequest request) {
        return botService.getString(request);
    }
}
