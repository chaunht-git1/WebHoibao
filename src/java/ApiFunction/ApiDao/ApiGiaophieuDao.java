 
package ApiFunction.ApiDao;

 
import ApiFunction.*;
import Fun.Xulychuoi;
import LocalModel.VwDshosoCgpSumWeb;
import LocalModel.VwDshosoChuagiaophieuWeb;
import LocalModel.VwDshosoDagiaophieuWeb;
import LocalModel.VwDshosoDgpSumWeb;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
 
public class ApiGiaophieuDao {
    
    
  private final String linkbasic="http://rest.dongamoneytransfer.com.vn/ServerRestKieuhoi/webresources";
     
  private final String linkbasic2="http://rest.dongamoneytransfer.com.vn/ServerRestKieuhoi/webresources";
     
 
   
    
 // Giao phieu chi nhanh.
 public  List<VwDshosoChuagiaophieuWeb> dshschuagiaophieuchinhanh(String chinhanh ) {
        

         List<VwDshosoChuagiaophieuWeb> dsKq;
         dsKq = new ArrayList<>();
     try {
         
         
         NetClientGet clientGet=new NetClientGet();
         LinkedTreeMap bientam = new LinkedTreeMap();
         String kq=clientGet.getClientJson(linkbasic+"/vwdshosochuagiaophieuweb/findbyidchinhanh/"+chinhanh);
         if(kq.equalsIgnoreCase("Error"))
         {
            kq=clientGet.getClientJson(linkbasic2+"/vwdshosochuagiaophieuweb/findbyidchinhanh/"+chinhanh);
         }
         Gson gson = new Gson();
         List listdata = gson.fromJson(kq, List.class);
           for (Object listdata1 : listdata) {
            bientam.clear();
            VwDshosoChuagiaophieuWeb allWeb=new VwDshosoChuagiaophieuWeb();
            bientam = (LinkedTreeMap) listdata1;
            allWeb.setIdCode(bientam.get("idCode").toString());
            allWeb.setTendoitac(bientam.get("tendoitac").toString());
            allWeb.setDiachi(bientam.get("diachi").toString());
            double abc=Double.parseDouble(bientam.get("sobn").toString());
            allWeb.setSobn(Double.toString(abc));
            allWeb.setMaNguoinhan(bientam.get("maNguoinhan").toString());
            allWeb.setDesNgaygiao(bientam.get("desNgaygiao").toString());
            allWeb.setDesSolanin(bientam.get("desSolanin").toString());
            allWeb.setHoten(bientam.get("hoten").toString());
            allWeb.setCityName(bientam.get("cityName").toString());
            allWeb.setDistrictName(bientam.get("districtName").toString());
            dsKq.add(allWeb);
     }
         
         return dsKq;
     } catch (Exception e) {
         return dsKq;
     }
     
    }
 
  // Giao phieu chi nhanh.
 public  List<VwDshosoChuagiaophieuWeb> dshschuagiaophieudetail(String khoa ) {
        

         List<VwDshosoChuagiaophieuWeb> dsKq;
         dsKq = new ArrayList<>();
     try {
         
         
         NetClientGet clientGet=new NetClientGet();
         LinkedTreeMap bientam = new LinkedTreeMap();
         String kq=clientGet.getClientJson(linkbasic+"/vwdshosochuagiaophieuweb/findbyquanhuyen/"+khoa);
         if(kq.equalsIgnoreCase("Error"))
         {
            kq=clientGet.getClientJson(linkbasic2+"/vwdshosochuagiaophieuweb/findbyquanhuyen/"+khoa);
         }
         Gson gson = new Gson();
         List listdata = gson.fromJson(kq, List.class);
           for (Object listdata1 : listdata) {
            bientam.clear();
            VwDshosoChuagiaophieuWeb allWeb=new VwDshosoChuagiaophieuWeb();
            bientam = (LinkedTreeMap) listdata1;
            allWeb.setIdCode(bientam.get("idCode").toString());
            allWeb.setTendoitac(bientam.get("tendoitac").toString());
            allWeb.setDiachi(bientam.get("diachi").toString());
            long abc=(long)Double.parseDouble(bientam.get("sobn").toString());
            allWeb.setSobn(Long.toString(abc));
            allWeb.setMaNguoinhan(bientam.get("maNguoinhan").toString());
            allWeb.setDesNgaygiao(bientam.get("desNgaygiao").toString());
            allWeb.setDesSolanin(bientam.get("desSolanin").toString());
            allWeb.setHoten(bientam.get("hoten").toString());
            allWeb.setCityName(bientam.get("cityName").toString());
            allWeb.setIdCity(bientam.get("idCity").toString());
            allWeb.setIdDistrict(bientam.get("idDistrict").toString());
            allWeb.setDistrictName(bientam.get("districtName").toString());
            String nvhis=bientam.get("nvhis").toString();
            allWeb.setNvhis(nvhis);
            if(!nvhis.equalsIgnoreCase("NOVALUE"))
            {
                allWeb.setIdNvChitra(nvhis);
            }
            allWeb.setDesloaigiaophieu(bientam.get("desNgaygiao").toString());
            dsKq.add(allWeb);
     }
         
         return dsKq;
     } catch (Exception e) {
         return dsKq;
     }
     
    }
 
