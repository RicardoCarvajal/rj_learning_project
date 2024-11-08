package org.intelix.app.sap.model;

import org.intelix.app.sap.builder.TransactionBuilder;

import javax.xml.bind.annotation.XmlElement;


public class Transaction {
    private String retailStoreId;
    private String businessDayDate;
    private String transactionTypeCode;
    private String workstationId;
    private String transactionSequenceNumber;
    private String beginDateTimeStamp;
    private String endDateTimeStamp;
    private String department;
    private String operatorQualifier;
    private String operatorId;
    private String transactionCurrency;
    private String transactionCurrencyIso;
    private String partnerQualifier;
    private String partnerId;
    private String activityTime;
    private String registerTime;
    private String tenderTime;
    private String pauseTime;
    private String trainingTime;
    private String tillId;
    private String customerIdPos;
    private String customerAge;
    private String customerEntryMethod;
    private String origRetailStoreId;
    private String origBusinessDayDate;
    private String origWorkstationId;
    private String origTransNumber;
    private String origBeginTimeStamp;
    private String origReasonCode;
    private String origLineItemNumber;
    private String logSys;

    public Transaction() {
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

    @XmlElement(name = "BEGINDATETIMESTAMP")
    public String getBeginDateTimeStamp() {
        return beginDateTimeStamp;
    }

    @XmlElement(name = "ENDDATETIMESTAMP")
    public String getEndDateTimeStamp() {
        return endDateTimeStamp;
    }

    @XmlElement(name = "DEPARTMENT")
    public String getDepartment() {
        return department;
    }

    @XmlElement(name = "OPERATORQUALIFIER")
    public String getOperatorQualifier() {
        return operatorQualifier;
    }

    @XmlElement(name = "OPERATORID")
    public String getOperatorId() {
        return operatorId;
    }

    @XmlElement(name = "TRANSACTIONCURRENCY")
    public String getTransactionCurrency() {
        return transactionCurrency;
    }

    @XmlElement(name = "TRANSACTIONCURRENCY_ISO")
    public String getTransactionCurrencyIso() {
        return transactionCurrencyIso;
    }

    @XmlElement(name = "PARTNERQUALIFIER")
    public String getPartnerQualifier() {
        return partnerQualifier;
    }

    @XmlElement(name = "PARTNERID")
    public String getPartnerId() {
        return partnerId;
    }

    @XmlElement(name = "ACTIVITYTIME")
    public String getActivityTime() {
        return activityTime;
    }

    @XmlElement(name = "REGISTERTIME")
    public String getRegisterTime() {
        return registerTime;
    }

    @XmlElement(name = "TENDERTIME")
    public String getTenderTime() {
        return tenderTime;
    }

    @XmlElement(name = "PAUSETIME")
    public String getPauseTime() {
        return pauseTime;
    }

    @XmlElement(name = "TRAININGTIME")
    public String getTrainingTime() {
        return trainingTime;
    }

    @XmlElement(name = "TILLID")
    public String getTillId() {
        return tillId;
    }

    @XmlElement(name = "CUSTOMERIDPOS")
    public String getCustomerIdPos() {
        return customerIdPos;
    }

    @XmlElement(name = "CUSTOMERAGE")
    public String getCustomerAge() {
        return customerAge;
    }

    @XmlElement(name = "CUSTOMERENTRYMETHOD")
    public String getCustomerEntryMethod() {
        return customerEntryMethod;
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

    public void setBeginDateTimeStamp(String beginDateTimeStamp) {
        this.beginDateTimeStamp = beginDateTimeStamp;
    }

    public void setEndDateTimeStamp(String endDateTimeStamp) {
        this.endDateTimeStamp = endDateTimeStamp;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setOperatorQualifier(String operatorQualifier) {
        this.operatorQualifier = operatorQualifier;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public void setTransactionCurrency(String transactionCurrency) {
        this.transactionCurrency = transactionCurrency;
    }

    public void setTransactionCurrencyIso(String transactionCurrencyIso) {
        this.transactionCurrencyIso = transactionCurrencyIso;
    }

    public void setPartnerQualifier(String partnerQualifier) {
        this.partnerQualifier = partnerQualifier;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public void setActivityTime(String activityTime) {
        this.activityTime = activityTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public void setTenderTime(String tenderTime) {
        this.tenderTime = tenderTime;
    }

    public void setPauseTime(String pauseTime) {
        this.pauseTime = pauseTime;
    }

    public void setTrainingTime(String trainingTime) {
        this.trainingTime = trainingTime;
    }

    public void setTillId(String tillId) {
        this.tillId = tillId;
    }

    public void setCustomerIdPos(String customerIdPos) {
        this.customerIdPos = customerIdPos;
    }

    public void setCustomerAge(String customerAge) {
        this.customerAge = customerAge;
    }

    public void setCustomerEntryMethod(String customerEntryMethod) {
        this.customerEntryMethod = customerEntryMethod;
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

    public static TransactionBuilder builder() {
        return new TransactionBuilder();
    }

}
