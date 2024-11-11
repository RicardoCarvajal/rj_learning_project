package org.intelix.app.sap.model;

import org.intelix.app.sap.builder.RetailLineItemBuilder;

import javax.xml.bind.annotation.XmlElement;

public class RetailLineItem {

    private String retailStoreId = "";
    private String businessDayDate = "";
    private String transactionTypeCode = "";
    private String workstationId = "";
    private String transactionSequenceNumber = "";
    private String retailSequenceNumber = "";
    private String retailTypeCode = "";
    private String retailReasonCode = "";
    private String itemIdQualifier = "";
    private String itemId = "";
    private String retailQuantity = "";
    private String salesUnitOfMeasure = "";
    private String salesUnitOfMeasureIso = "";
    private String salesAmount = "";
    private String normalSalesAmount = "";
    private String cost = "";
    private String batchId = "";
    private String serialNumber = "";
    private String promotionId = "";
    private String itemIdEntryMethodCode = "";
    private String actualUnitPrice = "";
    private String units = "";
    private String scanTime = "";
    private String nonexistentArticleId = "";
    private String nonexistentEan = "";
    private String enteredEan = "";
    private String origRetailStoreId = "";
    private String origBusinessDayDate = "";
    private String origWorkstationId = "";
    private String origTransNumber = "";
    private String origBeginTimeStamp = "";
    private String origReasonCode = "";
    private String origLineItemNumber = "";
    private String logSys = "";
    private String itemIdLong = "";
    private String nonexistentArticleIdLong = "";
    private String priceTypeCode = "";
    private String orderChannel = "";

