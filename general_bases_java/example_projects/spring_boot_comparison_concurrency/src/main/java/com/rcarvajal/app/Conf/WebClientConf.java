package com.rcarvajal.app.Conf;

import io.netty.channel.ChannelOption;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;
import java.time.Duration;

@Slf4j
@Configuration
public class WebClientConf {

    private final PropertiesConf properties;

    public WebClientConf(PropertiesConf properties) {
        this.properties = properties;
    }


    @Bean
    public WebClient webClient() throws SSLException {

        SslContext sslContext = SslContextBuilder
                .forClient()
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                .build();
        HttpClient httpClient = HttpClient.create().secure(t -> t.sslContext(sslContext)).responseTimeout(Duration.ofSeconds(3)).option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000);

        return WebClient
                .builder()
                .baseUrl(properties.getURL())
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Basic " + properties.getTOKEN())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_XML_VALUE)
                .defaultHeader("SOAPAction", "#" + properties.getACTION())
                .defaultHeader(HttpHeaders.COOKIE, "sap-usercontext=sap-client=100")
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();


    }

}
