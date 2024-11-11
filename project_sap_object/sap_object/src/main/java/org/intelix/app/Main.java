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

        XmlBody xmlBody = new XmlBody();

        Transaction transaction = Transaction.builder().retailStoreId("CR02")
                .businessDayDate("2024-06-21")
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

        xmlBody.setTransaction(transaction);
        xmlBody.setCustomerDetails(customerDetails);

        RetailLineItem retailLineItemOne = getRetailLineItemOne();
        RetailLineItem retailLineItemTwo = getRetailLineItemTwo();

        xmlBody.getRetailLine().getRetailLineItem().add(retailLineItemOne);
        xmlBody.getRetailLine().getRetailLineItem().add(retailLineItemTwo);

        JAXBContext jaxbContext = JAXBContext.newInstance(XmlBody.class);

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        StringWriter sw = new StringWriter();

        jaxbMarshaller.marshal(xmlBody, sw);

        String xmlString = sw.toString().replace(sw.toString().substring(0, 55), "");

        String parentString = Utils.getRoot();

        String result = parentString.replace("OBJECT", xmlString);

        log.info(result);
    }

    private static RetailLineItem getRetailLineItemTwo() {
        RetailLineItem retailLineItemTwo = new RetailLineItem();
        retailLineItemTwo.setRetailStoreId("CR02");
        retailLineItemTwo.setBusinessDayDate("2024-06-21");
        retailLineItemTwo.setTransactionTypeCode("1001");
        retailLineItemTwo.setWorkstationId("10");
        retailLineItemTwo.setTransactionSequenceNumber("301");
        retailLineItemTwo.setRetailSequenceNumber("2");
        retailLineItemTwo.setRetailTypeCode("1022");
        retailLineItemTwo.setItemIdQualifier("2");
        retailLineItemTwo.setItemId("100000002");
        retailLineItemTwo.setRetailQuantity("3");
        retailLineItemTwo.setSalesUnitOfMeasure("ST");
        retailLineItemTwo.setSalesAmount("3000");
        retailLineItemTwo.setNormalSalesAmount("3000");
        retailLineItemTwo.setItemIdEntryMethodCode("SCAN");
        retailLineItemTwo.setActualUnitPrice("1000");
        retailLineItemTwo.setUnits("3");
        return retailLineItemTwo;
    }

    private static RetailLineItem getRetailLineItemOne() {
        RetailLineItem retailLineItemOne = new RetailLineItem();
        retailLineItemOne.setRetailStoreId("CR02");
        retailLineItemOne.setBusinessDayDate("2024-06-21");
        retailLineItemOne.setTransactionTypeCode("1001");
        retailLineItemOne.setWorkstationId("10");
        retailLineItemOne.setTransactionSequenceNumber("301");
        retailLineItemOne.setRetailSequenceNumber("1");
        retailLineItemOne.setRetailTypeCode("1021");
        retailLineItemOne.setItemIdQualifier("2");
        retailLineItemOne.setItemId("100000002");
        retailLineItemOne.setRetailQuantity("2");
        retailLineItemOne.setSalesUnitOfMeasure("ST");
        retailLineItemOne.setSalesAmount("5650");
        retailLineItemOne.setNormalSalesAmount("6000");
        retailLineItemOne.setItemIdEntryMethodCode("SCAN");
        retailLineItemOne.setActualUnitPrice("2500");
        retailLineItemOne.setUnits("2");
        retailLineItemOne.setPriceTypeCode("05");
        return retailLineItemOne;
    }

    private static CustomerDetailsItem getCustomerDetailsItem(String NOMBRE, String Gloria_Estefan) {
        CustomerDetailsItem customerDetailsItemOne = new CustomerDetailsItem();

        customerDetailsItemOne.setRetailStoreId("CR02");
        customerDetailsItemOne.setBusinessDayDate("2024-06-21");
        customerDetailsItemOne.setTransactionTypeCode("1001");
        customerDetailsItemOne.setWorkstationId("10");
        customerDetailsItemOne.setTransactionSequenceNumber("301");
        customerDetailsItemOne.setCustomerInformationTypeCode("BAS");
        customerDetailsItemOne.setDataElementId(NOMBRE);
        customerDetailsItemOne.setDataElementValue(Gloria_Estefan);
        return customerDetailsItemOne;
    }


}