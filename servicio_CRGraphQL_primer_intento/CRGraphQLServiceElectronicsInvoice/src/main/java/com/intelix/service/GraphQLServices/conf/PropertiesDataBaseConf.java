package com.intelix.service.GraphQLServices.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * 
 * Clase que configura por inyeccion de dependencia
 * {@code @ConfigurationProperties(prefix = "options.id")} las propiedades de la
 * aplicación desde la base de datos en la tabla opción
 * 
 * @author Ricardo J. Carvajal F.
 *
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "options.id")
public class PropertiesDataBaseConf {

    /**
     * nombre de la tienda o sucursal
     */
    private Long namestore;

    /**
     * id del nit de epa
     */
    private Long epanit;

    /**
     * id del nrc de epa
     */
    private Long epanrc;

    /**
     * id del numero de facturacion para los documentos electronicos
     */
    private Long numberbiller;

    /**
     * id del email de la sucursal
     */
    private Long email;

    /**
     * id del telefono de epa
     */
    private Long phone;

    /**
     * id de la categoria de EPA
     */
    private Long category;

    /**
     * id del tipo de la institución
     */
    private Long typeInstitucion;

    /**
     * id del codigo de actividad economica de EPA
     */
    private Long activitiEpa;

    /**
     * id de la descripción de la actividad economica de EPA
     */
    private Long activitiEpaDesc;

    /**
     * id del codigo del municipio de epa
     */
    private Long municipalityCode;

    /**
     * id del codigo de departamento de epa
     */
    private Long departmentCode;

    /**
     * id de la tabla opcion donde esta la direccion de la tienda
     */
    private Long directionStore;

    /**
     * id de la tabla opcion donde esta la direccion de la central
     */
    private Long directionEpa;

    /**
     * id de la tabla opcion donde esta el codigo de municipio de la tienda
     */
    private Long municipalityCodeStore;

    /**
     * id de la tabla opcion donde esta el codigo de departamento de la tienda
     */
    private Long departmentCodeStore;

    /**
     * id de la tabla opcion donde esta el numero de la tienda
     */
    private Long numberStore;
}
