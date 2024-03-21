/*******************************************************************************
 * © 2012 Global Retail Information Ltd.
 ******************************************************************************/
/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.intelix.service.GraphQLServices.entitys;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Esta clase representa la entidad de base de datos Sesion, la cual representa la sesion
 * que inicio y termino un cajero en la aplicación de una caja registradora
 * 
 * @see Transaccion
 * 
 * @author Ricardo J. Carvajal F.
 */
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class Sesion {

    /**
     * id de la sesion
     */
    @Id
    @Basic(optional = false)
    @Column(name = "ID",
            nullable = false)
    private Long id;

    /**
     * fecha de inicio de la sesion
     */
    @Basic(optional = false)
    @Column(name = "FECHA_INICIO",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;

    /**
     * fecha de cierre de la sesion
     */
    @Column(name = "FECHA_CIERRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCierre;

    /**
     * caja registradora a la cual pertenece a la sesion
     */
    @Column(name = "ID_CAJA",
            nullable = false)
    private String idCaja;

}
