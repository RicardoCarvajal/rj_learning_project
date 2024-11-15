package com.rcarvajal.app.service.function.dto;

public class AuthResponse {

    private PolicyDocument policyDocument;

    public AuthResponse() {

    }

    public PolicyDocument getPolicyDocument() {
        return policyDocument;
    }

    public void setPolicyDocument(PolicyDocument policyDocument) {
        this.policyDocument = policyDocument;
    }

    public static AuthResponseBuilder builder() {
        return new AuthResponseBuilder();
    }

    public static class AuthResponseBuilder {

        private final AuthResponse authResponse = new AuthResponse();


        public AuthResponseBuilder policyDocument(PolicyDocument policyDocument) {
            this.authResponse.setPolicyDocument(policyDocument);
            return this;
        }

        public AuthResponse build() {
            return authResponse;
        }
    }
}