package com.rcarvajal.app.Conf;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.io.HttpClientConnectionManager;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.time.Duration;

@Configuration
public class RestTemplateConfig {

    @Bean
    public TrustStrategy trustStrategy() {
        return (X509Certificate[] chain, String authType) -> true;
    }

    @Bean
    public SSLContext sslContext(TrustStrategy trustStrategy) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        return org.apache.http.ssl.SSLContexts.custom()
                .loadTrustMaterial(null, trustStrategy)
                .build();
    }

    @Bean
    public SSLConnectionSocketFactory socketFactory(SSLContext sslContext) {
        return new SSLConnectionSocketFactory(sslContext, new NoopHostnameVerifier());
    }

    @Bean
    public HttpClientConnectionManager connectionManager(SSLConnectionSocketFactory socketFactory) {
        return PoolingHttpClientConnectionManagerBuilder.create()
                .setSSLSocketFactory(socketFactory)
                .build();
    }

    @Bean
    public HttpClient httpClient(HttpClientConnectionManager connectionManager) {
        return HttpClients.custom()
                .setConnectionManager(connectionManager)
                .build();
    }

    @Bean
    public HttpComponentsClientHttpRequestFactory requestFactory(HttpClient httpClient) {
        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }

    @Bean
    public RestTemplate restTemplate(HttpComponentsClientHttpRequestFactory requestFactory) throws Exception {

        requestFactory.setConnectTimeout(Duration.ofSeconds(3));

        return new RestTemplate(requestFactory);
    }
}