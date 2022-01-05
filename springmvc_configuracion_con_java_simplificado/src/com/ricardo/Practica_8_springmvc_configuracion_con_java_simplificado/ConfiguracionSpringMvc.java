package com.ricardo.Practica_8_springmvc_configuracion_con_java_simplificado;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = {"com.ricardo.Practica_8_springmvc_configuracion_con_java_simplificado"})
public class ConfiguracionSpringMvc {

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();

        resolver.setPrefix("/WEB-INF/jsp/");

        resolver.setSuffix(".jsp");

        return resolver;
    }

}
