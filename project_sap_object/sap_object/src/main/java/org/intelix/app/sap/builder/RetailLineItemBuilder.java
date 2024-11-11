package org.intelix.app.sap.builder;

import org.intelix.app.sap.model.RetailLineItem;
import org.intelix.app.sap.model.Transaction;

public class RetailLineItemBuilder {

    private RetailLineItem retailLineItem = new RetailLineItem();

    public RetailLineItemBuilder() {
    }

    public RetailLineItemBuilder transaction(Transaction transaction) {
        this.retailLineItem.setRetailStoreId(transaction.getRetailStoreId());
        this.retailLineItem.setWorkstationId(transaction.getWorkstationId());
        this.retailLineItem.setTransactionSequenceNumber(transaction.getTransactionSequenceNumber());
        this.retailLineItem.setTransactionTypeCode(transaction.getTransactionTypeCode());
        this.retailLineItem.setBusinessDayDate(transaction.getBusinessDayDate());
        return this;
    }

    public RetailLineItemBuilder retailStoreId(String retailStoreId) {
        this.retailLineItem.setRetailStoreId(retailStoreId);
        return this;
    }

    public RetailLineItemBuilder workstationId(String workstationId) {
        this.retailLineItem.setWorkstationId(workstationId);
        return this;
    }

    public RetailLineItemBuilder transactionSequenceNumber(String transactionSequenceNumber) {
        this.retailLineItem.setTransactionSequenceNumber(transactionSequenceNumber);
        return this;
    }

    public RetailLineItemBuilder transactionTypeCode(String transactionTypeCode) {
        this.retailLineItem.setTransactionTypeCode(transactionTypeCode);
        return this;
    }

    public RetailLineItemBuilder businessDayDate(String businessDayDate) {
        this.retailLineItem.setBusinessDayDate(businessDayDate);
        return this;
    }

    public RetailLineItemBuilder retailSequenceNumber(String dataElementId) {
        this.retailLineItem.setRetailSequenceNumber(dataElementId);
        return this;
    }

    public RetailLineItemBuilder retailTypeCode(String dataElementValue) {
        this.retailLineItem.setRetailTypeCode(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder retailReasonCode(String dataElementId) {
        this.retailLineItem.setRetailReasonCode(dataElementId);
        return this;
    }

    public RetailLineItemBuilder itemIdQualifier(String dataElementValue) {
        this.retailLineItem.setItemIdQualifier(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder itemId(String dataElementValue) {
        this.retailLineItem.setItemId(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder retailQuantity(String dataElementValue) {
        this.retailLineItem.setRetailQuantity(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder salesUnitOfMeasure(String dataElementValue) {
        this.retailLineItem.setSalesUnitOfMeasure(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder salesUnitOfMeasureIso(String dataElementValue) {
        this.retailLineItem.setSalesUnitOfMeasure(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder cost(String dataElementValue) {
        this.retailLineItem.setCost(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder batchId(String dataElementValue) {
        this.retailLineItem.setBatchId(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder serialNumber(String dataElementValue) {
        this.retailLineItem.setSerialNumber(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder promotionId(String dataElementValue) {
        this.retailLineItem.setPromotionId(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder itemIdEntryMethodCode(String dataElementValue) {
        this.retailLineItem.setItemIdEntryMethodCode(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder actualUnitPrice(String dataElementValue) {
        this.retailLineItem.setActualUnitPrice(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder salesAmount(String dataElementValue) {
        this.retailLineItem.setSalesAmount(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder normalSalesAmount(String dataElementValue) {
        this.retailLineItem.setNormalSalesAmount(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder units(String dataElementValue) {
        this.retailLineItem.setUnits(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder scanTime(String dataElementValue) {
        this.retailLineItem.setScanTime(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder nonexistentArticleId(String dataElementValue) {
        this.retailLineItem.setNonexistentArticleId(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder nonexistentEan(String dataElementValue) {
        this.retailLineItem.setNonexistentEan(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder enteredEan(String dataElementValue) {
        this.retailLineItem.setEnteredEan(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder origRetailStoreId(String dataElementValue) {
        this.retailLineItem.setOrigRetailStoreId(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder origBusinessDayDate(String dataElementValue) {
        this.retailLineItem.setOrigBusinessDayDate(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder origWorkstationId(String dataElementValue) {
        this.retailLineItem.setOrigWorkstationId(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder origTransNumber(String dataElementValue) {
        this.retailLineItem.setOrigTransNumber(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder origBeginTimeStamp(String dataElementValue) {
        this.retailLineItem.setOrigBeginTimeStamp(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder origReasonCode(String dataElementValue) {
        this.retailLineItem.setOrigReasonCode(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder origLineItemNumber(String dataElementValue) {
        this.retailLineItem.setOrigLineItemNumber(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder logSys(String dataElementValue) {
        this.retailLineItem.setLogSys(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder itemIdLong(String dataElementValue) {
        this.retailLineItem.setItemIdLong(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder nonexistentArticleIdLong(String dataElementValue) {
        this.retailLineItem.setNonexistentArticleIdLong(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder priceTypeCode(String dataElementValue) {
        this.retailLineItem.setPriceTypeCode(dataElementValue);
        return this;
    }

    public RetailLineItemBuilder orderChannel(String dataElementValue) {
        this.retailLineItem.setOrderChannel(dataElementValue);
        return this;
    }

    public RetailLineItem build() {
        return this.retailLineItem;
    }


}
