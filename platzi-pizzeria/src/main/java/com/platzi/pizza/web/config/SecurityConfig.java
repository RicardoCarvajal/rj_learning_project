package com.platzi.pizza.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filteSecurity(HttpSecurity httpSecurity) throws Exception{
		
//		httpSecurity
//			.authorizeHttpRequests()
//			.anyRequest()
//			.permitAll();
		
		httpSecurity
		.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers(HttpMethod.GET,"/api/**")//con un solo * a un solo nivel despues de / si le pongo dos ** permite todos los niveles
		.permitAll()
		.requestMatchers(HttpMethod.PUT).denyAll()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
				
		return httpSecurity.build();
		
	}

}