 // Giao phieu chi nhanh.
 public  List<VwDshosoCgpSumWeb> dshscgptongchinhanh(String chinhanh  ) {
        

         List<VwDshosoCgpSumWeb> dsKq;
         dsKq = new ArrayList<>();
     try {
         
         
         NetClientGet clientGet=new NetClientGet();
         LinkedTreeMap bientam = new LinkedTreeMap();
         String kq=clientGet.getClientJson(linkbasic+"/vwdshosocgpsumweb/dstheochinhanh/"+chinhanh);
         if(kq.equalsIgnoreCase("Error"))
         {
             kq=clientGet.getClientJson(linkbasic2+"/vwdshosocgpsumweb/dstheochinhanh/"+chinhanh);
         }
         Gson gson = new Gson();
         
         List listdata = gson.fromJson(kq, List.class);
           for (Object listdata1 : listdata) {
            bientam.clear();
            VwDshosoCgpSumWeb allWeb=new VwDshosoCgpSumWeb();
            bientam = (LinkedTreeMap) listdata1;
            // Kiem tra dieu kien  .
            allWeb.setIdCode(bientam.get("idCode").toString());
            allWeb.setIdChinhanh(bientam.get("idChinhanh").toString());
            allWeb.setTenchinhanh(bientam.get("tenchinhanh").toString());
            allWeb.setIdCity(bientam.get("idCity").toString());
            allWeb.setCityName(bientam.get("cityName").toString());
            allWeb.setIdDistrict(bientam.get("idDistrict").toString());
            allWeb.setDistrictName(bientam.get("districtName").toString());
            allWeb.setNvhis(bientam.get("nvhis").toString());
            String shstring=bientam.get("shs").toString();
            String shsmgtring=bientam.get("shsmg").toString();
            BigInteger bishs=Xulychuoi.chanceStringtoInteger(shstring);
            BigInteger bishsmg=Xulychuoi.chanceStringtoInteger(shsmgtring);
//            double hshdou=Double.parseDouble(shstring);  
//            BigDecimal bd1 = new BigDecimal(hshdou); //convert to BigDecimal
//            BigInteger bi = bd1.unscaledValue(); //convert to BigInteger
            allWeb.setShs(bishs);
            allWeb.setShsmg(bishsmg);
            allWeb.setIdLoaigiaophieu(bientam.get("idLoaigiaophieu").toString());
            allWeb.setDesloaigiaophieu(bientam.get("desloaigiaophieu").toString());
            dsKq.add(allWeb);
     }
            
         
         return dsKq;
     } catch (Exception e) {
         return dsKq;
     }
     
    }
 
