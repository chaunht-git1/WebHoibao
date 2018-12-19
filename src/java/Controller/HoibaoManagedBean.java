 
package Controller;

import ApiFunction.ApiFun;
import ConnectBean.ConnectionProvider;
import DanhmucModel.DmCitylist;
import EntitiesBean.VwGiaodichHoibaomobileNvall;
import EntitiesBean.VwKshbHosonvchinhaAll;
import EntitiesBean.VwTondongNvAllWeb;
import LocalFuntionGlobal.ConstantCodes;
import LocalFuntionGlobal.HamUserAll;
import LocalFuntionGlobal.SessionBean;
import LocalModel.ChinhanhList;
import LocalModel.ChitietgiaodichModel;
import LocalModel.UserModel;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

 
@Named(value = "hoibaoManagedBean")
@SessionScoped
public class HoibaoManagedBean implements Serializable {
    
  private  String tencntimkiem ;
  private VwKshbHosonvchinhaAll hosonvchinhaAll = new VwKshbHosonvchinhaAll();
  private List<VwKshbHosonvchinhaAll> listhskiemtranv= new ArrayList<>();
  private List<ChinhanhList> listchinhanh=  new ArrayList<>();
  private  List<UserModel> listusermdel= new  ArrayList<>();
  private List<VwKshbHosonvchinhaAll>  listhskiemtranvall= new ArrayList<VwKshbHosonvchinhaAll>();
  private List<DmCitylist> dscity= new ArrayList<>();
  private  List<ChitietgiaodichModel> chitietgiaodichModels=new ArrayList<>();
  private  ChitietgiaodichModel chitietgiaodichModel=new  ChitietgiaodichModel();
  private  List<VwTondongNvAllWeb> listnvtondong;




  public String  chuyentrangkshoibaochinhanh( ) {
 
    return "kshbthongkenhanvien" + "?faces-redirect=true";
    
  }
  
    
  public void  showthongtinnv( ) {
      try {
          String chinhanh = SessionBean.getChinhanhId();
          String userid=SessionBean.getUserId();
          listhskiemtranv = null;
          listhskiemtranv = new ArrayList<>();
          listhskiemtranv = HoibaoManagedBean.dsthongkenhanvien(chinhanh,userid);
         // listhskiemtranv = ApiFun.dsthongkenhanvien(chinhanh, userid, "") ;
          hosonvchinhaAll = listhskiemtranv.get(0);
        //  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tìm thấy" + listhskiemtranv.size(), ""));

      } catch (Exception e) {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Không có hồ sơ", ""));

      }
  
  }
  
