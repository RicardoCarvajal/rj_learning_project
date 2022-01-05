package com.ricardo.oprracion.jpa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.ricardo.configspring.ConfiguracionAccesoBaseDatos;
import com.ricardo.repositorio.RepositorioCajas;

public class opJpaSpring {

    public static void main(String[] args) {

        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(
                ConfiguracionAccesoBaseDatos.class);

        RepositorioCajas caja = ctx.getBean(RepositorioCajas.class);

        caja.findAll().forEach(System.out::println);

    }

}
