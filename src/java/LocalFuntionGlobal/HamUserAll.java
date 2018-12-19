 
package LocalFuntionGlobal;

import EntitiesBean.VwDmQuanlydotImagetongWeb;
import EntitiesBean.VwDmQuanlydotimagectietWeb;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageDecoder;
import com.sun.media.jai.codec.TIFFDecodeParam;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.RenderedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import LocalModel.ChinhanhList;
import EntitiesBean.VwTondongNvAllWeb;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import ConnectBean.ConnectionProvider;
import ConnectBean.Provider;
import static ConnectBean.Provider.LINKAPIKHACHHANGBASIC;
import DatabaseDao.ChinhanhlistDao;
import DatabaseDao.ImageDao;
import EntitiesBean.SmtbDanhmucList;
import EntitiesBean.VwDsUploadImagehbWeb;
import EntitiesBean.VwGiaodichHoibaomobileNvall;
import java.io.ByteArrayInputStream;
import static java.lang.System.out;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.model.UploadedFile;



 
public class HamUserAll {
    
   
 public static List<VwDmQuanlydotImagetongWeb> dshoibaotheonhanvien(String user,String trangthai) {
        
        
 
                return null;
       
         
 
    }
 

 public static List<VwDmQuanlydotImagetongWeb> dstheonhanvienmobile2018(String user,String trangthai) {
        
        try {
            
            List<VwDmQuanlydotImagetongWeb> dsKq=new ArrayList<>();
       
           // ConnectionProvider.reconnectdbastatic();
            Connection con=ConnectionProvider.getCon();
            
            // Tạo một câu SQL có 1 tham số (?)
            String  sql = "select * from KH.VW_GIAODICH_THEODOTHB_2018 WHERE MARKER_ID=? AND KIEMTRA=?";
            
            // Tạo một đối tượng PreparedStatement.
            PreparedStatement pstm = con.prepareStatement(sql);
            
            // Sét đặt giá trị tham số thứ nhất (Dấu ? thứ nhất)        
            pstm.setString(1, user);
            pstm.setString(2, trangthai);
            
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) { 
              VwDmQuanlydotImagetongWeb dataClass = new VwDmQuanlydotImagetongWeb();
              dataClass.setIdcode(rs.getString("IDCODE"));
              dataClass.setMarkerId(rs.getString("MARKER_ID"));
              dataClass.setIderror(rs.getString("IDERROR"));
              dataClass.setDotbn(rs.getString("DOTBN"));
              dataClass.setDateModified(rs.getDate("DATE_MODIFIED"));
              dataClass.setShs(rs.getBigDecimal("SHS"));
              dataClass.setKiemtra(rs.getString("KIEMTRA"));
              dataClass.setDeserror(rs.getString("DESERROR"));
              dsKq.add(dataClass);
            }
            pstm.close();
            return dsKq;
            
        } catch (SQLException ex) {

             Logger.getLogger(HamUserAll.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }
         
 
    }
     
 
  public static List<VwDmQuanlydotimagectietWeb> dshoibaochitiet2018(String dotbn,String ider) {
        
        try {
            
            List<VwDmQuanlydotimagectietWeb> dsKq=new ArrayList<>();
       
           // ConnectionProvider.reconnectdbastatic();
            Connection con=ConnectionProvider.getCon();
            
            // Tạo một câu SQL có 1 tham số (?)
            String  sql = "select * from KH.VW_GIAODICH_UPLOAD_2018 WHERE KHOATONG=?  ";
            
            // Tạo một đối tượng PreparedStatement.
            PreparedStatement pstm = con.prepareStatement(sql);
            
            // Sét đặt giá trị tham số thứ nhất (Dấu ? thứ nhất)        
            pstm.setString(1, dotbn);
            
            
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) { 
              VwDmQuanlydotimagectietWeb dataClass = new VwDmQuanlydotimagectietWeb();
              dataClass.setKhoa(rs.getString("KHOA"));
              dataClass.setHoten(rs.getString("HOTEN"));
              dataClass.setMarkerId(rs.getString("MARKER_ID"));
              dataClass.setIderror(rs.getString("IDERROR"));
              dataClass.setDotbn(rs.getString("DOTBN"));
              dataClass.setDateModified(rs.getDate("DATE_MODIFIED"));
              dataClass.setKhoatong(rs.getString("KHOATONG"));
              dataClass.setKiemtra(rs.getString("KIEMTRA"));
              dataClass.setDeserror(rs.getString("DESERROR"));
              dataClass.setIdCtTuythan(rs.getString("ID_CT_TUYTHAN"));
              dataClass.setSoCtTuythan(rs.getString("SO_CT_TUYTHAN"));
              dataClass.setMaNguoinhan(rs.getString("MA_NGUOINHAN"));
              dataClass.setSobn(rs.getLong("SOBN"));
              dataClass.setMakhachhang(rs.getString("MAKHACHHANG"));
              dataClass.setIdnoicap(rs.getString("ID_NOICAP"));
              dataClass.setMakhachhang(rs.getString("MAKHACHHANG"));
              dataClass.setNgaycap(rs.getDate("NGAYCAP"));
              dataClass.setDkhoanthanh(rs.getString("DKHOANTHANH"));
              dataClass.setNguoigoi(rs.getString("NGUOIGOI"));
              dataClass.setNoidungxm(rs.getString("NOIDUNGXM"));
              dataClass.setFilePath(rs.getString("FILEPATH") );
           
             /* ImageDao dao= new ImageDao();
              InputStream is=dao.getimagefromServer(rs.getString("SOBN"));
              dataClass.setHinhbn(is);
              */
              // Xu ly du lieu .
             // String idcttuytha=dataClass.getIdCtTuythan() ;
              
              
              dsKq.add(dataClass);
              
              
              
            }
            pstm.close();
            
            return dsKq;
            
        } catch (SQLException ex) {

             Logger.getLogger(HamUserAll.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }
         
 
    }
     
 
 public static String scanBarcode(InputStream isa,String duoifile) throws IOException, NotFoundException, ChecksumException, FormatException {
       
             BufferedImage originalImage = null;
             try {
                if(duoifile.equalsIgnoreCase(".TIF"))
                {
                TIFFDecodeParam param = null;
                ImageDecoder dec = ImageCodec.createImageDecoder("tiff", isa, null);
                RenderedImage op = dec.decodeAsRenderedImage(0);
                HamUserAll sa =new HamUserAll();
                originalImage=sa.convertRenderedImage(op);
                }
                else{
                    
                   originalImage = ImageIO.read(isa);  
                    
                }
             } catch (Exception e) {
                 
             }
               
               
                /*float ht=(originalImage.getHeight()/3);
                int h=(Math.round(ht));
                int w=(originalImage.getWidth()- h);
                int dodai=h;*/
                
                
                BufferedImage sublImage=originalImage;//originalImage.getSubimage(w,0,dodai, h);

                LuminanceSource source = new BufferedImageLuminanceSource(sublImage, 0, 0, sublImage.getWidth(), sublImage.getHeight());
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
//           // barcode decoding
                QRCodeReader reader = new QRCodeReader();
                Result result = null;
               try 
     {
                result = reader.decode(bitmap);
          
          
     
     } 
     catch (ReaderException e) 
     {
         return "reader error";
     }
        // Tao hinh tren Server . 
         // HamUserAll hamUserAll= new HamUserAll();
         // Boolean kq = hamUserAll.storeImageServer(originalImage, result.getText());      
               
       return result.getText() ;
      }
         