    public static List<VwKshbHosonvchinhaAll> dsthongkenhanvien(String chinhanh,String userid) {
        
        List<VwKshbHosonvchinhaAll> dsKq;
        dsKq = new ArrayList<>();
       // String userid=SessionBean.getUserId();
      
        
            Connection con=ConnectionProvider.getCon();

        try { 
           // Tạo một câu SQL có 1 tham số (?)
            String  sql = "select * from KHOUT.VW_KSHB_HOSONVCHINHA_ALL WHERE ID_CHINHANH=? AND ID_NV_CHITRA=? ";
            
            // Tạo một đối tượng PreparedStatement.
            PreparedStatement pstm = con.prepareStatement(sql);
            
            // Sét đặt giá trị tham số thứ nhất (Dấu ? thứ nhất)        
            pstm.setString(1, chinhanh);
            pstm.setString(2, userid);
          
            
            ResultSet rs = pstm.executeQuery();
            
             while (rs.next()) { 
              VwKshbHosonvchinhaAll dataClass = new VwKshbHosonvchinhaAll();
              dataClass.setIdCode(rs.getString("IDCODE"));
              dataClass.setIdChinhanh(rs.getString("ID_CHINHANH"));
              dataClass.setTenchinhanh(rs.getString("TENCHINHANH"));
              dataClass.setHoten(rs.getString("HOTEN"));
              dataClass.setDachitra(rs.getLong("DACHITRA"));
              dataClass.setChuachitra(rs.getLong("CHUACHITRA"));
              dataClass.setShs(rs.getLong("SHS"));
              dataClass.setDaquyetbn(rs.getLong("DAQUYETBN"));
              dataClass.setChoduyetbn(rs.getLong("CHODUYETBN"));
              dataClass.setThieutt(rs.getLong("THIEUTT"));
              dataClass.setErrorbn(rs.getBigDecimal("ERRORBN"));
              dataClass.setDachitrachuabn(rs.getLong("DACHITRACHUABN"));
              dataClass.setHoanthanh(rs.getString("HOANTHANH"));
              dataClass.setShstondong(rs.getLong("SHSTONDONG"));
              dataClass.setShsxacminh(rs.getLong("SHSXACMINH"));
              dataClass.setShsguixm(rs.getLong("SHSGUIXM"));
              dataClass.setChinhahoanthanh(rs.getString("CHINHAHOANTHANH"));
              dataClass.setSlmoneygram(rs.getLong("SLMONEYGRAM"));
              dataClass.setSlmoneygramdot1(rs.getLong("SLMONEYGRAMDOT1"));
              dataClass.setSoluonghbmobile(rs.getLong("SOLUONGHBMOBILE"));
              dsKq.add(dataClass);  
               }
      
          return dsKq;
        } catch (Exception e) {
             return null;
        }
    }
  
 
    public String chuyentrangchitiet(String dk) {
        String chinhanh=SessionBean.getChinhanhId();
        String userid=SessionBean.getUserId();         
        chitietgiaodichModels = new ArrayList<>();
        
        List<VwTondongNvAllWeb> listnvtondong= new ArrayList<VwTondongNvAllWeb>();
  
           switch (dk) 
           {
            case "C": 
            {
           listnvtondong=HamUserAll.dsdondongchitiet(chinhanh, userid, "");
           for (int i = 0; i < listnvtondong.size(); i++) {
           chitietgiaodichModel = new ChitietgiaodichModel();
           chitietgiaodichModel.setTendoitac(listnvtondong.get(i).getTenDoitac());
           chitietgiaodichModel.setHoten(listnvtondong.get(i).getHoten()); 
           chitietgiaodichModel.setSobn(listnvtondong.get(i).getSobn().toString()); 
           chitietgiaodichModel.setManguoinhan(listnvtondong.get(i).getMaNguoinhan()); 
           chitietgiaodichModel.setLydoxacminh(listnvtondong.get(i).getNoidungxmmobile()); 
           chitietgiaodichModel.setNguoigoi(listnvtondong.get(i).getNguoigoi()); 
           chitietgiaodichModel.setSotiengoi(listnvtondong.get(i).getSotiengoi()); 
           chitietgiaodichModel.setTygia(listnvtondong.get(i).getTygia()); 
           chitietgiaodichModel.setThanhtien(listnvtondong.get(i).getThanhtien()); 
           chitietgiaodichModel.setLoaitien(listnvtondong.get(i).getIdLoaitienchitra()); 
           chitietgiaodichModel.setDiachi(listnvtondong.get(i).getDiachi()); 
           chitietgiaodichModel.setSodienthoai(listnvtondong.get(i).getDienthoai());
           chitietgiaodichModel.setSocttuythan(listnvtondong.get(i).getSoCtTuythan());
           chitietgiaodichModels.add(chitietgiaodichModel);
           }
             break;
            }
          
          case "B": 
            {
           listnvtondong=HamUserAll.dsdondongchitiet(chinhanh, userid, "");
           for (int i = 0; i < listnvtondong.size(); i++) {
              VwTondongNvAllWeb allWeb=new VwTondongNvAllWeb();
              allWeb=listnvtondong.get(i);
              if(allWeb.getNoidungxmmobile()!=null)
              {
                   chitietgiaodichModel = new ChitietgiaodichModel();
                   chitietgiaodichModel.setTendoitac(allWeb.getTenDoitac());
                   chitietgiaodichModel.setHoten(allWeb.getHoten()); 
                   chitietgiaodichModel.setSobn(allWeb.getSobn().toString()); 
                   chitietgiaodichModel.setManguoinhan(allWeb.getMaNguoinhan()); 
                   chitietgiaodichModel.setLydoxacminh(allWeb.getNoidungxmmobile()); 
                   chitietgiaodichModel.setSodienthoai(listnvtondong.get(i).getDienthoai());
                   chitietgiaodichModel.setSocttuythan(listnvtondong.get(i).getSoCtTuythan());
                   chitietgiaodichModels.add(chitietgiaodichModel);
              }
           }
             break;  
            }
           case "HSDOT3": 
            {
           listnvtondong=HamUserAll.dsdondongdkienchitiet(chinhanh, userid, dk);
           for (int i = 0; i < listnvtondong.size(); i++) {
              VwTondongNvAllWeb allWeb=new VwTondongNvAllWeb();
               allWeb=listnvtondong.get(i);
               chitietgiaodichModel = new ChitietgiaodichModel();
               chitietgiaodichModel.setTendoitac(listnvtondong.get(i).getTenDoitac());
               chitietgiaodichModel.setHoten(listnvtondong.get(i).getHoten());
               chitietgiaodichModel.setSobn(listnvtondong.get(i).getSobn().toString());
               chitietgiaodichModel.setManguoinhan(listnvtondong.get(i).getMaNguoinhan());
               chitietgiaodichModel.setLydoxacminh(listnvtondong.get(i).getNoidungxmmobile());
               chitietgiaodichModel.setNguoigoi(listnvtondong.get(i).getNguoigoi());
               chitietgiaodichModel.setSotiengoi(listnvtondong.get(i).getSotiengoi());
               chitietgiaodichModel.setTygia(listnvtondong.get(i).getTygia());
               chitietgiaodichModel.setThanhtien(listnvtondong.get(i).getThanhtien());
               chitietgiaodichModel.setLoaitien(listnvtondong.get(i).getIdLoaitienchitra());
               chitietgiaodichModel.setDiachi(listnvtondong.get(i).getDiachi());
               chitietgiaodichModel.setSodienthoai(listnvtondong.get(i).getDienthoai());
               chitietgiaodichModel.setSocttuythan(listnvtondong.get(i).getSoCtTuythan());
               chitietgiaodichModels.add(chitietgiaodichModel);
           }
              break;
            } 
             
           case "HSDOT1": 
            {
           listnvtondong=HamUserAll.dsdondongdkienchitiet(chinhanh, userid, dk);
           for (int i = 0; i < listnvtondong.size(); i++) {
              VwTondongNvAllWeb allWeb=new VwTondongNvAllWeb();
               allWeb=listnvtondong.get(i);
               chitietgiaodichModel = new ChitietgiaodichModel();
               chitietgiaodichModel.setTendoitac(listnvtondong.get(i).getTenDoitac());
               chitietgiaodichModel.setHoten(listnvtondong.get(i).getHoten());
               chitietgiaodichModel.setSobn(listnvtondong.get(i).getSobn().toString());
               chitietgiaodichModel.setManguoinhan(listnvtondong.get(i).getMaNguoinhan());
               chitietgiaodichModel.setLydoxacminh(listnvtondong.get(i).getNoidungxmmobile());
               chitietgiaodichModel.setNguoigoi(listnvtondong.get(i).getNguoigoi());
               chitietgiaodichModel.setSotiengoi(listnvtondong.get(i).getSotiengoi());
               chitietgiaodichModel.setTygia(listnvtondong.get(i).getTygia());
               chitietgiaodichModel.setThanhtien(listnvtondong.get(i).getThanhtien());
               chitietgiaodichModel.setLoaitien(listnvtondong.get(i).getIdLoaitienchitra());
               chitietgiaodichModel.setDiachi(listnvtondong.get(i).getDiachi());
               chitietgiaodichModel.setSodienthoai(listnvtondong.get(i).getDienthoai());
               chitietgiaodichModel.setSocttuythan(listnvtondong.get(i).getSoCtTuythan());
               chitietgiaodichModels.add(chitietgiaodichModel);
           }
             break;  
            }  
                
           case "HSXNMOBILE": 
            {
            List<VwGiaodichHoibaomobileNvall> hoibaomobileNvall= new ArrayList<VwGiaodichHoibaomobileNvall>();
            hoibaomobileNvall=HamUserAll.dshoibaochitiet(chinhanh, userid, dk);
           for (int i = 0; i < hoibaomobileNvall.size(); i++) {
              VwGiaodichHoibaomobileNvall allWeb=new VwGiaodichHoibaomobileNvall();
               allWeb=hoibaomobileNvall.get(i);
               chitietgiaodichModel = new ChitietgiaodichModel();
               chitietgiaodichModel.setTendoitac(hoibaomobileNvall.get(i).getTenDoitac());
               chitietgiaodichModel.setHoten(hoibaomobileNvall.get(i).getHoten());
               chitietgiaodichModel.setSobn(hoibaomobileNvall.get(i).getSobn().toString());
               chitietgiaodichModel.setManguoinhan(hoibaomobileNvall.get(i).getMaNguoinhan());
               chitietgiaodichModel.setLydoxacminh(hoibaomobileNvall.get(i).getNoidungxmmobile());
               chitietgiaodichModel.setNguoigoi(hoibaomobileNvall.get(i).getNguoigoi());
               chitietgiaodichModel.setSotiengoi(hoibaomobileNvall.get(i).getSotiengoi());
               chitietgiaodichModel.setTygia(hoibaomobileNvall.get(i).getTygia());
               chitietgiaodichModel.setThanhtien(hoibaomobileNvall.get(i).getThanhtien());
               chitietgiaodichModel.setLoaitien(hoibaomobileNvall.get(i).getIdLoaitienchitra());
               chitietgiaodichModel.setDiachi(hoibaomobileNvall.get(i).getDiachi());
               chitietgiaodichModel.setSodienthoai(hoibaomobileNvall.get(i).getDienthoai());
               chitietgiaodichModel.setSocttuythan(hoibaomobileNvall.get(i).getSoCtTuythan());
               chitietgiaodichModels.add(chitietgiaodichModel);
               
               
           }
               return "chitiethosoktimage" + "?faces-redirect=true";
            }  
              
           }

        return "chitiethosokiemtra" + "?faces-redirect=true";

    }   
  
