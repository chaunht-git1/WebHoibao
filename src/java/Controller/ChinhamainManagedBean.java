 
package Controller;

import ApiFunction.ApiKhachHangDao;
import EntitiesBean.VwDmQuanlydotImagetongWeb;
import EntitiesBean.VwDmQuanlydotimagectietWeb;
import EntitiesBean.VwDsUploadImagehbWeb;
import Global.SessionBean;
import LocalFuntionGlobal.HamUserAll;
import LocalModel.Customer;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.CroppedImage;
import org.primefaces.model.UploadedFile;
import DatabaseDao.DmquanlyimageDao;
import DatabaseDao.GiaodichDao;
import DatabaseDao.ImageDao;
import DatabaseDao.KhachhangDao;
import LocalFuntionGlobal.Hamimage;
import LocalModel.HBbiennhantempToday;

 
@Named(value = "chinhamainManagedBean")
@SessionScoped
public class ChinhamainManagedBean  implements Serializable {

   //Khai bao bien don
    
    private String loaitkdulieu=null ;
    private UploadedFile file;
    private Boolean ishoibaofile=false;
    private String loaihb ;
    private String dotbn=null;
    private Integer fileno;
    private Boolean isupdatesoct=true;
    private Boolean loaiscan=false;
    private CroppedImage croppedImage;
    private String newImageName;
    private InputStream filedrop;
    private Boolean showbut=true;
    private Boolean showbutxacnhan=true;
    private String sobnerror=null;   
      private  List<VwDmQuanlydotImagetongWeb> dmQuanlydotImagetongWebs = new ArrayList<>();
      private  List<VwDmQuanlydotimagectietWeb> dmQuanlydotimagectietWebs = new ArrayList<>();
      private  List<VwDsUploadImagehbWeb> dsUploadImagehbWebs = new ArrayList<>();
      private  List<HBbiennhantempToday> bbiennhantempTodays = new ArrayList<>();
      private  VwDsUploadImagehbWeb vwDsUploadImagehbWeb = new VwDsUploadImagehbWeb();
       
    
    
 public String  taodoihoibao() {
    
      String device=SessionBean.getDeviceName();
      String userid=SessionBean.getUserId();
    //  if (device.equalsIgnoreCase("Desktop")  )
      //{
          ishoibaofile=false;
          DateFormat df = new SimpleDateFormat("MMddyyyyHHmm");
          Date today = Calendar.getInstance().getTime();        
          dotbn = df.format(today);
          fileno=0;
          return "dshshoibaonvchinhact"+ "?faces-redirect=true";
          
     // }
     /* else{
      
           FacesMessage message = new FacesMessage("Đăng nhập trên máy tính mới sử dụng được chức năng này" ,"" );
           FacesContext.getCurrentInstance().addMessage(null, message);
           return null;
 
      }
     */
    
}
 
