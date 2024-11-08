package org.intelix.app.sap.model;

import javax.xml.bind.annotation.XmlElement;

public class ReturnTransaction {
    private ReturnTransactionItem returnItem = new ReturnTransactionItem();

    public ReturnTransaction() {
    }

    @XmlElement(name = "item")
    public ReturnTransactionItem getReturnItem() {
        return returnItem;
    }

    public void setReturnItem(ReturnTransactionItem returnItem) {
        this.returnItem = returnItem;
    }
}