  public   String chuyentrangdshoibao(String dk) {
        
        String chinhanh=SessionBean.getChinhanhId();
        String userid=SessionBean.getUserId();         
        ApiFun af=new ApiFun();
        chitietgiaodichModels = new ArrayList<>();
           
           listnvtondong= new ArrayList<VwTondongNvAllWeb>();
  
           switch (dk) 
           {
            case "C": 
            {
           listnvtondong=HamUserAll.dsdondongchitiet(chinhanh, userid, dk);
    
           if(listnvtondong.size()==0){
              // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, listhskiemtranv.size(), ""));  
           }
           else{
           for (int i = 0; i < listnvtondong.size(); i++) {
          
           chitietgiaodichModel = new ChitietgiaodichModel();
           chitietgiaodichModel.setSocttuythan(listnvtondong.get(i).getSoCtTuythan());
           chitietgiaodichModel.setDotnhantien(listnvtondong.get(i).getIdQlqDottg());    
           chitietgiaodichModel.setMakhachhang(listnvtondong.get(i).getIdKhachhangtt());
           chitietgiaodichModel.setTendoitac(listnvtondong.get(i).getTenDoitac());
           chitietgiaodichModel.setHoten(listnvtondong.get(i).getHoten()); 
           chitietgiaodichModel.setSobn(listnvtondong.get(i).getSobn().toString()); 
           chitietgiaodichModel.setManguoinhan(listnvtondong.get(i).getMaNguoinhan()); 
           chitietgiaodichModel.setLydoxacminh(listnvtondong.get(i).getNoidungxmmobile()); 
           chitietgiaodichModel.setNguoigoi(listnvtondong.get(i).getNguoigoi()); 
           chitietgiaodichModel.setSotiengoi(listnvtondong.get(i).getSotiengoi()); 
           chitietgiaodichModel.setTygia(listnvtondong.get(i).getTygia()); 
           chitietgiaodichModel.setThanhtien(listnvtondong.get(i).getThanhtien()); 
           chitietgiaodichModel.setLoaitien(listnvtondong.get(i).getIdLoaitienchitra()); 
           chitietgiaodichModel.setDiachi(listnvtondong.get(i).getDiachi()); 
           chitietgiaodichModel.setSodienthoai(listnvtondong.get(i).getDienthoai());
           chitietgiaodichModel.setSophieu(listnvtondong.get(i).getSophieu());
           chitietgiaodichModel.setChinhanh(listnvtondong.get(i).getIdChinhanh());
           chitietgiaodichModel.setStt(listnvtondong.get(i).getStt());
           chitietgiaodichModel.setIdnvchitrachuyen("novalue");   
           chitietgiaodichModels.add(chitietgiaodichModel);
          
           }
           }
             break;
            }

           }

        return "dshoibaomobile" ;

    }   

