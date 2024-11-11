package org.intelix.app.sap.builder;

import org.intelix.app.sap.model.CustomerDetails;
import org.intelix.app.sap.model.CustomerDetailsItem;
import org.intelix.app.sap.model.Transaction;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDetailsBuilder {


    private Transaction transaction  = new Transaction();

    private String customerID = "";

    private String customerName = "";

    private String customerTypeIdentification = "";

    private String customerPhone = "";

    private String customerAddress = "";

    public CustomerDetailsBuilder() {
    }

    public CustomerDetailsBuilder transaction(Transaction transaction){
        this.transaction = transaction;
        return this;
    }

    public CustomerDetailsBuilder addCustomerID(String customerID) {
        this.customerID = customerID;
        return this;
    }

    public CustomerDetailsBuilder addCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }


    public CustomerDetailsBuilder addCustomerTypeIdentification(String customerTypeIdentification) {
        this.customerTypeIdentification = customerTypeIdentification;
        return this;
    }

    public CustomerDetailsBuilder addCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
        return this;
    }

    public CustomerDetailsBuilder addCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
        return this;
    }

    public CustomerDetails build(){
        CustomerDetails customer = new CustomerDetails();

        customer.addCustomerDetailsItem(CustomerDetailsItem.builder()
                .transaction(this.transaction)
                .dataElementId("ID")
                .dataElementValue(this.customerID).build());

        customer.addCustomerDetailsItem(CustomerDetailsItem.builder()
                .transaction(this.transaction)
                .dataElementId("NOMBRE")
                .dataElementValue(this.customerName).build());

        customer.addCustomerDetailsItem(CustomerDetailsItem.builder()
                .transaction(this.transaction)
                .dataElementId("TIPOID")
                .dataElementValue(this.customerTypeIdentification).build());

        customer.addCustomerDetailsItem(CustomerDetailsItem.builder()
                .transaction(this.transaction)
                .dataElementId("TELEFONO")
                .dataElementValue(this.customerPhone).build());

        customer.addCustomerDetailsItem(CustomerDetailsItem.builder()
                .transaction(this.transaction)
                .dataElementId("DIRECCION")
                .dataElementValue(this.customerAddress).build());

        return customer;
    }

}
