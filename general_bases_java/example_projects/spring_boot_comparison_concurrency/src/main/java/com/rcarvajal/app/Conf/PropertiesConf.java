package com.rcarvajal.app.Conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesConf {

    @Value("${webclient.api.soap.url}")
    private String URL;
    @Value("${webclient.api.soap.token}")
    private String TOKEN;
    @Value("${webclient.api.soap.action}")
    private String ACTION;


    public String getURL() {
        return URL;
    }

    public String getTOKEN() {
        return TOKEN;
    }

    public String getACTION() {
        return ACTION;
    }
    
}
