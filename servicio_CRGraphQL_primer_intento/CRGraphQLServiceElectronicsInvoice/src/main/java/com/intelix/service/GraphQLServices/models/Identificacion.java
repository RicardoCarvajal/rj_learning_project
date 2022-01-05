package com.intelix.service.GraphQLServices.models;

import com.intelix.service.GraphQLServices.entitys.Transaccion;

import lombok.Builder;
import lombok.Value;

/**
 * Clase modelo para manejar o mapear el identificacion.graphqls
 * 
 * @see {@link http://localhost:8080/playground} cuando levanta la aplicación
 * 
 * @author Ricardo J. Carvajal F.
 */
@Value
@Builder
public class Identificacion {

    /**
     * Se deberá colocar el número de la versión del Archivo JSON que se esta trabajando,
     * la cual debe asegurarse que sea la última versión vigente. Para la presente
     * version, se debe de enviar este campo con valor 2.
     * 
     */
    private Integer version;

    /**
     * Colocar el ambiente de trabajo por el cual se esta transmitiendo el Documento
     * Electrónico
     * 
     * Entiendase este ambiente de trabajo los siguientes : 00 - Modo Pruebas 01 - Modo
     * Producción
     * 
     */
    private String ambiente;

    /**
     * Se deberá colocar el código según el tipo del DTE a emitir, de acuerdo a tabla En
     * este caso Comprobante de Credito Fiscal con Código 01
     * 
     */
    private String tipoDte;

    /**
     * Debe mostrar código : 1 - Modelo de facturación Previo 2 - Modelo de facturación
     * Diferido
     * 
     */
    private Integer tipoModelo;

    /**
     * Debe contener código acuerdo al catálogo tipo de transmisión 1 - Normal 2 -
     * Contingencia
     * 
     * En Transmisión Normal solo permitirá Modelo de Facturación Previo
     * 
     * En tipo de transmisión por contingencia solo se permitirá con modelo de facturación
     * diferida.
     * 
     */
    private Integer tipoOperacion;

    /**
     * Por defecto será USD
     * 
     */
    private String tipoMoneda;

    /**
     * Debe cumplir con la estructura definida por la AT una longitud de 28 caracteres
     * (las siglas DTE + código de tipo de documento + código punto de venta y código de
     * casa matriz o sucursal + 15 dígitos. En el componente tres de la estructura deberá
     * contener en los últimos 3 dígitos el cód. de casa matriz o sucursal registrado y
     * activo
     * 
     * Ejemplo DTE-01-00123-000000000000001
     * 
     */
    private String numeroControl;

    /**
     * Debe cumplir con el estándar del UUID v4, el cual Debe ser único por documento (el
     * cual no debe repetirse) longitud de 32 dígitos sin guiones código de generación
     * consiste en un número identificador único, aleatorio y universal .
     * 
     */
    private String codigoGeneracion;

    /**
     * La Fecha de Generación del documento deberá tomarse del sistema del Contribuyente
     * emisor en el momento de generar el Documento, cuya Estructura definida por la
     * Administración Tributaria es: YYYY-MM-DD (2020-06-27)
     *
     * @see Transaccion#getFecha()
     */
    private String fecEmi;

    /**
     * La Hora de Generación del documento deberá tomarse del sistema del Contribuyente
     * emisor en el momento de generar el Documento, cuya Estructura definida por la
     * Administración Tributaria es: HH:MM:SS (15:58:30)
     * 
     * @see Transaccion#getHora()
     */
    private String horEmi;

    /**
     * Deberá completarse este campo únicamente si se elige el tipo de transmisión
     * 2-contingencia
     * 
     * Debe contener código de acuerdo a codificación según catálogo tipo de contingencia.
     * 1 - No disponibilidad de Sistema del MH 2 - No disponibilidad de Sistema del Emisor
     * 3 - Falla en el suministro de Servicio de Internet del Emisor 4 - Falla en el
     * suministro de Servicio de Energía Eléctrica del Emisor 5 - Otro
     * 
     */
    private Integer tipoContingencia;

    /**
     * 
     * Campo de texto para que contribuyente pueda ampliar sobre el motivo de
     * contingencia. Requerido sí el tipo de contingencia seleccionado es opción 5. (otro
     * motivo en tipo de contingencia)
     * 
     * 
     */
    private String motivoContin;

}
