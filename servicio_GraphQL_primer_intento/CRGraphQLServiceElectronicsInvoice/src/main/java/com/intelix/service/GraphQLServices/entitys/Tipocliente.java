/*******************************************************************************
 * © 2012 Global Retail Information Ltd.
 ******************************************************************************/
/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.intelix.service.GraphQLServices.entitys;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * Esta clase representa la entidad de base de datos Tipocliente
 * 
 * @see Cliente
 * 
 * @author Ricardo J. Carvajal F.
 */
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class Tipocliente {

    /**
     * id del tipo del cliente
     */
    @Id
    @Basic(optional = false)
    @Column(name = "ID",
            nullable = false)
    private Long id;

    /**
     * nombre del tipo de cliente
     */
    @Basic(optional = false)
    @Column(name = "NOMBRE",
            nullable = false,
            length = 40)
    private String nombre;

    /**
     * clienteList lista de clientes pertenecientes a un tipo de cliente determinado
     * 
     * @see Cliente
     */
    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "idTipocliente")
    private List<Cliente> clienteList;

}
