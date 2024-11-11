package org.intelix.app.sap.model;

import org.intelix.app.sap.builder.XmlBodyBuilder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "urn:_-POSDW_-BAPI_POSTR_CREATE")
public class XmlBody {

    @XmlElement(name = "I_COMMIT")
    private final String ICOMMIT = "X";

    @XmlElement(name = "I_LOCKWAIT")
    private final String ILOCKWAIT = "5";

    private Transaction transaction;

    private ReturnTransaction transactionReturn = new ReturnTransaction();

    private CustomerDetails customerDetails = new CustomerDetails();

    private RetailLine retailLine;

    private LineDiscount lineDiscount;

    private LineTax lineTax;

    private LineTaxExt lineTaxExt;


    public XmlBody() {
    }

    @XmlElement(name = "TRANSACTION")
    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }


    @XmlElement(name = "CUSTOMERDETAILS")
    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    @XmlElement(name = "RETAILLINEITEM")
    public RetailLine getRetailLine() {
        return retailLine;
    }

    public void setRetailLine(RetailLine retailLine) {
        this.retailLine = retailLine;
    }

    @XmlElement(name = "RETURN")
    public ReturnTransaction getTransactionReturn() {
        return transactionReturn;
    }

    public void setTransactionReturn(ReturnTransaction transactionReturn) {
        this.transactionReturn = transactionReturn;
    }

    @XmlElement(name = "LINEITEMDISCOUNT")
    public LineDiscount getLineDiscount() {
        return lineDiscount;
    }

    public void setLineDiscount(LineDiscount lineDiscount) {
        this.lineDiscount = lineDiscount;
    }

    @XmlElement(name = "LINEITEMTAX")
    public LineTax getLineTax() {
        return lineTax;
    }

    public void setLineTax(LineTax lineTax) {
        this.lineTax = lineTax;
    }

    @XmlElement(name = "LINEITEMTAXEXT")
    public LineTaxExt getLineTaxExt() {
        return lineTaxExt;
    }

    public void setLineTaxExt(LineTaxExt lineTaxExt) {
        this.lineTaxExt = lineTaxExt;
    }

    public static XmlBodyBuilder builder() {
        return new XmlBodyBuilder();
    }


}