    public Boolean storeImageServer(String rootpathimage,String filename, UploadedFile filein) throws IOException {

        // Lay chuoi ngay . 
        String filepath=rootpathimage+"/"+filename;
        InputStream in = filein.getInputstream();
        try {
            OutputStream out = new FileOutputStream(new File(filepath));
            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            in.close();
            out.flush();
            out.close();
        } catch (Exception e) {
        }

        return true;

    }

    
             
 public BufferedImage convertRenderedImage(RenderedImage img) {
    if (img instanceof BufferedImage) {
        return (BufferedImage)img;  
    }   
    ColorModel cm = img.getColorModel();
    int width = img.getWidth();
    int height = img.getHeight();
    WritableRaster raster = cm.createCompatibleWritableRaster(width, height);
    boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
    Hashtable properties = new Hashtable();
    String[] keys = img.getPropertyNames();
    if (keys!=null) {
        for (int i = 0; i < keys.length; i++) {
            properties.put(keys[i], img.getProperty(keys[i]));
        }
    }
    BufferedImage result = new BufferedImage(cm, raster, isAlphaPremultiplied, properties);
    img.copyData(raster);
    return result;
}
 
 public static BufferedImage thresholdImage(BufferedImage image, int threshold) {
    BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
    result.getGraphics().drawImage(image, 0, 0, null);
    WritableRaster raster = result.getRaster();
    int[] pixels = new int[image.getWidth()];
    for (int y = 0; y < image.getHeight(); y++) {
        raster.getPixels(0, y, image.getWidth(), 1, pixels);
        for (int i = 0; i < pixels.length; i++) {
            if (pixels[i] < threshold) pixels[i] = 0;
            else pixels[i] = 255;
        }
        raster.setPixels(0, y, image.getWidth(), 1, pixels);
    }
    
    return result;
}
 
 
 public Boolean moveImageServer( String filenameold,String filenameoldnew) throws IOException {
      String  rootpathimage="/var/home/imagehoibao/";
      String  rootpathimageerror="/var/home/imageerror/";
      InputStream inStream = null;
      OutputStream outStream = null;
      //String  rootpathimage="D:\\Truyenfile\\";
  
        inStream = new FileInputStream(rootpathimageerror);
    	outStream = new FileOutputStream(rootpathimage);
      
        try{

    	    File afile =new File(rootpathimageerror);
    	    File bfile =new File(rootpathimage);

    	    inStream = new FileInputStream(afile);
    	    outStream = new FileOutputStream(bfile);

    	    byte[] buffer = new byte[1024];

    	    int length;
    	    //copy the file content in bytes
    	    while ((length = inStream.read(buffer)) > 0){

    	    	outStream.write(buffer, 0, length);

    	    }

    	    inStream.close();
    	    outStream.close();

    	    //delete the original file
    	 //   afile.delete();

    	    System.out.println("File is copied successful!");
            return true; 
    	}catch(IOException e){
    	    return false; 
    	}

    }
 