    public String getTencntimkiem() {
        return tencntimkiem;
    }

    public void setTencntimkiem(String tencntimkiem) {
        this.tencntimkiem = tencntimkiem;
    }

    public VwKshbHosonvchinhaAll getHosonvchinhaAll() {
        return hosonvchinhaAll;
    }

    public void setHosonvchinhaAll(VwKshbHosonvchinhaAll hosonvchinhaAll) {
        this.hosonvchinhaAll = hosonvchinhaAll;
    }

    public List<VwKshbHosonvchinhaAll> getListhskiemtranv() {
        return listhskiemtranv;
    }

    public void setListhskiemtranv(List<VwKshbHosonvchinhaAll> listhskiemtranv) {
        this.listhskiemtranv = listhskiemtranv;
    }

    public List<ChinhanhList> getListchinhanh() {
        return listchinhanh;
    }

    public void setListchinhanh(List<ChinhanhList> listchinhanh) {
        this.listchinhanh = listchinhanh;
    }

    public List<UserModel> getListusermdel() {
        return listusermdel;
    }

    public void setListusermdel(List<UserModel> listusermdel) {
        this.listusermdel = listusermdel;
    }

    public List<VwKshbHosonvchinhaAll> getListhskiemtranvall() {
        return listhskiemtranvall;
    }

    public void setListhskiemtranvall(List<VwKshbHosonvchinhaAll> listhskiemtranvall) {
        this.listhskiemtranvall = listhskiemtranvall;
    }

    public List<DmCitylist> getDscity() {
        return dscity;
    }

    public void setDscity(List<DmCitylist> dscity) {
        this.dscity = dscity;
    }

    public List<ChitietgiaodichModel> getChitietgiaodichModels() {
        return chitietgiaodichModels;
    }

    public void setChitietgiaodichModels(List<ChitietgiaodichModel> chitietgiaodichModels) {
        this.chitietgiaodichModels = chitietgiaodichModels;
    }

    public ChitietgiaodichModel getChitietgiaodichModel() {
        return chitietgiaodichModel;
    }

    public void setChitietgiaodichModel(ChitietgiaodichModel chitietgiaodichModel) {
        this.chitietgiaodichModel = chitietgiaodichModel;
    }

    public List<VwTondongNvAllWeb> getListnvtondong() {
        return listnvtondong;
    }

    public void setListnvtondong(List<VwTondongNvAllWeb> listnvtondong) {
        this.listnvtondong = listnvtondong;
    }
    
    
    
    
  
  
}
