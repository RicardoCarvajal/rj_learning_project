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
 * Esta clase representa la entidad de base de datos el Usuario de una caja registradora
 * 
 * @author Ricardo J. Carvajal F.
 */
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class Usuario {

    /**
     * id del usuario
     */
    @Id
    @Basic(optional = false)
    @Column(name = "ID",
            nullable = false)
    private Long id;

    /**
     * ficha del usuario
     */
    @Basic(optional = false)
    @Column(name = "FICHA",
            nullable = false)
    private int ficha;

    /**
     * nombre del usuario
     */
    @Basic(optional = false)
    @Column(name = "NOMBRE",
            nullable = false,
            length = 30)
    private String nombre;

    /**
     * clave del usuario
     */
    @Basic(optional = false)
    @Column(name = "CLAVE",
            nullable = false,
            length = 32)
    private String clave;

    /**
     * codigo de barra del usuario
     */
    @Column(name = "CODIGO_BARRA",
            length = 32)
    private String codigoBarra;

}
