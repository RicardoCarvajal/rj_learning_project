package com.rcarvajal.app.Conf;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;

@Slf4j
@Configuration
public class WebClientConf {

    @Value("${webclient.api.soap.url}")
    private String URL;
    @Value("${webclient.api.soap.token}")
    private String TOKEN;
    @Value("${webclient.api.soap.action}")
    private String ACTION;

    @Bean
    public WebClient webClient() {
        try {
            SslContext sslContext = SslContextBuilder
                    .forClient()
                    .trustManager(InsecureTrustManagerFactory.INSTANCE)
                    .build();
            HttpClient httpClient = HttpClient.create().secure(t -> t.sslContext(sslContext));

            log.info(URL);
            log.info(TOKEN);
            log.info(ACTION);

            return WebClient
                    .builder()
                    .baseUrl(URL)
                    .defaultHeader(HttpHeaders.AUTHORIZATION, "Basic " + TOKEN)
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_XML_VALUE)
                    .defaultHeader("SOAPAction", "#" + ACTION)
                    .defaultHeader(HttpHeaders.COOKIE, "sap-usercontext=sap-client=100")
                    .clientConnector(new ReactorClientHttpConnector(httpClient))
                    .build();
        } catch (SSLException e) {
            log.error("Error en el bean de WebClient ", e.getMessage());
            return null;
        }


    }

}
