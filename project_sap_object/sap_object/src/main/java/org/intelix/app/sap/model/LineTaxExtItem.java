package org.intelix.app.sap.model;

import javax.xml.bind.annotation.XmlElement;

public class LineTaxExtItem {
    private String retailStoreId = "";
    private String businessDayDate = "";
    private String transactionTypeCode = "";
    private String workStationId = "";
    private String transactionSequenceNumber = "";
    private String retailSequenceNumber = "";
    private String taxSequenceNumber = "";
    private String fieldGroup = "";
    private String fieldName = "";
    private String fieldValue = "";

    public LineTaxExtItem() {
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

    @XmlElement(name = "FIELDGROUP")
    public String getFieldGroup() {
        return fieldGroup;
    }

    @XmlElement(name = "FIELDNAME")
    public String getFieldName() {
        return fieldName;
    }

    @XmlElement(name = "FIELDVALUE")
    public String getFieldValue() {
        return fieldValue;
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

    public void setFieldGroup(String fieldGroup) {
        this.fieldGroup = fieldGroup;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }


}
