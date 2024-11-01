package com.rcarvajal.app.service.function.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rcarvajal.app.service.function.dto.BodyRequest;
import com.rcarvajal.app.service.function.dto.FunctionRequest;
import com.rcarvajal.app.service.function.dto.RecordsItem;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Component
public class FunctionRequestMapper {

    private final ObjectMapper objectMapper;

    public FunctionRequestMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public BodyRequest getBody(FunctionRequest functionRequest) {
        try {

            if (Objects.isNull(functionRequest)) {
                System.out.println("La peticion no es valida");
            }

            List<RecordsItem> records = functionRequest.getRecords();

            if (CollectionUtils.isEmpty(records)) {
                return null;
            }

            String body = functionRequest.getRecords().getFirst().getBody();
            return this.objectMapper.readValue(body, BodyRequest.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }


}
