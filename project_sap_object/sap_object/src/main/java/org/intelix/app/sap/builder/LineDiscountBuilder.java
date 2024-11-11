package org.intelix.app.sap.builder;

import org.intelix.app.sap.model.LineDiscount;
import org.intelix.app.sap.model.LineDiscountItem;

public class LineDiscountBuilder {

    private LineDiscount lineDiscount = new LineDiscount();

    public LineDiscountBuilder() {
    }

    public LineDiscountBuilder addRetailLineItem(LineDiscountItem lineDiscountItem) {
        lineDiscount.addLineDiscountItem(lineDiscountItem);
        return this;
    }

    public LineDiscount build() {
        return this.lineDiscount;
    }

}
