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
 * Esta clase representa la entidad de base de datos Linea, la cual representa a una linea
 * de articulos para la venta
 * 
 * @see Articulo
 * 
 * @author Ricardo J. Carvajal F.
 */
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class Linea {

    /**
     * id de la linea
     */
    @Id
    @Basic(optional = false)
    @Column(name = "ID",
            nullable = false)
    private Long id;

    /**
     * codigo de la categoria de la linea
     */
    @Basic(optional = false)
    @Column(name = "CODIGO",
            nullable = false,
            length = 2)
    private String codigo;

    /**
     * nombre de la linea
     */
    @Basic(optional = false)
    @Column(name = "NOMBRE",
            nullable = false,
            length = 40)
    private String nombre;

}
