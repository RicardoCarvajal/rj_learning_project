package com.intelix.service.GraphQLServices.models;

import lombok.Builder;
import lombok.Value;

/**
 * Clase modelo para manejar o mapear el direccion.graphqls
 * 
 * @see {@link http://localhost:8080/playground} cuando levanta la aplicación
 * 
 * @author Ricardo J. Carvajal F.
 */
@Value
@Builder
public class Direccion {

    /**
     * Hace referencia a la dirección de la Casa Matriz, deberá indicar del catálogo , el
     * código de departamento en el cual se encuetra ubicada la Casa Matriz (ver catalogo
     * de codificación ¨Departamento¨)
     * 
     */
    private String departamento;

    /**
     * Deberá detallar el código de municipio de la dirección en la que se encuentra
     * ubicada la Casa Matriz (ver catalogo de codificación¨Municipio¨)
     * 
     */
    private String municipio;

    /**
     * Detallar el complemento de la dirección de la Casa Matriz (Por ejemplo, número de
     * casa, residencial, colonia, calle, etc. u otro dato con nomenclatura geográfica que
     * pueda identificar claramente su ubicación)
     * 
     */
    private String complemento;

}