    public RetailLineItem() {
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

    @XmlElement(name = "RETAILTYPECODE")
    public String getRetailTypeCode() {
        return retailTypeCode;
    }

    @XmlElement(name = "RETAILREASONCODE")
    public String getRetailReasonCode() {
        return retailReasonCode;
    }

    @XmlElement(name = "ITEMIDQUALIFIER")
    public String getItemIdQualifier() {
        return itemIdQualifier;
    }

    @XmlElement(name = "ITEMID")
    public String getItemId() {
        return itemId;
    }

    @XmlElement(name = "RETAILQUANTITY")
    public String getRetailQuantity() {
        return retailQuantity;
    }

    @XmlElement(name = "SALESUNITOFMEASURE")
    public String getSalesUnitOfMeasure() {
        return salesUnitOfMeasure;
    }

    @XmlElement(name = "SALESUNITOFMEASURE_ISO")
    public String getSalesUnitOfMeasureIso() {
        return salesUnitOfMeasureIso;
    }

    @XmlElement(name = "SALESAMOUNT")
    public String getSalesAmount() {
        return salesAmount;
    }

    @XmlElement(name = "NORMALSALESAMOUNT")
    public String getNormalSalesAmount() {
        return normalSalesAmount;
    }

    @XmlElement(name = "COST")
    public String getCost() {
        return cost;
    }

    @XmlElement(name = "BATCHID")
    public String getBatchId() {
        return batchId;
    }

    @XmlElement(name = "SERIALNUMBER")
    public String getSerialNumber() {
        return serialNumber;
    }

    @XmlElement(name = "PROMOTIONID")
    public String getPromotionId() {
        return promotionId;
    }

    @XmlElement(name = "ITEMIDENTRYMETHODCODE")
    public String getItemIdEntryMethodCode() {
        return itemIdEntryMethodCode;
    }

    @XmlElement(name = "ACTUALUNITPRICE")
    public String getActualUnitPrice() {
        return actualUnitPrice;
    }

    @XmlElement(name = "UNITS")
    public String getUnits() {
        return units;
    }

    @XmlElement(name = "SCANTIME")
    public String getScanTime() {
        return scanTime;
    }

    @XmlElement(name = "NONEXISTENTARTICLEID")
    public String getNonexistentArticleId() {
        return nonexistentArticleId;
    }

    @XmlElement(name = "NONEXISTENTEAN")
    public String getNonexistentEan() {
        return nonexistentEan;
    }

    @XmlElement(name = "ENTEREDEAN")
    public String getEnteredEan() {
        return enteredEan;
    }

    @XmlElement(name = "ORIGRETAILSTOREID")
    public String getOrigRetailStoreId() {
        return origRetailStoreId;
    }

    @XmlElement(name = "ORIGBUSINESSDAYDATE")
    public String getOrigBusinessDayDate() {
        return origBusinessDayDate;
    }

    @XmlElement(name = "ORIGWORKSTATIONID")
    public String getOrigWorkstationId() {
        return origWorkstationId;
    }

    @XmlElement(name = "ORIGTRANSNUMBER")
    public String getOrigTransNumber() {
        return origTransNumber;
    }

    @XmlElement(name = "ORIGBEGINTIMESTAMP")
    public String getOrigBeginTimeStamp() {
        return origBeginTimeStamp;
    }

    @XmlElement(name = "ORIGREASONCODE")
    public String getOrigReasonCode() {
        return origReasonCode;
    }

    @XmlElement(name = "ORIGLINEITEMNUMBER")
    public String getOrigLineItemNumber() {
        return origLineItemNumber;
    }

    @XmlElement(name = "LOGSYS")
    public String getLogSys() {
        return logSys;
    }

    @XmlElement(name = "ITEMID_LONG")
    public String getItemIdLong() {
        return itemIdLong;
    }

    @XmlElement(name = "NONEXISTENTARTICLEID_LONG")
    public String getNonexistentArticleIdLong() {
        return nonexistentArticleIdLong;
    }

    @XmlElement(name = "PRICETYPECODE")
    public String getPriceTypeCode() {
        return priceTypeCode;
    }

    @XmlElement(name = "ORDER_CHANNEL")
    public String getOrderChannel() {
        return orderChannel;
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

    public void setRetailTypeCode(String retailTypeCode) {
        this.retailTypeCode = retailTypeCode;
    }

    public void setRetailReasonCode(String retailReasonCode) {
        this.retailReasonCode = retailReasonCode;
    }

    public void setItemIdQualifier(String itemIdQualifier) {
        this.itemIdQualifier = itemIdQualifier;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setRetailQuantity(String retailQuantity) {
        this.retailQuantity = retailQuantity;
    }

    public void setSalesUnitOfMeasure(String salesUnitOfMeasure) {
        this.salesUnitOfMeasure = salesUnitOfMeasure;
    }

    public void setSalesUnitOfMeasureIso(String salesUnitOfMeasureIso) {
        this.salesUnitOfMeasureIso = salesUnitOfMeasureIso;
    }

    public void setSalesAmount(String salesAmount) {
        this.salesAmount = salesAmount;
    }

    public void setNormalSalesAmount(String normalSalesAmount) {
        this.normalSalesAmount = normalSalesAmount;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }

    public void setItemIdEntryMethodCode(String itemIdEntryMethodCode) {
        this.itemIdEntryMethodCode = itemIdEntryMethodCode;
    }

    public void setActualUnitPrice(String actualUnitPrice) {
        this.actualUnitPrice = actualUnitPrice;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public void setScanTime(String scanTime) {
        this.scanTime = scanTime;
    }

    public void setNonexistentArticleId(String nonexistentArticleId) {
        this.nonexistentArticleId = nonexistentArticleId;
    }

    public void setNonexistentEan(String nonexistentEan) {
        this.nonexistentEan = nonexistentEan;
    }

    public void setEnteredEan(String enteredEan) {
        this.enteredEan = enteredEan;
    }

    public void setOrigRetailStoreId(String origRetailStoreId) {
        this.origRetailStoreId = origRetailStoreId;
    }

    public void setOrigBusinessDayDate(String origBusinessDayDate) {
        this.origBusinessDayDate = origBusinessDayDate;
    }

    public void setOrigWorkstationId(String origWorkstationId) {
        this.origWorkstationId = origWorkstationId;
    }

    public void setOrigTransNumber(String origTransNumber) {
        this.origTransNumber = origTransNumber;
    }

    public void setOrigBeginTimeStamp(String origBeginTimeStamp) {
        this.origBeginTimeStamp = origBeginTimeStamp;
    }

    public void setOrigReasonCode(String origReasonCode) {
        this.origReasonCode = origReasonCode;
    }

    public void setOrigLineItemNumber(String origLineItemNumber) {
        this.origLineItemNumber = origLineItemNumber;
    }

    public void setLogSys(String logSys) {
        this.logSys = logSys;
    }

    public void setItemIdLong(String itemIdLong) {
        this.itemIdLong = itemIdLong;
    }

    public void setNonexistentArticleIdLong(String nonexistentArticleIdLong) {
        this.nonexistentArticleIdLong = nonexistentArticleIdLong;
    }

    public void setPriceTypeCode(String priceTypeCode) {
        this.priceTypeCode = priceTypeCode;
    }

    public void setOrderChannel(String orderChannel) {
        this.orderChannel = orderChannel;
    }

    public static RetailLineItemBuilder builder() {
        return new RetailLineItemBuilder();
    }

}