    public static List<ChinhanhList> laydschinhanh() {
        List<ChinhanhList> dsChinhanhbankLists = new ArrayList<>();
        ChinhanhlistDao chinhanhListDao = new ChinhanhlistDao();
        try {
            dsChinhanhbankLists = chinhanhListDao.findOneParaString("ID_VALIDITY", "O");
        } catch (Exception e) {
        }
        return dsChinhanhbankLists;
    } 
 

      public static List<SmtbDanhmucList> laydsdanhmuc(String loaidm) {
  
 
             return null;
     
        
    } 
 
   public static List  laydslydoxm(String loaixm,String ngonngu) {
  
         
             return null;
       
    } 
      
 
     
    private static char[] SPECIAL_CHARACTERS = { 
            'À', 'Á', 'Â', 'Ã', 'È', 'É', 'Ê', 'Ì', 'Í', 'Ò',
            'Ó', 'Ô', 'Õ', 'Ù', 'Ú', 'Ý', 'à', 'á', 'â', 'ã', 'è', 'é', 'ê',
            'ì', 'í', 'ò', 'ó', 'ô', 'õ', 'ù', 'ú', 'ý', 'Ă', 'ă', 'Đ', 'đ',
            'Ĩ', 'ĩ', 'Ũ', 'ũ', 'Ơ', 'ơ', 'Ư', 'ư', 'Ạ', 'ạ', 'Ả', 'ả', 'Ấ',
            'ấ', 'Ầ', 'ầ', 'Ẩ', 'ẩ', 'Ẫ', 'ẫ', 'Ậ', 'ậ', 'Ắ', 'ắ', 'Ằ', 'ằ',
            'Ẳ', 'ẳ', 'Ẵ', 'ẵ', 'Ặ', 'ặ', 'Ẹ', 'ẹ', 'Ẻ', 'ẻ', 'Ẽ', 'ẽ', 'Ế',
            'ế', 'Ề', 'ề', 'Ể', 'ể', 'Ễ', 'ễ', 'Ệ', 'ệ', 'Ỉ', 'ỉ', 'Ị', 'ị',
            'Ọ', 'ọ', 'Ỏ', 'ỏ', 'Ố', 'ố', 'Ồ', 'ồ', 'Ổ', 'ổ', 'Ỗ', 'ỗ', 'Ộ',
            'ộ', 'Ớ', 'ớ', 'Ờ', 'ờ', 'Ở', 'ở', 'Ỡ', 'ỡ', 'Ợ', 'ợ', 'Ụ', 'ụ',
            'Ủ', 'ủ', 'Ứ', 'ứ', 'Ừ', 'ừ', 'Ử', 'ử', 'Ữ', 'ữ', 'Ự', 'ự', };
 
