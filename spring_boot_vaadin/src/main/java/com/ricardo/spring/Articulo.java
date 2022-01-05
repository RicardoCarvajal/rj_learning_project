package com.ricardo.spring;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eve0016952@epa.com
 */
@Entity
@Table(name = "articulo")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Articulo.findAll",
                           query = "SELECT a FROM Articulo a"),
        @NamedQuery(name = "Articulo.findById",
                    query = "SELECT a FROM Articulo a WHERE a.id = :id"),
        @NamedQuery(name = "Articulo.findByIdLinea",
                    query = "SELECT a FROM Articulo a WHERE a.idLinea = :idLinea"),
        @NamedQuery(name = "Articulo.findByIdTasaimpuestotipo",
                    query = "SELECT a FROM Articulo a WHERE a.idTasaimpuestotipo = :idTasaimpuestotipo"),
        @NamedQuery(name = "Articulo.findByIdArticulocategorizado",
                    query = "SELECT a FROM Articulo a WHERE a.idArticulocategorizado = :idArticulocategorizado"),
        @NamedQuery(name = "Articulo.findByIdFamilia",
                    query = "SELECT a FROM Articulo a WHERE a.idFamilia = :idFamilia"),
        @NamedQuery(name = "Articulo.findByCodigo",
                    query = "SELECT a FROM Articulo a WHERE a.codigo = :codigo"),
        @NamedQuery(name = "Articulo.findByNombre",
                    query = "SELECT a FROM Articulo a WHERE a.nombre = :nombre"),
        @NamedQuery(name = "Articulo.findByFecha",
                    query = "SELECT a FROM Articulo a WHERE a.fecha = :fecha"),
        @NamedQuery(name = "Articulo.findByEstaactivo",
                    query = "SELECT a FROM Articulo a WHERE a.estaactivo = :estaactivo"),
        @NamedQuery(name = "Articulo.findByCantidadMaximaTransaccion",
                    query = "SELECT a FROM Articulo a WHERE a.cantidadMaximaTransaccion = :cantidadMaximaTransaccion"),
        @NamedQuery(name = "Articulo.findByCantidadMaximaPeriodo",
                    query = "SELECT a FROM Articulo a WHERE a.cantidadMaximaPeriodo = :cantidadMaximaPeriodo"),
        @NamedQuery(name = "Articulo.findByPeriodoCompra",
                    query = "SELECT a FROM Articulo a WHERE a.periodoCompra = :periodoCompra")})
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @Column(name = "id_linea")
    private long idLinea;

    @Basic(optional = false)
    @Column(name = "id_tasaimpuestotipo")
    private long idTasaimpuestotipo;

    @Column(name = "id_articulocategorizado")
    private BigInteger idArticulocategorizado;

    @Column(name = "id_familia")
    private BigInteger idFamilia;

    @Basic(optional = false)
    @Column(name = "codigo")
    private long codigo;

    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;

    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Basic(optional = false)
    @Column(name = "estaactivo")
    private String estaactivo;

    // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider
    // using these annotations to enforce field validation
    @Column(name = "cantidad_maxima_transaccion")
    private BigDecimal cantidadMaximaTransaccion;

    @Column(name = "cantidad_maxima_periodo")
    private BigDecimal cantidadMaximaPeriodo;

    @Column(name = "periodo_compra")
    private Integer periodoCompra;

    public Articulo() {
    }

    public Articulo(Long id) {
        this.id = id;
    }

    public Articulo(Long id, long idLinea, long idTasaimpuestotipo, long codigo, String nombre, Date fecha,
                    String estaactivo) {
        this.id = id;
        this.idLinea = idLinea;
        this.idTasaimpuestotipo = idTasaimpuestotipo;
        this.codigo = codigo;
        this.nombre = nombre;
        this.fecha = fecha;
        this.estaactivo = estaactivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(long idLinea) {
        this.idLinea = idLinea;
    }

    public long getIdTasaimpuestotipo() {
        return idTasaimpuestotipo;
    }

    public void setIdTasaimpuestotipo(long idTasaimpuestotipo) {
        this.idTasaimpuestotipo = idTasaimpuestotipo;
    }

    public BigInteger getIdArticulocategorizado() {
        return idArticulocategorizado;
    }

    public void setIdArticulocategorizado(BigInteger idArticulocategorizado) {
        this.idArticulocategorizado = idArticulocategorizado;
    }

    public BigInteger getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(BigInteger idFamilia) {
        this.idFamilia = idFamilia;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstaactivo() {
        return estaactivo;
    }

    public void setEstaactivo(String estaactivo) {
        this.estaactivo = estaactivo;
    }

    public BigDecimal getCantidadMaximaTransaccion() {
        return cantidadMaximaTransaccion;
    }

    public void setCantidadMaximaTransaccion(BigDecimal cantidadMaximaTransaccion) {
        this.cantidadMaximaTransaccion = cantidadMaximaTransaccion;
    }

    public BigDecimal getCantidadMaximaPeriodo() {
        return cantidadMaximaPeriodo;
    }

    public void setCantidadMaximaPeriodo(BigDecimal cantidadMaximaPeriodo) {
        this.cantidadMaximaPeriodo = cantidadMaximaPeriodo;
    }

    public Integer getPeriodoCompra() {
        return periodoCompra;
    }

    public void setPeriodoCompra(Integer periodoCompra) {
        this.periodoCompra = periodoCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ricardo.example.Articulo[ id=" + id + " ]";
    }

}
