package com.rcarvajal.app.service.function.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BodyRequest {

    @JsonProperty(value = "update_id")
    private int updateId;

    private Message message;

    private String messageSystem;

    public BodyRequest() {

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

    public String getMessageSystem() {
        return messageSystem;
    }

    public void setMessageSystem(String messageSystem) {
        this.messageSystem = messageSystem;
    }
}
