package com.rcarvajal.app.function.util;

import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Component;

import java.io.File;

@Slf4j
@Component
public class Utils {

    public String convertXMLtoString() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            File xmlFile = new File("src/main/resources/request_complete.xml");
            SAXReader reader = new SAXReader();
            Document document = reader.read(xmlFile);
            stringBuilder.append(document.asXML());
        } catch (DocumentException e) {
            log.error(e.getMessage());
            log.error("No se pudo generar el xml");
        }
        return stringBuilder.toString();
    }

}
