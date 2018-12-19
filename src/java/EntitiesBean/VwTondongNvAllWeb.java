 
package EntitiesBean;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

 
public class VwTondongNvAllWeb implements Serializable {
 
    private String idcode;
   
    private String idQlqDottg;
  
    private String idKhachhangtt;
 
    private String hsdot1;
 
    private String nguoigoi;
 
    private BigDecimal tygia;
  
    private BigDecimal thanhtien;
   
    private String soCtTuythan;
  
    private String hsdot3;
 
    private Number daxmmobile;
 
    private String noidungxmmobile;
  
    private String quydinhxm;
     
    private String codemg;
 
    private String idChinhanh;
 
    private String sophieu;
  
    private Number stt;
 
    private String tenchinhanh;
 
    private String idNvChitra;
    
    private String hotenNv;
  
    private String hoten;
 
    private String maNguoinhan;
     
    private Long sobn;
  
    private BigDecimal sotiengoi;
 
    private String diachi;
   
    private String xacminh;
  
    private Date ngayXacminh;
     
    private String ghichu;
 
    private String idDoitac;
   
    private String tenDoitac;
  
    private String idLoaitienchitra;
 
    private String daxacminh;
    
    private String dienthoai;

    public String getIdcode() {
        return idcode;
    }

    public void setIdcode(String idcode) {
        this.idcode = idcode;
    }
 
    public VwTondongNvAllWeb() {
    }

    public String getIdChinhanh() {
        return idChinhanh;
    }

    public void setIdChinhanh(String idChinhanh) {
        this.idChinhanh = idChinhanh;
    }

    public String getSophieu() {
        return sophieu;
    }

    public void setSophieu(String sophieu) {
        this.sophieu = sophieu;
    }
 
    public String getTenchinhanh() {
        return tenchinhanh;
    }

    public void setTenchinhanh(String tenchinhanh) {
        this.tenchinhanh = tenchinhanh;
    }

    public String getIdNvChitra() {
        return idNvChitra;
    }

    public void setIdNvChitra(String idNvChitra) {
        this.idNvChitra = idNvChitra;
    }

    public String getHotenNv() {
        return hotenNv;
    }

    public void setHotenNv(String hotenNv) {
        this.hotenNv = hotenNv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getMaNguoinhan() {
        return maNguoinhan;
    }

    public void setMaNguoinhan(String maNguoinhan) {
        this.maNguoinhan = maNguoinhan;
    }

    public Long getSobn() {
        return sobn;
    }

    public void setSobn(Long sobn) {
        this.sobn = sobn;
    }

    public BigDecimal getSotiengoi() {
        return sotiengoi;
    }

    public void setSotiengoi(BigDecimal sotiengoi) {
        this.sotiengoi = sotiengoi;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getXacminh() {
        return xacminh;
    }

    public void setXacminh(String xacminh) {
        this.xacminh = xacminh;
    }

    public Date getNgayXacminh() {
        return ngayXacminh;
    }

    public void setNgayXacminh(Date ngayXacminh) {
        this.ngayXacminh = ngayXacminh;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getIdDoitac() {
        return idDoitac;
    }

    public void setIdDoitac(String idDoitac) {
        this.idDoitac = idDoitac;
    }

    public String getTenDoitac() {
        return tenDoitac;
    }

    public void setTenDoitac(String tenDoitac) {
        this.tenDoitac = tenDoitac;
    }

    public String getIdLoaitienchitra() {
        return idLoaitienchitra;
    }

    public void setIdLoaitienchitra(String idLoaitienchitra) {
        this.idLoaitienchitra = idLoaitienchitra;
    }

    public String getDaxacminh() {
        return daxacminh;
    }

    public void setDaxacminh(String daxacminh) {
        this.daxacminh = daxacminh;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public String getCodemg() {
        return codemg;
    }

    public void setCodemg(String codemg) {
        this.codemg = codemg;
    }

    public Number getDaxmmobile() {
        return daxmmobile;
    }

    public void setDaxmmobile(Number daxmmobile) {
        this.daxmmobile = daxmmobile;
    }

    public Number getStt() {
        return stt;
    }

    public void setStt(Number stt) {
        this.stt = stt;
    }

  

    public String getNoidungxmmobile() {
        return noidungxmmobile;
    }

    public void setNoidungxmmobile(String noidungxmmobile) {
        this.noidungxmmobile = noidungxmmobile;
    }

    public String getQuydinhxm() {
        return quydinhxm;
    }

    public void setQuydinhxm(String quydinhxm) {
        this.quydinhxm = quydinhxm;
    }

    public String getHsdot3() {
        return hsdot3;
    }

    public void setHsdot3(String hsdot3) {
        this.hsdot3 = hsdot3;
    }

    public String getNguoigoi() {
        return nguoigoi;
    }

    public void setNguoigoi(String nguoigoi) {
        this.nguoigoi = nguoigoi;
    }

    public BigDecimal getTygia() {
        return tygia;
    }

    public void setTygia(BigDecimal tygia) {
        this.tygia = tygia;
    }

    public BigDecimal getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(BigDecimal thanhtien) {
        this.thanhtien = thanhtien;
    }

    public String getSoCtTuythan() {
        return soCtTuythan;
    }

    public void setSoCtTuythan(String soCtTuythan) {
        this.soCtTuythan = soCtTuythan;
    }

    public String getHsdot1() {
        return hsdot1;
    }

    public void setHsdot1(String hsdot1) {
        this.hsdot1 = hsdot1;
    }

    public String getIdQlqDottg() {
        return idQlqDottg;
    }

    public void setIdQlqDottg(String idQlqDottg) {
        this.idQlqDottg = idQlqDottg;
    }

    public String getIdKhachhangtt() {
        return idKhachhangtt;
    }

    public void setIdKhachhangtt(String idKhachhangtt) {
        this.idKhachhangtt = idKhachhangtt;
    }
    
}
