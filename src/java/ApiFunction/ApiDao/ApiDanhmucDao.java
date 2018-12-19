
package ApiFunction.ApiDao;

import ApiFunction.NetClientGet;
import Apimodel.DistrictApi;
import Apimodel.JobModel;
import static ConnectBean.Provider.URLAPI;
import static ConnectBean.Provider.URLAPIJAVA;
import EntitiesBean.CityList;
import EntitiesBean.DistrictList;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.List;

 
public class ApiDanhmucDao {
    
  private final String linkbasic="http://rest.dongamoneytransfer.com.vn/ServerRestKieuhoi/webresources";
     
  private final String linkbasic2="http://rest.dongamoneytransfer.com.vn/ServerRestKieuhoi/webresources";
  
     // Giao phieu chi nhanh.
  public  List<JobModel> getListJob() {
        
         String linkapi="http://10.11.51.12:8899/api/masterdata/getlistjob";
         List<JobModel> dsKq;
         dsKq = new ArrayList<>();
     try {
         
         
         NetClientGet clientGet=new NetClientGet();
         String kq=clientGet.getClientJson(linkapi);
         
        Gson gson = new Gson();
        List<JobModel> jms=new ArrayList<>();
        dsKq =  gson.fromJson(kq,new TypeToken<List<JobModel>>(){}.getType());
 
         return dsKq;
     } catch (Exception e) {
         return dsKq;
     }
     
    }
  
  
    public  List<DistrictList> getDistrictList(String cnnhanh) {
        
         String linkapi=URLAPIJAVA+"api/danhmuc/DistrictList/"+cnnhanh;
         List<DistrictList> dsKq;
         dsKq = new ArrayList<>();
     try {
         
         
         NetClientGet clientGet=new NetClientGet();
         String kq=clientGet.getClientJson(linkapi);
         
        Gson gson = new Gson();
        List<JobModel> jms=new ArrayList<>();
        dsKq =  gson.fromJson(kq,new TypeToken<List<DistrictList>>(){}.getType());
 
         return dsKq;
     } catch (Exception e) {
         return dsKq;
     }
     
    }
    
     public  List<CityList> dscitylist() {
        
         String linkapi=URLAPIJAVA+"api/danhmuc/CityList";
         List<CityList> dsKq;
         dsKq = new ArrayList<>();
     try {
         
         
         NetClientGet clientGet=new NetClientGet();
         String kq=clientGet.getClientJson(linkapi);
         
        Gson gson = new Gson();
        dsKq =  gson.fromJson(kq,new TypeToken<List<CityList>>(){}.getType());
 
         return dsKq;
     } catch (Exception e) {
         return dsKq;
     }
        
     
    }
 
   // Giao phieu chi nhanh.
// public  List<DmCitylist> dscitylist() {
//        
//
//         List<DmCitylist> dsKq;
//         dsKq = new ArrayList<>();
//     try {
//         
//         
//         NetClientGet clientGet=new NetClientGet();
//         LinkedTreeMap bientam = new LinkedTreeMap();
//         String kq=clientGet.getClientJson(linkbasic+"/danhmuc.citylist");
//         if(kq.equalsIgnoreCase("Error"))
//         {
//            kq=clientGet.getClientJson(linkbasic2+"/danhmuc.citylist");
//         }
//
//         java.lang.reflect.Type listType = new TypeToken<ArrayList<DmCitylist>>(){}.getType();
//         Gson gson = new Gson();
//         dsKq = new Gson().fromJson(kq, listType);
//       /*  List listdata = gson.fromJson(kq, List.class);
//           for (Object listdata1 : listdata) {
//            bientam.clear();
//            DmCitylist allWeb=new DmCitylist();
//            bientam = (LinkedTreeMap) listdata1;
//            String hieuluc =bientam.get("idValidity").toString();
//            if(hieuluc.contains("O"))
//            {    
//                 allWeb.setIdcode(bientam.get("idCode").toString());
//                 allWeb.setDescription(bientam.get("cityName").toString());
//                 dsKq.add(allWeb);
//            }
//            
//     }*/
//         
//         return dsKq;
//     } catch (Exception e) {
//         return dsKq;
//     }
//     
//    }
 
    // Giao phieu chi nhanh.
 public  List<DistrictList> dsquanhuyenlist(String city) {
        

         List<DistrictList> dsKq;
         dsKq = new ArrayList<>();
     try {
         
         
         NetClientGet clientGet=new NetClientGet();
         LinkedTreeMap bientam = new LinkedTreeMap();
         String kq=clientGet.getClientJson(linkbasic+"/danhmuc.districtlist");
         if(kq.equalsIgnoreCase("Error"))
         {
            kq=clientGet.getClientJson(linkbasic2+"/danhmuc.districtlist");
         }
         Gson gson = new Gson();
         List listdata = gson.fromJson(kq, List.class);
           for (Object listdata1 : listdata) {
            bientam.clear();
            DistrictList allWeb=new DistrictList();
            bientam = (LinkedTreeMap) listdata1;
            String hieuluc =bientam.get("idValidity").toString();
            String idcity =bientam.get("idCity").toString();
            if(hieuluc.contains("O") && idcity.contains(city) )
            {    
                 allWeb.setIdDistrict(bientam.get("idDistrict").toString());
                 allWeb.setDistrictName(bientam.get("districtName").toString());
                 try {
                    allWeb.setIdNvChitra(bientam.get("idNvChitra").toString());
                } catch (Exception e) {
                    allWeb.setIdNvChitra("NOVALUE");
                }
                 
                 dsKq.add(allWeb);
            }
            
     }
         
         return dsKq;
     } catch (Exception e) {
         return dsKq;
     }
     
    }
    
    
 
       
}
