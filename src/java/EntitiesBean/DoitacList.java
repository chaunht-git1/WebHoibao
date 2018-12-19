/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesBean;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "DOITAC_LIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DoitacList.findAll", query = "SELECT d FROM DoitacList d"),
    @NamedQuery(name = "DoitacList.findByIdCode", query = "SELECT d FROM DoitacList d WHERE d.idCode = :idCode"),
    @NamedQuery(name = "DoitacList.findByDescription", query = "SELECT d FROM DoitacList d WHERE d.description = :description"),
    @NamedQuery(name = "DoitacList.findByDiachi", query = "SELECT d FROM DoitacList d WHERE d.diachi = :diachi"),
    @NamedQuery(name = "DoitacList.findByIdCity", query = "SELECT d FROM DoitacList d WHERE d.idCity = :idCity"),
    @NamedQuery(name = "DoitacList.findByTel", query = "SELECT d FROM DoitacList d WHERE d.tel = :tel"),
    @NamedQuery(name = "DoitacList.findByFax", query = "SELECT d FROM DoitacList d WHERE d.fax = :fax"),
    @NamedQuery(name = "DoitacList.findByIdValidity", query = "SELECT d FROM DoitacList d WHERE d.idValidity = :idValidity"),
    @NamedQuery(name = "DoitacList.findByDateModified", query = "SELECT d FROM DoitacList d WHERE d.dateModified = :dateModified"),
    @NamedQuery(name = "DoitacList.findByIdNational", query = "SELECT d FROM DoitacList d WHERE d.idNational = :idNational"),
    @NamedQuery(name = "DoitacList.findBySotaikhoan", query = "SELECT d FROM DoitacList d WHERE d.sotaikhoan = :sotaikhoan"),
    @NamedQuery(name = "DoitacList.findByIdKyhopdong", query = "SELECT d FROM DoitacList d WHERE d.idKyhopdong = :idKyhopdong"),
    @NamedQuery(name = "DoitacList.findByNguoidaidien", query = "SELECT d FROM DoitacList d WHERE d.nguoidaidien = :nguoidaidien"),
    @NamedQuery(name = "DoitacList.findByChucdanh", query = "SELECT d FROM DoitacList d WHERE d.chucdanh = :chucdanh"),
    @NamedQuery(name = "DoitacList.findByIdDanghoahong", query = "SELECT d FROM DoitacList d WHERE d.idDanghoahong = :idDanghoahong"),
    @NamedQuery(name = "DoitacList.findByIdCongnoCodinh", query = "SELECT d FROM DoitacList d WHERE d.idCongnoCodinh = :idCongnoCodinh"),
    @NamedQuery(name = "DoitacList.findByIdLoaitienkhautru", query = "SELECT d FROM DoitacList d WHERE d.idLoaitienkhautru = :idLoaitienkhautru"),
    @NamedQuery(name = "DoitacList.findByTinhnguyente", query = "SELECT d FROM DoitacList d WHERE d.tinhnguyente = :tinhnguyente"),
    @NamedQuery(name = "DoitacList.findByTachhoahong", query = "SELECT d FROM DoitacList d WHERE d.tachhoahong = :tachhoahong"),
    @NamedQuery(name = "DoitacList.findByIdTygiaBank", query = "SELECT d FROM DoitacList d WHERE d.idTygiaBank = :idTygiaBank"),
    @NamedQuery(name = "DoitacList.findByThitruong", query = "SELECT d FROM DoitacList d WHERE d.thitruong = :thitruong"),
    @NamedQuery(name = "DoitacList.findByIdQ5", query = "SELECT d FROM DoitacList d WHERE d.idQ5 = :idQ5"),
    @NamedQuery(name = "DoitacList.findByTygiatheobank", query = "SELECT d FROM DoitacList d WHERE d.tygiatheobank = :tygiatheobank"),
    @NamedQuery(name = "DoitacList.findByThitruongNew", query = "SELECT d FROM DoitacList d WHERE d.thitruongNew = :thitruongNew"),
    @NamedQuery(name = "DoitacList.findByTentiengviet", query = "SELECT d FROM DoitacList d WHERE d.tentiengviet = :tentiengviet"),
    @NamedQuery(name = "DoitacList.findByTentienganh", query = "SELECT d FROM DoitacList d WHERE d.tentienganh = :tentienganh"),
    @NamedQuery(name = "DoitacList.findByIdKiemtra", query = "SELECT d FROM DoitacList d WHERE d.idKiemtra = :idKiemtra"),
    @NamedQuery(name = "DoitacList.findByMasothue", query = "SELECT d FROM DoitacList d WHERE d.masothue = :masothue"),
    @NamedQuery(name = "DoitacList.findByIdCongtacvien", query = "SELECT d FROM DoitacList d WHERE d.idCongtacvien = :idCongtacvien"),
    @NamedQuery(name = "DoitacList.findByTaikhoan", query = "SELECT d FROM DoitacList d WHERE d.taikhoan = :taikhoan"),
    @NamedQuery(name = "DoitacList.findByIdDoitien", query = "SELECT d FROM DoitacList d WHERE d.idDoitien = :idDoitien"),
    @NamedQuery(name = "DoitacList.findByIdChuyenkhoan", query = "SELECT d FROM DoitacList d WHERE d.idChuyenkhoan = :idChuyenkhoan"),
    @NamedQuery(name = "DoitacList.findByIdDuyettudong", query = "SELECT d FROM DoitacList d WHERE d.idDuyettudong = :idDuyettudong"),
    @NamedQuery(name = "DoitacList.findByIdLanHb", query = "SELECT d FROM DoitacList d WHERE d.idLanHb = :idLanHb"),
    @NamedQuery(name = "DoitacList.findByIdDaucau", query = "SELECT d FROM DoitacList d WHERE d.idDaucau = :idDaucau"),
    @NamedQuery(name = "DoitacList.findByIdBiennhan", query = "SELECT d FROM DoitacList d WHERE d.idBiennhan = :idBiennhan"),
    @NamedQuery(name = "DoitacList.findByIdNhaplieu", query = "SELECT d FROM DoitacList d WHERE d.idNhaplieu = :idNhaplieu"),
    @NamedQuery(name = "DoitacList.findByIdCongno", query = "SELECT d FROM DoitacList d WHERE d.idCongno = :idCongno"),
    @NamedQuery(name = "DoitacList.findByIdKetoan", query = "SELECT d FROM DoitacList d WHERE d.idKetoan = :idKetoan"),
    @NamedQuery(name = "DoitacList.findByIdTk", query = "SELECT d FROM DoitacList d WHERE d.idTk = :idTk"),
    @NamedQuery(name = "DoitacList.findByIdChuyendoiCt", query = "SELECT d FROM DoitacList d WHERE d.idChuyendoiCt = :idChuyendoiCt"),
    @NamedQuery(name = "DoitacList.findByIdLtgSdtd", query = "SELECT d FROM DoitacList d WHERE d.idLtgSdtd = :idLtgSdtd"),
    @NamedQuery(name = "DoitacList.findByChitraKhacCn", query = "SELECT d FROM DoitacList d WHERE d.chitraKhacCn = :chitraKhacCn"),
    @NamedQuery(name = "DoitacList.findByIdDoitacGocTk", query = "SELECT d FROM DoitacList d WHERE d.idDoitacGocTk = :idDoitacGocTk"),
    @NamedQuery(name = "DoitacList.findByHieulucQlds", query = "SELECT d FROM DoitacList d WHERE d.hieulucQlds = :hieulucQlds"),
    @NamedQuery(name = "DoitacList.findByUserKyCongno", query = "SELECT d FROM DoitacList d WHERE d.userKyCongno = :userKyCongno"),
    @NamedQuery(name = "DoitacList.findByNgayKyhd", query = "SELECT d FROM DoitacList d WHERE d.ngayKyhd = :ngayKyhd"),
    @NamedQuery(name = "DoitacList.findByNgayPsgd", query = "SELECT d FROM DoitacList d WHERE d.ngayPsgd = :ngayPsgd"),
    @NamedQuery(name = "DoitacList.findByTygiaApdung", query = "SELECT d FROM DoitacList d WHERE d.tygiaApdung = :tygiaApdung"),
    @NamedQuery(name = "DoitacList.findByIdDvUse", query = "SELECT d FROM DoitacList d WHERE d.idDvUse = :idDvUse"),
    @NamedQuery(name = "DoitacList.findByIdDtTt", query = "SELECT d FROM DoitacList d WHERE d.idDtTt = :idDtTt"),
    @NamedQuery(name = "DoitacList.findByIdDuyetQldsAuto", query = "SELECT d FROM DoitacList d WHERE d.idDuyetQldsAuto = :idDuyetQldsAuto"),
    @NamedQuery(name = "DoitacList.findByNhapTygia", query = "SELECT d FROM DoitacList d WHERE d.nhapTygia = :nhapTygia"),
    @NamedQuery(name = "DoitacList.findByIdLoaihhDb", query = "SELECT d FROM DoitacList d WHERE d.idLoaihhDb = :idLoaihhDb"),
    @NamedQuery(name = "DoitacList.findByIdTructuyen", query = "SELECT d FROM DoitacList d WHERE d.idTructuyen = :idTructuyen"),
    @NamedQuery(name = "DoitacList.findByDuthuong", query = "SELECT d FROM DoitacList d WHERE d.duthuong = :duthuong"),
    @NamedQuery(name = "DoitacList.findByIdHoahong", query = "SELECT d FROM DoitacList d WHERE d.idHoahong = :idHoahong"),
    @NamedQuery(name = "DoitacList.findByTentat", query = "SELECT d FROM DoitacList d WHERE d.tentat = :tentat")})
