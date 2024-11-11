package org.intelix.app.sap.builder;

import org.intelix.app.sap.model.LineTax;
import org.intelix.app.sap.model.LineTaxItem;

public class LineTaxBuilder {

    private final LineTax lineTax = new LineTax();

    public LineTaxBuilder() {
    }

    public LineTaxBuilder addLineTaxItem(LineTaxItem lineTaxItem) {
        lineTax.addLineTaxItem(lineTaxItem);
        return this;
    }

    public LineTax build() {
        return lineTax;
    }

}
