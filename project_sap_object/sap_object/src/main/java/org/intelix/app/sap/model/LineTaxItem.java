package org.intelix.app.sap.model;

import org.intelix.app.sap.builder.LineTaxItemBuilder;

import javax.xml.bind.annotation.XmlElement;

public class LineTaxItem {

    private String retailStoreId = "";
    private String businessDayDate = "";
    private String transactionTypeCode = "";
    private String workStationId = "";
    private String transactionSequenceNumber = "";
    private String retailSequenceNumber = "";
    private String taxSequenceNumber = "";
    private String taxTypeCode = "";
    private String taxAmount = "";
    private String taxClassification = "";

    public LineTaxItem() {

    }

    @XmlElement(name = "RETAILSTOREID")
    public String getRetailStoreId() {
        return retailStoreId;
    }

    @XmlElement(name = "BUSINESSDAYDATE")
    public String getBusinessDayDate() {
        return businessDayDate;
    }

    @XmlElement(name = "TRANSACTIONTYPECODE")
    public String getTransactionTypeCode() {
        return transactionTypeCode;
    }

    @XmlElement(name = "WORKSTATIONID")
    public String getWorkStationId() {
        return workStationId;
    }

    @XmlElement(name = "TRANSACTIONSEQUENCENUMBER")
    public String getTransactionSequenceNumber() {
        return transactionSequenceNumber;
    }

    @XmlElement(name = "RETAILSEQUENCENUMBER")
    public String getRetailSequenceNumber() {
        return retailSequenceNumber;
    }

    @XmlElement(name = "TAXSEQUENCENUMBER")
    public String getTaxSequenceNumber() {
        return taxSequenceNumber;
    }

    @XmlElement(name = "TAXTYPECODE")
    public String getTaxTypeCode() {
        return taxTypeCode;
    }

    @XmlElement(name = "TAXAMOUNT")
    public String getTaxAmount() {
        return taxAmount;
    }

    @XmlElement(name = "TAXCLASSIFICATION")
    public String getTaxClassification() {
        return taxClassification;
    }

    public void setRetailStoreId(String retailStoreId) {
        this.retailStoreId = retailStoreId;
    }

    public void setBusinessDayDate(String businessDayDate) {
        this.businessDayDate = businessDayDate;
    }

    public void setTransactionTypeCode(String transactionTypeCode) {
        this.transactionTypeCode = transactionTypeCode;
    }

    public void setWorkStationId(String workStationId) {
        this.workStationId = workStationId;
    }

    public void setTransactionSequenceNumber(String transactionSequenceNumber) {
        this.transactionSequenceNumber = transactionSequenceNumber;
    }

    public void setRetailSequenceNumber(String retailSequenceNumber) {
        this.retailSequenceNumber = retailSequenceNumber;
    }

    public void setTaxSequenceNumber(String taxSequenceNumber) {
        this.taxSequenceNumber = taxSequenceNumber;
    }

    public void setTaxTypeCode(String taxTypeCode) {
        this.taxTypeCode = taxTypeCode;
    }

    public void setTaxAmount(String taxAmount) {
        this.taxAmount = taxAmount;
    }

    public void setTaxClassification(String taxClassification) {
        this.taxClassification = taxClassification;
    }

    public static LineTaxItemBuilder builder() {
        return new LineTaxItemBuilder();
    }
}
