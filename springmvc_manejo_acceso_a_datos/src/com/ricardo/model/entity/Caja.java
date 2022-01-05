package com.ricardo.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

/**
 *
 * @author eve0016952
 */
@Data
@Entity
@Table(name = "CAJA")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Caja.findAll",
                           query = "SELECT c FROM Caja c"),
        @NamedQuery(name = "Caja.findById",
                    query = "SELECT c FROM Caja c WHERE c.id = :id"),
        @NamedQuery(name = "Caja.findByIp",
                    query = "SELECT c FROM Caja c WHERE c.ip = :ip"),
        @NamedQuery(name = "Caja.findByTipoCaja",
                    query = "SELECT c FROM Caja c WHERE c.tipoCaja = :tipoCaja"),
        @NamedQuery(name = "Caja.findByEstreplica",
                    query = "SELECT c FROM Caja c WHERE c.estreplica = :estreplica")})
public class Caja implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;

    @Column(name = "IP")
    private String ip;

    @Basic(optional = false)
    @Column(name = "TIPO_CAJA")
    private int tipoCaja;

    @Basic(optional = false)
    @Column(name = "ESTREPLICA")
    private Character estreplica;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caja)) {
            return false;
        }
        Caja other = (Caja) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ Datos=" + id + ip + tipoCaja + " ]";
    }

}
