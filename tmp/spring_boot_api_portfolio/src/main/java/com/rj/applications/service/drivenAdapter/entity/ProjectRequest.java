package com.rj.applications.service.drivenAdapter.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("projects_requests")
public class ProjectRequest {

    @Id
    private String _id;
    private String name;

    private String description;

    private Integer percentage;

    private Integer deviationPercentage;

    private String observations;

    private Date requestDateInit;

    private Date requestDateFinalPlan;

    private Date requestDateFinalReal;

    private String state;

    private String area;

    public ProjectRequest() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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
