package com.intelix.service.GraphQLServices.models;

import java.math.BigDecimal;
import java.util.List;

import lombok.Builder;
import lombok.Value;

/**
 * Clase modelo para manejar o mapear el cuerpodocumento.graphqls
 * 
 * @see {@link http://localhost:8080/playground} cuando levanta la aplicación
 * 
 * @author Ricardo J. Carvajal F.
 */
@Value
@Builder
public class CuerpoDocumento {

    /**
     * En este campo se hará referencia a las filas de los items por cada Bien o Servicio
     * vendido, por lo que deberá contener una numeración secuencial iniciando en 1 al "n"
     * (con un máximo de 2000 items).
     * 
     */
    private Integer numItem;

    /**
     * Deberá indicar si es un bien o servicio el que se esta realizando, detallar por
     * item en el cuerpo del Documento. 1 - Bienes 2 - Servicio 3 - Ambos (Bien y
     * Servicio, incluye los dos inherente al Producto o servicio)
     * 
     */
    private Integer tipoItem;

    /**
     * Si el Emisor cuenta con una codificación para los productos o servicios que brinda,
     * este campo debera de contener la codificación con que se identifica el Producto o
     * Servicio, por item. Si el Emisor no cuenta con dicha codificación el campo deberá
     * ser enviado con null.
     * 
     */
    private String codigo;

    /**
     * Deberá contener la descripción que detalle el producto o servicio que se brinda,
     * por item
     * 
     */
    private String descripcion;

    /**
     * Debera indicar la cantidad del mismo Producto o Servicio que detalla por item
     * 
     */
    private BigDecimal cantidad;

    /**
     * Deberá detallar el codigo de la unidad de medida que utiliza para la descripción
     * del producto por item
     * 
     * Para el caso que el contribuyente preste un servicio la unidad de medida a
     * seleccionar será: "99 - OTRA".
     * 
     */
    private Integer uniMedida;

    /**
     * Deberá indicar el Precio unitario de cada Producto o Servicio que se brinda, por
     * item
     * 
     */
    private BigDecimal precioUni;

    /**
     * En este campo se detallará, los Descuentos, Bonificación o Rebajas realizados a los
     * productos o servicios por Item cuando el emisor tenga a disposición ciertos
     * productos o servicios con Descuentos, Bonificaciones o Rebajas.
     * 
     */
    private BigDecimal montoDescu;

    /**
     * Se deberá indicar en este campo las ventas realizadas que cumplan con las
     * características de ser No Sujetas. Debera detallar el valor de las Venta no sujeta
     * de la Operación. (Si no existen ventas no sujetas en el campo deberá colocar $0.0)
     * 
     */
    private BigDecimal ventaNoSuj;

    /**
     * Se deberá indicar en este campo las ventas realizadas que cumplan con las
     * características de ser Exentas. Debera detallar el valor de las Ventas Exentas de
     * la Operación. (Si no existen ventas exentas en el campo deberá colocar $0.0)
     * 
     */
    private BigDecimal ventaExenta;

    /**
     * Se deberá indicar en este campo las ventas realizadas que cumplan con las
     * características de ser gravadas. Debera detallar el valor de las Ventas Gravadas de
     * la Operación (Si no existen gravadas en el campo deberá colocar $0.0)
     * 
     */
    private BigDecimal ventaGravada;

    /**
     * a) Otros créditos o pagos a favor del receptor que no afectan la base imponible: El
     * contribuyente Emisor podrá acreditar saldos o montos a favor del contribuyente
     * receptor que no estén afectos a la base imponible. El contribuyente incorporará el
     * valor del saldo o monto con signo negativo.
     * 
     * b) Otros cargos o cobros al receptor que no afectan la base imponible: El
     * contribuyente Emisor podrá cargar o cobrar saldos o montos al contribuyente
     * receptor que no estén afectos a la base imponible. El contribuyente incorporará el
     * valor del saldo o monto con signo positivo. Si este campo no es utilizado por el
     * contribuyente, deberia de enviar el valor con null
     * 
     */
    private BigDecimal noGravado;

    /**
     * En este campo se deberá indicar el código de los tributos que apliquen al producto
     * o servicio detallado por item (Ver catálogo: código de tributo)
     * 
     * cuando en el documento existan ventas gravadas el campo Debe contener por lo menos
     * un código de tributo.
     * 
     * cuando aplique más de un código de tributo este Deberá colocarse entre corchetes y
     * separarse por comas
     * 
     * ejemplo: [1,12]
     * 
     * Se validara campo null (cuando por naturaleza de la operación no lo requiera Ej.:
     * ventas no sujetas, ventas exentas, ventas gravadas a cero).
     * 
     */
    private List<Integer> tributos;

    /**
     * Deberá contener los Precios Sugeridos de venta según aplique para los productos de
     * Tabaco o Alcohol, de acuerdo a lo informado a la Administración Tributaria en los
     * formularios respectivos, los cuales deberan detallarse por item.
     * 
     * Nota: Este campo No debe ser visible en la representación gráfica que se entregue a
     * los receptores
     * 
     */
    private Integer psv;

    /**
     * Debera contener el monto de diferencial de precios de los producto, detallados por
     * item al tabaco y alcohol, el cual estara dado por la diferencia entre el precio de
     * venta y el precio sujerido de venta del producto.
     * 
     * Nota: Este campo No debe ser visible en la representación gráfica que se entregue a
     * los receptores
     * 
     */
    private Integer diferencial;

}
