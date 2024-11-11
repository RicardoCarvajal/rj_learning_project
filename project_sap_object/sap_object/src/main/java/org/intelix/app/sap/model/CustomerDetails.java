package org.intelix.app.sap.model;

import org.intelix.app.sap.builder.CustomerDetailsBuilder;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDetails {


    private List<CustomerDetailsItem> item = new ArrayList<>();

    public CustomerDetails() {
    }

    @XmlElement(name = "item")
    public List<CustomerDetailsItem> getItem() {
        return item;
    }

    public void setItem(List<CustomerDetailsItem> item) {
        this.item = item;
    }

    public void addCustomerDetailsItem(CustomerDetailsItem customerDetailsItem) {
        this.item.add(customerDetailsItem);
    }

    public static CustomerDetailsBuilder builder() {
        return new CustomerDetailsBuilder();
    }
}
