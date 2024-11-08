package org.intelix.app.sap.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class RetailLine {

    private List<RetailLineItem> retailLineItem = new ArrayList<>();

    public RetailLine() {
    }

    @XmlElement(name = "item")
    public List<RetailLineItem> getRetailLineItem() {
        return retailLineItem;
    }

    public void setRetailLineItem(List<RetailLineItem> retailLineItem) {
        this.retailLineItem = retailLineItem;
    }
}
