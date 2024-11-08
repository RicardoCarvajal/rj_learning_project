package org.intelix.app.sap.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "urn:_-POSDW_-BAPI_POSTR_CREATE")
public class XmlBody {

    private String iCommit = "";

    private String iLockWait = "";

    private ReturnTransaction transactionReturn = new ReturnTransaction();

    private Transaction transaction;

    private CustomerDetails customerDetails = new CustomerDetails();

    private RetailLine retailLine = new RetailLine();

    private LineDiscount lineDiscount = new LineDiscount();


    public XmlBody() {
    }

    @XmlElement(name = "TRANSACTION")
    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @XmlElement(name = "I_COMMIT")
    public String getICommit() {
        return iCommit;
    }

    public void setICommit(String iCommit) {
        this.iCommit = iCommit;
    }

    @XmlElement(name = "I_LOCKWAIT")
    public String getILockWait() {
        return iLockWait;
    }

    public void setILockWait(String iLockWait) {
        this.iLockWait = iLockWait;
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
}