    private static char[] REPLACEMENTS = {  'A', 'A', 'A', 'A', 'E', 'E', 'E',
            'I', 'I', 'O', 'O', 'O', 'O', 'U', 'U', 'Y', 'a', 'a', 'a', 'a',
            'e', 'e', 'e', 'i', 'i', 'o', 'o', 'o', 'o', 'u', 'u', 'y', 'A',
            'a', 'D', 'd', 'I', 'i', 'U', 'u', 'O', 'o', 'U', 'u', 'A', 'a',
            'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A',
            'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'E', 'e', 'E', 'e',
            'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'I',
            'i', 'I', 'i', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o',
            'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O',
            'o', 'U', 'u', 'U', 'u', 'U', 'u', 'U', 'u', 'U', 'u', 'U', 'u',
            'U', 'u', };
 
    public  String toUrlFriendly(String s) {
        int maxLength = Math.min(s.length(), 236);
        char[] buffer = new char[maxLength];
        int n = 0;
        for (int i = 0; i < maxLength; i++) {
            char ch = s.charAt(i);
            buffer[n] = removeAccent(ch);
            // skip not printable characters
            if (buffer[n] > 31) {
                n++;
            }
        }
        // skip trailing slashes
        while (n > 0 && buffer[n - 1] == '/') {
            n--;
        }
        
        return String.valueOf(buffer, 0, n);
    }
 
    public static char removeAccent(char ch) {
        int index = Arrays.binarySearch(SPECIAL_CHARACTERS, ch);
        if (index >= 0) {
            ch = REPLACEMENTS[index];
        }
        return ch;
    }
     
