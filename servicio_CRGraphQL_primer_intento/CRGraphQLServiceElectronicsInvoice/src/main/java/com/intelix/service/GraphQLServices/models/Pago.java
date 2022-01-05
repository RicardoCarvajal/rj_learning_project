package com.intelix.service.GraphQLServices.models;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Value;

/**
 * Clase modelo para manejar o mapear el pago.graphqls
 * 
 * @see {@link http://localhost:8080/playground} cuando levanta la aplicación
 * 
 * @author Ricardo J. Carvajal F.
 */
@Value
@Builder
public class Pago {

    /**
     * Seleccionar modalidad de pago. (ver catalogo forma de pago ) NOTA: podrá
     * seleccionar todas las Formas de Pago necesarias.
     * 
     * Cuando el contribuyente receptor refleje o posea saldo a favor debera seleccionar
     * CÓDIGO DE FORMA DE PAGO 99- otros.
     * 
     */
    private String codigo;

    /**
     * Debera contener la Descripción de las distintas Forma de pago utilizadas de acuerdo
     * al código seleccionado de catalogo de codificación en el campo anterior. (ver
     * catalogo forma de pago )
     * 
     * Cuando el contribuyente receptor refleje o posea saldo a favor debera seleccionar
     * CÓDIGO DE FORMA DE PAGO 99- otros.
     * 
     */
    private String descripcion;

    /**
     * Debera contener el número de referencia cada modalidad de pago detallada a
     * excepción de la modalidad de pago "Efectivo" (ejemplo: Número de Cheque,
     * transferencia bancaria, etc.)
     * 
     */
    private String referencia;

    /**
     * Si la venta es al Crédito, en este campo se deberá de colocar el número de días,
     * meses o años en que se otorga el plazo (Ejemplo: si el plazo es 6 meses, en este
     * campo se deberá colocar únicamente el número 6)
     * 
     */
    private BigDecimal periodo[];

    /**
     * Este campo se habilitara si en el campo Condiciones de la Operación se selecciona
     * la opcion 02 - Crédito, deberá contener el tiempo del plazo otorgado expresado de
     * acuerdo al código según tabla(ver catalogo de codificación: Plazo) 01 - días 02 -
     * meses 03 - años (Continuando con el ejemplo: si el plazo es en meses, en este campo
     * se deberá colocar el código "02", para hacer relación a meses)
     * 
     */
    private BigDecimal plazo[];

}
