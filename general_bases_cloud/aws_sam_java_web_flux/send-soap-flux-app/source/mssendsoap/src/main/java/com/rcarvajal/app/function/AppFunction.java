package com.rcarvajal.app.function;

import com.rcarvajal.app.function.dto.RequestDto;
import com.rcarvajal.app.function.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Slf4j
@Component
public class AppFunction implements Function<RequestDto, ResponseEntity<ResponseDto>> {
    @Override
    public ResponseEntity<ResponseDto> apply(RequestDto request) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("El mensaje fue enviado");
        responseDto.setStatus("OK");
        responseDto.setData(sleepMethod_one() + " " + sleepMethod_two());
        log.info("Response: {}", responseDto.getMessage());
        return ResponseEntity.ok().body(responseDto);
    }

    public String sleepMethod_one() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Send 1";
    }

    public String sleepMethod_two() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Send 2";
    }

}
