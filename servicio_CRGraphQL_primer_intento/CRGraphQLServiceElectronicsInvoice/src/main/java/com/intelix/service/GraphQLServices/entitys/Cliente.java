package com.intelix.service.GraphQLServices.entitys;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Esta clase representa la entidad de base de datos Cliente
 * 
 * @author Ricardo J. Carvajal F.
 */
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class Cliente {

    /**
     * numeroIdentificacionCliente es la cedula de identidad del cliente tambien es el ID
     * de la tabla
     */
    @Id
    @Basic(optional = false)
    @Column(name = "NUMERO_IDENTIFICACION_CLIENTE",
            nullable = false,
            length = 25)
    private String numeroIdentificacionCliente;

    /**
     * nombre del cliente
     */
    @Column(name = "NOMBRE",
            nullable = false,
            length = 255)
    private String nombre;

    /**
     * numero de identificacion tributario del cliente NIT
     */
    @Basic(optional = false)
    @Column(name = "NUMERO_IDENTIFICACION_TRIBUTARIO",
            nullable = false,
            length = 25)
    private String numeroIdentificacionTributario;

    /**
     * direccion del cliente
     */
    @Column(name = "DIRECCION",
            nullable = false,
            length = 255)
    private String direccion;

    /**
     * direccion fiscal del cliente
     */
    @Column(name = "DIRECCION_FISCAL",
            nullable = false,
            length = 255)
    private String direccionFiscal;

    /**
     * telefono del cliente
     */
    @Column(name = "TELEFONO",
            length = 15)
    private String telefono;

    /**
     * correo electronico del cliente
     */
    @Column(name = "CORREO_ELECTRONICO",
            length = 255)
    private String correoElectronico;

    /**
     * marca que indica con una 'S' si el cliente es agente de retencion y con una 'N' si
     * no lo es
     */
    @Column(name = "ESAGENTERETENCION")
    private Character esagenteretencion;

    /**
     * maraca que indica con una 'S' si el cliente es un diplomatico y con una 'N' si no
     * lo es
     */
    @Basic(optional = false)
    @Column(name = "ESDIPLOMATICO",
            nullable = false)
    private char esdiplomatico;

    /**
     * si el cliente es un empleado de EPA aca se guarda la ficha del asesor
     */
    @Column(name = "FICHA")
    private BigInteger ficha;

    /**
     * marca que indica con una 'S' si el cliente es de categoria fiscal grande y con una
     * 'N' si no lo es
     */
    @Basic(optional = false)
    @Column(name = "ESGRANDE",
            nullable = false)
    private char esgrande;

    /**
     * transaccionList una lista de tipo {@link Transaccion} que tienen todas las
     * transacciones de un cliente por la relacion entre tablas
     */
    @OneToMany(mappedBy = "numeroIdentificacionCliente")
    private List<Transaccion> transaccionList;

    /**
     * idGiroactividadeconomica posee toda la informacion del giro de actividad economica
     * del cliente
     * 
     * @see Giroactividadeconomica
     */
    @JoinColumn(name = "ID_GIROACTIVIDADECONOMICA",
                referencedColumnName = "ID")
    @ManyToOne
    private Giroactividadeconomica idGiroactividadeconomica;

    /**
     * idTipocliente guarda la informacion de el tipo del cliente
     * 
     * @see Tipocliente
     */
    @JoinColumn(name = "ID_TIPOCLIENTE",
                referencedColumnName = "ID",
                nullable = false)
    @ManyToOne(optional = false)
    private Tipocliente idTipocliente;

    /**
     * si el cliente paga este tipo de impuesto se coloca en este campo 'S' sino 'N'
     */
    @Basic(optional = false)
    @Column(name = "PERCEPCION",
            nullable = false)
    private String percepcion;

}