 public String handleFileUpload(FileUploadEvent event) throws IOException, ClassNotFoundException, SQLException, NotFoundException, ChecksumException, FormatException {
        
        String chinhanh=SessionBean.getChinhanhId();
        UploadedFile filein=event.getFile();  
        String filename = filein.getFileName();
        String ext = filename.substring(filename.lastIndexOf('.'), filename.length());
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext(); 
        String webContentRoot = ec.getRealPath("/resources/tempimage/");
        String pathfileimage =null;
        String maso=HamUserAll.scanBarcode(filein.getInputstream(),ext);
        HamUserAll hamUserAll= new HamUserAll();
        String iderror=null;
        Boolean ktkq ;
        GiaodichDao giaodichDao= new GiaodichDao();
         if (maso !=null && !maso.equalsIgnoreCase("reader error") )
         {
             iderror="N";
             pathfileimage=webContentRoot ;
          
             
             String sobiennhan=giaodichDao.timkiemsobn("IDCODE",chinhanh+maso);
             filename=sobiennhan+ext;
             ktkq =hamUserAll.storeImageServer(pathfileimage, filename, filein);
             Hamimage hamimage= new Hamimage();
             Boolean kqtest=null;
             if (ktkq)
             {
               kqtest=hamimage.uploadImageFtp(pathfileimage+"/"+filename, sobiennhan);
             }
        if (kqtest ) 
        {
             String filepath=pathfileimage+"/"+filename;
             Boolean ketqua=this.capnhatthongtinupload(maso, iderror, filepath, dotbn);
     
        }
         
         }
         else{
             maso = filename.substring(1,filename.lastIndexOf('.') );      
             iderror="Y";
             pathfileimage=webContentRoot ;
             filename=filename;
             ktkq =hamUserAll.storeImageServer(pathfileimage, filename, filein);
              if (ktkq)
             {
               String filepath=pathfileimage+"/"+filename;
               Boolean ketqua=this.capnhatthongtinupload(maso, iderror, filepath, dotbn);
             
             }
         }
         
         
                 
         
         
         
 
         
//        {  
//        /* Neu file tiff phai convert */
//        String maso=HamUserAll.scanBarcode(filein.getInputstream(),ext);
//        ImageUploadModel imageUploadModel= new ImageUploadModel();
//        if (maso !=null && !maso.equalsIgnoreCase("reader error") )
//        {           
//            
//// Lay thong tin bien nhan .
//            VwDsUploadImagehbWeb imagehbWeb= HamUserAll.getchitietgdformnvandsobn2018(maso,"B");
// 
//            // Tim thong tin  tu ma so tra ve . 
//            
//             boolean kq= uploadmutilimage(filein,maso,"N",dotbn,ext,imagehbWeb);
//          
//            if (kq)
//            {
//          
//         
//            FacesMessage message = new FacesMessage(maso+ "cập nhật thành công");
//            FacesContext.getCurrentInstance().addMessage(null, message);
//            }
//            else{
//                
//               FacesMessage message = new FacesMessage(maso+ "cập nhật thất bại");
//               FacesContext.getCurrentInstance().addMessage(null, message); 
//                
//            }
//            
//
//        }
//        else{
//
//            boolean kq=  uploadmutilimage(filein,"ER"+dotbn+str,"Y",dotbn,ext,null);
//            FacesMessage message = new FacesMessage(maso+ "không có mã vạch hoặc không đọc được dữ liệu");
//            FacesContext.getCurrentInstance().addMessage(null, message);
//            
//        }

        return "dshshoibaonvchinha" + "?faces-redirect=true";
      
      
    } 

 public String handleFileUploadMobile(FileUploadEvent event) throws IOException, ClassNotFoundException, SQLException, NotFoundException, ChecksumException, FormatException {
        
        String chinhanh=SessionBean.getChinhanhId();
        UploadedFile filein=event.getFile();  
        String filename = filein.getFileName();
        String ext = filename.substring(filename.lastIndexOf('.'), filename.length());
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext(); 
        String webContentRoot = ec.getRealPath("/resources/tempimage/");
        String pathfileimage =null;
        String maso=HamUserAll.scanBarcode(filein.getInputstream(),ext);
        HamUserAll hamUserAll= new HamUserAll();
        String iderror=null;
        Boolean ktkq ;
        GiaodichDao giaodichDao= new GiaodichDao();
        if (maso != null && !maso.equalsIgnoreCase("reader error")) {
             iderror = "N";
             pathfileimage = webContentRoot;

             String sobiennhan = giaodichDao.timkiemsobn("IDCODE", chinhanh + maso);
             filename = sobiennhan + ext;
             ktkq = hamUserAll.storeImageServer(pathfileimage, filename, filein);
             Hamimage hamimage = new Hamimage();
             Boolean kqtest = null;
             if (ktkq) {
                 kqtest = hamimage.uploadImageFtp(pathfileimage + "/" + filename, sobiennhan);
             }
             if (kqtest) {
                 Boolean ketqua = this.capnhatthongtinuploadmobile(sobiennhan);
             }

         }
        else{
             maso = filename.substring(1,filename.lastIndexOf('.') );      
             iderror="Y";
             pathfileimage=webContentRoot ;
             filename=filename;
             Boolean kqtest = null;
             ktkq =hamUserAll.storeImageServer(pathfileimage, filename, filein);
             Hamimage hamimage = new Hamimage();
             if (ktkq) {
                 Boolean ketqua = this.uploadmobileerror(pathfileimage + "/" + filename,maso);
             }

            
        }          
     
  
        return null;
      
      
    }  
     
    
 public boolean capnhatthongtinupload( String maso,String iderror,String filepath,String dotbnhan ) throws IOException, ClassNotFoundException, SQLException   {
    
     String userid=SessionBean.getUserId();
     HamUserAll hamUserAll= new HamUserAll();
     String kq=hamUserAll.uploadttinbiennhan(maso, userid, iderror, filepath, dotbnhan);
    
     return true;
 
    }
 
     
 public boolean capnhatthongtinuploadmobile( String maso ) throws IOException, ClassNotFoundException, SQLException   {
    
     String userid=SessionBean.getUserId();
     HamUserAll hamUserAll= new HamUserAll();
     String kq=hamUserAll.uploadbnoutmobile(maso, userid);
    
     return true;
 
}
 
