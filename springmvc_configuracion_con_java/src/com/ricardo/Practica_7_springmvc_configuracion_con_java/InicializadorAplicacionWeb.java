package com.ricardo.Practica_7_springmvc_configuracion_con_java;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class InicializadorAplicacionWeb implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext contenedor) throws ServletException {

        AnnotationConfigWebApplicationContext contextoAplicacio = new AnnotationConfigWebApplicationContext();

        contextoAplicacio.setConfigLocation("com.ricardo.Practica_7_springmvc_configuracion_con_java");

        ServletRegistration.Dynamic registro = contenedor.addServlet("practica_configuracion_anotaciones",
                                                                     new DispatcherServlet(contextoAplicacio));

        registro.setLoadOnStartup(1);

        registro.addMapping("*.do");

    }

}
