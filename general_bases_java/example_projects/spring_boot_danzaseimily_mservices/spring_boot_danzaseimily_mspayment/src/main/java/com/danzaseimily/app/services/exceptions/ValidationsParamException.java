package com.danzaseimily.app.services.exceptions;

import com.danzaseimily.app.services.dtos.ResponseDto;

public class ValidationsParamException extends RuntimeException {

    private ResponseDto message;


    public ValidationsParamException(ResponseDto message) {
        super(message.toString());
        this.message = message;
    }

    public ResponseDto getMessageResponse() {
        return message;
    }
}
