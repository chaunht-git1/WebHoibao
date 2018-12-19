 
package ApiFunction.ApiDao;

import ApiFunction.NetClientGet;
import EntitiesBean.VwXemdulieutkMaster;
import EntitiesBean.VwXemdulieutkkhMaster;
import LocalModel.DmXacminhToday;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

 
 
 
public class ApiTimkiemDao {
    
    
  private final String linkbasic="http://rest.dongamoneytransfer.com.vn/ServerRestKieuhoi/webresources";
     
  private final String linkbasic2="http://rest.dongamoneytransfer.com.vn/ServerRestKieuhoi/webresources";
     
 
   
    
 // Giao phieu chi nhanh.
 public  List<VwXemdulieutkkhMaster> dskhachhang(String userid ) {
        

         List<VwXemdulieutkkhMaster> dsKq;
         dsKq = new ArrayList<>();
     try {
         
         
         NetClientGet clientGet=new NetClientGet();
         LinkedTreeMap bientam = new LinkedTreeMap();
         String kq=clientGet.getClientJson(linkbasic+"/entity.vwxemdulieutkkhmaster/dskhachhangtimthay/"+userid);
         if(kq.equalsIgnoreCase("Error"))
         {
            kq=clientGet.getClientJson(linkbasic2+"/entity.vwxemdulieutkkhmaster/dskhachhangtimthay/"+userid);
         }
         java.lang.reflect.Type listType = new TypeToken<ArrayList<VwXemdulieutkkhMaster>>(){}.getType();
         Gson gson = new Gson();
         dsKq = new Gson().fromJson(kq, listType);
  
         /* List listdata = gson.fromJson(kq, List.class);
           for (Object listdata1 : listdata) {
            bientam.clear();
            VwXemdulieutkkhMaster allWeb=new VwXemdulieutkkhMaster();
            bientam = (LinkedTreeMap) listdata1;
            allWeb.setIdcode(bientam.get("idcode").toString());
            allWeb.setIdKhachhang(bientam.get("idKhachhang").toString());
            allWeb.setHoten(bientam.get("hoten").toString());
            allWeb.setDachuanhoa(bientam.get("dachuanhoa").toString());
            double abc=Double.parseDouble(bientam.get("shshis").toString());
            allWeb.setShshis(new BigDecimal(abc).toBigInteger());
            allWeb.setSochungminh(bientam.get("sochungminh").toString());
            allWeb.setSonhaHientai(bientam.get("sonhaHientai").toString());
            allWeb.setSonhaThuongtru(bientam.get("sonhaThuongtru").toString());
            allWeb.setThanhphoThuongtru(bientam.get("thanhphoThuongtru").toString());
            allWeb.setQuanThuongtru(bientam.getOrDefault("quanThuongtru","").toString());
            allWeb.setTen(bientam.getOrDefault("ten","").toString());
            allWeb.setTpHientai(bientam.getOrDefault("tpHientai","").toString());
            allWeb.setQuanHientai(bientam.getOrDefault("quanHientai","").toString());
            allWeb.setUserId(bientam.get("userId").toString());*/
           //dsKq.add(allWeb);
     //}
         
         return dsKq;
     } catch (Exception e) {
         return dsKq;
     }
     
    }
  
