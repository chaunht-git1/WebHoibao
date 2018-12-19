 
package EntitiesBean;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
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

 
@Entity
@Table(name = "DISTRICT_LIST")
@XmlRootElement
@Cacheable
@NamedQueries({
    @NamedQuery(name = "DistrictList.findAll", query = "SELECT d FROM DistrictList d"),
    @NamedQuery(name = "DistrictList.findByIdDistrict", query = "SELECT d FROM DistrictList d WHERE d.idDistrict = :idDistrict"),
    @NamedQuery(name = "DistrictList.findByIdCity", query = "SELECT d FROM DistrictList d WHERE d.idCity = :idCity"),
    @NamedQuery(name = "DistrictList.findByDistrictName", query = "SELECT d FROM DistrictList d WHERE d.districtName = :districtName"),
    @NamedQuery(name = "DistrictList.findByIdValidity", query = "SELECT d FROM DistrictList d WHERE d.idValidity = :idValidity"),
    @NamedQuery(name = "DistrictList.findByNgayCapnhat", query = "SELECT d FROM DistrictList d WHERE d.ngayCapnhat = :ngayCapnhat"),
    @NamedQuery(name = "DistrictList.findByMacdinh", query = "SELECT d FROM DistrictList d WHERE d.macdinh = :macdinh"),
    @NamedQuery(name = "DistrictList.findByIdNvChitra", query = "SELECT d FROM DistrictList d WHERE d.idNvChitra = :idNvChitra"),
    @NamedQuery(name = "DistrictList.findByIdDiaban", query = "SELECT d FROM DistrictList d WHERE d.idDiaban = :idDiaban"),
    @NamedQuery(name = "DistrictList.findByIdNvUpdate", query = "SELECT d FROM DistrictList d WHERE d.idNvUpdate = :idNvUpdate"),
    @NamedQuery(name = "DistrictList.findByIdCnQuanly", query = "SELECT d FROM DistrictList d WHERE d.idCnQuanly = :idCnQuanly"),
    @NamedQuery(name = "DistrictList.findByDaphanQh", query = "SELECT d FROM DistrictList d WHERE d.daphanQh = :daphanQh"),
    @NamedQuery(name = "DistrictList.findByIdNvChitra2", query = "SELECT d FROM DistrictList d WHERE d.idNvChitra2 = :idNvChitra2"),
    @NamedQuery(name = "DistrictList.findByIdKhongchi", query = "SELECT d FROM DistrictList d WHERE d.idKhongchi = :idKhongchi"),
    @NamedQuery(name = "DistrictList.findByChuoiTimkiem", query = "SELECT d FROM DistrictList d WHERE d.chuoiTimkiem = :chuoiTimkiem"),
    @NamedQuery(name = "DistrictList.findBySttTk", query = "SELECT d FROM DistrictList d WHERE d.sttTk = :sttTk"),
    @NamedQuery(name = "DistrictList.findByIdTimAuto", query = "SELECT d FROM DistrictList d WHERE d.idTimAuto = :idTimAuto"),
    @NamedQuery(name = "DistrictList.findByChuoiLoaitru", query = "SELECT d FROM DistrictList d WHERE d.chuoiLoaitru = :chuoiLoaitru")})
