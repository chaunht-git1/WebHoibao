 
package ApiFunction;

 
import static ConnectBean.Provider.LINKAPIKHACHHANGBASIC;
import static ConnectBean.Provider.URLAPI;
import static ConnectBean.Provider.URL_API;
import static ConnectBean.Provider.URL_API_KH;
import EntitiesBean.VwKshbHosonvchinhaAll;
import EntitiesBean.VwTondongNvAllWeb;
import LocalModel.DshosoMg;
import LocalModel.UserModel;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
 
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
 
 
public class ApiFun {
    
//     public static void main(String[] args) {
//         ApiFu clientGet=new NetClientGet();
//         String kq=clientGet.getClientJson("http://emoney-web.dongamoneytransfer.com.vn/ServerRestKieuhoi/webresources/vwtondongnvallweb");
//         LinkedTreeMap kq1=tc.getApidataID("vwtondongnvallweb","06308042017000021090");
//        
//
//    
//	}
    
   // private final String linkbasic="http://rest.dongamoneytransfer.com.vn/ServerRestKieuhoi/webresources";
    //private final String linkbasic="http://192.168.42.10/ApiServerJava/api";
    private final String linkbasic=URL_API_KH;
    public List getApidata(String  linkapi){
        
         //String linkbasic="http://emoney-web.dongamoneytransfer.com.vn/ServerRestKieuhoi/webresources/" ;
         NetClientGet clientGet=new NetClientGet();
         String kq=clientGet.getClientJson(linkbasic+linkapi);
         Gson gson = new Gson();
         List listdata = gson.fromJson(kq, List.class);
         return listdata;
        
    }
    
