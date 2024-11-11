package org.intelix.app.sap.builder;

import org.intelix.app.sap.model.*;

public class XmlBodyBuilder {

    private XmlBody xmlBody = new XmlBody();

    public XmlBodyBuilder() {

    }

    public XmlBodyBuilder transaction(Transaction transaction) {
        xmlBody.setTransaction(transaction);
        return this;
    }

    public XmlBodyBuilder customerDetails(CustomerDetails customer) {
        xmlBody.setCustomerDetails(customer);
        return this;
    }

    public XmlBodyBuilder retailLine(RetailLine retailLine) {
        xmlBody.setRetailLine(retailLine);
        return this;
    }

    public XmlBodyBuilder lineDiscount(LineDiscount lineDiscount) {
        xmlBody.setLineDiscount(lineDiscount);
        return this;
    }

    public XmlBodyBuilder lineTax(LineTax lineTax) {
        xmlBody.setLineTax(lineTax);
        return this;
    }

    public XmlBodyBuilder lineTaxExt(LineTaxExt lineTaxExt) {
        xmlBody.setLineTaxExt(lineTaxExt);
        return this;
    }

    public XmlBody build() {
        return xmlBody;
    }

}