    public static String removeAccent(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            sb.setCharAt(i, removeAccent(sb.charAt(i)));
        }
        return sb.toString();
    }
    
    
     public static List<VwTondongNvAllWeb> dsdondongchitiet(String chinhanh,String nvchitra,String loaitk) {
        
        List<VwTondongNvAllWeb> dsKq;
        dsKq = new ArrayList<VwTondongNvAllWeb>();
        ConnectionProvider.reconnectdbastatic();
        Connection con=ConnectionProvider.getCon();

        try { 
             // Tạo một câu SQL có 1 tham số (?)
            String  sql = "select * from KHOUT.VW_TONDONG_NV_ALL_WEB WHERE ID_CHINHANH=? AND ID_NV_CHITRA=?  ";
            
            // Tạo một đối tượng PreparedStatement.
            PreparedStatement pstm = con.prepareStatement(sql);
            
            // Sét đặt giá trị tham số thứ nhất (Dấu ? thứ nhất)        
            pstm.setString(1, chinhanh);
            pstm.setString(2, nvchitra);
            
            ResultSet rs = pstm.executeQuery();
            
              while (rs.next()) { 
                  
              VwTondongNvAllWeb dataClass = new VwTondongNvAllWeb();
              dataClass.setIdcode(rs.getString("IDCODE"));
              dataClass.setIdDoitac(rs.getString("ID_DOITAC"));
              dataClass.setSobn(rs.getLong("SOBN"));
              dataClass.setHoten(rs.getString("HOTEN"));
              dataClass.setMaNguoinhan(rs.getString("MA_NGUOINHAN"));
              dataClass.setIdChinhanh(rs.getString("ID_CHINHANH"));
              
              dataClass.setSophieu(rs.getString("SOPHIEU"));
              dataClass.setStt(rs.getBigDecimal("STT"));
              dataClass.setTenchinhanh(rs.getString("TENCHINHANH"));
              dataClass.setSoCtTuythan(rs.getString("ID_NV_CHITRA"));
              dataClass.setSoCtTuythan(rs.getString("HOTEN_NV"));
              dataClass.setSoCtTuythan(rs.getString("NGUOIGOI")); 
              dataClass.setSotiengoi(rs.getBigDecimal("SOTIENGOI")); 
              
              dataClass.setTygia(rs.getBigDecimal("TYGIA")); 
              dataClass.setThanhtien(rs.getBigDecimal("THANHTIEN")); 
              dataClass.setSoCtTuythan(rs.getString("SO_CT_TUYTHAN")); 
              dataClass.setDiachi(rs.getString("DIACHI")); 
              dataClass.setXacminh(rs.getString("XACMINH")); 
              dataClass.setNgayXacminh(rs.getDate("NGAY_XACMINH"));  
              dataClass.setGhichu(rs.getString("GHICHU")); 
              
              dataClass.setTenDoitac(rs.getString("TEN_DOITAC")); 
              dataClass.setIdLoaitienchitra(rs.getString("ID_LOAITIENCHITRA")); 
              dataClass.setDaxacminh(rs.getString("DAXACMINH")); 
              dataClass.setDienthoai(rs.getString("DIENTHOAI")); 
              dataClass.setCodemg(rs.getString("CODEMG"));
              dataClass.setDaxmmobile(rs.getLong("DAXMMOBILE"));
              dataClass.setNoidungxmmobile(rs.getString("NOIDUNGXMMOBILE"));
              dataClass.setQuydinhxm(rs.getString("QUYDINHXM"));
              dataClass.setHsdot3(rs.getString("HSDOT3"));
              dataClass.setQuydinhxm(rs.getString("HSDOT1"));
              dataClass.setIdQlqDottg(rs.getString("ID_QLQ_DOTTU"));
              dataClass.setIdKhachhangtt(rs.getString("ID_KHACHHANGTT"));
              dsKq.add(dataClass);
            }
            
          return dsKq;
        } catch (Exception e) {
             return null;
        }
    }
     
     public static List<VwTondongNvAllWeb> dsdondongdkienchitiet(String chinhanh,String nvchitra,String loaitk) {
        
        List<VwTondongNvAllWeb> dsKq;
        dsKq = new ArrayList<VwTondongNvAllWeb>();
        ConnectionProvider.reconnectdbastatic();
        Connection con=ConnectionProvider.getCon();

        try { 
            String subsql=null;
             // Tạo một câu SQL có 1 tham số (?)
             switch (loaitk){
                 case "HSDOT1":subsql="AND HSDOT1=?";
                 break;
                 case "HSDOT3":subsql="AND HSDOT3=?";
                 break;
             }
            String  sql = "select * from KHOUT.VW_TONDONG_NV_ALL_WEB WHERE ID_CHINHANH=? AND ID_NV_CHITRA=?" + subsql;
            
            // Tạo một đối tượng PreparedStatement.
            PreparedStatement pstm = con.prepareStatement(sql);
            
            // Sét đặt giá trị tham số thứ nhất (Dấu ? thứ nhất)        
            pstm.setString(1, chinhanh);
            pstm.setString(2, nvchitra);
            pstm.setString(3, "Y");
             
            ResultSet rs = pstm.executeQuery();
            
              while (rs.next()) { 
                  
              VwTondongNvAllWeb dataClass = new VwTondongNvAllWeb();
              dataClass.setIdcode(rs.getString("IDCODE"));
              dataClass.setIdDoitac(rs.getString("ID_DOITAC"));
              dataClass.setSobn(rs.getLong("SOBN"));
              dataClass.setHoten(rs.getString("HOTEN"));
              dataClass.setMaNguoinhan(rs.getString("MA_NGUOINHAN"));
              dataClass.setIdChinhanh(rs.getString("ID_CHINHANH"));
              
              dataClass.setSophieu(rs.getString("SOPHIEU"));
              dataClass.setStt(rs.getBigDecimal("STT"));
              dataClass.setTenchinhanh(rs.getString("TENCHINHANH"));
              dataClass.setIdNvChitra(rs.getString("ID_NV_CHITRA"));
              dataClass.setHotenNv(rs.getString("HOTEN_NV"));
              dataClass.setNguoigoi(rs.getString("NGUOIGOI")); 
              dataClass.setSotiengoi(rs.getBigDecimal("SOTIENGOI")); 
              
              dataClass.setTygia(rs.getBigDecimal("TYGIA")); 
              dataClass.setThanhtien(rs.getBigDecimal("THANHTIEN")); 
              dataClass.setSoCtTuythan(rs.getString("SO_CT_TUYTHAN")); 
              dataClass.setDiachi(rs.getString("DIACHI")); 
              dataClass.setXacminh(rs.getString("XACMINH")); 
              dataClass.setNgayXacminh(rs.getDate("NGAY_XACMINH"));  
              dataClass.setGhichu(rs.getString("GHICHU")); 
              
              dataClass.setTenDoitac(rs.getString("TEN_DOITAC")); 
              dataClass.setIdLoaitienchitra(rs.getString("ID_LOAITIENCHITRA")); 
              dataClass.setDaxacminh(rs.getString("DAXACMINH")); 
              dataClass.setDienthoai(rs.getString("DIENTHOAI")); 
              dataClass.setCodemg(rs.getString("CODEMG"));
              dataClass.setDaxmmobile(rs.getLong("DAXMMOBILE"));
              dataClass.setNoidungxmmobile(rs.getString("NOIDUNGXMMOBILE"));
              dataClass.setQuydinhxm(rs.getString("QUYDINHXM"));
              dataClass.setHsdot3(rs.getString("HSDOT3"));
              dataClass.setQuydinhxm(rs.getString("HSDOT1"));
              dataClass.setIdQlqDottg(rs.getString("ID_QLQ_DOTTU"));
              dataClass.setIdKhachhangtt(rs.getString("ID_KHACHHANGTT"));
              dsKq.add(dataClass);
            }
            
          return dsKq;
        } catch (Exception e) {
             return null;
        }
    }
 
     public static List<VwGiaodichHoibaomobileNvall> dshoibaochitiet(String chinhanh,String nvchitra,String loaitk) {
        
        List<VwGiaodichHoibaomobileNvall> dsKq;
        dsKq = new ArrayList<VwGiaodichHoibaomobileNvall>();
        
       //ConnectionProvider.reconnectdbastatic();
        Connection con=ConnectionProvider.getCon();
     
        try { 
             String subsql=null;
             // Tạo một câu SQL có 1 tham số (?)
             switch (loaitk){
                 case "HSDOT1":subsql="AND HSDOT1=?";
                 break;
                 case "HSDOT3":subsql="AND HSDOT3=?";
                 break;
             }
             
            String  sql = "select * from KHOUT.VW_HS_XACNHANMOBILE_2018 WHERE ID_CHINHANH=? AND ID_NV_CHITRA=?";
            
            // Tạo một đối tượng PreparedStatement.
            PreparedStatement pstm = con.prepareStatement(sql);
            
            // Sét đặt giá trị tham số thứ nhất (Dấu ? thứ nhất)        
            pstm.setString(1, chinhanh);
            pstm.setString(2, nvchitra);
            ResultSet rs = pstm.executeQuery();
            
             while (rs.next()) { 
                  
              VwGiaodichHoibaomobileNvall dataClass = new VwGiaodichHoibaomobileNvall();
              dataClass.setIdcode(rs.getString("IDCODE"));
              dataClass.setIdDoitac(rs.getString("ID_DOITAC"));
              dataClass.setSobn(rs.getLong("SOBN"));
              dataClass.setHoten(rs.getString("HOTEN"));
              dataClass.setMaNguoinhan(rs.getString("MA_NGUOINHAN"));
              dataClass.setIdChinhanh(rs.getString("ID_CHINHANH"));
              
              dataClass.setSophieu(rs.getString("SOPHIEU"));
              dataClass.setStt(rs.getBigDecimal("STT"));
              dataClass.setTenchinhanh(rs.getString("TENCHINHANH"));
              dataClass.setIdNvChitra(rs.getString("ID_NV_CHITRA"));
              dataClass.setHotenNv(rs.getString("HOTEN_NV"));
              dataClass.setNguoigoi(rs.getString("NGUOIGOI")); 
              dataClass.setSotiengoi(rs.getBigDecimal("SOTIENGOI")); 
              
              dataClass.setTygia(rs.getBigDecimal("TYGIA")); 
              dataClass.setThanhtien(rs.getBigDecimal("THANHTIEN")); 
              dataClass.setSoCtTuythan(rs.getString("SO_CT_TUYTHAN")); 
              dataClass.setDiachi(rs.getString("DIACHI")); 
              dataClass.setXacminh(rs.getString("XACMINH")); 
              dataClass.setNgayXacminh(rs.getDate("NGAY_XACMINH"));  
              dataClass.setGhichu(rs.getString("GHICHU")); 
              
              dataClass.setTenDoitac(rs.getString("TEN_DOITAC")); 
              dataClass.setIdLoaitienchitra(rs.getString("ID_LOAITIENCHITRA")); 
              dataClass.setDaxacminh(rs.getString("DAXACMINH")); 
              dataClass.setDienthoai(rs.getString("DIENTHOAI")); 
              dataClass.setCodemg(rs.getString("CODEMG"));
              dataClass.setDaxmmobile(rs.getLong("DAXMMOBILE"));
              dataClass.setNoidungxmmobile(rs.getString("NOIDUNGXMMOBILE"));
              dataClass.setQuydinhxm(rs.getString("QUYDINHXM"));
              dataClass.setHsdot3(rs.getString("HSDOT3"));
              dataClass.setQuydinhxm(rs.getString("HSDOT1"));
              dsKq.add(dataClass);
             }
               
          return dsKq;
        } catch (Exception e) {
             return null;
        }
    }
     
     
         
     public static  String getmacadss( ) {
         
         InetAddress ip;
   
     
     try {

		ip = InetAddress.getLocalHost();
		System.out.println("Current IP address : " + ip.getHostAddress());

		NetworkInterface network = NetworkInterface.getByInetAddress(ip);

		byte[] mac = network.getHardwareAddress();

		System.out.print("Current MAC address : ");

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
		}
		
                return sb.toString();

	} catch (UnknownHostException e) {

		return null;

	} catch (SocketException e){

		return null;


	}
     
     }

     
