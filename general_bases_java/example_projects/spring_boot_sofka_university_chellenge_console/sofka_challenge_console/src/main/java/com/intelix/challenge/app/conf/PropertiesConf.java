package com.intelix.challenge.app.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "consoleapp.option")
public class PropertiesConf {
	private int type;
}
