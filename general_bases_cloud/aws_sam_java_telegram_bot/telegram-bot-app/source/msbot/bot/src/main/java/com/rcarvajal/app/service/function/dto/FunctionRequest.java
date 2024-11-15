package com.rcarvajal.app.service.function.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FunctionRequest {

    @JsonProperty("Records")
    private List<RecordsItem> records;

    public List<RecordsItem> getRecords() {
        return records;
    }

    public void setRecords(List<RecordsItem> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "FunctionRequest{" +
                "records=" + records.getFirst().getBody() +
                '}';
    }
}
