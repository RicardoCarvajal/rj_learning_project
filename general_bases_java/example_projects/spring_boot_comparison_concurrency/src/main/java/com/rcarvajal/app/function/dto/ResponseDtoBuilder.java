package com.rcarvajal.app.function.dto;

public class ResponseDtoBuilder {
    private String message;
    private String status;
    private String data;

    public ResponseDtoBuilder() {
    }

    public ResponseDtoBuilder message(String message) {
        this.message = message;
        return this;
    }

    public ResponseDtoBuilder status(String status) {
        this.status = status;
        return this;
    }

    public ResponseDtoBuilder data(String data) {
        this.data = data;
        return this;
    }

    public ResponseDto build() {
        return new ResponseDto(message, status, data);
    }
}
