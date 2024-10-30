package com.rcarvajal.app.service.functions.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class FunctionRequest {

    @JsonProperty(value = "update_id")
    private int updateId;

    private Message message;

    public FunctionRequest() {

    }

    public int getUpdateId() {
        return updateId;
    }

    public void setUpdateId(int updateId) {
        this.updateId = updateId;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
