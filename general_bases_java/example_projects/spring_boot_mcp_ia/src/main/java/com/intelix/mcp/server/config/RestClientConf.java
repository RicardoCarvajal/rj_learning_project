package com.intelix.mcp.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

import javax.net.ssl.SSLException;

@Configuration
public class RestClientConf {

    @Bean
    public RestClient webClient() throws SSLException {
        return RestClient.builder()
                .baseUrl("http://internal-preprodate-cr-bopos-lb-834087683.us-east-1.elb.amazonaws.com")
                .build();
    }
}
