package com.danzaseimily.app.service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;


@EnableReactiveMongoAuditing
@OpenAPIDefinition(info = @Info(title = "MsRegistrationApplication"))//http://<server>:<port>/swagger-ui.html
@SpringBootApplication
public class MsRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsRegistrationApplication.class, args);
	}

}
