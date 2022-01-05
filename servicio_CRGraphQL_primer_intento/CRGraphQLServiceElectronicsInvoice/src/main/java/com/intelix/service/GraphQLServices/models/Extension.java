package com.intelix.service.GraphQLServices.models;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Value;

/**
 * Clase modelo para manejar o mapear el extension.graphqls
 * 
 * @see {@link http://localhost:8080/playground} cuando levanta la aplicación
 * 
 * @author Ricardo J. Carvajal F.
 */
@Value
@Builder
public class Extension {

    /**
     * Deberá contener la suma total de las cantidades de bienes o servicios realizados
     * 
     */
    private BigDecimal totalItems;

    /**
     * Debe contener la Sumatoria de los campos: Descuento, Bonificación, Rebajas por item
     * o línea de operación + Monto de Descuento, Bonificación, Rebajas, subsidio,
     * compensaciones, disminuciones y otros a la suma de operaciones sin impuestos.
     * 
     * A efecto de mostrar la sumatoria total de descuento tanto de Item como global
     * 
     */
    private BigDecimal totalDescu;

    /**
     * Deberá colocar el nombre de la persona que genera y entrega el DTE, estos datos son
     * requisitos de Ley para cuando el "Total de la Operación" es igual o mayor
     * $11,428.57
     * 
     */
    private String nombEntrega;

    /**
     * Debera completar documento de identificaion de quien genera el DTE si Total de la
     * Operación es igual o mayor $11,428.57
     * 
     */
    private String docuEntrega;

    /**
     * Deberá indicar el código del empleado que genera el documento, si el emisor cuenta
     * con esta codificación
     * 
     */
    private String codEmpleado;

    /**
     * Colocar el nombre de la persona encargada del área de recepción de los DTE por
     * parte del receptor o persona designada por el receptor, ya que estos datos son
     * requisitos de Ley para cuando el "Total de la Operación " es igual o mayor
     * $11,428.57
     * 
     */
    private String nombRecibe;

    /**
     * Debera completar documento de identificaion del responsable si ¨Total de la
     * Operación¨ es igual o mayor $11,428.57
     * 
     */
    private String docuRecibe;

    /**
     * Queda a disposición de cualquier otra observación que el emisor desee colocar
     */
    private String observaciones;

    /**
     * Deberá colocar el número de placa del Vehículo del receptor. Aplica para aquellos
     * contribuyentes emisores que se dediquen a Venta de combustibles, lubricantes y
     * otros (Gasolineras)
     */
    private String placaVehiculo;

    /**
     * Autorización de los certificados Fito sanitarios y zoosanitarios para el comercio
     * de productos y subproductos de origen vegetal y animal
     * 
     * Este aplica para el emisor del docuemento segun modelo de negocio.
     */
    private String autoFitoSanitaria;

}
