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
 * Esta clase representa la entidad de base de datos Opcion, la cual es una tabla de
 * configuracion generica
 * 
 * 
 * @author Ricardo J. Carvajal F.
 */
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class Opcion {

    /**
     * id de la tabla opción
     */
    @Id
    @Basic(optional = false)
    @Column(name = "ID",
            nullable = false)
    private Long id;

    /**
     * valor de la configuración
     */
    @Basic(optional = false)
    @Column(name = "VALOR",
            nullable = false,
            length = 1000)
    private String valor;

}
