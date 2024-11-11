package org.intelix.app.sap.builder;

import org.intelix.app.sap.model.LineTaxItem;
import org.intelix.app.sap.model.Transaction;

public class LineTaxItemBuilder {

    LineTaxItem lineTaxItem = new LineTaxItem();

    public LineTaxItemBuilder() {
    }

    public LineTaxItemBuilder transaction(Transaction transaction) {
        this.lineTaxItem.setRetailStoreId(transaction.getRetailStoreId());
        this.lineTaxItem.setWorkStationId(transaction.getWorkstationId());
        this.lineTaxItem.setTransactionSequenceNumber(transaction.getTransactionSequenceNumber());
        this.lineTaxItem.setTransactionTypeCode(transaction.getTransactionTypeCode());
        this.lineTaxItem.setBusinessDayDate(transaction.getBusinessDayDate());
        return this;
    }

    public LineTaxItemBuilder retailStoreId(String retailStoreId) {
        this.lineTaxItem.setRetailStoreId(retailStoreId);
        return this;
    }

    public LineTaxItemBuilder businessDayDate(String businessDayDate) {
        this.lineTaxItem.setBusinessDayDate(businessDayDate);
        return this;
    }

    public LineTaxItemBuilder transactionTypeCode(String transactionTypeCode) {
        this.lineTaxItem.setTransactionTypeCode(transactionTypeCode);
        return this;
    }

    public LineTaxItemBuilder workStationId(String workStationId) {
        this.lineTaxItem.setWorkStationId(workStationId);
        return this;
    }

    public LineTaxItemBuilder transactionSequenceNumber(String transactionSequenceNumber) {
        this.lineTaxItem.setTransactionSequenceNumber(transactionSequenceNumber);
        return this;
    }

    public LineTaxItemBuilder retailSequenceNumber(String retailSequenceNumber) {
        this.lineTaxItem.setRetailSequenceNumber(retailSequenceNumber);
        return this;
    }

    public LineTaxItemBuilder taxSequenceNumber(String taxSequenceNumber) {
        this.lineTaxItem.setTaxSequenceNumber(taxSequenceNumber);
        return this;
    }

    public LineTaxItemBuilder taxTypeCode(String taxTypeCode) {
        this.lineTaxItem.setTaxTypeCode(taxTypeCode);
        return this;
    }

    public LineTaxItemBuilder taxAmount(String taxAmount) {
        this.lineTaxItem.setTaxAmount(taxAmount);
        return this;
    }

    public LineTaxItemBuilder taxClassification(String taxClassification) {
        this.lineTaxItem.setTaxClassification(taxClassification);
        return this;
    }

    public LineTaxItem build() {
        return this.lineTaxItem;
    }

}