 public List<VwXemdulieutkMaster> showthongtin(String userid) {
     
    
         List<VwXemdulieutkMaster> dsKq;
         dsKq = new ArrayList<>();
     try {
         
         
         NetClientGet clientGet=new NetClientGet();
         LinkedTreeMap bientam = new LinkedTreeMap();
         String kq=clientGet.getClientJson(linkbasic+"/entity.vwxemdulieutkmaster/dslichsugiaodich/"+userid);
         if(kq.equalsIgnoreCase("Error"))
         {
            kq=clientGet.getClientJson(linkbasic2+"/entity.vwxemdulieutkmaster/dslichsugiaodich/"+userid);
         }
         java.lang.reflect.Type listType = new TypeToken<ArrayList<VwXemdulieutkMaster>>(){}.getType();
        // Gson gson = new Gson();
         dsKq = new Gson().fromJson(kq, listType);
         return dsKq;
        /* Gson gson = new Gson();
         List listdata = gson.fromJson(kq, List.class);
           for (Object listdata1 : listdata) {
                bientam.clear();
                VwTkttBiennhanMaster d = new VwTkttBiennhanMaster();
                 bientam = (LinkedTreeMap) listdata1;
            
                d.setIdcode(bientam.getOrDefault("idCode","").toString());
                d.setHoten(bientam.get("hoten").toString());
                long abc=(long)Double.parseDouble(bientam.getOrDefault("sobn",0).toString());
                d.setSobn(Long.toString(abc));
                d.setDienthoai(bientam.get("dienthoai").toString());
                d.setManguoinhan(bientam.get("maNguoinhan").toString());
                d.setIdchinhanh(bientam.get("idChinhanh").toString());
                d.setChinhanhname(bientam.get("chinhanhName").toString());
                d.setIddoitac(bientam.get("idDoitac").toString());
                d.setDoitacname(bientam.get("doitacName").toString());;
                d.setGiaytohoten(bientam.get("giaytoHoten").toString());
                d.setPayagentseq(bientam.getOrDefault("payagentseg","").toString());
                d.setAgent(bientam.getOrDefault("agent","").toString());
                d.setIdagent(bientam.getOrDefault("idAgent","").toString());
                d.setPinno(bientam.getOrDefault("pinNo","").toString());
                d.setNgaynhaplieu(Xulychuoi.chanceStringtoDate(bientam.get("ngayNhaplieu").toString()));
                d.setMabiennhan(bientam.getOrDefault("mabiennhan","").toString());
                d.setNgaynhaplieu(Xulychuoi.chanceStringtoDate(bientam.getOrDefault("ngayChitra","").toString()));
                d.setDiachi(bientam.getOrDefault("diachi","").toString());
                d.setSo_ct_tuythan(bientam.getOrDefault("soCtTuythan","").toString());
                d.setId_nv_chitra(bientam.getOrDefault("idNvChitra","").toString());
                d.setNguoigoi(bientam.getOrDefault("nguoigoi","").toString());
                d.setDachitra(bientam.getOrDefault("dachitra","").toString());
                d.setId_diadiemchitra(bientam.getOrDefault("idDiadiemchitra","").toString());
                d.setDanhanphieu(bientam.getOrDefault("danhanphieu","").toString());
                d.setIdcttuythan(bientam.getOrDefault("idCtTuythan","").toString());
                d.setLoaigiayto(bientam.getOrDefault("loaiGiayto","").toString());


                d.setSotiengoi(Xulychuoi.chanceStringtoBigDecimal(bientam.getOrDefault("sotiengoi","0").toString()));
                d.setTygia(Xulychuoi.chanceStringtoBigDecimal(bientam.getOrDefault("tygia","0").toString()));
                d.setThanhtien(Xulychuoi.chanceStringtoBigDecimal(bientam.getOrDefault("thanhtien","0").toString()));
                d.setIdloaitienchitra(bientam.getOrDefault("idLoaitienchitra","").toString());
                d.setIdloaitiengoi(bientam.getOrDefault("idLoaitiengoi","").toString());
                d.setIdloaicongno(bientam.getOrDefault("idLoaicongno","").toString());
                d.setManguoinhan(bientam.getOrDefault("maNguoinhan","").toString());
                d.setIdcity(bientam.getOrDefault("idCity","").toString());
                d.setCityname(bientam.getOrDefault("cityName","").toString());
  
                d.setIdnvbaocao(bientam.getOrDefault("idNvBaocao","").toString());
                d.setIdnvxacnhan(bientam.getOrDefault("idNvXacnhan","").toString());
                d.setIdnvbiennhan(bientam.getOrDefault("idNvBiennhan","").toString());
                d.setKhachhangnhan(bientam.getOrDefault("khachhangNhan","").toString());

                d.setXacminh(bientam.getOrDefault("xacnhan","").toString());
                d.setGhichu(bientam.getOrDefault("ghichu","").toString());
                d.setLydoxmnk(bientam.getOrDefault("lydoXmnk","").toString());
                d.setIdnvnhaplieu(bientam.getOrDefault("idNvNhaplieu","").toString());
    
            
                d.setIdthanhtoan(bientam.getOrDefault("idThanhtoan","").toString());
                d.setCongtacvien(bientam.getOrDefault("congtacvien","").toString());
               
               
                d.setExtorder(bientam.getOrDefault("extOrder","").toString());
                d.setSocttuythan(bientam.getOrDefault("soCtTuythan","").toString());
                d.setIddistrict(bientam.getOrDefault("idDistrict","").toString());
                d.setDistrictname(bientam.getOrDefault("districtName","").toString());
                d.setNgaychitratrue(Xulychuoi.chanceStringtoDate(bientam.getOrDefault("ngayChitraTrue","").toString()));
                d.setNgaychitra(Xulychuoi.chanceStringtoDate(bientam.getOrDefault("ngayChitra","").toString()));
                d.setNgaybiennhan(Xulychuoi.chanceStringtoDate(bientam.getOrDefault("ngayBiennhan","").toString()));
                d.setNgayxacminh(Xulychuoi.chanceStringtoDate(bientam.getOrDefault("ngayXacminh","").toString()));
                d.setNgaygiaophieu(Xulychuoi.chanceStringtoDate(bientam.getOrDefault("ngayGiaophieu","").toString()));
                d.setBiennhanc(bientam.getOrDefault("biennhanC","").toString());
                d.setDakiemtra(bientam.getOrDefault("dakiemtra","").toString());
                d.setIdnvxacminh(bientam.getOrDefault("idNvXacminh","").toString());
                dsKq.add(d);
                

            }
                */

        } catch (Exception e) {
             return null;
        }

        
    }
    
 
  // Giao phieu chi nhanh.
 public  Boolean timkhachhang(String user,String giatritk,String loaitk, String chinhanh ) {
    
     try {

         NetClientGet clientGet=new NetClientGet();
         LinkedTreeMap bientam = new LinkedTreeMap();
         Gson gson = new Gson();
         String kq=clientGet.getClientJson(linkbasic+"/hamxuly/timkhachhang/"+user+"/"+giatritk+"/"+loaitk+"/"+chinhanh);
         if(kq.equalsIgnoreCase("Error"))
         {
            kq=clientGet.getClientJson(linkbasic2+"/hamxuly/timkhachhang/"+user+"/"+giatritk+"/"+loaitk+"/"+chinhanh);
         }
      
     
          if(!kq.equalsIgnoreCase("F"))
         {
            String ketqua = gson.fromJson(kq, String.class);
            
            if(ketqua.equalsIgnoreCase("T")){
                return true; 
            }
            else{
                return false; 
            }
             
         }
         else{
             return false;
         }
          
     } catch (Exception e) {
         return false;
     }
     
    }
 