public static Boolean taothumuchinh(Path path){
    

       try {
                Files.createDirectories(path);
                return true;
            } catch (IOException e) {
                //fail to create directory
                e.printStackTrace();
                return false;
            }

    
}

public static  VwDsUploadImagehbWeb getchitietgdformnvandsobn2018(String maso,String loaitk) {
        
        try {
            
            VwDsUploadImagehbWeb  dsKq=new  VwDsUploadImagehbWeb();
       
            ConnectionProvider.reconnectdbastatic();
            Connection con=ConnectionProvider.getCon();
            
            // Tạo một câu SQL có 1 tham số (?)
            String sql = null ;
            switch (loaitk) {
            case "A": sql ="select * from KHOUT.VW_DS_UPLOAD_IMAGEHB_WEB WHERE SOBN=? " ;
            break;
            default   : sql ="select * from KHOUT.VW_DS_UPLOAD_IMAGEHB_WEB WHERE SOPHIEU||STT=? " ;
            break;
            }
            
            // Tạo một đối tượng PreparedStatement.
            PreparedStatement pstm = con.prepareStatement(sql);
            
            // Sét đặt giá trị tham số thứ nhất (Dấu ? thứ nhất)        
            pstm.setString(1, maso);
          
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) { 
              VwDsUploadImagehbWeb dataClass = new VwDsUploadImagehbWeb();
              String kq=rs.getString("ID_CODE");
              dataClass.setIdCode(rs.getString("ID_CODE"));
              dataClass.setIdDoitac(rs.getString("ID_DOITAC"));
              dataClass.setSobn(rs.getLong("SOBN"));
              dataClass.setHoten(rs.getString("HOTEN"));
              dataClass.setMaNguoinhan(rs.getString("MA_NGUOINHAN"));
              dataClass.setIdChinhanh(rs.getString("ID_CHINHANH"));
              dataClass.setSophieu(rs.getString("SOPHIEU"));
              dataClass.setStt(rs.getBigDecimal("STT"));
              dataClass.setBiennhanC(rs.getString("BIENNHAN_C"));
              dataClass.setSoCtTuythan(rs.getString("SO_CT_TUYTHAN"));
              try {
                   dataClass.setIdCtTuythan(rs.getString("ID_CT_TUYTHAN"));  
               } catch (Exception e) {
                   dataClass.setIdCtTuythan("001");  
               }
               try {
                   dataClass.setNgayCap(rs.getDate("NGAYCAP"));  
                } catch (Exception e) {
                }
             
              dsKq=dataClass;
            }
            pstm.close();
            return dsKq;
            
        } catch (SQLException ex) {

             Logger.getLogger(HamUserAll.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }
         
 
    }

