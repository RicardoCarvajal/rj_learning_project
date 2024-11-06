package com.rcarvajal.app.function;

import com.rcarvajal.app.Conf.PropertiesConf;
import com.rcarvajal.app.function.dto.RequestDto;
import com.rcarvajal.app.function.dto.ResponseDto;
import com.rcarvajal.app.function.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;

@Slf4j
@Component
public class AppFunctionMultiThread implements Function<List<RequestDto>, ResponseEntity<ResponseDto>> {

    private final PropertiesConf properties;

    private final Utils utils;

    private final RestTemplate restTemplate;

    public AppFunctionMultiThread(PropertiesConf properties, Utils utils, RestTemplate restTemplate) {
        this.properties = properties;
        this.utils = utils;
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<ResponseDto> apply(List<RequestDto> request) {
        ForkJoinPool threadPool = new ForkJoinPool(10);
        try {
            List<String> result = threadPool.submit(() -> request
                            .stream()
                            .parallel()
                            .map(r -> sendSoap(r.getTr()))
                            .toList())
                    .get();
            return ResponseEntity.ok().body(ResponseDto
                    .builder()
                    .status("200")
                    .message("Enviados")
                    .data(result.toString())
                    .build());
        } catch (Exception e) {
            log.error("Error durante el envio de las transacciones", e);
            return ResponseEntity.badRequest().build();
        } finally {
            threadPool.shutdown();
        }
    }

    public String sendSoap(Integer count) {
        String soapRequest = utils.convertXMLtoString();

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_XML_VALUE);
        headers.add(HttpHeaders.AUTHORIZATION, "Basic " + properties.getTOKEN());
        headers.add("SOAPAction", "#" + properties.getACTION());
        headers.add(HttpHeaders.COOKIE, "sap-usercontext=sap-client=100");

        HttpEntity<String> entity = new HttpEntity<String>(soapRequest, headers);

        try {
            Thread.sleep(Duration.ofSeconds(5));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String result = restTemplate.postForObject(properties.getURL(), entity, String.class);

        return "Send " + count;


    }

}