  public  List<DmXacminhToday> dsHsXacMinhtrongngay( ) {
        

         List<DmXacminhToday> dsKq;
         dsKq = new ArrayList<>();
     try {

         NetClientGet clientGet=new NetClientGet();
         LinkedTreeMap bientam = new LinkedTreeMap();
         String kq=clientGet.getClientJson(linkbasic+"/dmxacminhtoday");
         Gson gson = new Gson();
         List listdata = gson.fromJson(kq, List.class);
           for (Object listdata1 : listdata) {
            bientam.clear();
            DmXacminhToday allWeb=new DmXacminhToday();
            bientam = (LinkedTreeMap) listdata1;
            allWeb.setKhoa(bientam.get("khoa").toString());
            allWeb.setNoidungxm(bientam.get("noidungxm").toString());
            allWeb.setSobn(bientam.get("sobn").toString());
           
            
            dsKq.add(allWeb);
     }
         
         return dsKq;
     } catch (Exception e) {
         return dsKq;
     }
     
    }
 
 public   DmXacminhToday  noiDungxmtrongngay(String id) {
        
     DmXacminhToday allWeb = new DmXacminhToday();
     
     try {
         NetClientGet clientGet = new NetClientGet();
         Gson gson = new Gson();
         LinkedTreeMap bientam = new LinkedTreeMap();
         String kq = clientGet.getClientJson(linkbasic + "/dmxacminhtoday/" + id);
         if(!kq.equalsIgnoreCase("Error"))
         {
         bientam = gson.fromJson(kq, LinkedTreeMap.class);

         allWeb.setKhoa(bientam.get("khoa").toString());
         allWeb.setNoidungxm(bientam.get("noidungxm").toString());
         allWeb.setSobn(bientam.get("sobn").toString());
         String target=bientam.get("dateModified").toString();
         String pattern = "yyyy-MM-dd'T'HH:mm:ss";
         DateFormat df = new SimpleDateFormat(pattern,Locale.ENGLISH);
         
         Date result =  df.parse(target); 
         
         allWeb.setDateModified(result);
         return allWeb;
         }
         else{
             return null;
         }
         
     } catch (Exception e) {
         return null;
     }
     

     
    }
 
  
 
}
    
    

