package com.rj.lambda.models;

public class Article {

    private String name = "";

    private Integer code;

    private String description = "";

    public Article() {
        super();
    }

    public Article(String name, int code, String description) {
        super();
        this.name = name;
        this.code = code;
        this.description = description;
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
