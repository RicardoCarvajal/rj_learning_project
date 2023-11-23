package com.intelix.sofka.app.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
public class PropertiesConf {

	@Value("${commission.atm.amount}")
	private String amountAtm;

	public String getAmountAtm() {
		return amountAtm;
	}

	public void setAmountAtm(String amountAtm) {
		this.amountAtm = amountAtm;
	}

}
