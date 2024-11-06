package com.rcarvajal.app.function.dto;

public class ResponseDto {
    private String message;
    private String status;
    private String data;

    public ResponseDto() {
    }

    public ResponseDto(String message, String status, String data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public static ResponseDtoBuilder builder() {
        return new ResponseDtoBuilder();
    }
}