  public boolean uploadmobileerror( String filepath,String maso ) throws IOException, ClassNotFoundException, SQLException   {
    
     String userid=SessionBean.getUserId();
     HamUserAll hamUserAll= new HamUserAll();
     String kq=hamUserAll.uploadbnoutmobileerror(maso, userid,filepath);
    
     return true;
 
} 
 
 
 
  public void showthongtinhoibao(){

     //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Infosdsdsdsdsdsdsdsds", "PrimeFaces Rocks."));
    // Lay thong tin . 
      dmQuanlydotImagetongWebs= new ArrayList<>();
      String userid =SessionBean.getUserId();
      dmQuanlydotImagetongWebs=HamUserAll.dstheonhanvienmobile2018(userid,"N");
     // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tìm thấy"+dmQuanlydotImagetongWebs.size(), ""));
     
    
} 
    
  public String chuyentrangdshshoibaonvchinha(){

           return "dshshoibaonvchinha" + "?faces-redirect=true";
         
    }   
  
    public String  kiemtrabiennhan(VwDmQuanlydotImagetongWeb dmQuanlydotImagetongWeb) {
        
        
        dmQuanlydotimagectietWebs=new ArrayList<>();
        dmQuanlydotimagectietWebs=HamUserAll.dshoibaochitiet2018(dmQuanlydotImagetongWeb.getIdcode(), dmQuanlydotImagetongWeb.getIderror());
   
      if(dmQuanlydotImagetongWeb.getIderror().equalsIgnoreCase("ERROR"))
      {
          return "dshshoibaonvchinharexacnhanerror" + "?faces-redirect=true";
      }
      else if (dmQuanlydotImagetongWeb.getDeserror().equalsIgnoreCase("XM"))
      {
        
           return "dshshoibaonvchinhakiemtraxm" + "?faces-redirect=true";
       
      }
      else{
          
          return "dshshoibaonvchinhakiemtra" + "?faces-redirect=true";
          
      }
      
    
}   
    
     public String  kiemtrahoanthanh(VwDmQuanlydotImagetongWeb dmQuanlydotImagetongWeb) {
        
        
        dmQuanlydotimagectietWebs=new ArrayList<>();
        dmQuanlydotimagectietWebs=HamUserAll.dshoibaochitiet2018(dmQuanlydotImagetongWeb.getIdcode(), dmQuanlydotImagetongWeb.getIderror());
    
          return "dshshoibaohoanthanh" + "?faces-redirect=true";
     
    
}   
  
