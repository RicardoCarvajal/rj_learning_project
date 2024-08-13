package com.intelix.service.GraphQLServices.models;

import com.intelix.service.GraphQLServices.entitys.Transaccion;

import lombok.Builder;
import lombok.Value;

/**
 * Clase modelo para manejar o mapear el documento.graphqls
 * 
 * @see {@link http://localhost:8080/playground} cuando levanta la aplicación
 * 
 * @author Ricardo J. Carvajal F.
 */
@Builder
@Value
public class Documento {

    /**
     * id de la transacción a la cual pertenece el documento
     * 
     * @see Transaccion
     * 
     */
    private String id;

    /**
     * numero de la transacción a la cual pertenece el documento
     * 
     * @see Transaccion
     * 
     */
    private int numero;

    /**
     * este apartado debera llenarse si existiere doc. a relacionar de lo contrario esta
     * informacion se completara con null
     */
    private String documentoRelacionado;

    /**
     * VENTA A CUENTA DE TERCEROS ( este apartado debera llenarse la venta es a cuenta de
     * terceros de lo contrario esta infirmacion se completara con null )
     */
    private String ventaTercero;

    /**
     * Para informacion propia del emisor (donde aplique)
     * 
     */
    private String apendice;

    /**
     * este campo es usado para transmitir por los resolvers lo que ya se obtuvo de la
     * base de datos
     * 
     */
    private Transaccion parentTransaction;

}
