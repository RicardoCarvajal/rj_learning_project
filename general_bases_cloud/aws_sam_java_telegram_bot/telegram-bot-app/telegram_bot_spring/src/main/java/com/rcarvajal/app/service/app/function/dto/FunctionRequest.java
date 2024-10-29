package com.rcarvajal.app.service.app.function.dto;

import jakarta.annotation.Nonnull;
import org.springframework.lang.NonNull;

public class FunctionRequest {
    private String id;
    private String message;
    public FunctionRequest() {
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
