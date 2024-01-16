package com.rj.applications.service.entryPoint.dto;

import java.math.BigDecimal;

public class ProductDto {

    private String code;
    private String stock;

    private String name;


    private String description;

    private BigDecimal retailPrice;

    private BigDecimal mayorPrice;

    public ProductDto() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
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

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public BigDecimal getMayorPrice() {
        return mayorPrice;
    }

    public void setMayorPrice(BigDecimal mayorPrice) {
        this.mayorPrice = mayorPrice;
    }
}
