package com.rj.app.service.entryPoint.dto;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ProjectRequestDto {

    private String id;

    @NotEmpty(message = "El nombre no puede estar en blanco")
    private String name;

    @NotEmpty(message = "La descripción no puede estar en blanco")
    private String description;

    private Integer percentage;

    private Integer deviationPercentage;

    private String observations;

    private Date requestDateInit;

    @DateTimeFormat(pattern = "yyy-mm-dd")
    private Date requestDateFinalPlan;

    private Date requestDateFinalReal;


    private String state;

    @NotEmpty(message = "El area no puede estar en blanco")
    private String area;

    public ProjectRequestDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public Integer getDeviationPercentage() {
        return deviationPercentage;
    }

    public void setDeviationPercentage(Integer deviationPercentage) {
        this.deviationPercentage = deviationPercentage;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Date getRequestDateInit() {
        return requestDateInit;
    }

    public void setRequestDateInit(Date requestDateInit) {
        this.requestDateInit = requestDateInit;
    }

    public Date getRequestDateFinalPlan() {
        return requestDateFinalPlan;
    }

    public void setRequestDateFinalPlan(Date requestDateFinalPlan) {
        this.requestDateFinalPlan = requestDateFinalPlan;
    }

    public Date getRequestDateFinalReal() {
        return requestDateFinalReal;
    }

    public void setRequestDateFinalReal(Date requestDateFinalReal) {
        this.requestDateFinalReal = requestDateFinalReal;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
