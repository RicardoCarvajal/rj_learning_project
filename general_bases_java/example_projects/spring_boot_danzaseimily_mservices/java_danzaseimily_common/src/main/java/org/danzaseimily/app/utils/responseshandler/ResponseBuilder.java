package org.danzaseimily.app.utils.responseshandler;

public class ResponseBuilder {
    private String code;
    private String message;
    private Object data;

    public ResponseBuilder() {

    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public ResponseBuilder code(String code) {
        this.code = code;
        return this;
    }

    public ResponseBuilder message(String message) {
        this.message = message;
        return this;
    }

    public ResponseBuilder data(Object data) {
        this.data = data;
        return this;
    }

    public ResponseDto build() {
        return new ResponseDto(this);
    }
}
