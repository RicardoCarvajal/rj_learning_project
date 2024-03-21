/*******************************************************************************
 * © 2012 Global Retail Information Ltd.
 ******************************************************************************/
/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.intelix.service.GraphQLServices.entitys;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Esta clase representa la entidad de base de datos Giroactividadeconomica
 * 
 * @author Ricardo J. Carvajal F.
 */
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class Giroactividadeconomica {

    /**
     * id del giro de actividad economica de un cliente
     * 
     * @see Cliente
     */
    @Id
    @Basic(optional = false)
    @Column(name = "ID",
            nullable = false)
    private Long id;

    /**
     * codigo del giro
     */
    @Basic(optional = false)
    @Column(name = "CODIGO",
            nullable = false)
    private int codigo;

    /**
     * descripción del giro
     */
    @Basic(optional = false)
    @Column(name = "DESCRIPCION",
            nullable = false,
            length = 200)
    private String descripcion;

    /**
     * categoria del giro
     */
    @Basic(optional = false)
    @Column(name = "CATEGORIA",
            nullable = false)
    private int categoria;

    /**
     * clienteList una lista de cliente con un giro de actividad economica en particular
     * 
     * @see Cliente
     */
    @OneToMany(mappedBy = "idGiroactividadeconomica")
    private List<Cliente> clienteList;

}
