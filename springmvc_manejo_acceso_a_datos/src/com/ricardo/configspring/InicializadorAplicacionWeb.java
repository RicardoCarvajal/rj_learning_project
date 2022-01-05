package com.ricardo.configspring;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class InicializadorAplicacionWeb extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {ConfiguracionSpringMvc.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"*.do"};
    }

}
