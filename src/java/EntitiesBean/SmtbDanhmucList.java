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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SMTB_DANHMUC_LIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SmtbDanhmucList.findAll", query = "SELECT s FROM SmtbDanhmucList s"),
    @NamedQuery(name = "SmtbDanhmucList.findByIdCode", query = "SELECT s FROM SmtbDanhmucList s WHERE s.idCode = :idCode"),
    @NamedQuery(name = "SmtbDanhmucList.findByDescription", query = "SELECT s FROM SmtbDanhmucList s WHERE s.description = :description"),
    @NamedQuery(name = "SmtbDanhmucList.findByMakerId", query = "SELECT s FROM SmtbDanhmucList s WHERE s.makerId = :makerId"),
    @NamedQuery(name = "SmtbDanhmucList.findByNgayKhoitao", query = "SELECT s FROM SmtbDanhmucList s WHERE s.ngayKhoitao = :ngayKhoitao"),
    @NamedQuery(name = "SmtbDanhmucList.findByDateModified", query = "SELECT s FROM SmtbDanhmucList s WHERE s.dateModified = :dateModified"),
    @NamedQuery(name = "SmtbDanhmucList.findByDuyet", query = "SELECT s FROM SmtbDanhmucList s WHERE s.duyet = :duyet"),
    @NamedQuery(name = "SmtbDanhmucList.findByIdNvDuyet", query = "SELECT s FROM SmtbDanhmucList s WHERE s.idNvDuyet = :idNvDuyet"),
    @NamedQuery(name = "SmtbDanhmucList.findByNgayDuyet", query = "SELECT s FROM SmtbDanhmucList s WHERE s.ngayDuyet = :ngayDuyet"),
    @NamedQuery(name = "SmtbDanhmucList.findByRecordNote", query = "SELECT s FROM SmtbDanhmucList s WHERE s.recordNote = :recordNote"),
    @NamedQuery(name = "SmtbDanhmucList.findByIdValidity", query = "SELECT s FROM SmtbDanhmucList s WHERE s.idValidity = :idValidity"),
    @NamedQuery(name = "SmtbDanhmucList.findById", query = "SELECT s FROM SmtbDanhmucList s WHERE s.id = :id"),
    @NamedQuery(name = "SmtbDanhmucList.findByIdTieude", query = "SELECT s FROM SmtbDanhmucList s WHERE s.idTieude = :idTieude")})
public class SmtbDanhmucList implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 20)
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
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "ID")
    private String id;
    @Size(max = 20)
    @Column(name = "ID_TIEUDE")
    private String idTieude;
    @JoinColumn(name = "MA_DANHMUC", referencedColumnName = "ID_CODE")
    @ManyToOne
    private SmtbDanhmucDetail maDanhmuc;

    public SmtbDanhmucList() {
    }

    public SmtbDanhmucList(String id) {
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdTieude() {
        return idTieude;
    }

    public void setIdTieude(String idTieude) {
        this.idTieude = idTieude;
    }

    public SmtbDanhmucDetail getMaDanhmuc() {
        return maDanhmuc;
    }

    public void setMaDanhmuc(SmtbDanhmucDetail maDanhmuc) {
        this.maDanhmuc = maDanhmuc;
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
        if (!(object instanceof SmtbDanhmucList)) {
            return false;
        }
        SmtbDanhmucList other = (SmtbDanhmucList) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConnectBean.SmtbDanhmucList[ id=" + id + " ]";
    }
    
}
