package com.rcarvajal.app.function;

import com.rcarvajal.app.function.dto.RequestDto;
import com.rcarvajal.app.function.dto.ResponseDto;
import com.rcarvajal.app.function.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.function.Function;

@Slf4j
@Component
public class AppFunctionReactive implements Function<Flux<RequestDto>, Mono<ResponseEntity<ResponseDto>>> {

    private final WebClient webClient;

    private final Utils utils;

    public AppFunctionReactive(WebClient webClient, Utils utils) {
        this.webClient = webClient;
        this.utils = utils;
    }

    @Override
    public Mono<ResponseEntity<ResponseDto>> apply(Flux<RequestDto> request) {
        return request.flatMap(dto -> {
            log.info("Transaccion " + dto.getTr());
            return sendSoap(dto.getTr());
        }).collectList().map(list -> {
            ResponseDto responseDto = new ResponseDto();
            responseDto.setStatus("200");
            responseDto.setMessage("Enviados");
            responseDto.setData(list.toString());
            return ResponseEntity.ok().body(responseDto);
        });
    }

    public Mono<String> sendSoap(Integer count) {

        String soapRequest = utils.convertXMLtoString();

        return webClient.post()
                .body(Mono.just(soapRequest), String.class)
                .retrieve()
                .bodyToMono(String.class).map(s -> "Send" + count).delayElement(Duration.ofSeconds(5));

    }


}


