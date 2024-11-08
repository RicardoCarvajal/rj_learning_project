package org.intelix.app.sap.model;

import javax.xml.bind.annotation.XmlElement;

public class ReturnTransactionItem {
    private String type = "";
    private String id = "";
    private String number = "";
    private String message = "";
    private String logNo = "";
    private String logMsgNo = "";
    private String messageV1 = "";
    private String messageV2 = "";
    private String messageV3 = "";
    private String messageV4 = "";
    private String parameter = "";
    private String row = "";
    private String field = "";
    private String system = "";

    public ReturnTransactionItem() {
    }

    @XmlElement(name = "TYPE")
    public String getType() {
        return type;
    }

    @XmlElement(name = "ID")
    public String getId() {
        return id;
    }

    @XmlElement(name = "NUMBER")
    public String getNumber() {
        return number;
    }

    @XmlElement(name = "MESSAGE")
    public String getMessage() {
        return message;
    }

    @XmlElement(name = "LOG_NO")
    public String getLogNo() {
        return logNo;
    }

    @XmlElement(name = "LOG_MSG_NO")
    public String getLogMsgNo() {
        return logMsgNo;
    }

    @XmlElement(name = "MESSAGE_V1")
    public String getMessageV1() {
        return messageV1;
    }

    @XmlElement(name = "MESSAGE_V2")
    public String getMessageV2() {
        return messageV2;
    }

    @XmlElement(name = "MESSAGE_V3")
    public String getMessageV3() {
        return messageV3;
    }

    @XmlElement(name = "MESSAGE_V4")
    public String getMessageV4() {
        return messageV4;
    }

    @XmlElement(name = "PARAMETER")
    public String getParameter() {
        return parameter;
    }

    @XmlElement(name = "ROW")
    public String getRow() {
        return row;
    }

    @XmlElement(name = "FIELD")
    public String getField() {
        return field;
    }

    @XmlElement(name = "SYSTEM")
    public String getSystem() {
        return system;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setLogNo(String logNo) {
        this.logNo = logNo;
    }

    public void setLogMsgNo(String logMsgNo) {
        this.logMsgNo = logMsgNo;
    }

    public void setMessageV1(String messageV1) {
        this.messageV1 = messageV1;
    }

    public void setMessageV2(String messageV2) {
        this.messageV2 = messageV2;
    }

    public void setMessageV3(String messageV3) {
        this.messageV3 = messageV3;
    }

    public void setMessageV4(String messageV4) {
        this.messageV4 = messageV4;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setSystem(String system) {
        this.system = system;
    }
}
