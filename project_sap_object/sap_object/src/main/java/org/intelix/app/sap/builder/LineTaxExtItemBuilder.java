package org.intelix.app.sap.builder;

import org.intelix.app.sap.model.LineTaxExtItem;
import org.intelix.app.sap.model.Transaction;

public class LineTaxExtItemBuilder {

    private final LineTaxExtItem lineTaxExtItem = new LineTaxExtItem();

    public LineTaxExtItemBuilder() {

    }

    public LineTaxExtItemBuilder transaction(Transaction transaction) {
        this.lineTaxExtItem.setRetailStoreId(transaction.getRetailStoreId());
        this.lineTaxExtItem.setWorkStationId(transaction.getWorkstationId());
        this.lineTaxExtItem.setTransactionSequenceNumber(transaction.getTransactionSequenceNumber());
        this.lineTaxExtItem.setTransactionTypeCode(transaction.getTransactionTypeCode());
        this.lineTaxExtItem.setBusinessDayDate(transaction.getBusinessDayDate());
        return this;
    }

    public LineTaxExtItemBuilder retailStoreId(String retailStoreId) {
        this.lineTaxExtItem.setRetailStoreId(retailStoreId);
        return this;
    }

    public LineTaxExtItemBuilder businessDayDate(String businessDayDate) {
        this.lineTaxExtItem.setBusinessDayDate(businessDayDate);
        return this;
    }

    public LineTaxExtItemBuilder transactionTypeCode(String transactionTypeCode) {
        this.lineTaxExtItem.setTransactionTypeCode(transactionTypeCode);
        return this;
    }

    public LineTaxExtItemBuilder workStationId(String workStationId) {
        this.lineTaxExtItem.setWorkStationId(workStationId);
        return this;
    }

    public LineTaxExtItemBuilder transactionSequenceNumber(String transactionSequenceNumber) {
        this.lineTaxExtItem.setTransactionSequenceNumber(transactionSequenceNumber);
        return this;
    }

    public LineTaxExtItemBuilder retailSequenceNumber(String retailSequenceNumber) {
        this.lineTaxExtItem.setRetailSequenceNumber(retailSequenceNumber);
        return this;
    }

    public LineTaxExtItemBuilder taxSequenceNumber(String taxSequenceNumber) {
        this.lineTaxExtItem.setTaxSequenceNumber(taxSequenceNumber);
        return this;
    }

    public LineTaxExtItemBuilder fieldGroup(String fieldGroup) {
        this.lineTaxExtItem.setFieldGroup(fieldGroup);
        return this;
    }

    public LineTaxExtItemBuilder fieldName(String fieldName) {
        this.lineTaxExtItem.setFieldName(fieldName);
        return this;
    }

    public LineTaxExtItemBuilder fieldValue(String fieldValue) {
        this.lineTaxExtItem.setFieldValue(fieldValue);
        return this;
    }

    public LineTaxExtItem build() {
        return this.lineTaxExtItem;
    }


}