public static  VwDsUploadImagehbWeb getbiennhanfromsobn2018(String maso) {
        
        try {
            
            VwDsUploadImagehbWeb  dsKq=new  VwDsUploadImagehbWeb();
       
            ConnectionProvider.reconnectdbastatic();
            Connection con=ConnectionProvider.getCon();
            
            // Tạo một câu SQL có 1 tham số (?)
            String  sql = "select * from KHOUT.VW_DS_UPLOAD_IMAGEHB_WEB WHERE SOBN=?  ";
            
            // Tạo một đối tượng PreparedStatement.
            PreparedStatement pstm = con.prepareStatement(sql);
            
            // Sét đặt giá trị tham số thứ nhất (Dấu ? thứ nhất)        
            pstm.setString(1, maso);
          
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) { 
              VwDsUploadImagehbWeb dataClass = new VwDsUploadImagehbWeb();
              dataClass.setIdCode(rs.getString("ID_CODE"));
              dataClass.setIdDoitac(rs.getString("ID_DOITAC"));
              dataClass.setSobn(rs.getLong("SOBN"));
              dataClass.setHoten(rs.getString("HOTEN"));
              dataClass.setMaNguoinhan(rs.getString("MA_NGUOINHAN"));
              dataClass.setIdChinhanh(rs.getString("ID_CHINHANH"));
              dataClass.setSophieu(rs.getString("SOPHIEU"));
              dataClass.setStt(rs.getBigDecimal("STT"));
              dataClass.setBiennhanC(rs.getString("BIENNHAN_C"));
              dataClass.setSoCtTuythan(rs.getString("SO_CT_TUYTHAN"));
              dataClass.setSotiengoi(rs.getBigDecimal("SOTIENGOI"));
              dataClass.setMaKhachhang(rs.getString("MA_KHACHHANG"));
              dataClass.setIdNvChitra(rs.getString("ID_NV_CHITRA"));
              dsKq=dataClass;
            }
            pstm.close();
            return dsKq;
            
        } catch (SQLException ex) {

             Logger.getLogger(HamUserAll.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }
         
 
    }

