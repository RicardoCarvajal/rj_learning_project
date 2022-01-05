package com.intelix.service.GraphQLServices.entitys;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Esta clase representa la entidad de base de datos Transaccionarticulo, que representa
 * el articulo en una {@link Transaccion}
 * 
 * @author Ricardo J. Carvajal F.
 */
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class Transaccionarticulo {

    /**
     * id del articulo de la transacción
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID",
            nullable = false)
    private Long id;

    /**
     * cantidad facturada para el articulo
     */
    @Basic(optional = false)
    @Column(name = "CANTIDAD",
            nullable = false,
            precision = 13,
            scale = 2)
    private BigDecimal cantidad;

    /**
     * monto unitario del articulo sin impuesto ni rebaja
     */
    @Basic(optional = false)
    @Column(name = "MONTO_UNITARIO",
            nullable = false,
            precision = 13,
            scale = 2)
    private BigDecimal montoUnitario;

    /**
     * monto base del articulo que es el monto unitario mas la rebaja
     */
    @Basic(optional = false)
    @Column(name = "MONTO_BASE",
            nullable = false,
            precision = 13,
            scale = 2)
    private BigDecimal montoBase;

    /**
     * impuesto unitario del articulo
     */
    @Basic(optional = false)
    @Column(name = "MONTO_IMPUESTO",
            nullable = false,
            precision = 13,
            scale = 2)
    private BigDecimal montoImpuesto;

    /**
     * es el monto base multiplicado por la cantidad
     */
    @Basic(optional = false)
    @Column(name = "TOTAL_BASE",
            nullable = false,
            precision = 13,
            scale = 2)
    private BigDecimal totalBase;

    /**
     * es el monto impuesto multiplicado por la cantidad
     */
    @Basic(optional = false)
    @Column(name = "TOTAL_IMPUESTO",
            nullable = false,
            precision = 13,
            scale = 2)
    private BigDecimal totalImpuesto;

    /**
     * es el total base mas el total impuesto
     */
    @Basic(optional = false)
    @Column(name = "TOTAL_ARTICULO",
            nullable = false,
            precision = 13,
            scale = 2)
    private BigDecimal totalArticulo;

    /**
     * es el total de la rebaja de un articulo
     */
    @Basic(optional = false)
    @Column(name = "TOTAL_REBAJA",
            nullable = false,
            precision = 13,
            scale = 2)
    private BigDecimal totalRebaja;

    /**
     * id de la transaccion a la cual pertenece el articulo
     */
    @Basic(optional = false)
    @Column(name = "ID_TRANSACCION",
            nullable = false)
    private String idTransaccion;

    /**
     * idArticulo es la informacion general de un articulo de una transacció
     * 
     * @see Articulo
     */
    @JoinColumn(name = "ID_ARTICULO",
                referencedColumnName = "ID",
                nullable = false)
    @ManyToOne(optional = false)
    private Articulo idArticulo;

    /**
     * si el cliente de una transacción esta marcado con percepcion 'S' y la aplica en la
     * transacción se marcan los articulos en este campo con 'S', solo si el articulo no
     * es de servicio o exento
     */
    @Basic(optional = false)
    @Column(name = "PERCEPCION",
            nullable = false)
    private String percepcion;

    /**
     * monto unitario de la percepcion para el articulo
     */
    @Basic(optional = false)
    @Column(name = "MONTO_PERCEPCION",
            nullable = false,
            precision = 13,
            scale = 5)
    private BigDecimal montoPercepcion;

    /**
     * es el monto percepcion multiplicado por la cantidad
     */
    @Basic(optional = false)
    @Column(name = "TOTAL_PERCEPCION",
            nullable = false,
            precision = 13,
            scale = 5)
    private BigDecimal totalPercepcion;

    /**
     * este campo guarda la información de la unidad de venta de un articulo
     * 
     * @see Unidadventa
     */
    @JoinColumn(name = "ID_UNIDADVENTA",
                referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Unidadventa idUnidadventa;

    /**
     * este campo guarda la informacion del impuesto de un articulo de una transacción
     * 
     * @see Tasaimpuestovalor
     */
    @JoinColumn(name = "ID_TASAIMPUESTOVALOR",
                referencedColumnName = "ID",
                nullable = false)
    @ManyToOne(optional = false)
    private Tasaimpuestovalor idTasaimpuestovalor;

}
