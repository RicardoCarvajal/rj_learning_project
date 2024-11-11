package org.intelix.app.sap.model;

import org.intelix.app.sap.builder.CustomerDetailsItemBuilder;

import javax.xml.bind.annotation.XmlElement;

public class CustomerDetailsItem {


    private String retailStoreId = "";
    private String businessDayDate = "";
    private String transactionTypeCode = "";
    private String workstationId = "";
    private String transactionSequenceNumber = "";
    private String customerInformationTypeCode = "";
    private String dataElementId = "";
    private String dataElementValue = "";
    private String customerDetailsSequenceNumber = "";

    public CustomerDetailsItem() {
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
    public String getWorkstationId() {
        return workstationId;
    }

    @XmlElement(name = "TRANSACTIONSEQUENCENUMBER")
    public String getTransactionSequenceNumber() {
        return transactionSequenceNumber;
    }

    @XmlElement(name = "CUSTOMERINFORMATIONTYPECODE")
    public String getCustomerInformationTypeCode() {
        return customerInformationTypeCode;
    }

    @XmlElement(name = "DATAELEMENTID")
    public String getDataElementId() {
        return dataElementId;
    }

    @XmlElement(name = "DATAELEMENTVALUE")
    public String getDataElementValue() {
        return dataElementValue;
    }

    @XmlElement(name = "CUSTOMERDETAILSSEQUENCENUMBER")
    public String getCustomerDetailsSequenceNumber() {
        return customerDetailsSequenceNumber;
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

    public void setWorkstationId(String workstationId) {
        this.workstationId = workstationId;
    }

    public void setTransactionSequenceNumber(String transactionSequenceNumber) {
        this.transactionSequenceNumber = transactionSequenceNumber;
    }

    public void setCustomerInformationTypeCode(String customerInformationTypeCode) {
        this.customerInformationTypeCode = customerInformationTypeCode;
    }

    public void setDataElementId(String dataElementId) {
        this.dataElementId = dataElementId;
    }

    public void setDataElementValue(String dataElementValue) {
        this.dataElementValue = dataElementValue;
    }

    public void setCustomerDetailsSequenceNumber(String customerDetailsSequenceNumber) {
        this.customerDetailsSequenceNumber = customerDetailsSequenceNumber;
    }

    public static CustomerDetailsItemBuilder builder() {
        return new CustomerDetailsItemBuilder();
    }


}
