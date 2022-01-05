package com.intelix.service.GraphQLServices.entitys;

import java.math.BigInteger;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * Esta clase representa la entidad de base de datos Articulo
 * 
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
public class Articulo {

    /**
     * id del articulo
     */
    @Id
    @Basic(optional = false)
    @Column(name = "ID",
            nullable = false)
    private Long id;

    /**
     * codigo interno de EPA para el articulo
     */
    @Basic(optional = false)
    @Column(name = "CODIGO",
            nullable = false)
    private BigInteger codigo;

    /**
     * nombre del articulo
     */
    @Basic(optional = false)
    @Column(name = "NOMBRE",
            nullable = false,
            length = 80)
    private String nombre;

    /**
     * contiene la información general de la linea del articulo
     * 
     * @see Linea
     */
    @JoinColumn(name = "ID_LINEA",
                referencedColumnName = "ID",
                nullable = false)
    @ManyToOne(optional = false)
    private Linea idLinea;

}