       public LinkedTreeMap getApidataID(String  linkapi ,String id){
           
         String linkbasic="http://emoney-web.dongamoneytransfer.com.vn/ServerRestKieuhoi/webresources/" ;
         NetClientGet clientGet=new NetClientGet();
         String kq=clientGet.getClientJson(linkbasic+linkapi+"/"+id);
         Gson gson = new Gson();    
         LinkedTreeMap bientam = new LinkedTreeMap();
         bientam=gson.fromJson(kq, LinkedTreeMap.class);
         return bientam;
        
    }
       
       
 public  List<VwTondongNvAllWeb> dsdondongchitiet(String chinhanh,String nvchitra,String loaitk) {
        

         List<VwTondongNvAllWeb> dsKq;
         dsKq = new ArrayList<>();
     try {
         
         String linkbasic="http://rest.dongamoneytransfer.com.vn/ServerRestKieuhoi/webresources/vwtondongnvallweb/dschinhanhtheonv/"+chinhanh+"/"+nvchitra;
         NetClientGet clientGet=new NetClientGet();
         LinkedTreeMap bientam = new LinkedTreeMap();
         String kq=clientGet.getClientJson(linkbasic);
         Gson gson = new Gson();
         java.lang.reflect.Type listType = new TypeToken<ArrayList<VwTondongNvAllWeb>>(){}.getType();
        // Gson gson = new Gson();
         dsKq = new Gson().fromJson(kq, listType);
  
      /*   List listdata = gson.fromJson(kq, List.class);
           for (Object listdata1 : listdata) {
            bientam.clear();
            VwTondongNvAllWeb allWeb=new VwTondongNvAllWeb();
            bientam = (LinkedTreeMap) listdata1;
            String a= bientam.get("codemg").toString();
            allWeb.setCodemg(bientam.get("codemg").toString());
            allWeb.setIdcode(bientam.get("idcode").toString());
            allWeb.setDaxacminh(bientam.get("daxacminh").toString());
            BigInteger bien=BigInteger.valueOf((long)Double.parseDouble(bientam.get("daxmmobile").toString())) ;
            allWeb.setDaxmmobile(bien);
            allWeb.setDiachi(bientam.get("diachi").toString());
            allWeb.setDienthoai(bientam.get("dienthoai").toString());
            allWeb.setHoten(bientam.get("hoten").toString());
            allWeb.setHotenNv(bientam.get("hotenNv").toString());
            allWeb.setHsdot1(bientam.get("hsdot1").toString());
            allWeb.setHsdot3(bientam.get("hsdot3").toString());
            allWeb.setIdChinhanh(bientam.get("idChinhanh").toString());
            allWeb.setIdDoitac(bientam.get("idDoitac").toString());
            allWeb.setIdKhachhangtt(bientam.get("idKhachhangtt").toString());
            allWeb.setIdLoaitienchitra(bientam.get("idLoaitienchitra").toString());
            allWeb.setIdNvChitra(bientam.get("idNvChitra").toString());
            allWeb.setIdQlqDottg(bientam.get("idQlqDottg").toString());
            allWeb.setMaNguoinhan(bientam.get("maNguoinhan").toString());
            allWeb.setNguoigoi(bientam.get("nguoigoi").toString());
            allWeb.setQuydinhxm(bientam.get("quydinhxm").toString());
            double q=  Double.parseDouble(bientam.get("sobn").toString());
            long sobn=(long)q;
            allWeb.setSobn(sobn);
            allWeb.setSophieu(bientam.get("sophieu").toString());
            BigDecimal bigstg = BigDecimal.valueOf(Double.parseDouble(bientam.get("sotiengoi").toString()));
            allWeb.setSotiengoi(bigstg );
            double qtam=  Double.parseDouble(bientam.get("stt").toString());
            long stt=(long)qtam;
            BigInteger bigstt = BigInteger.valueOf(stt);
            allWeb.setStt(bigstt);
            allWeb.setTenDoitac(bientam.get("tenDoitac").toString() );
            allWeb.setTenchinhanh(bientam.get("tenchinhanh").toString());
            try {
                  allWeb.setSoCtTuythan(bientam.get("soCtTuythan").toString());
               } catch (Exception e) {
               }
            
            try {
                
                BigDecimal bigthanhtien = BigDecimal.valueOf(Double.parseDouble(bientam.get("thanhtien").toString()));
                allWeb.setThanhtien((bigthanhtien));
                
                
            } catch (Exception e) {
                 allWeb.setThanhtien(null);
            }
            try {
  
                BigDecimal bigtygia= BigDecimal.valueOf(Double.parseDouble(bientam.get("tygia").toString()));
                allWeb.setTygia(bigtygia);
                
            } catch (Exception e) {
                allWeb.setTygia(null);
            }
            dsKq.add(allWeb);
     }*/
         
         return dsKq;
     } catch (Exception e) {
         return dsKq;
     }
     
    }
 
