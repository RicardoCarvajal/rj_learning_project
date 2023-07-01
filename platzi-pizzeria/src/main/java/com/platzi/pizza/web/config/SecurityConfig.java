package com.platzi.pizza.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filteSecurity(HttpSecurity httpSecurity) throws Exception{
		
//		httpSecurity
//			.authorizeHttpRequests()
//			.anyRequest()
//			.permitAll();
// El codigo comentado arriba permite todo :-)
		
		httpSecurity
		.csrf().disable()
		.authorizeHttpRequests()
		//con un solo * a un solo nivel despues de / si le pongo dos ** permite todos los niveles
		//Con las dos lineas siguientes no necesitas roles y permites todo
        //		.requestMatchers(HttpMethod.GET,"/api/pizzas**")
        //		.permitAll()
		.requestMatchers(HttpMethod.GET,"/api/pizzas**")
		.hasAnyRole("ADMIN","CAJERO")
		.requestMatchers(HttpMethod.POST,"/api/pizzas**")
		.hasRole("ADMIN")
		.requestMatchers(HttpMethod.PUT).hasRole("ADMIN")
		.requestMatchers("/api/orders**").hasRole("ADMIN")//Permite todos los metodos
		//Con la linea siguiente deniegas todo
        //		.requestMatchers(HttpMethod.PUT).denyAll()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
				
		return httpSecurity.build();
		
	}
	
	@Bean
	public UserDetailsService memoryUsers() {
		UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build();
		
		UserDetails cajero = User.builder().username("cajero").password(passwordEncoder().encode("cajero")).roles("CAJERO").build();
		
		return new InMemoryUserDetailsManager(admin, cajero);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
