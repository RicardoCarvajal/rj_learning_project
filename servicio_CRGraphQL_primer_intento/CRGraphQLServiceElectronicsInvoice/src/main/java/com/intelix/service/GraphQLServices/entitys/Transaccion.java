package com.intelix.service.GraphQLServices.entitys;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Esta clase representa la entidad de base de datos Transaccion
 * 
 * @author Ricardo J. Carvajal F.
 */
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class Transaccion {

    /**
     * Id de la transacción
     */
    @Id
    @Column(name = "ID",
            nullable = false)
    private String id;

    /**
     * numero de la transacción la cual se puede repetir en cada caja registradora
     */
    @Column(name = "NUMERO",
            nullable = false)
    private int numero;

    /**
     * numero fiscal de la transacción que debe de ser unico por cada caja registradora
     */
    @Basic(optional = false)
    @Column(name = "NUMERO_FISCAL",
            nullable = false)
    private int numeroFiscal;

    /**
     * ficha del cajero que efectuo la transacción
     */
    @Column(name = "CAJERO")
    private Integer cajero;

    /**
     * tipo de transacción la cual puede ser
     * 'VENTA','ANULACION','DEVOLUCION','ORDENDEVENTA','PAGOCREDITO','ANULACREDITO','ACREENCIAS','ANULAORDENDEVENTA','NOPRESENCIAL'
     */
    @Basic(optional = false)
    @Column(name = "TIPO",
            nullable = false,
            length = 50)
    private String tipo;

    /**
     * estado de la transacción el cual puede ser 'F' finalizada, 'I' incompleta o 'E' en
     * espera
     */
    @Basic(optional = false)
    @Column(name = "ESTADO",
            nullable = false)
    private char estado;

    /**
     * fecha y hora en la que se hizo la transacción
     */
    @Basic(optional = false)
    @Column(name = "FECHA",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    /**
     * totalBase es el total de la transacción sin el impuesto y con la rebaja
     */
    @Basic(optional = false)
    @Column(name = "TOTAL_BASE",
            nullable = false,
            precision = 13,
            scale = 2)
    private BigDecimal totalBase;

    /**
     * totalImpuesto es el monto total del impuesto de la transacción
     */
    @Basic(optional = false)
    @Column(name = "TOTAL_IMPUESTO",
            nullable = false,
            precision = 13,
            scale = 2)
    private BigDecimal totalImpuesto;

    /**
     * totalRebaja es el monto total de la rebaja de la transacción
     */
    @Basic(optional = false)
    @Column(name = "TOTAL_REBAJA",
            nullable = false,
            precision = 13,
            scale = 2)
    private BigDecimal totalRebaja;

    /**
     * vuelto de la transacción
     */
    @Basic(optional = false)
    @Column(name = "VUELTO",
            nullable = false,
            precision = 13,
            scale = 2)
    private BigDecimal vuelto;

    /**
     * reglones es la cantidad de items que tiene la transaccion
     */
    @Basic(optional = false)
    @Column(name = "RENGLONES",
            nullable = false)
    private int renglones;

    /**
     * el total a pagar de la transacción
     */
    @Basic(optional = false)
    @Column(name = "TOTAL_TRANSACCION",
            nullable = false,
            precision = 13,
            scale = 2)
    private BigDecimal totalTransaccion;

    /**
     * numeroIdentificacionCliente de tipo {@link Cliente} contiene toda la informacion
     * del cliente de la transacción
     */
    @JoinColumn(name = "NUMERO_IDENTIFICACION_CLIENTE",
                referencedColumnName = "NUMERO_IDENTIFICACION_CLIENTE")
    @ManyToOne
    private Cliente numeroIdentificacionCliente;

    /**
     * idUsuario de tipo {@link Usuario} contienen toda la informacion relativa al cajero
     * que realiza la transacción
     */
    @JoinColumn(name = "ID_USUARIO",
                referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    /**
     * idSerialimpresora contiene el id del registro de la tabla serialimpresora, la cual
     * contiene la informacion fiscal de la caja
     */
    @Basic(optional = false)
    @Column(name = "ID_SERIALIMPRESORA",
            nullable = false)
    private Long idSerialimpresora;

    /**
     * idSesion de tipo {@link Sesion} contiene toda la informacion de la sesion de la
     * caja registradiora de cuando se hizo la transacción
     */
    @JoinColumn(name = "ID_SESION",
                referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Sesion idSesion;

    /**
     * percepcion si la transacción tiene este tipo de impueto se coloca 'S' en este campo
     * sino se coloca 'N'
     */
    @Basic(optional = false)
    @Column(name = "PERCEPCION",
            nullable = false)
    private char percepcion;

    /**
     * totalPercepcion es el monto total de el impuesto de percepcion de la transacción
     */
    @Basic(optional = false)
    @Column(name = "TOTAL_PERCEPCION",
            nullable = false,
            precision = 13,
            scale = 5)
    private BigDecimal totalPercepcion;

    /**
     * transaccionarticuloList de tipo {@link Transaccionarticulo} tiene una lista de
     * articulos perteneciente a la transacción
     */
    @OneToMany(fetch = FetchType.EAGER,
               cascade = CascadeType.ALL,
               mappedBy = "idTransaccion")
    private Set<Transaccionarticulo> transaccionarticuloList;

    /**
     * transaccionformadepagoList de tipo {@link Transaccionformadepago} contiene una
     * lista de los pagos de la transacción
     */
    @OneToMany(fetch = FetchType.EAGER,
               cascade = CascadeType.ALL,
               mappedBy = "idTransaccion")
    private Set<Transaccionformadepago> transaccionformadepagoList;

    /**
     * Este metodo retorna solo la fecha del campo {@code fecha} en formato "YYYY-MM-dd"
     * 
     * @see SimpleDateFormat#format(Object)
     * 
     * @return String con formato YYYY-MM-dd
     */
    public String getFecha() {
        SimpleDateFormat date = new SimpleDateFormat("YYYY-MM-dd");
        return date.format(fecha);
    }

    /**
     * Este metodo retorna solo la hora del campo {@code fecha} en formato "hh:mm:ss"
     * 
     * @see SimpleDateFormat#format(Object)
     * 
     * @return String con formato hh:mm:ss
     */
    public String getHora() {
        SimpleDateFormat date = new SimpleDateFormat("hh:mm:ss");
        return date.format(fecha);
    }

}
