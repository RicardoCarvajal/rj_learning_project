package com.intelix.service.GraphQLServices.models;

import lombok.Builder;
import lombok.Value;

/**
 * Clase modelo para manejar o mapear el sucursal.graphqls
 * 
 * @see {@link http://localhost:8080/playground} cuando levanta la aplicación
 * 
 * @author Ricardo J. Carvajal F.
 */
@Value
@Builder
public class Sucursal {

    /**
     * Deberá de incorporar el código de / Sucursal / Agencia / Bodega según aplique,
     * donde el Contribuyente Emisor realiza la operación. Este código será informado
     * cuando la Administración Tributaria lo asigne, por el momento debera de colocar el
     * código interno que maneja el contribuyente; De no utilizar código para sucursal
     * agencia o bodega colocar en el campo: null.
     * 
     */
    private String codigo;

    /**
     * Deberá de incorporar el código del punto de venta del Contribuyente Emisor donde se
     * genera el DTE. Dicho código será informado cuando la Administración Tributaria lo
     * asigne.
     * 
     * Este código será informado cuando la Administración Tributaria lo asigne, por el
     * momento debera de colocar el código interno que maneja el contribuyente; De no
     * utilizar código punto de venta colocará en el campo: null.
     * 
     */
    private String puntoVenta;

    /**
     * Deberá de incorporar el Nombre de la Sucursal / Agencia / Bodega según aplique,
     * donde el Contribuyente Emisor realiza la operación. En caso de no generarlo desde
     * una sucursal agencia o bodega colocar en el campo: null.
     * 
     */
    private String nombre;

    /**
     * Debe de incorporar el número de teléfono de sucursal
     * 
     */
    private String telefono;

}
