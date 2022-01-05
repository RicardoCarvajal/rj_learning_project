/*******************************************************************************
 * © 2012 Global Retail Information Ltd.
 ******************************************************************************/
/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.intelix.service.GraphQLServices.entitys;

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
 * Esta clase representa la entidad de base de datos Unidadventa
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
public class Unidadventa {

    /**
     * id de la unidad de venta
     */
    @Id
    @Basic(optional = false)
    @Column(name = "ID",
            nullable = false)
    private Long id;

    /**
     * nombre de la unidad de venta
     */
    @Basic(optional = false)
    @Column(name = "NOMBRE",
            nullable = false,
            length = 20)
    private String nombre;

    /**
     * simbolo de la unidad de medida
     */
    @Basic(optional = false)
    @Column(name = "SIMBOLO",
            nullable = false,
            length = 4)
    private String simbolo;

    /**
     * indica si la unidad de medida se puede fraccionar
     */
    @Basic(optional = false)
    @Column(name = "ESFRACCION",
            nullable = false)
    private char esfraccion;

}
