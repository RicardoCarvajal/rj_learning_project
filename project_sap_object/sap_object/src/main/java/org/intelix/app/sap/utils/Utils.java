package org.intelix.app.sap.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;


public class Utils {

    private static final Logger log = LoggerFactory.getLogger(Utils.class);

    public static String getRoot() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            File xmlTemplate = new File("/home/ricardo/workspace_learning/project_sap_object/sap_object/src/main/resources/request_part.xml");
            SAXReader reader = new SAXReader();
            Document document = reader.read(xmlTemplate);
            stringBuilder.append(document.asXML());
        } catch (DocumentException e) {
            log.info("Error en creacion de root xml {}", e.getMessage());
        }
        return stringBuilder.toString().replace(stringBuilder.substring(0, 38), "");

    }

}
