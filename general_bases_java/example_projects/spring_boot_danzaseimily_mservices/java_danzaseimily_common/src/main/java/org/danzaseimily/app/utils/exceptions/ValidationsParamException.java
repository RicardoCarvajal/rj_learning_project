package org.danzaseimily.app.utils.exceptions;


import org.danzaseimily.app.utils.responseshandler.ResponseDto;

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
