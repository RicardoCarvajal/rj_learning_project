package org.intelix.app.sap.model;

import javax.xml.bind.annotation.XmlElement;

public class LineDiscountItem {

    private String retailStoreId = "";
    private String businessDayDate = "";
    private String transactionTypeCode = "";
    private String workstationId = "";
    private String transactionSequenceNumber = "";
    private String retailSequenceNumber = "";
    private String discountSequenceNumber = "";
    private String discountTypeCode = "";
    private String discountReasonCode = "";
    private String reductionAmount = "";
    private String storeFinancialLedgerAccountId = "";
    private String discountId = "";
    private String discountIdQualifier = "";
    private String bonusBuyId = "";
    private String offerId = "";
    private String discountIdLong = "";

    public LineDiscountItem() {

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

    @XmlElement(name = "RETAILSEQUENCENUMBER")
    public String getRetailSequenceNumber() {
        return retailSequenceNumber;
    }

    @XmlElement(name = "DISCOUNTSEQUENCENUMBER")
    public String getDiscountSequenceNumber() {
        return discountSequenceNumber;
    }

    @XmlElement(name = "DISCOUNTTYPECODE")
    public String getDiscountTypeCode() {
        return discountTypeCode;
    }

    @XmlElement(name = "DISCOUNTREASONCODE")
    public String getDiscountReasonCode() {
        return discountReasonCode;
    }

    @XmlElement(name = "REDUCTIONAMOUNT")
    public String getReductionAmount() {
        return reductionAmount;
    }

    @XmlElement(name = "STOREFINANCIALLEDGERACCOUNTID")
    public String getStoreFinancialLedgerAccountId() {
        return storeFinancialLedgerAccountId;
    }

    @XmlElement(name = "DISCOUNTID")
    public String getDiscountId() {
        return discountId;
    }

    @XmlElement(name = "DISCOUNTIDQUALIFIER")
    public String getDiscountIdQualifier() {
        return discountIdQualifier;
    }

    @XmlElement(name = "BONUSBUYID")
    public String getBonusBuyId() {
        return bonusBuyId;
    }

    @XmlElement(name = "OFFERID")
    public String getOfferId() {
        return offerId;
    }

    @XmlElement(name = "DISCOUNTID_LONG")
    public String getDiscountIdLong() {
        return discountIdLong;
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

    public void setRetailSequenceNumber(String retailSequenceNumber) {
        this.retailSequenceNumber = retailSequenceNumber;
    }

    public void setDiscountSequenceNumber(String discountSequenceNumber) {
        this.discountSequenceNumber = discountSequenceNumber;
    }

    public void setDiscountTypeCode(String discountTypeCode) {
        this.discountTypeCode = discountTypeCode;
    }

    public void setDiscountReasonCode(String discountReasonCode) {
        this.discountReasonCode = discountReasonCode;
    }

    public void setReductionAmount(String reductionAmount) {
        this.reductionAmount = reductionAmount;
    }

    public void setStoreFinancialLedgerAccountId(String storeFinancialLedgerAccountId) {
        this.storeFinancialLedgerAccountId = storeFinancialLedgerAccountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }

    public void setDiscountIdQualifier(String discountIdQualifier) {
        this.discountIdQualifier = discountIdQualifier;
    }

    public void setBonusBuyId(String bonusBuyId) {
        this.bonusBuyId = bonusBuyId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public void setDiscountIdLong(String discountIdLong) {
        this.discountIdLong = discountIdLong;
    }
}
