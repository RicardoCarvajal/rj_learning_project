package org.intelix.app.sap.builder;

import org.intelix.app.sap.model.RetailLine;
import org.intelix.app.sap.model.RetailLineItem;

public class RetailLineBuilder {

    RetailLine retailLine = new RetailLine();

    public RetailLineBuilder() {
    }

    public RetailLineBuilder addRetailLineItem(RetailLineItem retailLineItem) {
        retailLine.addRetailLineItem(retailLineItem);
        return this;
    }

    public RetailLine build() {
        return retailLine;
    }
}