public static   InputStream   getImageToday(String khoa) {

        InputStream sImage;
        Connection con = null;
        BufferedImage bufferedImage = null;
        OutputStream outputStream = null;

        try {
           // ConnectionProvider.reconnectdbastatic();
            if(con==null)
            {
             ConnectionProvider.reconnectdbastatic();
            }
            con = ConnectionProvider.getCon();
            String id = khoa;

            byte[] imageBytes = null;

        //    String sql = "SELECT KHOA, HINH_BN FROM IMAGE_XNDOITAC where KHOA='" + id + "'";
            String sql="SELECT  HINH_BN FROM  KHOUT.DM_QUANLYIMAGE_TODAY where KHOA='"+id+"'   ";
            
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {  

                imageBytes = rs.getBytes("HINH_BN");
                

            }

            statement.close();
       
            sImage= new ByteArrayInputStream(imageBytes);
            return sImage;

        } catch (Exception e) {

            return null;
             
        }
}

public String uploadttinbiennhan(String khoa  ,String userid ,String iderror   ,String filepath  ,String dotupload  ) {

        try {
            String ketqua;
            ConnectionProvider.reconnectdbastatic();
            Connection con = ConnectionProvider.getCon();
            String fnCall = "{call ? := KH.PKS_HOIBAO_WEB_2018.XULY_UPLOAD_IMAGE(? ,?,?,?,?)}";
            CallableStatement stm = con.prepareCall(fnCall);
            stm.registerOutParameter(1, Types.VARCHAR);
            stm.setString(2, khoa);
            stm.setString(3,userid);
            stm.setString(4, iderror);
            stm.setString(5, filepath);
            stm.setString(6, dotupload);
            stm.execute();
            ketqua = (String) stm.getString(1);
            stm.close();
            con.close();
            return ketqua;

        } catch (SQLException ex) {

          //  Bean.SystemBean.proMessError(AlertCustom.timMatKetNoiMang);
            return "";

        }

    }
 

    
}