    public void kiemtragiaodich(VwDmQuanlydotimagectietWeb dmQuanlydotimagectietWe,String sobn){

     VwDmQuanlydotimagectietWeb tclass= new VwDmQuanlydotimagectietWeb();
             isupdatesoct=false;
     vwDsUploadImagehbWeb=new VwDsUploadImagehbWeb();
      int stt=dmQuanlydotimagectietWebs.indexOf(dmQuanlydotimagectietWe);
      tclass=dmQuanlydotimagectietWe;
      VwDsUploadImagehbWeb imagehbWeb=new VwDsUploadImagehbWeb();
      imagehbWeb= HamUserAll.getbiennhanfromsobn2018(dmQuanlydotimagectietWe.getSobn().toString());
      if( imagehbWeb.getIdChinhanh()!=null){
          
          vwDsUploadImagehbWeb.setHoten(imagehbWeb.getHoten());
          vwDsUploadImagehbWeb.setIdNvChitra(imagehbWeb.getIdNvChitra());
          vwDsUploadImagehbWeb.setMaNguoinhan(imagehbWeb.getMaNguoinhan());
          vwDsUploadImagehbWeb.setSotiengoi(imagehbWeb.getSotiengoi());
          vwDsUploadImagehbWeb.setIdCtTuythan(imagehbWeb.getIdCtTuythan());
          vwDsUploadImagehbWeb.setSoCtTuythan(imagehbWeb.getSoCtTuythan());
          vwDsUploadImagehbWeb.setDachitra(imagehbWeb.getDachitra());
          vwDsUploadImagehbWeb.setBiennhanC(imagehbWeb.getBiennhanC());
          vwDsUploadImagehbWeb.setSobn(imagehbWeb.getSobn());

          
          String dct=imagehbWeb.getBiennhanC().toString();
          tclass.setIdNvChitra(imagehbWeb.getIdNvChitra());
          tclass.setSoCtTuythan(imagehbWeb.getSoCtTuythan());
          tclass.setHoten(imagehbWeb.getHoten());
          dmQuanlydotimagectietWebs.set(stt, tclass);
          if (dct.equalsIgnoreCase("Y") )
          {
             isupdatesoct=true;
          }
          else
          {
             isupdatesoct= false;
          }
          
          if (imagehbWeb.getSoCtTuythan()!=null) 
          {
            this.timtheoloaigiayto(dmQuanlydotimagectietWe) ;
          }
          
      }
    
}    
      public void timtheoloaigiayto(VwDmQuanlydotimagectietWeb vdqw) {
       
         // Lay thong tin khach hang . 
          VwDmQuanlydotimagectietWeb tclass=new VwDmQuanlydotimagectietWeb();
          tclass=vdqw;      
          int stt=dmQuanlydotimagectietWebs.indexOf(vdqw);
          Customer khachhangmodel= new Customer();
          KhachhangDao khachhangDao= new KhachhangDao();
        try {
            khachhangmodel=khachhangDao.timkiemkhachhangcmnd("SOCHUNGMINH",tclass.getSoCtTuythan() );
        } catch (SQLException ex) {
            khachhangmodel=null;
        }
           if (khachhangmodel.getCustomerCode() !=null)
           {
              tclass.setNgaycap(khachhangmodel.getDateOfIssueDateValue());
              tclass.setIdnoicap(khachhangmodel.getPlaceOfIssue());
              tclass.setMakhachhang(khachhangmodel.getCustomerCode());
              dmQuanlydotimagectietWebs.set(stt, tclass);
           }  
           else{
              tclass.setNgaycap(null);
              tclass.setIdnoicap(null);
              tclass.setMakhachhang("NOVALUE");
              dmQuanlydotimagectietWebs.set(stt, tclass);
               
               
           }
 
    }
    
  public void  rexacnhanthongtinerror(VwDmQuanlydotimagectietWeb dmQuanlydotimagectietWeb) throws SQLException {
        
        String makhachhang=null;
        makhachhang=dmQuanlydotimagectietWeb.getMakhachhang();
        String khoa=dmQuanlydotimagectietWeb.getKhoa().toString();
        String soct=dmQuanlydotimagectietWeb.getSoCtTuythan().toString();
        String sobn=dmQuanlydotimagectietWeb.getSobn().toString();
        String filepath=dmQuanlydotimagectietWeb.getFilePath();
        Customer customer= new Customer();
        KhachhangDao khachhangDao= new KhachhangDao();
        if (makhachhang==null)
        {
          makhachhang="NOVALUE";
 
        }  
        else{
            
           customer=khachhangDao.timkiemkhachhangcmnd("SOCHUNGMINH",dmQuanlydotimagectietWeb.getSoCtTuythan() );
           
            if (customer.getCustomerCode()==null){
            
               makhachhang="NOVALUE";
               
            }
            else{

               makhachhang=customer.getCustomerCode();
             }
           
           
        }
 
        
        if (makhachhang.equalsIgnoreCase("NOVALUE") )  
         {
             //Tao khach hang moi
                // Tim lai bang so CMND .   
             
            
            customer.setFullname(dmQuanlydotimagectietWeb.getHoten());
            customer.setIdCardNumber(dmQuanlydotimagectietWeb.getSoCtTuythan());
            customer.setIdCardTypeCode(dmQuanlydotimagectietWeb.getIdCtTuythan());
            customer.setDateOfIssueDateValue(dmQuanlydotimagectietWeb.getNgaycap());
            customer.setPlaceOfIssue(dmQuanlydotimagectietWeb.getIdnoicap());

            makhachhang=khachhangDao.createttkh(customer, sobn);
 
         }
        
        DmquanlyimageDao dao=new DmquanlyimageDao();
        Hamimage hamimage= new Hamimage();
        Boolean ketqua=hamimage.uploadImageFtp(filepath, sobn);
        if (ketqua) 
        {
          String kq=dao.updatebiennhanerror(khoa,dmQuanlydotimagectietWeb.getIdCtTuythan(), soct,sobn,"Y",dmQuanlydotimagectietWeb.getNgaycap(),makhachhang,dmQuanlydotimagectietWeb.getIdnoicap());
          if (kq.equalsIgnoreCase("T"))  
        {    
     
            dmQuanlydotimagectietWebs.remove(dmQuanlydotimagectietWeb);
                
            FacesMessage message = new FacesMessage("Xác nhận  thành công . "  , "" );
            FacesContext.getCurrentInstance().addMessage(null, message);
         

        }
        else{
            
               FacesMessage message = new FacesMessage("Xác nhận không thành công . " +kq, "" );
               FacesContext.getCurrentInstance().addMessage(null, message);
            
          }
        }
        else{
               FacesMessage message = new FacesMessage("Không cập nhật được hình về server " , "" );
               FacesContext.getCurrentInstance().addMessage(null, message);
        }
      
      
             
 
   } 
   
