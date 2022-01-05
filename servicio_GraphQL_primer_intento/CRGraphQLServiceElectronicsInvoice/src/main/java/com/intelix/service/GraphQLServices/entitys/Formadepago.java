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
 * Esta clase representa la entidad de base de datos Formadepago
 * 
 * @author Ricardo J. Carvajal F.
 */
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class Formadepago {

    /**
     * ID de la forma de pago
     */
    @Id
    @Basic(optional = false)
    @Column(name = "ID",
            nullable = false)
    private Long id;

    /**
     * codigo de legacy para la forma de pago en la tabla VENTAS.CABFDP
     */
    @Basic(optional = false)
    @Column(name = "CODIGO",
            nullable = false)
    private int codigo;

    /**
     * nombre de la FDP
     */
    @Basic(optional = false)
    @Column(name = "NOMBRE",
            nullable = false,
            length = 12)
    private String nombre;

    /**
     * transaccionformadepagoList una lista de los pagos realizados con determinada forma
     * de pago
     * 
     * @see Transaccionformadepago
     */
    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "idFormadepago")
    private List<Transaccionformadepago> transaccionformadepagoList;

}
