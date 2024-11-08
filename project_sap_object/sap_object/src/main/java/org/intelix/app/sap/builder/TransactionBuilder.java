package org.intelix.app.sap.builder;

import org.intelix.app.sap.model.Transaction;

public class TransactionBuilder {

    private final Transaction transaction;

    public TransactionBuilder() {
        this.transaction = new Transaction();
    }

    public TransactionBuilder retailStoreId(String retailStoreId) {
        this.transaction.setRetailStoreId(retailStoreId);
        return this;
    }

    public TransactionBuilder businessDayDate(String businessDayDate) {
        this.transaction.setBusinessDayDate(businessDayDate);
        return this;
    }

    public TransactionBuilder transactionTypeCode(String transactionTypeCode) {
        this.transaction.setTransactionTypeCode(transactionTypeCode);
        return this;
    }

    public TransactionBuilder workstationId(String workstationId) {
        this.transaction.setWorkstationId(workstationId);
        return this;
    }

    public TransactionBuilder transactionSequenceNumber(String transactionSequenceNumber) {
        this.transaction.setTransactionSequenceNumber(transactionSequenceNumber);
        return this;
    }

    public TransactionBuilder beginDateTimeStamp(String beginDateTimeStamp) {
        this.transaction.setBeginDateTimeStamp(beginDateTimeStamp);
        return this;
    }

    public TransactionBuilder endDateTimeStamp(String endDateTimeStamp) {
        this.transaction.setEndDateTimeStamp(endDateTimeStamp);
        return this;
    }

    public TransactionBuilder department(String department) {
        this.transaction.setDepartment(department);
        return this;
    }

    public TransactionBuilder operatorQualifier(String operatorQualifier) {
        this.transaction.setOperatorQualifier(operatorQualifier);
        return this;
    }

    public TransactionBuilder operatorId(String operatorId) {
        this.transaction.setOperatorId(operatorId);
        return this;
    }

    public TransactionBuilder transactionCurrency(String transactionCurrency) {
        this.transaction.setTransactionCurrency(transactionCurrency);
        return this;
    }

    public TransactionBuilder transactionCurrencyIso(String transactionCurrencyIso) {
        this.transaction.setTransactionCurrencyIso(transactionCurrencyIso);
        return this;
    }

    public TransactionBuilder partnerQualifier(String partnerQualifier) {
        this.transaction.setPartnerQualifier(partnerQualifier);
        return this;
    }

    public TransactionBuilder partnerId(String partnerId) {
        this.transaction.setPartnerId(partnerId);
        return this;
    }

    public TransactionBuilder activityTime(String activityTime) {
        this.transaction.setActivityTime(activityTime);
        return this;
    }

    public TransactionBuilder registerTime(String registerTime) {
        this.transaction.setRegisterTime(registerTime);
        return this;
    }

    public TransactionBuilder tenderTime(String tenderTime) {
        this.transaction.setTenderTime(tenderTime);
        return this;
    }

    public TransactionBuilder pauseTime(String pauseTime) {
        this.transaction.setPauseTime(pauseTime);
        return this;
    }

    public TransactionBuilder trainingTime(String trainingTime) {
        this.transaction.setTrainingTime(trainingTime);
        return this;
    }

    public TransactionBuilder tillId(String tillId) {
        this.transaction.setTillId(tillId);
        return this;
    }

    public TransactionBuilder customerIdPos(String customerIdPos) {
        this.transaction.setCustomerIdPos(customerIdPos);
        return this;
    }

    public TransactionBuilder customerAge(String customerAge) {
        this.transaction.setCustomerAge(customerAge);
        return this;
    }

    public TransactionBuilder customerEntryMethod(String customerEntryMethod) {
        this.transaction.setCustomerEntryMethod(customerEntryMethod);
        return this;
    }

    public TransactionBuilder origRetailStoreId(String origRetailStoreId) {
        this.transaction.setOrigRetailStoreId(origRetailStoreId);
        return this;
    }

    public TransactionBuilder origBusinessDayDate(String origBusinessDayDate) {
        this.transaction.setOrigBusinessDayDate(origBusinessDayDate);
        return this;
    }

    public TransactionBuilder origWorkstationId(String origWorkstationId) {
        this.transaction.setOrigWorkstationId(origWorkstationId);
        return this;
    }

    public TransactionBuilder origTransNumber(String origTransNumber) {
        this.transaction.setOrigTransNumber(origTransNumber);
        return this;
    }

    public TransactionBuilder origBeginTimeStamp(String origBeginTimeStamp) {
        this.transaction.setOrigBeginTimeStamp(origBeginTimeStamp);
        return this;
    }

    public TransactionBuilder origReasonCode(String origReasonCode) {
        this.transaction.setOrigReasonCode(origReasonCode);
        return this;
    }

    public TransactionBuilder origLineItemNumber(String origLineItemNumber) {
        this.transaction.setOrigLineItemNumber(origLineItemNumber);
        return this;
    }

    public TransactionBuilder logSys(String logSys) {
        this.transaction.setLogSys(logSys);
        return this;
    }

    public Transaction build() {
        return this.transaction;
    }
}
