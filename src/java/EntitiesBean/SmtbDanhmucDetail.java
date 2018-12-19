/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesBean;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "SMTB_DANHMUC_DETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SmtbDanhmucDetail.findAll", query = "SELECT s FROM SmtbDanhmucDetail s"),
    @NamedQuery(name = "SmtbDanhmucDetail.findByIdCode", query = "SELECT s FROM SmtbDanhmucDetail s WHERE s.idCode = :idCode"),
    @NamedQuery(name = "SmtbDanhmucDetail.findByDescription", query = "SELECT s FROM SmtbDanhmucDetail s WHERE s.description = :description"),
    @NamedQuery(name = "SmtbDanhmucDetail.findByMakerId", query = "SELECT s FROM SmtbDanhmucDetail s WHERE s.makerId = :makerId"),
    @NamedQuery(name = "SmtbDanhmucDetail.findByNgayKhoitao", query = "SELECT s FROM SmtbDanhmucDetail s WHERE s.ngayKhoitao = :ngayKhoitao"),
    @NamedQuery(name = "SmtbDanhmucDetail.findByDateModified", query = "SELECT s FROM SmtbDanhmucDetail s WHERE s.dateModified = :dateModified"),
    @NamedQuery(name = "SmtbDanhmucDetail.findByDuyet", query = "SELECT s FROM SmtbDanhmucDetail s WHERE s.duyet = :duyet"),
    @NamedQuery(name = "SmtbDanhmucDetail.findByIdNvDuyet", query = "SELECT s FROM SmtbDanhmucDetail s WHERE s.idNvDuyet = :idNvDuyet"),
    @NamedQuery(name = "SmtbDanhmucDetail.findByNgayDuyet", query = "SELECT s FROM SmtbDanhmucDetail s WHERE s.ngayDuyet = :ngayDuyet"),
    @NamedQuery(name = "SmtbDanhmucDetail.findByRecordNote", query = "SELECT s FROM SmtbDanhmucDetail s WHERE s.recordNote = :recordNote"),
    @NamedQuery(name = "SmtbDanhmucDetail.findByIdValidity", query = "SELECT s FROM SmtbDanhmucDetail s WHERE s.idValidity = :idValidity")})
public class SmtbDanhmucDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ID_CODE")
    private String idCode;
    @Size(max = 1000)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 20)
    @Column(name = "MAKER_ID")
    private String makerId;
    @Column(name = "NGAY_KHOITAO")
    @Temporal(TemporalType.DATE)
    private Date ngayKhoitao;
    @Column(name = "DATE_MODIFIED")
    @Temporal(TemporalType.DATE)
    private Date dateModified;
    @Size(max = 20)
    @Column(name = "DUYET")
    private String duyet;
    @Size(max = 20)
    @Column(name = "ID_NV_DUYET")
    private String idNvDuyet;
    @Column(name = "NGAY_DUYET")
    @Temporal(TemporalType.DATE)
    private Date ngayDuyet;
    @Size(max = 200)
    @Column(name = "RECORD_NOTE")
    private String recordNote;
    @Size(max = 20)
    @Column(name = "ID_VALIDITY")
    private String idValidity;
    @OneToMany(mappedBy = "maDanhmuc")
    private Collection<SmtbDanhmucList> smtbDanhmucListCollection;

    public SmtbDanhmucDetail() {
    }

    public SmtbDanhmucDetail(String idCode) {
        this.idCode = idCode;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMakerId() {
        return makerId;
    }

    public void setMakerId(String makerId) {
        this.makerId = makerId;
    }

    public Date getNgayKhoitao() {
        return ngayKhoitao;
    }

    public void setNgayKhoitao(Date ngayKhoitao) {
        this.ngayKhoitao = ngayKhoitao;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public String getDuyet() {
        return duyet;
    }

    public void setDuyet(String duyet) {
        this.duyet = duyet;
    }

    public String getIdNvDuyet() {
        return idNvDuyet;
    }

    public void setIdNvDuyet(String idNvDuyet) {
        this.idNvDuyet = idNvDuyet;
    }

    public Date getNgayDuyet() {
        return ngayDuyet;
    }

    public void setNgayDuyet(Date ngayDuyet) {
        this.ngayDuyet = ngayDuyet;
    }

    public String getRecordNote() {
        return recordNote;
    }

    public void setRecordNote(String recordNote) {
        this.recordNote = recordNote;
    }

    public String getIdValidity() {
        return idValidity;
    }

    public void setIdValidity(String idValidity) {
        this.idValidity = idValidity;
    }

    @XmlTransient
    public Collection<SmtbDanhmucList> getSmtbDanhmucListCollection() {
        return smtbDanhmucListCollection;
    }

    public void setSmtbDanhmucListCollection(Collection<SmtbDanhmucList> smtbDanhmucListCollection) {
        this.smtbDanhmucListCollection = smtbDanhmucListCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCode != null ? idCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmtbDanhmucDetail)) {
            return false;
        }
        SmtbDanhmucDetail other = (SmtbDanhmucDetail) object;
        if ((this.idCode == null && other.idCode != null) || (this.idCode != null && !this.idCode.equals(other.idCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConnectBean.SmtbDanhmucDetail[ idCode=" + idCode + " ]";
    }
    
}
