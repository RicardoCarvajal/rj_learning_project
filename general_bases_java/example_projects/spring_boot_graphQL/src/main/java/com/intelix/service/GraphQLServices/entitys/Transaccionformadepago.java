/*******************************************************************************
 * © 2012 Global Retail Information Ltd.
 ******************************************************************************/
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
 * Esta clase representa la entidad de base de datos Transaccionformadepago, que
 * representa las FDP en una {@link Transaccion}
 * 
 * @author Ricardo J. Carvajal F.
 */
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class Transaccionformadepago {

    /**
     * id de la forma de pago en una transaccion
     * 
     * @see Transaccion
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID",
            nullable = false)
    private Long id;

    /**
     * el consecutivo de la forma de pago en una transacción
     */
    @Basic(optional = false)
    @Column(name = "ITEM",
            nullable = false)
    private int item;

    /**
     * monto de la forma de pago para la transaccion en moneda local
     */
    @Basic(optional = false)
    @Column(name = "MONTO_MONEDA_LOCAL",
            nullable = false,
            precision = 13,
            scale = 2)
    private BigDecimal montoMonedaLocal;

    /**
     * monto de la forma de pago para la transacción
     */
    @Basic(optional = false)
    @Column(name = "MONTO_MONEDA",
            nullable = false,
            precision = 13,
            scale = 2)
    private BigDecimal montoMoneda;

    /**
     * información extra de la forma de pago
     */
    @Basic(optional = false)
    @Column(name = "DOCUMENTO",
            nullable = false,
            length = 20)
    private String documento;

    /**
     * información extra de la forma de pago
     */
    @Basic(optional = false)
    @Column(name = "CUENTA",
            nullable = false,
            length = 20)
    private String cuenta;

    /**
     * la transaccion que pertenece a la forma de pago
     * 
     * @see Transaccion
     */
    @Basic(optional = false)
    @Column(name = "ID_TRANSACCION",
            nullable = false)
    private String idTransaccion;

    /**
     * información general de la forma de pago
     * 
     * @see Formadepago
     */
    @JoinColumn(name = "ID_FORMADEPAGO",
                referencedColumnName = "ID",
                nullable = false)
    @ManyToOne(optional = false)
    private Formadepago idFormadepago;

}