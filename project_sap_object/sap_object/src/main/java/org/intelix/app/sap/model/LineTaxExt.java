package org.intelix.app.sap.model;

import org.intelix.app.sap.builder.LineTaxBuilder;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class LineTaxExt {

    private List<LineTaxExtItem> lineTaxExtItem = new ArrayList<>();

    public LineTaxExt() {
    }

    @XmlElement(name = "item")
    public List<LineTaxExtItem> getLineTaxItem() {
        return lineTaxExtItem;
    }

    public void setLineTaxItem(List<LineTaxExtItem> lineTaxItem) {
        this.lineTaxExtItem = lineTaxItem;
    }

    public void addLineTaxItem(LineTaxExtItem lineTaxItem) {
        this.lineTaxExtItem.add(lineTaxItem);
    }

    public static LineTaxBuilder builder() {
        return new LineTaxBuilder();
    }
}
