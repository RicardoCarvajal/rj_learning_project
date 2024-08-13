package com.intelix.service.GraphQLServices.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * 
 * Clase que configura por inyeccion de dependencia
 * {@code @ConfigurationProperties(prefix = "services.properties")} las propiedades de la
 * aplicación desde el application.yml
 * 
 * @author Ricardo J. Carvajal F.
 *
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "services.properties")
public class PropertiesConf {

    /**
     * version numero de la version de factura electronica para EPA SV
     */
    private Integer version;

    /**
     * env codigo del ambien para el envio del documento a la API de factura electronica
     * de hacienda, si es un ambiente de prueba 00 si es un ambiente productivo 01
     */
    private String env;

    /**
     * money siglas de la moneda usada para enviar a la API de factura electronica de
     * hacienda
     */
    private String money;

    /**
     * Debe mostrar código asignado en catálogo de codificación: 1 - Modelo de facturación
     * Previo 2 - Modelo de facturación Diferido
     * 
     */
    private Integer modeltype;

    /**
     * Debe contener código acuerdo al catálogo tipo de transmisión: 1 - Normal 2 -
     * Contingencia
     * 
     * En Transmisión Normal solo permitirá Modelo de Facturación Previo
     * 
     * En tipo de transmisión por contingencia solo se permitirá con modelo de facturación
     * diferida.
     */
    private Integer modeloperation;

    /**
     * Id de la forma de pago retencion en la base de datos, tabla formadepago
     */
    private Long retentionPay;

    /**
     * Monto con el cual se hace las validaciondes para crear la extencion del documento
     * de F.E.
     */
    private Double amountExtension;

}
