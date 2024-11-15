package com.rcarvajal.app.service.function.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Statement {

    @JsonProperty("Action")
    private final String ACTION = "execute-api:Invoke";

    @JsonProperty("Effect")
    private String effect;

    @JsonProperty("Resource")
    private String resource;

    public Statement() {
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public static StatementBuilder builder() {
        return new StatementBuilder();
    }

    public static class StatementBuilder {

        private final Statement statement = new Statement();

        public StatementBuilder resource(String resource) {
            this.statement.setResource(resource);
            return this;
        }

        public StatementBuilder effect(String effect) {
            this.statement.setEffect(effect);
            return this;
        }

        public Statement build() {
            return this.statement;
        }
    }

}