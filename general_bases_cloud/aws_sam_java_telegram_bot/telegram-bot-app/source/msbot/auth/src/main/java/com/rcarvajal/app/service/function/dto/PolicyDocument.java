package com.rcarvajal.app.service.function.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class PolicyDocument {

    @JsonProperty("Version")
    private final String VERSION = "2012-10-17";

    @JsonProperty("Statement")
    private List<Statement> statement = new ArrayList<>();

    public PolicyDocument() {

    }

    public List<Statement> getStatement() {
        return statement;
    }

    public void setStatement(List<Statement> statement) {
        this.statement = statement;
    }

    public void addStatement(Statement statement) {
        this.statement.add(statement);
    }

    public static PolicyDocumentBuilder builder() {
        return new PolicyDocumentBuilder();
    }

    public static class PolicyDocumentBuilder {

        PolicyDocument policyDocument = new PolicyDocument();

        public PolicyDocumentBuilder statement(Statement statement) {
            this.policyDocument.addStatement(statement);
            return this;
        }

        public PolicyDocument build() {
            return policyDocument;
        }
    }
}