 
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

 
@Entity
@Table(name = "VW_XEMDULIEUTK_MASTER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwXemdulieutkMaster.findAll", query = "SELECT v FROM VwXemdulieutkMaster v"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByIdCode", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.idCode = :idCode"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByHoten", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.hoten = :hoten"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByHotenXuly", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.hotenXuly = :hotenXuly"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByDienthoai", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.dienthoai = :dienthoai"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByMaNguoinhan", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.maNguoinhan = :maNguoinhan"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByIdChinhanh", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.idChinhanh = :idChinhanh"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByChinhanhName", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.chinhanhName = :chinhanhName"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByIdDoitac", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.idDoitac = :idDoitac"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByDoitacName", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.doitacName = :doitacName"),
    @NamedQuery(name = "VwXemdulieutkMaster.findBySobn", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.sobn = :sobn"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByGiaytoHoten", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.giaytoHoten = :giaytoHoten"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByPayagentseq", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.payagentseq = :payagentseq"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByAgent", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.agent = :agent"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByIdAgent", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.idAgent = :idAgent"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByPinNo", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.pinNo = :pinNo"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByNgayNhaplieu", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.ngayNhaplieu = :ngayNhaplieu"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByMabiennhan", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.mabiennhan = :mabiennhan"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByNgayChitra", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.ngayChitra = :ngayChitra"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByDiachi", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.diachi = :diachi"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByIdCtTuythan", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.idCtTuythan = :idCtTuythan"),
    @NamedQuery(name = "VwXemdulieutkMaster.findBySoCtTuythan", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.soCtTuythan = :soCtTuythan"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByNgaycap", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.ngaycap = :ngaycap"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByNgayChitraTrue", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.ngayChitraTrue = :ngayChitraTrue"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByIdNvChitra", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.idNvChitra = :idNvChitra"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByIdDiadiemchitra", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.idDiadiemchitra = :idDiadiemchitra"),
    @NamedQuery(name = "VwXemdulieutkMaster.findBySophieu", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.sophieu = :sophieu"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByStt", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.stt = :stt"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByNguoigoi", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.nguoigoi = :nguoigoi"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByBiennhanC", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.biennhanC = :biennhanC"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByBiennhan", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.biennhan = :biennhan"),
    @NamedQuery(name = "VwXemdulieutkMaster.findBySolandichitra", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.solandichitra = :solandichitra"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByDanhanphieu", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.danhanphieu = :danhanphieu"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByLoaigiayto", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.loaigiayto = :loaigiayto"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByNguoigoi1", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.nguoigoi1 = :nguoigoi1"),
    @NamedQuery(name = "VwXemdulieutkMaster.findBySotiengoi", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.sotiengoi = :sotiengoi"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByTygia", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.tygia = :tygia"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByThanhtien", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.thanhtien = :thanhtien"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByIdLoaitienchitra", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.idLoaitienchitra = :idLoaitienchitra"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByIdLoaitiengoi", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.idLoaitiengoi = :idLoaitiengoi"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByIdLoaicongno", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.idLoaicongno = :idLoaicongno"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByIdCity", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.idCity = :idCity"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByCityName", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.cityName = :cityName"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByIdNvBaocao", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.idNvBaocao = :idNvBaocao"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByIdNvXacnhan", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.idNvXacnhan = :idNvXacnhan"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByIdNvBiennhan", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.idNvBiennhan = :idNvBiennhan"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByKhachhangNhan", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.khachhangNhan = :khachhangNhan"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByXacminh", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.xacminh = :xacminh"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByGhichu", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.ghichu = :ghichu"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByLydoXmnk", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.lydoXmnk = :lydoXmnk"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByIdNvNhaplieu", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.idNvNhaplieu = :idNvNhaplieu"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByIdNvTruyenfile", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.idNvTruyenfile = :idNvTruyenfile"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByDateTruyenfile", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.dateTruyenfile = :dateTruyenfile"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByIdNvUpdate", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.idNvUpdate = :idNvUpdate"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByIdNvXoaphieu", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.idNvXoaphieu = :idNvXoaphieu"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByLydoxoaphieu", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.lydoxoaphieu = :lydoxoaphieu"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByIdNvKt", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.idNvKt = :idNvKt"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByIdThanhtoan", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.idThanhtoan = :idThanhtoan"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByCongtacvien", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.congtacvien = :congtacvien"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByExtOrder", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.extOrder = :extOrder"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByIdDistrict", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.idDistrict = :idDistrict"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByDistrictName", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.districtName = :districtName"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByNgayBiennhan", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.ngayBiennhan = :ngayBiennhan"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByNgayXacminh", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.ngayXacminh = :ngayXacminh"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByNgaygiaophieu", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.ngaygiaophieu = :ngaygiaophieu"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByDakiemtra", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.dakiemtra = :dakiemtra"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByIdNvXacminh", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.idNvXacminh = :idNvXacminh"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByNgayUpdate", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.ngayUpdate = :ngayUpdate"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByNgayXoaphieu", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.ngayXoaphieu = :ngayXoaphieu"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByNgayKiemtra", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.ngayKiemtra = :ngayKiemtra"),
    @NamedQuery(name = "VwXemdulieutkMaster.findBySolanin", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.solanin = :solanin"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByNhapho", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.nhapho = :nhapho"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByHoten1", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.hoten1 = :hoten1"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByGiaytoHoten1", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.giaytoHoten1 = :giaytoHoten1"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByHoten2", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.hoten2 = :hoten2"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByGiaytoHoten2", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.giaytoHoten2 = :giaytoHoten2"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByGhichuGoi", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.ghichuGoi = :ghichuGoi"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByIdNvDuyetChuyencn", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.idNvDuyetChuyencn = :idNvDuyetChuyencn"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByIdNvYcChuyencn", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.idNvYcChuyencn = :idNvYcChuyencn"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByNgayChuyencn", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.ngayChuyencn = :ngayChuyencn"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByNgayYeucauChuyencn", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.ngayYeucauChuyencn = :ngayYeucauChuyencn"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByLydoUpdate", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.lydoUpdate = :lydoUpdate"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByLydoYcChuyencn", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.lydoYcChuyencn = :lydoYcChuyencn"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByDienthoaiGoc", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.dienthoaiGoc = :dienthoaiGoc"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByDiachiGoc", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.diachiGoc = :diachiGoc"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByIdNoicap", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.idNoicap = :idNoicap"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByNoicapName", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.noicapName = :noicapName"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByIdBank", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.idBank = :idBank"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByBankName", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.bankName = :bankName"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByDotck", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.dotck = :dotck"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByDack", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.dack = :dack"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByIdNvCk", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.idNvCk = :idNvCk"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByNgayCk", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.ngayCk = :ngayCk"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByCkTienmat", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.ckTienmat = :ckTienmat"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByIdNvDuyetCtck", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.idNvDuyetCtck = :idNvDuyetCtck"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByNgayXnck", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.ngayXnck = :ngayXnck"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByNgayxacnhan", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.ngayxacnhan = :ngayxacnhan"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByXacnhanCk", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.xacnhanCk = :xacnhanCk"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByGhichuCk", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.ghichuCk = :ghichuCk"),
    @NamedQuery(name = "VwXemdulieutkMaster.findBySotaikhoankh", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.sotaikhoankh = :sotaikhoankh"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByNoinhantien", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.noinhantien = :noinhantien"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByUserId", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.userId = :userId"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByMaKhachhang", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.maKhachhang = :maKhachhang"),
    @NamedQuery(name = "VwXemdulieutkMaster.findByDachitra", query = "SELECT v FROM VwXemdulieutkMaster v WHERE v.dachitra = :dachitra")})
public class VwXemdulieutkMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 80)
    @Column(name = "ID_CODE")
    @Id
    private String idCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "HOTEN")
    private String hoten;
    @Size(max = 4000)
    @Column(name = "HOTEN_XULY")
    private String hotenXuly;
    @Size(max = 40)
    @Column(name = "DIENTHOAI")
    private String dienthoai;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "MA_NGUOINHAN")
    private String maNguoinhan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ID_CHINHANH")
    private String idChinhanh;
    @Size(max = 4000)
    @Column(name = "CHINHANH_NAME")
    private String chinhanhName;
    @Size(max = 20)
    @Column(name = "ID_DOITAC")
    private String idDoitac;
    @Size(max = 4000)
    @Column(name = "DOITAC_NAME")
    private String doitacName;
    @Column(name = "SOBN")
    private Long sobn;
    @Size(max = 40)
    @Column(name = "GIAYTO_HOTEN")
    private String giaytoHoten;
    @Size(max = 40)
    @Column(name = "PAYAGENTSEQ")
    private String payagentseq;
    @Size(max = 40)
    @Column(name = "AGENT")
    private String agent;
    @Size(max = 40)
    @Column(name = "ID_AGENT")
    private String idAgent;
    @Size(max = 40)
    @Column(name = "PIN_NO")
    private String pinNo;
    @Column(name = "NGAY_NHAPLIEU")
    @Temporal(TemporalType.DATE)
    private Date ngayNhaplieu;
    @Size(max = 60)
    @Column(name = "MABIENNHAN")
    private String mabiennhan;
    @Column(name = "NGAY_CHITRA")
    @Temporal(TemporalType.DATE)
    private Date ngayChitra;
    @Size(max = 150)
    @Column(name = "DIACHI")
    private String diachi;
    @Size(max = 20)
    @Column(name = "ID_CT_TUYTHAN")
    private String idCtTuythan;
    @Size(max = 20)
    @Column(name = "SO_CT_TUYTHAN")
    private String soCtTuythan;
    @Column(name = "NGAYCAP")
    @Temporal(TemporalType.DATE)
    private Date ngaycap;
    @Column(name = "NGAY_CHITRA_TRUE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayChitraTrue;
    @Size(max = 20)
    @Column(name = "ID_NV_CHITRA")
    private String idNvChitra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ID_DIADIEMCHITRA")
    private String idDiadiemchitra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "SOPHIEU")
    private String sophieu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STT")
    private BigInteger stt;
    @Size(max = 60)
    @Column(name = "NGUOIGOI")
    private String nguoigoi;
    @Size(max = 1)
    @Column(name = "BIENNHAN_C")
    private String biennhanC;
    @Size(max = 1)
    @Column(name = "BIENNHAN")
    private String biennhan;
    @Column(name = "SOLANDICHITRA")
    private BigInteger solandichitra;
    @Column(name = "DANHANPHIEU")
    private Character danhanphieu;
    @Size(max = 4000)
    @Column(name = "LOAIGIAYTO")
    private String loaigiayto;
    @Size(max = 60)
    @Column(name = "NGUOIGOI_1")
    private String nguoigoi1;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SOTIENGOI")
    private BigDecimal sotiengoi;
    @Column(name = "TYGIA")
    private BigDecimal tygia;
    @Column(name = "THANHTIEN")
    private BigDecimal thanhtien;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ID_LOAITIENCHITRA")
    private String idLoaitienchitra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ID_LOAITIENGOI")
    private String idLoaitiengoi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ID_LOAICONGNO")
    private String idLoaicongno;
    @Size(max = 20)
    @Column(name = "ID_CITY")
    private String idCity;
    @Size(max = 4000)
    @Column(name = "CITY_NAME")
    private String cityName;
    @Size(max = 20)
    @Column(name = "ID_NV_BAOCAO")
    private String idNvBaocao;
    @Size(max = 20)
    @Column(name = "ID_NV_XACNHAN")
    private String idNvXacnhan;
    @Size(max = 20)
    @Column(name = "ID_NV_BIENNHAN")
    private String idNvBiennhan;
    @Size(max = 100)
    @Column(name = "KHACHHANG_NHAN")
    private String khachhangNhan;
    @Size(max = 60)
    @Column(name = "XACMINH")
    private String xacminh;
    @Size(max = 400)
    @Column(name = "GHICHU")
    private String ghichu;
    @Size(max = 1000)
    @Column(name = "LYDO_XMNK")
    private String lydoXmnk;
    @Size(max = 20)
    @Column(name = "ID_NV_NHAPLIEU")
    private String idNvNhaplieu;
    @Size(max = 20)
    @Column(name = "ID_NV_TRUYENFILE")
    private String idNvTruyenfile;
    @Column(name = "DATE_TRUYENFILE")
    @Temporal(TemporalType.DATE)
    private Date dateTruyenfile;
    @Size(max = 20)
    @Column(name = "ID_NV_UPDATE")
    private String idNvUpdate;
    @Size(max = 20)
    @Column(name = "ID_NV_XOAPHIEU")
    private String idNvXoaphieu;
    @Size(max = 100)
    @Column(name = "LYDOXOAPHIEU")
    private String lydoxoaphieu;
    @Size(max = 20)
    @Column(name = "ID_NV_KT")
    private String idNvKt;
    @Size(max = 20)
    @Column(name = "ID_THANHTOAN")
    private String idThanhtoan;
    @Size(max = 1)
    @Column(name = "CONGTACVIEN")
    private String congtacvien;
    @Size(max = 40)
    @Column(name = "EXT_ORDER")
    private String extOrder;
    @Size(max = 20)
    @Column(name = "ID_DISTRICT")
    private String idDistrict;
    @Size(max = 4000)
    @Column(name = "DISTRICT_NAME")
    private String districtName;
    @Column(name = "NGAY_BIENNHAN")
    @Temporal(TemporalType.DATE)
    private Date ngayBiennhan;
    @Column(name = "NGAY_XACMINH")
    @Temporal(TemporalType.DATE)
    private Date ngayXacminh;
    @Column(name = "NGAYGIAOPHIEU")
    @Temporal(TemporalType.DATE)
    private Date ngaygiaophieu;
    @Size(max = 1)
    @Column(name = "DAKIEMTRA")
    private String dakiemtra;
    @Size(max = 20)
    @Column(name = "ID_NV_XACMINH")
    private String idNvXacminh;
    @Size(max = 20)
    @Column(name = "NGAY_UPDATE")
    private String ngayUpdate;
    @Column(name = "NGAY_XOAPHIEU")
    @Temporal(TemporalType.DATE)
    private Date ngayXoaphieu;
    @Column(name = "NGAY_KIEMTRA")
    @Temporal(TemporalType.DATE)
    private Date ngayKiemtra;
    @Column(name = "SOLANIN")
    private BigInteger solanin;
    @Size(max = 1)
    @Column(name = "NHAPHO")
    private String nhapho;
    @Size(max = 100)
    @Column(name = "HOTEN_1")
    private String hoten1;
    @Size(max = 40)
    @Column(name = "GIAYTO_HOTEN_1")
    private String giaytoHoten1;
    @Size(max = 100)
    @Column(name = "HOTEN_2")
    private String hoten2;
    @Size(max = 40)
    @Column(name = "GIAYTO_HOTEN_2")
    private String giaytoHoten2;
    @Size(max = 400)
    @Column(name = "GHICHU_GOI")
    private String ghichuGoi;
    @Size(max = 20)
    @Column(name = "ID_NV_DUYET_CHUYENCN")
    private String idNvDuyetChuyencn;
    @Size(max = 20)
    @Column(name = "ID_NV_YC_CHUYENCN")
    private String idNvYcChuyencn;
    @Column(name = "NGAY_CHUYENCN")
    @Temporal(TemporalType.DATE)
    private Date ngayChuyencn;
    @Column(name = "NGAY_YEUCAU_CHUYENCN")
    @Temporal(TemporalType.DATE)
    private Date ngayYeucauChuyencn;
    @Size(max = 1000)
    @Column(name = "LYDO_UPDATE")
    private String lydoUpdate;
    @Size(max = 500)
    @Column(name = "LYDO_YC_CHUYENCN")
    private String lydoYcChuyencn;
    @Size(max = 50)
    @Column(name = "DIENTHOAI_GOC")
    private String dienthoaiGoc;
    @Size(max = 500)
    @Column(name = "DIACHI_GOC")
    private String diachiGoc;
    @Size(max = 20)
    @Column(name = "ID_NOICAP")
    private String idNoicap;
    @Size(max = 4000)
    @Column(name = "NOICAP_NAME")
    private String noicapName;
    @Size(max = 20)
    @Column(name = "ID_BANK")
    private String idBank;
    @Size(max = 4000)
    @Column(name = "BANK_NAME")
    private String bankName;
    @Column(name = "DOTCK")
    private BigInteger dotck;
    @Size(max = 1)
    @Column(name = "DACK")
    private String dack;
    @Size(max = 20)
    @Column(name = "ID_NV_CK")
    private String idNvCk;
    @Column(name = "NGAY_CK")
    @Temporal(TemporalType.DATE)
    private Date ngayCk;
    @Size(max = 1)
    @Column(name = "CK_TIENMAT")
    private String ckTienmat;
    @Size(max = 20)
    @Column(name = "ID_NV_DUYET_CTCK")
    private String idNvDuyetCtck;
    @Column(name = "NGAY_XNCK")
    @Temporal(TemporalType.DATE)
    private Date ngayXnck;
    @Column(name = "NGAYXACNHAN")
    @Temporal(TemporalType.DATE)
    private Date ngayxacnhan;
    @Size(max = 1)
    @Column(name = "XACNHAN_CK")
    private String xacnhanCk;
    @Size(max = 1000)
    @Column(name = "GHICHU_CK")
    private String ghichuCk;
    @Size(max = 50)
    @Column(name = "SOTAIKHOANKH")
    private String sotaikhoankh;
    @Size(max = 5)
    @Column(name = "NOINHANTIEN")
    private String noinhantien;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "USER_ID")
    private String userId;
    @Size(max = 40)
    @Column(name = "MA_KHACHHANG")
    private String maKhachhang;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DACHITRA")
    private Character dachitra;

    public VwXemdulieutkMaster() {
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getHotenXuly() {
        return hotenXuly;
    }

    public void setHotenXuly(String hotenXuly) {
        this.hotenXuly = hotenXuly;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public String getMaNguoinhan() {
        return maNguoinhan;
    }

    public void setMaNguoinhan(String maNguoinhan) {
        this.maNguoinhan = maNguoinhan;
    }

    public String getIdChinhanh() {
        return idChinhanh;
    }

    public void setIdChinhanh(String idChinhanh) {
        this.idChinhanh = idChinhanh;
    }

    public String getChinhanhName() {
        return chinhanhName;
    }

    public void setChinhanhName(String chinhanhName) {
        this.chinhanhName = chinhanhName;
    }

    public String getIdDoitac() {
        return idDoitac;
    }

    public void setIdDoitac(String idDoitac) {
        this.idDoitac = idDoitac;
    }

    public String getDoitacName() {
        return doitacName;
    }

    public void setDoitacName(String doitacName) {
        this.doitacName = doitacName;
    }

    public Long getSobn() {
        return sobn;
    }

    public void setSobn(Long sobn) {
        this.sobn = sobn;
    }

    public String getGiaytoHoten() {
        return giaytoHoten;
    }

    public void setGiaytoHoten(String giaytoHoten) {
        this.giaytoHoten = giaytoHoten;
    }

    public String getPayagentseq() {
        return payagentseq;
    }

    public void setPayagentseq(String payagentseq) {
        this.payagentseq = payagentseq;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(String idAgent) {
        this.idAgent = idAgent;
    }

    public String getPinNo() {
        return pinNo;
    }

    public void setPinNo(String pinNo) {
        this.pinNo = pinNo;
    }

    public Date getNgayNhaplieu() {
        return ngayNhaplieu;
    }

    public void setNgayNhaplieu(Date ngayNhaplieu) {
        this.ngayNhaplieu = ngayNhaplieu;
    }

    public String getMabiennhan() {
        return mabiennhan;
    }

    public void setMabiennhan(String mabiennhan) {
        this.mabiennhan = mabiennhan;
    }

    public Date getNgayChitra() {
        return ngayChitra;
    }

    public void setNgayChitra(Date ngayChitra) {
        this.ngayChitra = ngayChitra;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getIdCtTuythan() {
        return idCtTuythan;
    }

    public void setIdCtTuythan(String idCtTuythan) {
        this.idCtTuythan = idCtTuythan;
    }

    public String getSoCtTuythan() {
        return soCtTuythan;
    }

    public void setSoCtTuythan(String soCtTuythan) {
        this.soCtTuythan = soCtTuythan;
    }

    public Date getNgaycap() {
        return ngaycap;
    }

    public void setNgaycap(Date ngaycap) {
        this.ngaycap = ngaycap;
    }

    public Date getNgayChitraTrue() {
        return ngayChitraTrue;
    }

    public void setNgayChitraTrue(Date ngayChitraTrue) {
        this.ngayChitraTrue = ngayChitraTrue;
    }

    public String getIdNvChitra() {
        return idNvChitra;
    }

    public void setIdNvChitra(String idNvChitra) {
        this.idNvChitra = idNvChitra;
    }

    public String getIdDiadiemchitra() {
        return idDiadiemchitra;
    }

    public void setIdDiadiemchitra(String idDiadiemchitra) {
        this.idDiadiemchitra = idDiadiemchitra;
    }

    public String getSophieu() {
        return sophieu;
    }

    public void setSophieu(String sophieu) {
        this.sophieu = sophieu;
    }

    public BigInteger getStt() {
        return stt;
    }

    public void setStt(BigInteger stt) {
        this.stt = stt;
    }

    public String getNguoigoi() {
        return nguoigoi;
    }

    public void setNguoigoi(String nguoigoi) {
        this.nguoigoi = nguoigoi;
    }

    public String getBiennhanC() {
        return biennhanC;
    }

    public void setBiennhanC(String biennhanC) {
        this.biennhanC = biennhanC;
    }

    public String getBiennhan() {
        return biennhan;
    }

    public void setBiennhan(String biennhan) {
        this.biennhan = biennhan;
    }

    public BigInteger getSolandichitra() {
        return solandichitra;
    }

    public void setSolandichitra(BigInteger solandichitra) {
        this.solandichitra = solandichitra;
    }

    public Character getDanhanphieu() {
        return danhanphieu;
    }

    public void setDanhanphieu(Character danhanphieu) {
        this.danhanphieu = danhanphieu;
    }

    public String getLoaigiayto() {
        return loaigiayto;
    }

    public void setLoaigiayto(String loaigiayto) {
        this.loaigiayto = loaigiayto;
    }

    public String getNguoigoi1() {
        return nguoigoi1;
    }

    public void setNguoigoi1(String nguoigoi1) {
        this.nguoigoi1 = nguoigoi1;
    }

    public BigDecimal getSotiengoi() {
        return sotiengoi;
    }

    public void setSotiengoi(BigDecimal sotiengoi) {
        this.sotiengoi = sotiengoi;
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

    public String getIdLoaitienchitra() {
        return idLoaitienchitra;
    }

    public void setIdLoaitienchitra(String idLoaitienchitra) {
        this.idLoaitienchitra = idLoaitienchitra;
    }

    public String getIdLoaitiengoi() {
        return idLoaitiengoi;
    }

    public void setIdLoaitiengoi(String idLoaitiengoi) {
        this.idLoaitiengoi = idLoaitiengoi;
    }

    public String getIdLoaicongno() {
        return idLoaicongno;
    }

    public void setIdLoaicongno(String idLoaicongno) {
        this.idLoaicongno = idLoaicongno;
    }

    public String getIdCity() {
        return idCity;
    }

    public void setIdCity(String idCity) {
        this.idCity = idCity;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getIdNvBaocao() {
        return idNvBaocao;
    }

    public void setIdNvBaocao(String idNvBaocao) {
        this.idNvBaocao = idNvBaocao;
    }

    public String getIdNvXacnhan() {
        return idNvXacnhan;
    }

    public void setIdNvXacnhan(String idNvXacnhan) {
        this.idNvXacnhan = idNvXacnhan;
    }

    public String getIdNvBiennhan() {
        return idNvBiennhan;
    }

    public void setIdNvBiennhan(String idNvBiennhan) {
        this.idNvBiennhan = idNvBiennhan;
    }

    public String getKhachhangNhan() {
        return khachhangNhan;
    }

    public void setKhachhangNhan(String khachhangNhan) {
        this.khachhangNhan = khachhangNhan;
    }

    public String getXacminh() {
        return xacminh;
    }

    public void setXacminh(String xacminh) {
        this.xacminh = xacminh;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getLydoXmnk() {
        return lydoXmnk;
    }

    public void setLydoXmnk(String lydoXmnk) {
        this.lydoXmnk = lydoXmnk;
    }

    public String getIdNvNhaplieu() {
        return idNvNhaplieu;
    }

    public void setIdNvNhaplieu(String idNvNhaplieu) {
        this.idNvNhaplieu = idNvNhaplieu;
    }

    public String getIdNvTruyenfile() {
        return idNvTruyenfile;
    }

    public void setIdNvTruyenfile(String idNvTruyenfile) {
        this.idNvTruyenfile = idNvTruyenfile;
    }

    public Date getDateTruyenfile() {
        return dateTruyenfile;
    }

    public void setDateTruyenfile(Date dateTruyenfile) {
        this.dateTruyenfile = dateTruyenfile;
    }

    public String getIdNvUpdate() {
        return idNvUpdate;
    }

    public void setIdNvUpdate(String idNvUpdate) {
        this.idNvUpdate = idNvUpdate;
    }

    public String getIdNvXoaphieu() {
        return idNvXoaphieu;
    }

    public void setIdNvXoaphieu(String idNvXoaphieu) {
        this.idNvXoaphieu = idNvXoaphieu;
    }

    public String getLydoxoaphieu() {
        return lydoxoaphieu;
    }

    public void setLydoxoaphieu(String lydoxoaphieu) {
        this.lydoxoaphieu = lydoxoaphieu;
    }

    public String getIdNvKt() {
        return idNvKt;
    }

    public void setIdNvKt(String idNvKt) {
        this.idNvKt = idNvKt;
    }

    public String getIdThanhtoan() {
        return idThanhtoan;
    }

    public void setIdThanhtoan(String idThanhtoan) {
        this.idThanhtoan = idThanhtoan;
    }

    public String getCongtacvien() {
        return congtacvien;
    }

    public void setCongtacvien(String congtacvien) {
        this.congtacvien = congtacvien;
    }

    public String getExtOrder() {
        return extOrder;
    }

    public void setExtOrder(String extOrder) {
        this.extOrder = extOrder;
    }

    public String getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(String idDistrict) {
        this.idDistrict = idDistrict;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Date getNgayBiennhan() {
        return ngayBiennhan;
    }

    public void setNgayBiennhan(Date ngayBiennhan) {
        this.ngayBiennhan = ngayBiennhan;
    }

    public Date getNgayXacminh() {
        return ngayXacminh;
    }

    public void setNgayXacminh(Date ngayXacminh) {
        this.ngayXacminh = ngayXacminh;
    }

    public Date getNgaygiaophieu() {
        return ngaygiaophieu;
    }

    public void setNgaygiaophieu(Date ngaygiaophieu) {
        this.ngaygiaophieu = ngaygiaophieu;
    }

    public String getDakiemtra() {
        return dakiemtra;
    }

    public void setDakiemtra(String dakiemtra) {
        this.dakiemtra = dakiemtra;
    }

    public String getIdNvXacminh() {
        return idNvXacminh;
    }

    public void setIdNvXacminh(String idNvXacminh) {
        this.idNvXacminh = idNvXacminh;
    }

    public String getNgayUpdate() {
        return ngayUpdate;
    }

    public void setNgayUpdate(String ngayUpdate) {
        this.ngayUpdate = ngayUpdate;
    }

    public Date getNgayXoaphieu() {
        return ngayXoaphieu;
    }

    public void setNgayXoaphieu(Date ngayXoaphieu) {
        this.ngayXoaphieu = ngayXoaphieu;
    }

    public Date getNgayKiemtra() {
        return ngayKiemtra;
    }

    public void setNgayKiemtra(Date ngayKiemtra) {
        this.ngayKiemtra = ngayKiemtra;
    }

    public BigInteger getSolanin() {
        return solanin;
    }

    public void setSolanin(BigInteger solanin) {
        this.solanin = solanin;
    }

    public String getNhapho() {
        return nhapho;
    }

    public void setNhapho(String nhapho) {
        this.nhapho = nhapho;
    }

    public String getHoten1() {
        return hoten1;
    }

    public void setHoten1(String hoten1) {
        this.hoten1 = hoten1;
    }

    public String getGiaytoHoten1() {
        return giaytoHoten1;
    }

    public void setGiaytoHoten1(String giaytoHoten1) {
        this.giaytoHoten1 = giaytoHoten1;
    }

    public String getHoten2() {
        return hoten2;
    }

    public void setHoten2(String hoten2) {
        this.hoten2 = hoten2;
    }

    public String getGiaytoHoten2() {
        return giaytoHoten2;
    }

    public void setGiaytoHoten2(String giaytoHoten2) {
        this.giaytoHoten2 = giaytoHoten2;
    }

    public String getGhichuGoi() {
        return ghichuGoi;
    }

    public void setGhichuGoi(String ghichuGoi) {
        this.ghichuGoi = ghichuGoi;
    }

    public String getIdNvDuyetChuyencn() {
        return idNvDuyetChuyencn;
    }

    public void setIdNvDuyetChuyencn(String idNvDuyetChuyencn) {
        this.idNvDuyetChuyencn = idNvDuyetChuyencn;
    }

    public String getIdNvYcChuyencn() {
        return idNvYcChuyencn;
    }

    public void setIdNvYcChuyencn(String idNvYcChuyencn) {
        this.idNvYcChuyencn = idNvYcChuyencn;
    }

    public Date getNgayChuyencn() {
        return ngayChuyencn;
    }

    public void setNgayChuyencn(Date ngayChuyencn) {
        this.ngayChuyencn = ngayChuyencn;
    }

    public Date getNgayYeucauChuyencn() {
        return ngayYeucauChuyencn;
    }

    public void setNgayYeucauChuyencn(Date ngayYeucauChuyencn) {
        this.ngayYeucauChuyencn = ngayYeucauChuyencn;
    }

    public String getLydoUpdate() {
        return lydoUpdate;
    }

    public void setLydoUpdate(String lydoUpdate) {
        this.lydoUpdate = lydoUpdate;
    }

    public String getLydoYcChuyencn() {
        return lydoYcChuyencn;
    }

    public void setLydoYcChuyencn(String lydoYcChuyencn) {
        this.lydoYcChuyencn = lydoYcChuyencn;
    }

    public String getDienthoaiGoc() {
        return dienthoaiGoc;
    }

    public void setDienthoaiGoc(String dienthoaiGoc) {
        this.dienthoaiGoc = dienthoaiGoc;
    }

    public String getDiachiGoc() {
        return diachiGoc;
    }

    public void setDiachiGoc(String diachiGoc) {
        this.diachiGoc = diachiGoc;
    }

    public String getIdNoicap() {
        return idNoicap;
    }

    public void setIdNoicap(String idNoicap) {
        this.idNoicap = idNoicap;
    }

    public String getNoicapName() {
        return noicapName;
    }

    public void setNoicapName(String noicapName) {
        this.noicapName = noicapName;
    }

    public String getIdBank() {
        return idBank;
    }

    public void setIdBank(String idBank) {
        this.idBank = idBank;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public BigInteger getDotck() {
        return dotck;
    }

    public void setDotck(BigInteger dotck) {
        this.dotck = dotck;
    }

    public String getDack() {
        return dack;
    }

    public void setDack(String dack) {
        this.dack = dack;
    }

    public String getIdNvCk() {
        return idNvCk;
    }

    public void setIdNvCk(String idNvCk) {
        this.idNvCk = idNvCk;
    }

    public Date getNgayCk() {
        return ngayCk;
    }

    public void setNgayCk(Date ngayCk) {
        this.ngayCk = ngayCk;
    }

    public String getCkTienmat() {
        return ckTienmat;
    }

    public void setCkTienmat(String ckTienmat) {
        this.ckTienmat = ckTienmat;
    }

    public String getIdNvDuyetCtck() {
        return idNvDuyetCtck;
    }

    public void setIdNvDuyetCtck(String idNvDuyetCtck) {
        this.idNvDuyetCtck = idNvDuyetCtck;
    }

    public Date getNgayXnck() {
        return ngayXnck;
    }

    public void setNgayXnck(Date ngayXnck) {
        this.ngayXnck = ngayXnck;
    }

    public Date getNgayxacnhan() {
        return ngayxacnhan;
    }

    public void setNgayxacnhan(Date ngayxacnhan) {
        this.ngayxacnhan = ngayxacnhan;
    }

    public String getXacnhanCk() {
        return xacnhanCk;
    }

    public void setXacnhanCk(String xacnhanCk) {
        this.xacnhanCk = xacnhanCk;
    }

    public String getGhichuCk() {
        return ghichuCk;
    }

    public void setGhichuCk(String ghichuCk) {
        this.ghichuCk = ghichuCk;
    }

    public String getSotaikhoankh() {
        return sotaikhoankh;
    }

    public void setSotaikhoankh(String sotaikhoankh) {
        this.sotaikhoankh = sotaikhoankh;
    }

    public String getNoinhantien() {
        return noinhantien;
    }

    public void setNoinhantien(String noinhantien) {
        this.noinhantien = noinhantien;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMaKhachhang() {
        return maKhachhang;
    }

    public void setMaKhachhang(String maKhachhang) {
        this.maKhachhang = maKhachhang;
    }

    public Character getDachitra() {
        return dachitra;
    }

    public void setDachitra(Character dachitra) {
        this.dachitra = dachitra;
    }
    
}