public class DoitacList implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ID_CODE")
    private String idCode;
    @Size(max = 60)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 100)
    @Column(name = "DIACHI")
    private String diachi;
    @Size(max = 20)
    @Column(name = "ID_CITY")
    private String idCity;
    @Size(max = 60)
    @Column(name = "TEL")
    private String tel;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 60)
    @Column(name = "FAX")
    private String fax;
    @Size(max = 20)
    @Column(name = "ID_VALIDITY")
    private String idValidity;
    @Column(name = "DATE_MODIFIED")
    @Temporal(TemporalType.DATE)
    private Date dateModified;
    @Size(max = 20)
    @Column(name = "ID_NATIONAL")
    private String idNational;
    @Size(max = 20)
    @Column(name = "SOTAIKHOAN")
    private String sotaikhoan;
    @Size(max = 20)
    @Column(name = "ID_KYHOPDONG")
    private String idKyhopdong;
    @Size(max = 60)
    @Column(name = "NGUOIDAIDIEN")
    private String nguoidaidien;
    @Size(max = 60)
    @Column(name = "CHUCDANH")
    private String chucdanh;
    @Size(max = 20)
    @Column(name = "ID_DANGHOAHONG")
    private String idDanghoahong;
    @Size(max = 20)
    @Column(name = "ID_CONGNO_CODINH")
    private String idCongnoCodinh;
    @Size(max = 20)
    @Column(name = "ID_LOAITIENKHAUTRU")
    private String idLoaitienkhautru;
    @Size(max = 1)
    @Column(name = "TINHNGUYENTE")
    private String tinhnguyente;
    @Size(max = 1)
    @Column(name = "TACHHOAHONG")
    private String tachhoahong;
    @Size(max = 20)
    @Column(name = "ID_TYGIA_BANK")
    private String idTygiaBank;
    @Size(max = 10)
    @Column(name = "THITRUONG")
    private String thitruong;
    @Size(max = 1)
    @Column(name = "ID_Q5")
    private String idQ5;
    @Size(max = 20)
    @Column(name = "TYGIATHEOBANK")
    private String tygiatheobank;
    @Size(max = 10)
    @Column(name = "THITRUONG_NEW")
    private String thitruongNew;
    @Size(max = 100)
    @Column(name = "TENTIENGVIET")
    private String tentiengviet;
    @Size(max = 100)
    @Column(name = "TENTIENGANH")
    private String tentienganh;
    @Size(max = 1)
    @Column(name = "ID_KIEMTRA")
    private String idKiemtra;
    @Size(max = 50)
    @Column(name = "MASOTHUE")
    private String masothue;
    @Size(max = 1)
    @Column(name = "ID_CONGTACVIEN")
    private String idCongtacvien;
    @Size(max = 1)
    @Column(name = "TAIKHOAN")
    private String taikhoan;
    @Size(max = 1)
    @Column(name = "ID_DOITIEN")
    private String idDoitien;
    @Size(max = 1)
    @Column(name = "ID_CHUYENKHOAN")
    private String idChuyenkhoan;
    @Size(max = 1)
    @Column(name = "ID_DUYETTUDONG")
    private String idDuyettudong;
    @Size(max = 20)
    @Column(name = "ID_LAN_HB")
    private String idLanHb;
    @Size(max = 1)
    @Column(name = "ID_DAUCAU")
    private String idDaucau;
    @Size(max = 1)
    @Column(name = "ID_BIENNHAN")
    private String idBiennhan;
    @Size(max = 1)
    @Column(name = "ID_NHAPLIEU")
    private String idNhaplieu;
    @Size(max = 1)
    @Column(name = "ID_CONGNO")
    private String idCongno;
    @Size(max = 1)
    @Column(name = "ID_KETOAN")
    private String idKetoan;
    @Size(max = 1)
    @Column(name = "ID_TK")
    private String idTk;
    @Size(max = 1)
    @Column(name = "ID_CHUYENDOI_CT")
    private String idChuyendoiCt;
    @Size(max = 1)
    @Column(name = "ID_LTG_SDTD")
    private String idLtgSdtd;
    @Size(max = 1)
    @Column(name = "CHITRA_KHAC_CN")
    private String chitraKhacCn;
    @Size(max = 20)
    @Column(name = "ID_DOITAC_GOC_TK")
    private String idDoitacGocTk;
    @Size(max = 1)
    @Column(name = "HIEULUC_QLDS")
    private String hieulucQlds;
    @Size(max = 20)
    @Column(name = "USER_KY_CONGNO")
    private String userKyCongno;
    @Column(name = "NGAY_KYHD")
    @Temporal(TemporalType.DATE)
    private Date ngayKyhd;
    @Column(name = "NGAY_PSGD")
    @Temporal(TemporalType.DATE)
    private Date ngayPsgd;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TYGIA_APDUNG")
    private BigDecimal tygiaApdung;
    @Size(max = 20)
    @Column(name = "ID_DV_USE")
    private String idDvUse;
    @Size(max = 1)
    @Column(name = "ID_DT_TT")
    private String idDtTt;
    @Size(max = 1)
    @Column(name = "ID_DUYET_QLDS_AUTO")
    private String idDuyetQldsAuto;
    @Size(max = 1)
    @Column(name = "NHAP_TYGIA")
    private String nhapTygia;
    @Size(max = 1)
    @Column(name = "ID_LOAIHH_DB")
    private String idLoaihhDb;
    @Size(max = 1)
    @Column(name = "ID_TRUCTUYEN")
    private String idTructuyen;
    @Size(max = 1)
    @Column(name = "DUTHUONG")
    private String duthuong;
    @Size(max = 1)
    @Column(name = "ID_HOAHONG")
    private String idHoahong;
    @Size(max = 100)
    @Column(name = "TENTAT")
    private String tentat;

    public DoitacList() {
    }

    public DoitacList(String idCode) {
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

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getIdCity() {
        return idCity;
    }

    public void setIdCity(String idCity) {
        this.idCity = idCity;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
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

    public String getIdNational() {
        return idNational;
    }

    public void setIdNational(String idNational) {
        this.idNational = idNational;
    }

    public String getSotaikhoan() {
        return sotaikhoan;
    }

    public void setSotaikhoan(String sotaikhoan) {
        this.sotaikhoan = sotaikhoan;
    }

    public String getIdKyhopdong() {
        return idKyhopdong;
    }

    public void setIdKyhopdong(String idKyhopdong) {
        this.idKyhopdong = idKyhopdong;
    }

    public String getNguoidaidien() {
        return nguoidaidien;
    }

    public void setNguoidaidien(String nguoidaidien) {
        this.nguoidaidien = nguoidaidien;
    }

    public String getChucdanh() {
        return chucdanh;
    }

    public void setChucdanh(String chucdanh) {
        this.chucdanh = chucdanh;
    }

    public String getIdDanghoahong() {
        return idDanghoahong;
    }

    public void setIdDanghoahong(String idDanghoahong) {
        this.idDanghoahong = idDanghoahong;
    }

    public String getIdCongnoCodinh() {
        return idCongnoCodinh;
    }

    public void setIdCongnoCodinh(String idCongnoCodinh) {
        this.idCongnoCodinh = idCongnoCodinh;
    }

    public String getIdLoaitienkhautru() {
        return idLoaitienkhautru;
    }

    public void setIdLoaitienkhautru(String idLoaitienkhautru) {
        this.idLoaitienkhautru = idLoaitienkhautru;
    }

    public String getTinhnguyente() {
        return tinhnguyente;
    }

    public void setTinhnguyente(String tinhnguyente) {
        this.tinhnguyente = tinhnguyente;
    }

    public String getTachhoahong() {
        return tachhoahong;
    }

    public void setTachhoahong(String tachhoahong) {
        this.tachhoahong = tachhoahong;
    }

    public String getIdTygiaBank() {
        return idTygiaBank;
    }

    public void setIdTygiaBank(String idTygiaBank) {
        this.idTygiaBank = idTygiaBank;
    }

    public String getThitruong() {
        return thitruong;
    }

    public void setThitruong(String thitruong) {
        this.thitruong = thitruong;
    }

    public String getIdQ5() {
        return idQ5;
    }

    public void setIdQ5(String idQ5) {
        this.idQ5 = idQ5;
    }

    public String getTygiatheobank() {
        return tygiatheobank;
    }

    public void setTygiatheobank(String tygiatheobank) {
        this.tygiatheobank = tygiatheobank;
    }

    public String getThitruongNew() {
        return thitruongNew;
    }

    public void setThitruongNew(String thitruongNew) {
        this.thitruongNew = thitruongNew;
    }

    public String getTentiengviet() {
        return tentiengviet;
    }

    public void setTentiengviet(String tentiengviet) {
        this.tentiengviet = tentiengviet;
    }

    public String getTentienganh() {
        return tentienganh;
    }

    public void setTentienganh(String tentienganh) {
        this.tentienganh = tentienganh;
    }

    public String getIdKiemtra() {
        return idKiemtra;
    }

    public void setIdKiemtra(String idKiemtra) {
        this.idKiemtra = idKiemtra;
    }

    public String getMasothue() {
        return masothue;
    }

    public void setMasothue(String masothue) {
        this.masothue = masothue;
    }

    public String getIdCongtacvien() {
        return idCongtacvien;
    }

    public void setIdCongtacvien(String idCongtacvien) {
        this.idCongtacvien = idCongtacvien;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getIdDoitien() {
        return idDoitien;
    }

    public void setIdDoitien(String idDoitien) {
        this.idDoitien = idDoitien;
    }

    public String getIdChuyenkhoan() {
        return idChuyenkhoan;
    }

    public void setIdChuyenkhoan(String idChuyenkhoan) {
        this.idChuyenkhoan = idChuyenkhoan;
    }

    public String getIdDuyettudong() {
        return idDuyettudong;
    }

    public void setIdDuyettudong(String idDuyettudong) {
        this.idDuyettudong = idDuyettudong;
    }

    public String getIdLanHb() {
        return idLanHb;
    }

    public void setIdLanHb(String idLanHb) {
        this.idLanHb = idLanHb;
    }

    public String getIdDaucau() {
        return idDaucau;
    }

    public void setIdDaucau(String idDaucau) {
        this.idDaucau = idDaucau;
    }

    public String getIdBiennhan() {
        return idBiennhan;
    }

    public void setIdBiennhan(String idBiennhan) {
        this.idBiennhan = idBiennhan;
    }

    public String getIdNhaplieu() {
        return idNhaplieu;
    }

    public void setIdNhaplieu(String idNhaplieu) {
        this.idNhaplieu = idNhaplieu;
    }

    public String getIdCongno() {
        return idCongno;
    }

    public void setIdCongno(String idCongno) {
        this.idCongno = idCongno;
    }

    public String getIdKetoan() {
        return idKetoan;
    }

    public void setIdKetoan(String idKetoan) {
        this.idKetoan = idKetoan;
    }

    public String getIdTk() {
        return idTk;
    }

    public void setIdTk(String idTk) {
        this.idTk = idTk;
    }

    public String getIdChuyendoiCt() {
        return idChuyendoiCt;
    }

    public void setIdChuyendoiCt(String idChuyendoiCt) {
        this.idChuyendoiCt = idChuyendoiCt;
    }

    public String getIdLtgSdtd() {
        return idLtgSdtd;
    }

    public void setIdLtgSdtd(String idLtgSdtd) {
        this.idLtgSdtd = idLtgSdtd;
    }

    public String getChitraKhacCn() {
        return chitraKhacCn;
    }

    public void setChitraKhacCn(String chitraKhacCn) {
        this.chitraKhacCn = chitraKhacCn;
    }

    public String getIdDoitacGocTk() {
        return idDoitacGocTk;
    }

    public void setIdDoitacGocTk(String idDoitacGocTk) {
        this.idDoitacGocTk = idDoitacGocTk;
    }

    public String getHieulucQlds() {
        return hieulucQlds;
    }

    public void setHieulucQlds(String hieulucQlds) {
        this.hieulucQlds = hieulucQlds;
    }

    public String getUserKyCongno() {
        return userKyCongno;
    }

    public void setUserKyCongno(String userKyCongno) {
        this.userKyCongno = userKyCongno;
    }

    public Date getNgayKyhd() {
        return ngayKyhd;
    }

    public void setNgayKyhd(Date ngayKyhd) {
        this.ngayKyhd = ngayKyhd;
    }

    public Date getNgayPsgd() {
        return ngayPsgd;
    }

    public void setNgayPsgd(Date ngayPsgd) {
        this.ngayPsgd = ngayPsgd;
    }

    public BigDecimal getTygiaApdung() {
        return tygiaApdung;
    }

    public void setTygiaApdung(BigDecimal tygiaApdung) {
        this.tygiaApdung = tygiaApdung;
    }

    public String getIdDvUse() {
        return idDvUse;
    }

    public void setIdDvUse(String idDvUse) {
        this.idDvUse = idDvUse;
    }

    public String getIdDtTt() {
        return idDtTt;
    }

    public void setIdDtTt(String idDtTt) {
        this.idDtTt = idDtTt;
    }

    public String getIdDuyetQldsAuto() {
        return idDuyetQldsAuto;
    }

    public void setIdDuyetQldsAuto(String idDuyetQldsAuto) {
        this.idDuyetQldsAuto = idDuyetQldsAuto;
    }

    public String getNhapTygia() {
        return nhapTygia;
    }

    public void setNhapTygia(String nhapTygia) {
        this.nhapTygia = nhapTygia;
    }

    public String getIdLoaihhDb() {
        return idLoaihhDb;
    }

    public void setIdLoaihhDb(String idLoaihhDb) {
        this.idLoaihhDb = idLoaihhDb;
    }

    public String getIdTructuyen() {
        return idTructuyen;
    }

    public void setIdTructuyen(String idTructuyen) {
        this.idTructuyen = idTructuyen;
    }

    public String getDuthuong() {
        return duthuong;
    }

    public void setDuthuong(String duthuong) {
        this.duthuong = duthuong;
    }

    public String getIdHoahong() {
        return idHoahong;
    }

    public void setIdHoahong(String idHoahong) {
        this.idHoahong = idHoahong;
    }

    public String getTentat() {
        return tentat;
    }

    public void setTentat(String tentat) {
        this.tentat = tentat;
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
        if (!(object instanceof DoitacList)) {
            return false;
        }
        DoitacList other = (DoitacList) object;
        if ((this.idCode == null && other.idCode != null) || (this.idCode != null && !this.idCode.equals(other.idCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConnectBean.DoitacList[ idCode=" + idCode + " ]";
    }
    
}
