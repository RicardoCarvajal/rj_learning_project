package com.intelix.service.GraphQLServices.models;

import lombok.Builder;
import lombok.Value;

/**
 * Clase modelo para manejar o mapear el emisor.graphqls
 * 
 * @see {@link http://localhost:8080/playground} cuando levanta la aplicación
 * 
 * @author Ricardo J. Carvajal F.
 */
@Value
@Builder
public class Emisor {

    /**
     * Deberá de contener el Número de NIT del Emisor
     * 
     */
    private String nit;

    /**
     * Deberá de contener el Número de NRC del Emisor
     * 
     */
    private String nrc;

    /**
     * Deberá de contener el Número de Facturador Electrónico del Emisor, el cual será
     * entregado por la Administración Tributaria cuando el emisor se registre como
     * Facturador Electrónico para la emisión de Documentos Tibutarios Electrónicos.
     * 
     */
    private String numFacturador;

    /**
     * Deberá contener el Nombre, denominación o razón social del contribuyente Emisor,
     * tal cual aparezca en la última Tarjeta de NRC
     * 
     */
    private String nombre;

    /**
     * Deberá de incorporar el Nombre Comercial del Contribuyente Emisor donde se genera
     * la operación.
     * 
     */
    private String nombreComercial;

    /**
     * Deberá de incorporar el tipo de Establecimiento en el que se emite el DTE (Matriz,
     * Sucursal/Agencia o Bodega), 1 - Casa Matriz 2 - Sucursal / Agencia 3 - Bodega 4 -
     * Otro
     * 
     * Si la operación se esta realizando desde Casa Matriz no será necerio establecer
     * nuevamente la dirección y si la Opreación se realiza desde Sucursal / Agencia o
     * Bodega, deberá especificarse a continuación la dirección correspondiente a esta.
     * 
     */
    private Integer tipoEstablecimiento;

    /**
     * Debe de incorporar el número de teléfono de Casa Matriz
     * 
     */
    private String telefono;

    /**
     * Deberá incorporar el correo electrónico con dominio vigente, del Contribuyente
     * (Casa Matriz)
     * 
     */
    private String correo;

    /**
     * Deberá contener la Categoria asignada por la Administración Tributaria al
     * Contribuyente Emisor Especificar el código de la Categoría de Contribuyente 1 -
     * Grande 2 - Mediano 3 - Otro
     * 
     */
    private Integer categoria;

    /**
     * caja desde donde se hizo la transacción del emisor
     */
    private String caja;

    /**
     * Este campo aplicara si el emisor fuera del ramo medico, pero para epa esto no
     * aplica. Sin embargo, de igual forma debe estar en el schema
     */
    private String medico;

    /**
     * Debera detallar la fecha de calificación como Sujeto Excluido de Renta si el emisor
     * cuenta con dicha clasificación.
     * 
     * en caso de no ser sujeto excluido de renta debera colocar en el campo: null
     * 
     */
    private String fecSujExcl;

    /**
     * Deberá colocar el número de la carta de venta en caso de existir una venta de
     * animales bovinos y equinos
     * 
     * En caso que el modelo de negocio no lo requiera debera colocar en el campo: null
     * 
     */
    private String cartaVenta;

}
