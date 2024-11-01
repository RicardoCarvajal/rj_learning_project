package com.rcarvajal.app.service.function.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rcarvajal.app.service.function.dto.BodyRequest;
import com.rcarvajal.app.service.function.dto.FunctionRequest;
import com.rcarvajal.app.service.function.dto.RecordsItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class FunctionRequestMapper {

    private final ObjectMapper objectMapper;

    public FunctionRequestMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Optional<BodyRequest> getBody(FunctionRequest functionRequest) {
        try {
            List<RecordsItem> records = functionRequest.getRecords();
            if (CollectionUtils.isEmpty(records)) {
                return Optional.empty();
            }
            String body = functionRequest.getRecords().getFirst().getBody();
            return Optional.of(this.objectMapper.readValue(body, BodyRequest.class));
        } catch (JsonProcessingException e) {
            return Optional.empty();
        }
    }


}