     public void  capnhatcmnd(VwDmQuanlydotimagectietWeb dmQuanlydotimagectietWeb) throws SQLException {
    
       // Ma khach hang bi trong thi se tim trong bang khach hang . Neu chua co se tao khach hang moi .
        String makhachhang=dmQuanlydotimagectietWeb.getMakhachhang();
        String sobn=dmQuanlydotimagectietWeb.getSobn().toString();
        VwDmQuanlydotimagectietWeb tclass=new VwDmQuanlydotimagectietWeb();
        tclass  =dmQuanlydotimagectietWeb;     
        Customer customer= new Customer();
        KhachhangDao khachhangDao= new KhachhangDao();
        if (makhachhang==null || makhachhang.equalsIgnoreCase("NOVALUE"))
        {
           makhachhang="NOVALUE";
        }
        else{
            
           customer=khachhangDao.timkiemkhachhangcmnd("SOCHUNGMINH",dmQuanlydotimagectietWeb.getSoCtTuythan() );
         
         
            if (customer==null){

                   makhachhang="NOVALUE";
            }
            else{

                   makhachhang=customer.getCustomerCode();
            }
            }

        if (makhachhang.equalsIgnoreCase("NOVALUE") )  
         {
             //Tao khach hang moi
                // Tim lai bang so CMND .   
            
            customer.setFullname(dmQuanlydotimagectietWeb.getHoten());
            customer.setIdCardNumber(dmQuanlydotimagectietWeb.getSoCtTuythan());
            customer.setIdCardTypeCode(dmQuanlydotimagectietWeb.getIdCtTuythan());
            customer.setDateOfIssueDateValue(dmQuanlydotimagectietWeb.getNgaycap());
            customer.setPlaceOfIssue(dmQuanlydotimagectietWeb.getIdnoicap());
            makhachhang=khachhangDao.createttkh(customer, sobn);
       
         }
        
        tclass.setMakhachhang(makhachhang);
        DmquanlyimageDao dao=new DmquanlyimageDao();
        String kq=dao.updatettkhtodate(tclass, "Y");
        if (kq.equalsIgnoreCase("T"))  
        {
            
            // Cap nhat khach hang
             dmQuanlydotimagectietWebs.remove(dmQuanlydotimagectietWeb);
             FacesMessage message = new FacesMessage("Xác nhận  thành công . "  , "" );
             FacesContext.getCurrentInstance().addMessage(null, message);
        }
        
        else{
            
               FacesMessage message = new FacesMessage("Xác nhận không thành công . " +kq, "" );
               FacesContext.getCurrentInstance().addMessage(null, message);
            
        }
 

   }  
     
   public void showthongtinhbdahoanthanh(){
    
     //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Infosdsdsdsdsdsdsdsds", "PrimeFaces Rocks."));
    // Lay thong tin . 
      this.showbutxacnhan=true;
      String userid =SessionBean.getUserId();
      dmQuanlydotImagetongWebs=HamUserAll.dstheonhanvienmobile2018(userid,"Y");
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tìm thấy"+dmQuanlydotImagetongWebs.size(), ""));
     
    
}      
   
 public void showbiennhanuploaderror(){
      String userid =SessionBean.getUserId();
      GiaodichDao giaodichDao= new GiaodichDao();
      this.showbutxacnhan=true;
      bbiennhantempTodays=new ArrayList<>();
      bbiennhantempTodays=giaodichDao.dshosoerrornhanvien(userid);
}    
 
