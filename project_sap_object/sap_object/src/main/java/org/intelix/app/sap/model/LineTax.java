package org.intelix.app.sap.model;

import org.intelix.app.sap.builder.LineTaxBuilder;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class LineTax {

    private List<LineTaxItem> lineTaxItem = new ArrayList<>();

    public LineTax() {
    }

    @XmlElement(name = "item")
    public List<LineTaxItem> getLineTaxItem() {
        return lineTaxItem;
    }

    public void setLineTaxItem(List<LineTaxItem> lineTaxItem) {
        this.lineTaxItem = lineTaxItem;
    }

    public void addLineTaxItem(LineTaxItem lineTaxItem) {
        this.lineTaxItem.add(lineTaxItem);
    }

    public static LineTaxBuilder builder() {
        return new LineTaxBuilder();
    }
}
