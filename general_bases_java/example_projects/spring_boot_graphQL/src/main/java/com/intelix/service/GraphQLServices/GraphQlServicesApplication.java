package com.intelix.service.GraphQLServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase de inicio de la aplicación
 * 
 * @author Ricardo J. Carvajal F.
 */
@SpringBootApplication
public class GraphQlServicesApplication {

    /**
     *
     * Metodo main de la clase principal la cual inicia la aplicación, usando el metodo
     * {@link SpringApplication#run(Class, String...)} de
     * org.springframework.boot.SpringApplication
     * 
     * @param args aunque recibe un argumento, la aplicacion no esta diseñada para reibir
     *        ningun parametro al inicio
     * 
     */
    public static void main(String[] args) {
        SpringApplication.run(GraphQlServicesApplication.class, args);
    }

}
