package com.rcarvajal.app.service.conf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import javax.net.ssl.SSLException;

@Slf4j
@Configuration
public class WebClientConf {

    private final ConfProperties properties;

    public WebClientConf(ConfProperties properties) {
        this.properties = properties;
    }


    @Bean
    public WebClient webClient() throws SSLException {
        return WebClient
                .builder()
                .baseUrl("https://api.telegram.org/bot" + properties.getCredentialTelegram())
                .build();
    }

}
