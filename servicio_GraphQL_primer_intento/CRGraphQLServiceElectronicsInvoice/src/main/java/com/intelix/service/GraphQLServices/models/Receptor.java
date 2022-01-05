package com.intelix.service.GraphQLServices.models;

import com.intelix.service.GraphQLServices.entitys.Cliente;

import lombok.Builder;
import lombok.Value;

/**
 * Clase modelo para manejar o mapear el receptor.graphqls
 * 
 * @see {@link http://localhost:8080/playground} cuando levanta la aplicación
 * 
 * @author Ricardo J. Carvajal F.
 */
@Value
@Builder
public class Receptor {

    /**
     * Deberá de contener el NIT del Receptor
     * 
     * @see Cliente#getNumeroIdentificacionCliente()
     * 
     */
    private String nit;

    /**
     * Deberá de contener el NRC del Receptor
     * 
     * @see Cliente#getNumeroIdentificacionTributario()
     */
    private String nrc;

    /**
     * Deberá contener el Nombre, denominación o razón social del contribuyente Receptor
     * 
     * @see Cliente#getNombre()
     */
    private String nombre;

    /**
     * Si el contribuyente Receptor cuenta con un Nombre Comercial se deberá de incorporar
     * dicho Nombre proporcionado por Contribuyente Receptor en este campo.
     * 
     */
    private String nombreComercial;

    /**
     * Deberá detallar la Categoria asignada por la Administración Tributaria al
     * Contribuyente Receptor Especificar el código de la Categoría de Contribuyente de
     * (ver catalogo de codificación Categoria de contribuyente) 1 - Grande 2 - Mediano 3
     * - Otro
     * 
     */
    private Integer categoria;

    /**
     * Debe de incorporar el número de teléfono asociado al receptor
     * 
     * @see Cliente#getTelefono()
     */
    private String telefono;

    /**
     * Deberá incorporar el correo electrónico con dominio vigente, del Contribuyente
     * receptor.
     *
     * @see Cliente#getCorreoElectronico()
     */
    private String correo;

    /**
     * Debera detallar la fecha de calificación como Sujeto Excluido de Renta si el
     * Receptor cuenta con dicha clasificación.
     * 
     * En caso de no ser sujeto excluido de renta debera colocar en el campo: null
     * 
     */
    private String fecSujExcl;

    /**
     * Deberá de contener el Número de Facturador Electrónico del Receptor, el cual será
     * entregado por la Administración Tributaria cuando el RECEPTOR se registre como
     * Facturador Electrónico para la emisión de Documentos Tibutarios Electrónicos.
     * 
     * Durante la transición este campo sera opcional.
     * 
     */
    private String numFacturador;

    /**
     * Entidad cliente donde se espera guardar cliente de la transacción
     */
    private Cliente cliente;

}
