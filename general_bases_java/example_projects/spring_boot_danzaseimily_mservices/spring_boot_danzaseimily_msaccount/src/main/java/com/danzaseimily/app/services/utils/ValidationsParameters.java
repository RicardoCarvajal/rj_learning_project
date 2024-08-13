package com.danzaseimily.app.services.utils;

import com.danzaseimily.app.services.dtos.ResponseDto;
import com.danzaseimily.app.services.exceptions.ValidationsParamException;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import reactor.core.publisher.Mono;

@Component
public class ValidationsParameters {

    private final Validator validator;

    public ValidationsParameters(Validator validator) {
        this.validator = validator;
    }

    public <T> Mono<T> valid(T dto) {
        Errors error = new BeanPropertyBindingResult(dto, dto.getClass().getName());
        validator.validate(dto, error);
        if (error.hasErrors()) {
            if (error.getFieldError() != null) {
                throw new ValidationsParamException(ResponseDto.builder().code(HttpResponseStatus.BAD_REQUEST.toString()).message(error.getFieldError().getField() + " " + error.getFieldError().getDefaultMessage()).build());
            } else {
                throw new ValidationsParamException(ResponseDto.builder().code(HttpResponseStatus.BAD_REQUEST.toString()).build());
            }
        }
        return Mono.just(dto);
    }


}