  public void  rexactinerrormobile(HBbiennhantempToday bbiennhantempToday) throws SQLException, IOException, ClassNotFoundException {
        
        String sobiennhan=bbiennhantempToday.getSobn();
        String userid=bbiennhantempToday.getMatkerid();
        String filename=bbiennhantempToday.getFilepath();
        Hamimage hamimage= new Hamimage();  
        Boolean kqtest = hamimage.uploadImageFtp(filename, sobiennhan);
   
             if (kqtest) {
                 Boolean ketqua = this.capnhatthongtinuploadmobile(sobiennhan);
             }
             bbiennhantempTodays.remove(bbiennhantempToday);
         
 
   } 
   
 
    public String getLoaitkdulieu() {
        return loaitkdulieu;
    }

    public void setLoaitkdulieu(String loaitkdulieu) {
        this.loaitkdulieu = loaitkdulieu;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Boolean getIshoibaofile() {
        return ishoibaofile;
    }

    public void setIshoibaofile(Boolean ishoibaofile) {
        this.ishoibaofile = ishoibaofile;
    }

    public String getLoaihb() {
        return loaihb;
    }

    public void setLoaihb(String loaihb) {
        this.loaihb = loaihb;
    }

    public String getDotbn() {
        return dotbn;
    }

    public void setDotbn(String dotbn) {
        this.dotbn = dotbn;
    }

    public Integer getFileno() {
        return fileno;
    }

    public void setFileno(Integer fileno) {
        this.fileno = fileno;
    }

    public Boolean getIsupdatesoct() {
        return isupdatesoct;
    }

    public void setIsupdatesoct(Boolean isupdatesoct) {
        this.isupdatesoct = isupdatesoct;
    }

    public Boolean getLoaiscan() {
        return loaiscan;
    }

    public void setLoaiscan(Boolean loaiscan) {
        this.loaiscan = loaiscan;
    }

    public CroppedImage getCroppedImage() {
        return croppedImage;
    }

    public void setCroppedImage(CroppedImage croppedImage) {
        this.croppedImage = croppedImage;
    }

    public String getNewImageName() {
        return newImageName;
    }

    public void setNewImageName(String newImageName) {
        this.newImageName = newImageName;
    }

    public InputStream getFiledrop() {
        return filedrop;
    }

    public void setFiledrop(InputStream filedrop) {
        this.filedrop = filedrop;
    }

    public Boolean getShowbut() {
        return showbut;
    }

    public void setShowbut(Boolean showbut) {
        this.showbut = showbut;
    }

    public Boolean getShowbutxacnhan() {
        return showbutxacnhan;
    }

    public void setShowbutxacnhan(Boolean showbutxacnhan) {
        this.showbutxacnhan = showbutxacnhan;
    }

    public String getSobnerror() {
        return sobnerror;
    }

    public void setSobnerror(String sobnerror) {
        this.sobnerror = sobnerror;
    }

    public List<VwDmQuanlydotImagetongWeb> getDmQuanlydotImagetongWebs() {
        return dmQuanlydotImagetongWebs;
    }

    public void setDmQuanlydotImagetongWebs(List<VwDmQuanlydotImagetongWeb> dmQuanlydotImagetongWebs) {
        this.dmQuanlydotImagetongWebs = dmQuanlydotImagetongWebs;
    }

    public List<VwDmQuanlydotimagectietWeb> getDmQuanlydotimagectietWebs() {
        return dmQuanlydotimagectietWebs;
    }

    public void setDmQuanlydotimagectietWebs(List<VwDmQuanlydotimagectietWeb> dmQuanlydotimagectietWebs) {
        this.dmQuanlydotimagectietWebs = dmQuanlydotimagectietWebs;
    }

    public List<VwDsUploadImagehbWeb> getDsUploadImagehbWebs() {
        return dsUploadImagehbWebs;
    }

    public void setDsUploadImagehbWebs(List<VwDsUploadImagehbWeb> dsUploadImagehbWebs) {
        this.dsUploadImagehbWebs = dsUploadImagehbWebs;
    }

    public VwDsUploadImagehbWeb getVwDsUploadImagehbWeb() {
        return vwDsUploadImagehbWeb;
    }

    public void setVwDsUploadImagehbWeb(VwDsUploadImagehbWeb vwDsUploadImagehbWeb) {
        this.vwDsUploadImagehbWeb = vwDsUploadImagehbWeb;
    }

    public List<HBbiennhantempToday> getBbiennhantempTodays() {
        return bbiennhantempTodays;
    }

    public void setBbiennhantempTodays(List<HBbiennhantempToday> bbiennhantempTodays) {
        this.bbiennhantempTodays = bbiennhantempTodays;
    }
    
    
    
    
    
    
    
    
    
    
    
    public ChinhamainManagedBean() {
        
        
        
    }
    
}
