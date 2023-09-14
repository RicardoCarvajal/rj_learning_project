package com.platzi.pizza.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filteSecurity(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.csrf().disable().authorizeHttpRequests().requestMatchers(HttpMethod.GET, "/api/pizzas/**")
				.hasAnyRole("ADMIN", "CAJERO").requestMatchers(HttpMethod.POST, "/api/pizzas/**").hasRole("ADMIN")
				.requestMatchers("/api/customers/**").hasAnyRole("ADMIN", "CAJERO").requestMatchers(HttpMethod.PUT)
				.hasRole("ADMIN").requestMatchers(HttpMethod.POST, "/api/orders/random").hasAuthority("random_order")
				.requestMatchers("/api/orders/**").hasRole("ADMIN").anyRequest().authenticated().and().httpBasic();

		return httpSecurity.build();

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService memoryUsers() {
		UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")
				.build();

		UserDetails cajero = User.builder().username("cajero").password(passwordEncoder().encode("cajero"))
				.roles("CAJERO").build();

		return new InMemoryUserDetailsManager(admin, cajero);
	}

}
