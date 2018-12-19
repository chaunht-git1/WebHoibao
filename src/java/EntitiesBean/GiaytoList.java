/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesBean;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "GIAYTO_LIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GiaytoList.findAll", query = "SELECT g FROM GiaytoList g"),
    @NamedQuery(name = "GiaytoList.findByMaGiayto", query = "SELECT g FROM GiaytoList g WHERE g.maGiayto = :maGiayto"),
    @NamedQuery(name = "GiaytoList.findByTenGiayto", query = "SELECT g FROM GiaytoList g WHERE g.tenGiayto = :tenGiayto"),
    @NamedQuery(name = "GiaytoList.findByIdValidity", query = "SELECT g FROM GiaytoList g WHERE g.idValidity = :idValidity"),
    @NamedQuery(name = "GiaytoList.findByDateModified", query = "SELECT g FROM GiaytoList g WHERE g.dateModified = :dateModified")})
public class GiaytoList implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "MA_GIAYTO")
    private String maGiayto;
    @Size(max = 100)
    @Column(name = "TEN_GIAYTO")
    private String tenGiayto;
    @Size(max = 20)
    @Column(name = "ID_VALIDITY")
    private String idValidity;
    @Column(name = "DATE_MODIFIED")
    @Temporal(TemporalType.DATE)
    private Date dateModified;

    public GiaytoList() {
    }

    public GiaytoList(String maGiayto) {
        this.maGiayto = maGiayto;
    }

    public String getMaGiayto() {
        return maGiayto;
    }

    public void setMaGiayto(String maGiayto) {
        this.maGiayto = maGiayto;
    }

    public String getTenGiayto() {
        return tenGiayto;
    }

    public void setTenGiayto(String tenGiayto) {
        this.tenGiayto = tenGiayto;
    }

    public String getIdValidity() {
        return idValidity;
    }

    public void setIdValidity(String idValidity) {
        this.idValidity = idValidity;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maGiayto != null ? maGiayto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GiaytoList)) {
            return false;
        }
        GiaytoList other = (GiaytoList) object;
        if ((this.maGiayto == null && other.maGiayto != null) || (this.maGiayto != null && !this.maGiayto.equals(other.maGiayto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConnectBean.GiaytoList[ maGiayto=" + maGiayto + " ]";
    }
    
}
