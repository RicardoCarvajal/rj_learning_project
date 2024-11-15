package com.rcarvajal.app.service.function.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FunctionRequest {

    private String type;

    private String authorizationToken;

    private String methodArn;

    public FunctionRequest() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthorizationToken() {
        return authorizationToken;
    }

    public void setAuthorizationToken(String authorizationToken) {
        this.authorizationToken = authorizationToken;
    }

    public String getMethodArn() {
        return methodArn;
    }

    public void setMethodArn(String methodArn) {
        this.methodArn = methodArn;
    }
}