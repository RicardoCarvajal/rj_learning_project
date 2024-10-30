package com.rcarvajal.app.service.functions.config;

import com.rcarvajal.app.service.functions.BotFunction;
import com.rcarvajal.app.service.functions.dto.FunctionRequest;
import com.rcarvajal.app.service.functions.service.BotService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.function.Function;

@Configuration
public class AWSFunctionConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.create();
    }

    @Bean(name = "telegram")
    public Function<FunctionRequest, String> execute(BotService botService) {
        return new BotFunction(botService);
    }
}