  // Giao phieu chi nhanh.
 public String giaophieutungbn(VwDshosoChuagiaophieuWeb chuagiaophieuWeb ,String user ) {
        

         List<VwDshosoChuagiaophieuWeb> dsKq;
         dsKq = new ArrayList<>();
     try {
         
         String khoa = chuagiaophieuWeb.getIdCode();
         String chuoitk = chuagiaophieuWeb.getIdCity()+"@"+chuagiaophieuWeb.getIdDistrict()+"@"+chuagiaophieuWeb.getIdNvChitra()+"@"+user;
         NetClientGet clientGet=new NetClientGet();
         LinkedTreeMap bientam = new LinkedTreeMap();
        String kq=clientGet.getClientJson(linkbasic+"/hamxuly/capnhatgiaophieu/"+khoa+"/"+chuoitk);
         if(kq.equalsIgnoreCase("Error"))
         {
             kq=clientGet.getClientJson(linkbasic2+"/hamxuly/capnhatgiaophieu/"+khoa+"/"+chuoitk);
         }
         Gson gson = new Gson();
         String listdata =  gson.fromJson(kq,String.class);
       
         return "T";
     } catch (Exception e) {
         return "F";
     }
     
    }
 
 
   // Giao phieu chi nhanh.
 public String hoantungbn(VwDshosoDagiaophieuWeb chuagiaophieuWeb ,String user ) {
        

         List<VwDshosoDagiaophieuWeb> dsKq;
         dsKq = new ArrayList<>();
     try {
         
         String khoa = chuagiaophieuWeb.getIdCode();
         String chuoitk = chuagiaophieuWeb.getIdCity()+"@"+chuagiaophieuWeb.getIdDistrict()+"@"+chuagiaophieuWeb.getIdNvChitra()+"@"+user;
         NetClientGet clientGet=new NetClientGet();
         LinkedTreeMap bientam = new LinkedTreeMap();
        String kq=clientGet.getClientJson(linkbasic+"/hamxuly/capnhatphgiaophieu/"+khoa+"/"+chuoitk);
         if(kq.equalsIgnoreCase("Error"))
         {
             kq=clientGet.getClientJson(linkbasic2+"/hamxuly/capnhatphgiaophieu/"+khoa+"/"+chuoitk);
         }
         Gson gson = new Gson();
         String listdata =  gson.fromJson(kq,String.class);
       
         return "T";
     } catch (Exception e) {
         return "F";
     }
     
    }
 
 
  public  List<VwDshosoDgpSumWeb> dshsdagpsumchinhanh(String chinhanh  ) {
        

         List<VwDshosoDgpSumWeb> dsKq;
         dsKq = new ArrayList<>();
     try {
         
         
         NetClientGet clientGet=new NetClientGet();
         LinkedTreeMap bientam = new LinkedTreeMap();
         String kq=clientGet.getClientJson(linkbasic+"/vwdshosodgpsumweb/dsbychinhanh/"+chinhanh);
         if(kq.equalsIgnoreCase("Error"))
         {
             kq=clientGet.getClientJson(linkbasic2+"/vwdshosodgpsumweb/dsbychinhanh/"+chinhanh);
         }
         Gson gson = new Gson();
         
         List listdata = gson.fromJson(kq, List.class);
           for (Object listdata1 : listdata) {
            bientam.clear();
            VwDshosoDgpSumWeb allWeb=new VwDshosoDgpSumWeb();
            bientam = (LinkedTreeMap) listdata1;
            // Kiem tra dieu kien  .
            allWeb.setIdCode(bientam.get("idCode").toString());
            allWeb.setIdNvChitra(bientam.get("idNvChitra").toString());
            allWeb.setIdChinhanh(bientam.get("idChinhanh").toString());
            allWeb.setTenchinhanh(bientam.get("tenchinhanh").toString());
            allWeb.setIdCity(bientam.get("idCity").toString());
            allWeb.setCityName(bientam.get("cityName").toString());
            allWeb.setIdDistrict(bientam.get("idDistrict").toString());
            allWeb.setDistrictName(bientam.get("districtName").toString());
            String shstring=bientam.get("shs").toString();
            String shsmgtring=bientam.get("shsmg").toString();
            String shsria=bientam.get("shsria").toString();
            String shssaigon=bientam.get("shssaigon").toString();
            String shsdtt=bientam.get("shsdtt").toString();
            BigInteger bishs=Xulychuoi.chanceStringtoInteger(shstring);
            BigInteger bishsmg=Xulychuoi.chanceStringtoInteger(shsmgtring);
            BigInteger bishsria=Xulychuoi.chanceStringtoInteger(shsria);
            BigInteger bishssaigon=Xulychuoi.chanceStringtoInteger(shssaigon);
            BigInteger bishsdtt=Xulychuoi.chanceStringtoInteger(shsdtt);
            allWeb.setShs(bishs);
            allWeb.setShsmg(bishsmg);
            allWeb.setShsria(bishsria);
            allWeb.setShssaigon(bishssaigon);
            allWeb.setShsdtt(bishsdtt);
            dsKq.add(allWeb);
     }
            
         
         return dsKq;
     } catch (Exception e) {
         return dsKq;
     }
     
    }
  
   public  List<VwDshosoDagiaophieuWeb> dshshoanphieudetail(String khoa ) {
        

         List<VwDshosoDagiaophieuWeb> dsKq;
         dsKq = new ArrayList<>();
     try {
         
         
         NetClientGet clientGet=new NetClientGet();
         LinkedTreeMap bientam = new LinkedTreeMap();
         String kq=clientGet.getClientJson(linkbasic+"/vwdshosodagiaophieuweb/findbykhoa/"+khoa);
         if(kq.equalsIgnoreCase("Error"))
         {
            kq=clientGet.getClientJson(linkbasic2+"/vwdshosodagiaophieuweb/findbykhoa/"+khoa);
         }
         Gson gson = new Gson();
         List listdata = gson.fromJson(kq, List.class);
           for (Object listdata1 : listdata) {
            bientam.clear();
            VwDshosoDagiaophieuWeb allWeb=new VwDshosoDagiaophieuWeb();
            bientam = (LinkedTreeMap) listdata1;
            allWeb.setIdCode(bientam.get("idCode").toString());
            allWeb.setIdDoitac(bientam.get("idDoitac").toString());
            allWeb.setTendoitac(bientam.get("tendoitac").toString());
            allWeb.setDiachi(bientam.get("diachi").toString());
            long abc=(long)Double.parseDouble(bientam.get("sobn").toString());
            allWeb.setSobn(Long.toString(abc));
            allWeb.setMaNguoinhan(bientam.get("maNguoinhan").toString());
            allWeb.setDesNgaygiao(bientam.get("desNgaygiao").toString());
            allWeb.setHoten(bientam.get("hoten").toString());
            allWeb.setCityName(bientam.get("cityName").toString());
            allWeb.setIdCity(bientam.get("idCity").toString());
            allWeb.setIdDistrict(bientam.get("idDistrict").toString());
            allWeb.setDistrictName(bientam.get("districtName").toString());
            allWeb.setIdNvChitra(bientam.get("idNvChitra").toString());
            dsKq.add(allWeb);
     }
         
         return dsKq;
     } catch (Exception e) {
         return dsKq;
     }
     
    }
 
  
 
 
}
    
    

