package org.intelix.app.sap.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class LineDiscount {

    private List<LineDiscountItem> lineDiscountItems = new ArrayList<>();

    public LineDiscount() {
    }

    @XmlElement(name = "item")
    public List<LineDiscountItem> getLineDiscountItems() {
        return lineDiscountItems;
    }

    public void setLineDiscountItems(List<LineDiscountItem> lineDiscountItems) {
        this.lineDiscountItems = lineDiscountItems;
    }
}
