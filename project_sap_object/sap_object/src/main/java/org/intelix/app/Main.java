package org.intelix.app;

import org.intelix.app.sap.model.*;
import org.intelix.app.sap.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws JAXBException {
        log.info("Test object");

        Transaction transaction = Transaction.builder()
                .retailStoreId("CR02")
                .businessDayDate("2024-06-22")
                .transactionTypeCode("1001")
                .workstationId("10")
                .transactionSequenceNumber("301")
                .beginDateTimeStamp("20240621100500")
                .endDateTimeStamp("20240621101000")
                .operatorId("CAJERO-001")
                .transactionCurrency("CRC")
                .transactionCurrencyIso("CRC")
                .customerIdPos("12456999")
                .build();

        CustomerDetails customerDetails = CustomerDetails.builder()
                .transaction(transaction)
                .addCustomerID("12456999")
                .addCustomerName("Gloria Estefan")
                .addCustomerTypeIdentification("CEDULA")
                .addCustomerPhone("+1 (305) 456-6546")
                .addCustomerAddress("Miami, FL")
                .build();

        RetailLine retailLine = RetailLine.builder()
                .addRetailLineItem(
                        RetailLineItem.builder()
                                .transaction(transaction)
                                .retailSequenceNumber("2")
                                .retailTypeCode("1022")
                                .itemIdQualifier("2")
                                .itemId("100000002")
                                .retailQuantity("3")
                                .salesUnitOfMeasure("ST")
                                .salesAmount("3000")
                                .normalSalesAmount("3000")
                                .itemIdEntryMethodCode("SCAN")
                                .actualUnitPrice("1000")
                                .units("3")
                                .build()
                ).addRetailLineItem(
                        RetailLineItem.builder()
                                .transaction(transaction)
                                .retailSequenceNumber("1")
                                .retailTypeCode("1021")
                                .itemIdQualifier("2")
                                .itemId("100000002")
                                .retailQuantity("2")
                                .salesUnitOfMeasure("ST")
                                .salesAmount("5650")
                                .normalSalesAmount("6000")
                                .itemIdEntryMethodCode("SCAN")
                                .actualUnitPrice("2500")
                                .units("2")
                                .priceTypeCode("05")
                                .build()
                )
                .build();


        LineDiscount lineDiscount = LineDiscount.builder()
                .addRetailLineItem(
                        LineDiscountItem.builder()
                                .transaction(transaction)
                                .retailSequenceNumber("1")
                                .discountSequenceNumber("1")
                                .discountTypeCode("ZDPO")
                                .reductionAmount("1000")
                                .build()
                )
                .build();

        LineTax lineTax = LineTax.builder()
                .addLineTaxItem(
                        LineTaxItem.builder()
                                .transaction(transaction)
                                .retailSequenceNumber("1")
                                .taxSequenceNumber("1")
                                .taxTypeCode("TXF1")
                                .taxAmount("650")
                                .taxClassification("6")
                                .build()
                ).addLineTaxItem(
                        LineTaxItem.builder()
                                .transaction(transaction)
                                .retailSequenceNumber("2")
                                .taxSequenceNumber("1")
                                .taxTypeCode("TXF1")
                                .taxAmount("0")
                                .taxClassification("0")
                                .build()
                )
                .build();

        XmlBody xmlBody = XmlBody.builder()
                .transaction(transaction)
                .customerDetails(customerDetails)
                .retailLine(retailLine)
                .lineDiscount(lineDiscount)
                .lineTax(lineTax)
                .build();


        JAXBContext jaxbContext = JAXBContext.newInstance(XmlBody.class);

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        StringWriter sw = new StringWriter();

        jaxbMarshaller.marshal(xmlBody, sw);

        String xmlString = sw.toString().replace(sw.toString().substring(0, 55), "");

        String parentString = Utils.getRoot();

        String result = parentString.replace("OBJECT", xmlString);

        log.info(result);
    }

}