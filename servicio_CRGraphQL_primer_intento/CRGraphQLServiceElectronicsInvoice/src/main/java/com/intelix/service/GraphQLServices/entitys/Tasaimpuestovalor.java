/*******************************************************************************
 * © 2012 Global Retail Information Ltd.
 ******************************************************************************/
/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.intelix.service.GraphQLServices.entitys;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Esta clase representa la entidad de base de datos Tasaimpuestovalor, la cual guarda
 * informacion del impuesto que puede tener un articulo
 * 
 * @see Articulo
 * @see Transaccionarticulo
 * 
 * @author Ricardo J. Carvajal F.
 */
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class Tasaimpuestovalor {

    /**
     * id de la tasa de impuesto
     */
    @Id
    @Basic(optional = false)
    @Column(name = "ID",
            nullable = false)
    private Long id;

    /**
     * valor del porcentaje del impuesto {@link BigDecimal}
     */
    @Basic(optional = false)
    @Column(name = "TASA",
            nullable = false,
            precision = 13,
            scale = 2)
    private BigDecimal tasa;

}
