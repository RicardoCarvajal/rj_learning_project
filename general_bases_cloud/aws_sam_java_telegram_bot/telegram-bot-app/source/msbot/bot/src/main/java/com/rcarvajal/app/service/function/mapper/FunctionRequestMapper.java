package com.rcarvajal.app.service.function.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rcarvajal.app.service.function.dto.BodyRequest;
import com.rcarvajal.app.service.function.dto.FunctionRequest;
import com.rcarvajal.app.service.function.dto.RecordsItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Component
public class FunctionRequestMapper {

    private final ObjectMapper objectMapper;

    public FunctionRequestMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Mono<BodyRequest> getBody(FunctionRequest functionRequest) {
        log.info("Mapeando request");
        try {
            List<RecordsItem> records = functionRequest.getRecords();
            if (CollectionUtils.isEmpty(records)) {
                return Mono.empty();
            }
            String body = records.getFirst().getBody();
            return Mono.just(this.objectMapper.readValue(body, BodyRequest.class));
        } catch (JsonProcessingException e) {
            log.error("Error mapeando request {}", e.getMessage());
            return Mono.error(new Exception("Error al mapear el JSON de entrada"));
        }
    }


}