public class DistrictList implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ID_DISTRICT")
    private String idDistrict;
    @Size(max = 20)
    @Column(name = "ID_CITY")
    private String idCity;
    @Size(max = 80)
    @Column(name = "DISTRICT_NAME")
    private String districtName;
    @Size(max = 20)
    @Column(name = "ID_VALIDITY")
    private String idValidity;
    @Column(name = "NGAY_CAPNHAT")
    @Temporal(TemporalType.DATE)
    private Date ngayCapnhat;
    @Size(max = 1)
    @Column(name = "MACDINH")
    private String macdinh;
    @Size(max = 20)
    @Column(name = "ID_NV_CHITRA")
    private String idNvChitra;
    @Size(max = 6)
    @Column(name = "ID_DIABAN")
    private String idDiaban;
    @Size(max = 20)
    @Column(name = "ID_NV_UPDATE")
    private String idNvUpdate;
    @Size(max = 10)
    @Column(name = "ID_CN_QUANLY")
    private String idCnQuanly;
    @Size(max = 1)
    @Column(name = "DAPHAN_QH")
    private String daphanQh;
    @Size(max = 20)
    @Column(name = "ID_NV_CHITRA_2")
    private String idNvChitra2;
    @Size(max = 1)
    @Column(name = "ID_KHONGCHI")
    private String idKhongchi;
    @Size(max = 1000)
    @Column(name = "CHUOI_TIMKIEM")
    private String chuoiTimkiem;
    @Column(name = "STT_TK")
    private BigInteger sttTk;
    @Size(max = 1)
    @Column(name = "ID_TIM_AUTO")
    private String idTimAuto;
    @Size(max = 2000)
    @Column(name = "CHUOI_LOAITRU")
    private String chuoiLoaitru;

    public DistrictList() {
    }

    public DistrictList(String idDistrict) {
        this.idDistrict = idDistrict;
    }

    public String getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(String idDistrict) {
        this.idDistrict = idDistrict;
    }

    public String getIdCity() {
        return idCity;
    }

    public void setIdCity(String idCity) {
        this.idCity = idCity;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getIdValidity() {
        return idValidity;
    }

    public void setIdValidity(String idValidity) {
        this.idValidity = idValidity;
    }

    public Date getNgayCapnhat() {
        return ngayCapnhat;
    }

    public void setNgayCapnhat(Date ngayCapnhat) {
        this.ngayCapnhat = ngayCapnhat;
    }

    public String getMacdinh() {
        return macdinh;
    }

    public void setMacdinh(String macdinh) {
        this.macdinh = macdinh;
    }

    public String getIdNvChitra() {
        return idNvChitra;
    }

    public void setIdNvChitra(String idNvChitra) {
        this.idNvChitra = idNvChitra;
    }

    public String getIdDiaban() {
        return idDiaban;
    }

    public void setIdDiaban(String idDiaban) {
        this.idDiaban = idDiaban;
    }

    public String getIdNvUpdate() {
        return idNvUpdate;
    }

    public void setIdNvUpdate(String idNvUpdate) {
        this.idNvUpdate = idNvUpdate;
    }

    public String getIdCnQuanly() {
        return idCnQuanly;
    }

    public void setIdCnQuanly(String idCnQuanly) {
        this.idCnQuanly = idCnQuanly;
    }

    public String getDaphanQh() {
        return daphanQh;
    }

    public void setDaphanQh(String daphanQh) {
        this.daphanQh = daphanQh;
    }

    public String getIdNvChitra2() {
        return idNvChitra2;
    }

    public void setIdNvChitra2(String idNvChitra2) {
        this.idNvChitra2 = idNvChitra2;
    }

    public String getIdKhongchi() {
        return idKhongchi;
    }

    public void setIdKhongchi(String idKhongchi) {
        this.idKhongchi = idKhongchi;
    }

    public String getChuoiTimkiem() {
        return chuoiTimkiem;
    }

    public void setChuoiTimkiem(String chuoiTimkiem) {
        this.chuoiTimkiem = chuoiTimkiem;
    }

    public BigInteger getSttTk() {
        return sttTk;
    }

    public void setSttTk(BigInteger sttTk) {
        this.sttTk = sttTk;
    }

    public String getIdTimAuto() {
        return idTimAuto;
    }

    public void setIdTimAuto(String idTimAuto) {
        this.idTimAuto = idTimAuto;
    }

    public String getChuoiLoaitru() {
        return chuoiLoaitru;
    }

    public void setChuoiLoaitru(String chuoiLoaitru) {
        this.chuoiLoaitru = chuoiLoaitru;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDistrict != null ? idDistrict.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DistrictList)) {
            return false;
        }
        DistrictList other = (DistrictList) object;
        if ((this.idDistrict == null && other.idDistrict != null) || (this.idDistrict != null && !this.idDistrict.equals(other.idDistrict))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConnectBean.DistrictList[ idDistrict=" + idDistrict + " ]";
    }
    
}
