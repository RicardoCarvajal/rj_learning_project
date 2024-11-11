package org.intelix.app.sap.builder;

import org.intelix.app.sap.model.CustomerDetailsItem;
import org.intelix.app.sap.model.Transaction;

public class CustomerDetailsItemBuilder {

    private CustomerDetailsItem customerDetailsItem = new CustomerDetailsItem();

    private final String CUSTOMERINFORMATIONTYPECODE = "BAS";

    public CustomerDetailsItemBuilder() {
        this.customerDetailsItem.setCustomerInformationTypeCode(CUSTOMERINFORMATIONTYPECODE);
    }

    public CustomerDetailsItemBuilder transaction(Transaction transaction){
        this.customerDetailsItem.setRetailStoreId(transaction.getRetailStoreId());
        this.customerDetailsItem.setWorkstationId(transaction.getWorkstationId());
        this.customerDetailsItem.setTransactionSequenceNumber(transaction.getTransactionSequenceNumber());
        this.customerDetailsItem.setTransactionTypeCode(transaction.getTransactionTypeCode());
        this.customerDetailsItem.setBusinessDayDate(transaction.getBusinessDayDate());
        return this;
    }

    public CustomerDetailsItemBuilder retailStoreId(String retailStoreId){
        this.customerDetailsItem.setRetailStoreId(retailStoreId);
        return this;
    }

    public CustomerDetailsItemBuilder workstationId(String workstationId){
        this.customerDetailsItem.setWorkstationId(workstationId);
        return this;
    }

    public CustomerDetailsItemBuilder transactionSequenceNumber(String transactionSequenceNumber){
        this.customerDetailsItem.setTransactionSequenceNumber(transactionSequenceNumber);
        return this;
    }

    public CustomerDetailsItemBuilder transactionTypeCode(String transactionTypeCode){
        this.customerDetailsItem.setTransactionTypeCode(transactionTypeCode);
        return this;
    }

    public CustomerDetailsItemBuilder businessDayDate(String  businessDayDate){
        this.customerDetailsItem.setBusinessDayDate(businessDayDate);
        return this;
    }

    public CustomerDetailsItemBuilder dataElementId(String dataElementId){
        this.customerDetailsItem.setDataElementId(dataElementId);
        return this;
    }

    public CustomerDetailsItemBuilder dataElementValue(String dataElementValue){
        this.customerDetailsItem.setDataElementValue(dataElementValue);
        return this;
    }

    public CustomerDetailsItemBuilder customerInformationTypeCode(String customerInformationTypeCode){
        if (customerInformationTypeCode == null || customerInformationTypeCode.isEmpty()){
            this.customerDetailsItem.setCustomerInformationTypeCode(CUSTOMERINFORMATIONTYPECODE);
            return this;
        }
        this.customerDetailsItem.setCustomerInformationTypeCode(customerInformationTypeCode);
        return this;
    }

    public CustomerDetailsItem build(){
        return this.customerDetailsItem;
    }


}
