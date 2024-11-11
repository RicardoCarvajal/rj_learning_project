package org.intelix.app.sap.builder;

import org.intelix.app.sap.model.LineDiscountItem;
import org.intelix.app.sap.model.Transaction;

public class LineDiscountItemBuilder {

    LineDiscountItem lineDiscountItem = new LineDiscountItem();

    public LineDiscountItemBuilder() {
    }

    public LineDiscountItemBuilder transaction(Transaction transaction) {
        this.lineDiscountItem.setRetailStoreId(transaction.getRetailStoreId());
        this.lineDiscountItem.setWorkstationId(transaction.getWorkstationId());
        this.lineDiscountItem.setTransactionSequenceNumber(transaction.getTransactionSequenceNumber());
        this.lineDiscountItem.setTransactionTypeCode(transaction.getTransactionTypeCode());
        this.lineDiscountItem.setBusinessDayDate(transaction.getBusinessDayDate());
        return this;
    }

    public LineDiscountItemBuilder retailStoreId(String retailStoreId) {
        this.lineDiscountItem.setRetailStoreId(retailStoreId);
        return this;
    }

    public LineDiscountItemBuilder businessDayDate(String businessDayDate) {
        this.lineDiscountItem.setBusinessDayDate(businessDayDate);
        return this;
    }

    public LineDiscountItemBuilder transactionTypeCode(String transactionTypeCode) {
        this.lineDiscountItem.setTransactionTypeCode(transactionTypeCode);
        return this;
    }

    public LineDiscountItemBuilder workstationId(String workstationId) {
        this.lineDiscountItem.setWorkstationId(workstationId);
        return this;
    }

    public LineDiscountItemBuilder transactionSequenceNumber(String transactionSequenceNumber) {
        this.lineDiscountItem.setTransactionSequenceNumber(transactionSequenceNumber);
        return this;
    }

    public LineDiscountItemBuilder retailSequenceNumber(String retailSequenceNumber) {
        this.lineDiscountItem.setRetailSequenceNumber(retailSequenceNumber);
        return this;
    }

    public LineDiscountItemBuilder discountSequenceNumber(String discountSequenceNumber) {
        this.lineDiscountItem.setDiscountSequenceNumber(discountSequenceNumber);
        return this;
    }

    public LineDiscountItemBuilder discountTypeCode(String discountTypeCode) {
        this.lineDiscountItem.setDiscountTypeCode(discountTypeCode);
        return this;
    }

    public LineDiscountItemBuilder discountReasonCode(String discountReasonCode) {
        this.lineDiscountItem.setDiscountReasonCode(discountReasonCode);
        return this;
    }

    public LineDiscountItemBuilder reductionAmount(String reductionAmount) {
        this.lineDiscountItem.setReductionAmount(reductionAmount);
        return this;
    }

    public LineDiscountItemBuilder storeFinancialLedgerAccountId(String storeFinancialLedgerAccountId) {
        this.lineDiscountItem.setStoreFinancialLedgerAccountId(storeFinancialLedgerAccountId);
        return this;
    }

    public LineDiscountItemBuilder discountId(String discountId) {
        this.lineDiscountItem.setDiscountId(discountId);
        return this;
    }

    public LineDiscountItemBuilder discountIdQualifier(String discountIdQualifier) {
        this.lineDiscountItem.setDiscountIdQualifier(discountIdQualifier);
        return this;
    }

    public LineDiscountItemBuilder bonusBuyId(String bonusBuyId) {
        this.lineDiscountItem.setBonusBuyId(bonusBuyId);
        return this;
    }

    public LineDiscountItemBuilder offerId(String offerId) {
        this.lineDiscountItem.setOfferId(offerId);
        return this;
    }

    public LineDiscountItemBuilder discountIdLong(String discountIdLong) {
        this.lineDiscountItem.setDiscountIdLong(discountIdLong);
        return this;
    }

    public LineDiscountItem build() {
        return this.lineDiscountItem;
    }


}