   public static List<VwKshbHosonvchinhaAll> dsthongkenhanvien(String chinhanh,String nvchitra,String loaitk) {
        
        List<VwKshbHosonvchinhaAll> dsKq;
        dsKq = new ArrayList<>();
        String linkbasic="http://rest.dongamoneytransfer.com.vn/ServerRestKieuhoi/webresources/vwkshbhosonvchinhaall/dshstheonv/"+chinhanh+"/"+nvchitra;
        NetClientGet clientGet=new NetClientGet();
        LinkedTreeMap bientam = new LinkedTreeMap();
        String kq=clientGet.getClientJson(linkbasic);
        Gson gson = new Gson();
        List listdata = gson.fromJson(kq, List.class);
        
        // Lay du lieu . 
        for (Object listdata1 : listdata) {
            bientam.clear();
            VwKshbHosonvchinhaAll allWeb=new VwKshbHosonvchinhaAll();
            bientam = (LinkedTreeMap) listdata1;
           
            allWeb.setIdChinhanh(bientam.get("idChinhanh").toString());
            allWeb.setTenchinhanh(bientam.get("idNvChitra").toString());
            allWeb.setChinhahoanthanh(bientam.get("chinhahoanthanh").toString());
            allWeb.setChoduyetbn(BigInteger.valueOf((long)Double.parseDouble(bientam.get("choduyetbn").toString() ))) ;
   
            allWeb.setChuachitra(BigInteger.valueOf((long)Double.parseDouble(bientam.get("chuachitra").toString() ))) ;
            allWeb.setDachitra(BigInteger.valueOf((long)Double.parseDouble(bientam.get("dachitra").toString())));
            allWeb.setDachitrachuabn(BigInteger.valueOf((long)Double.parseDouble(bientam.get("dachitrachuabn").toString())));
            allWeb.setDaquyetbn(BigInteger.valueOf((long)Double.parseDouble(bientam.get("daquyetbn").toString())));
            allWeb.setErrorbn(BigInteger.valueOf((long)Double.parseDouble(bientam.get("errorbn").toString())));
            allWeb.setHoanthanh(bientam.get("hoanthanh").toString());
            allWeb.setHoten(bientam.get("hoten").toString());
            allWeb.setShs(BigInteger.valueOf((long)Double.parseDouble(bientam.get("shs").toString())));
            allWeb.setShsguixm(BigInteger.valueOf((long)Double.parseDouble(bientam.get("shsguixm").toString())));
            allWeb.setShstondong(BigInteger.valueOf((long)Double.parseDouble(bientam.get("shstondong").toString())));
            allWeb.setShsxacminh(BigInteger.valueOf((long)Double.parseDouble(bientam.get("shsxacminh").toString())));
            allWeb.setSlmoneygram(BigInteger.valueOf((long)Double.parseDouble(bientam.get("slmoneygram").toString())));
            allWeb.setSlmoneygramdot1(BigInteger.valueOf((long)Double.parseDouble(bientam.get("slmoneygramdot1").toString())));
            allWeb.setSoluonghbmobile(BigInteger.valueOf((long)Double.parseDouble(bientam.get("soluonghbmobile").toString())));
            dsKq.add(allWeb);
    }
        
   return dsKq;
   
}
   
   public  UserModel layThongUser(String username) {
      
       UserModel model=new UserModel(); 
       try {
       
         NetClientGet clientGet = new NetClientGet();
         Gson gson = new Gson();
         LinkedTreeMap bientam = new LinkedTreeMap();
         String kq = clientGet.getClientJson(linkbasic + "/login/laythongtinuser/" + username);
          
         
         if(!kq.equalsIgnoreCase("Error"))
         {
           // bientam  = gson.fromJson(kq, LinkedTreeMap.class);
            model =  gson.fromJson(kq,new TypeToken<UserModel>(){}.getType());
            
           /* model.setUsername(bientam.get("username").toString());
            model.setHomebranch(bientam.get("homebranch").toString());  
            model.setUserid(bientam.get("userid").toString());
          */
         }
         else{
             return null;
         }
         
         return model;
         
     } catch (Exception e) {
             LocalFuntionGlobal.SystemBean.proMessError(e.getMessage());
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
  
      public Boolean uploadimage(String  sobn ,InputStream fileupload) throws IOException {
        
      try {
          
          DefaultHttpClient httpclient = new DefaultHttpClient();
          HttpPost httppost = new HttpPost(LINKAPIKHACHHANGBASIC+"api/receipt/uploadreceiptimage");
          //httppost.addHeader("Content-Type","application/json;charset=utf-8");
          StringBody stringBody= new StringBody(sobn, ContentType.APPLICATION_JSON);
          String filename= sobn;
        //  FileBody data = new FileBody( fileupload, ContentType.DEFAULT_BINARY, filename);
          
          MultipartEntityBuilder builder = MultipartEntityBuilder.create();
          builder.addPart("ImageName", new InputStreamBody(fileupload, filename));
          //builder.addPart("ReceiptCode", stringBody);
          HttpEntity entity = builder.build();
          httppost.setEntity(entity);
          HttpResponse response = httpclient.execute(httppost);
           
          BufferedReader reader= new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
          StringBuffer  result=new StringBuffer();
          String line="";
          while ((line=reader.readLine()) !=null ){
             
              result.append(line);
              
          }
          
          String kqstring=result.toString();
          Boolean kqboo=Boolean.parseBoolean(kqstring);
          
           return kqboo;
      } catch (UnsupportedEncodingException ex) {    
           return  false;
      }
        
        
    }
   
}
    
    

