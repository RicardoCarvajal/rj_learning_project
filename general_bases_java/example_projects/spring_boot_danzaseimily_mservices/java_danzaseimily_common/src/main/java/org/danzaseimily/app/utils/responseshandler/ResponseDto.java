package org.danzaseimily.app.utils.responseshandler;

public class ResponseDto {
    private String code;
    private String message;
    private Object data;

    public ResponseDto() {
    }

    public ResponseDto(ResponseBuilder builder) {
        this.code = builder.getCode();
        this.message = builder.getMessage();
        this.data = builder.getData();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResponseBuilder builder() {
        return new ResponseBuilder();
    }

}

