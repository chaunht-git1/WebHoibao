 
package ApiFunction.ApiDao;

 
import ApiFunction.NetClientGet;
import static ConnectBean.Provider.URLAPIJAVA;
import static ConnectBean.Provider.URL_API;
import static ConnectBean.Provider.URL_API_KH;
import LocalModel.DmXacminhToday;
import LocalModel.DshosoMg;
import LocalModel.UserModel;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
 
public class ApiLogin {
    
    
  private final String linkbasic=URLAPIJAVA;
     
 public  List<DmXacminhToday> dsHsXacMinhtrongngay( ) {
        

         List<DmXacminhToday> dsKq;
         dsKq = new ArrayList<>();
     try {

         NetClientGet clientGet=new NetClientGet();
         LinkedTreeMap bientam = new LinkedTreeMap();
         String kq=clientGet.getClientJson(linkbasic+"api/smtbuserweb/checklogin");
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
 
  public   String  validate(String username,String password) {
      
       try {
           
         NetClientGet clientGet = new NetClientGet();
         Gson gson = new Gson();
         LinkedTreeMap bientam = new LinkedTreeMap();
         String fulllink=linkbasic + "api/login/emoney/" + username.toUpperCase()+"/"+password.toUpperCase();
         //String passmahoa= MaHoaDuLieu.md5hash(username.toUpperCase()+password.toUpperCase());
         String kq = clientGet.getClientJson(fulllink);
         if(!kq.equalsIgnoreCase("F"))
         {
            return kq;
         }
         else{
             return null;
         }
         
     } catch (Exception e) {
             return null;
     }
       
  }
     public  UserModel layThongUser(String username) {
      
       UserModel model=new UserModel(); 
       try {
       
         NetClientGet clientGet = new NetClientGet();
         Gson gson = new Gson();
         LinkedTreeMap bientam = new LinkedTreeMap();
         String kq = clientGet.getClientJson(linkbasic + "/laythongtinuser/" + username);
         if(!kq.equalsIgnoreCase("Error"))
         {
            bientam  = gson.fromJson(kq, LinkedTreeMap.class);
          
            model.setUsername(bientam.get("username").toString());
            model.setHomebranch(bientam.get("homebranch").toString());  
            model.setUserid(bientam.get("userid").toString());
         }
         else{
             return null;
         }
         
         return model;
         
     } catch (Exception e) {
             return null;
     }
       
     }
 
  public  List<DshosoMg> dshsDshosoMg(String chinhanh ,String dot) {
        

         List<DshosoMg> dsKq;
         dsKq = new ArrayList<>();
     try {
         
         
         NetClientGet clientGet=new NetClientGet();
         LinkedTreeMap bientam = new LinkedTreeMap();
         String kq=clientGet.getClientJson(linkbasic+"/vwtondongnvallweb/dshosogiaomobile/"+chinhanh+"/"+dot);
         Gson gson = new Gson();
         List listdata = gson.fromJson(kq, List.class);
           for (Object listdata1 : listdata) {
            bientam.clear();
            DshosoMg allWeb=new DshosoMg();
            bientam = (LinkedTreeMap) listdata1;
            allWeb.setIdnvchitra(bientam.get("idnvchitra").toString());
            String abc=bientam.get("shs").toString() ;
            Double f1 = Double.parseDouble(abc);
            Integer i = f1.intValue(); 
            allWeb.setShs(i.toString());
            allWeb.setHotennv(bientam.get("hotennv").toString());
            dsKq.add(allWeb);
     }
         
         return dsKq;
     } catch (Exception e) {
         return dsKq;
     }
     
    }
 
     
}
    
    

