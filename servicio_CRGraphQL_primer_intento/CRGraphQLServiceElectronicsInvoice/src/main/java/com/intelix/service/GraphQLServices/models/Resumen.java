package com.intelix.service.GraphQLServices.models;

import java.math.BigDecimal;
import java.util.Set;

import com.intelix.service.GraphQLServices.entitys.Transaccionformadepago;

import lombok.Builder;
import lombok.Value;

/**
 * Clase modelo para manejar o mapear el resumen.graphqls
 * 
 * @see {@link http://localhost:8080/playground} cuando levanta la aplicación
 * 
 * @author Ricardo J. Carvajal F.
 */
@Value
@Builder
public class Resumen {

    /**
     * Deberá de contener la sumatoria de todas las operaciones no sujetas realizadas.
     * 
     */
    private BigDecimal totalNoSuj;

    /**
     * Deberá de contener la sumatoria de todas las operaciones exentas realizadas.
     * 
     */
    private BigDecimal totalExenta;

    /**
     * Deberá de contener la sumatoria de todas las operaciones gravadas realizadas.
     * 
     */
    private BigDecimal totalGravada;

    /**
     * Deberá contener la Sumatoria de todas las operaciones realizadas (Total de
     * operaciones No sujetas,Total de operaciones Exentas y Total de operaciones
     * Gravadas)
     * 
     */
    private BigDecimal subTotalVentas;

    /**
     * En este campo se indicará el monto de descuento, Bonificación, Rebajas, subsidio,
     * compensaciones, disminuciones y otros que el emisior realice al campo SUMA DE
     * OPERACIONES SIN IMPUESTOS (descuento global en monto al campo suma de operaciones
     * sin impuesto) (De no existir descuento aplicado por el Emisor, deberá colocar el
     * valor $0.0)
     * 
     */
    private BigDecimal descuento;

    /**
     * En este campo se indicará el Porcentaje de descuento, Bonificación, Rebajas,
     * subsidio, compensaciones, disminuciones y otros que el emisior realice al campo:
     * SUMA DE OPERACIONES SIN IMPUESTOS (descuento global en porcentaje al campo suma de
     * operaciones sin impuesto)
     * 
     */
    private BigDecimal porcentajeDescuento;

    /**
     * Debe contener el monto computado del Impuesto cuando no aplique a IVA debera
     * colocar $0.00
     * 
     */
    private BigDecimal totalIva;

    /**
     * Indica la Suma de: SUMATORIA DE OPERACIONES SIN IMPUESTOS - Monto de Descuento,
     * Bonificación, Rebajas, subsidio, compensaciones, disminuciones y otros al campo
     * SUMA DE OPERACIONES SIN IMPUESTOS + impuesto IVA
     * 
     */
    private BigDecimal subTotal;

    /**
     * cuando la operación este sujeta a percepcion, debe contener el monto de ajuste
     * computado del Impuesto percibido De no existir IVA PERCIBIDO debera completar campo
     * con $0.00
     * 
     */
    private BigDecimal ivaPerci1;

    /**
     * cuando la operación este sujeta a retención, debe contener el monto de ajuste
     * computado del Impuesto retenido De no existir IVA RETENIDO debera completar campo
     * con $0.00
     * 
     */
    private BigDecimal ivaRete1;

    /**
     * Debera contener el monto de la contribucion fovial cuando exista ventas de
     * Combustible. De no existir contribucion fovial debera completar campo con $0.00
     * 
     */
    private BigDecimal fovial;

    /**
     * Debera contener el monto de la contribucion COTRANS cuando exista ventas de
     * Combustible. De no existir contribucion COTRANS debera completar campo con $0.00
     * 
     */
    private BigDecimal cotrans;

    /**
     * Debera contener el monto de la contribución especial para la promición del t
     * turismo 5%, cuando se realizen servicios de alojamiento. De no existir contribucion
     * TURISMO debera completar campo con $0.00
     * 
     */
    private BigDecimal turismo;

    /**
     * Debera contener el total de ad- valorem por diferencial de precios resultantes de
     * calcular previamente por items diferecncial de precios al tabaco y alcohol campo
     * oculto
     * 
     */
    private BigDecimal adValorem;

    /**
     * Debera Indicar la Suma de los campos: SUB TOTAL + CONTRIBUCIONES
     * 
     */
    private BigDecimal montoTotalOperacion;

    /**
     * El contribuyente Emisor deberá de calcular el total de los créditos o pagos a favor
     * del receptor (resta) y/o los cargos o cobros efectuados al receptor (suma) que no
     * estén afectos a la base imponible.
     * 
     */
    private BigDecimal totalNoGravado;

    /**
     * Debera contener el valor total a pagar
     * 
     * Si se ha realizado percepción: Monto Total de la Operación + IVA Percibido + (TOTAL
     * OTROS CRÉDITOS O PAGOS A FAVOR DEL RECEPTOR / TOTAL OTROS CARGOS O COBROS AL
     * RECEPTOR QUE NO AFECTAN LA BASE IMPONIBLE)
     * 
     * Si se ha realizado Retención: Monto Total de la Operación - IVA Retenido + (TOTAL
     * OTROS CRÉDITOS O PAGOS A FAVOR DEL RECEPTOR / TOTAL OTROS CARGOS O COBROS AL
     * RECEPTOR QUE NO AFECTAN LA BASE IMPONIBLE)
     * 
     * Nota: Cuando el campo TOTAL OTROS CRÉDITOS O PAGOS A FAVOR DEL RECEPTOR, sea mayor
     * al resultado del campo MONTO TOTAL DE LA OPERACIÓN en el campo TOTAL A PAGAR deberá
     * colocarse $0.00
     * 
     */
    private BigDecimal totalPagar;

    /**
     * Deberá contener el valor total a pagar por el receptor en letras
     * 
     */
    private String totalLetras;

    /**
     * Indicará el Saldo a Favor cuando el contribuyente tenga otros creditos o pagos a
     * favor del receptor. Este se registra en monto negativo.
     * 
     */
    private BigDecimal saldoFavor;

    /**
     * Se debe indicar la Condición de la Operación (Ver catálogo condicion de la
     * operacion ) 1. Contado 2. a Crédito 3 otro Cuando el contribuyente receptor refleje
     * o posea saldo a favor debera seleccionar condición de la operación 1- contado.
     * 
     */
    private Integer condicionOperacion;

    /**
     * Campo destinado para indicar el Número de Pago Electrónico cuando exista (por
     * ejemplo el NPE)
     * 
     */
    private String numPagoElectronico;

    /**
     * Informacion de la forma de pago obtenido de la entidad transacción
     */
    private Set<Transaccionformadepago> formadepagoInfo;

}
