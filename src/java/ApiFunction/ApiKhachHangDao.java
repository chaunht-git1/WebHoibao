 
package ApiFunction;

import ApiFunction.NetClientGet;
 
import Apimodel.CardtypeModel;
import Apimodel.JobModel;
import static ConnectBean.Provider.LINKAPIKHACHHANGBASIC;
import static ConnectBean.Provider.URLAPI;
import LocalModel.Customer;
 
 
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

 
public class ApiKhachHangDao {
    
  private final String linkbasic= LINKAPIKHACHHANGBASIC+"api/customer";
 
   // Giao phieu chi nhanh.
 public  List<JobModel> getidcardimage(String funmane,String imageid) {
     
         String linkapi=linkbasic+"/"+funmane+"?ImageName="+imageid+".jpg";
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
 
 
 public  List<CardtypeModel> getListCardType(String funmane) {
        
         String linkapi=linkbasic+"/"+funmane;
         List<CardtypeModel> dsKq;
         dsKq = new ArrayList<>();
     try {
         
         
         NetClientGet clientGet=new NetClientGet();
         String kq=clientGet.getClientJson(linkapi);
         
        Gson gson = new Gson();
        dsKq =  gson.fromJson(kq,new TypeToken<List<CardtypeModel>>(){}.getType());
 
         return dsKq;
     } catch (Exception e) {
         return dsKq;
     }
     
    }  
 
    // Giao phieu chi nhanh.
 public  List<Customer> getListCustomerSoCMND(String funmane) {
         String linkapi=URLAPI+"api/customer/searchcustomer?Type=2&Keyword="+funmane;
 
         List<Customer> dsKq;
         dsKq = new ArrayList<>();
     try {
         
         
         NetClientGet clientGet=new NetClientGet();
         String kq=clientGet.getClientJson(linkapi);
         
        Gson gson = new Gson();
        Customer jms=new Customer();
        jms =  gson.fromJson(kq,new TypeToken<Customer>(){}.getType());
         if(jms!=null)
         {
             dsKq.add(jms);
         }
        
         return dsKq;
     } catch (Exception e) {
         return null;
     }
     
    }
 
  public  List<Customer> getListCustomerMaKH(String funmane) {
    
         String linkapi=URLAPI+"api/customer/searchcustomer?Type=1&Keyword="+funmane;
         List<Customer> dsKq;
         dsKq = new ArrayList<>();
     try {
         
         
         NetClientGet clientGet=new NetClientGet();
         String kq=clientGet.getClientJson(linkapi);
         
        Gson gson = new Gson();
        Customer jms=new Customer();
        jms =  gson.fromJson(kq,new TypeToken<Customer>(){}.getType());
        // Convert thong tin ngay  .
       String phone = null;
       String[] listphone=jms.getPhones();
         for (int i = 0; i < listphone.length; i++) {
             
             phone=phone+" "+listphone[i];
             
         }
     //  jms.setPhone(phone);
       try {
            String sDate=jms.getDateOfIssue();
            Date ngaycapDate=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(sDate);
            jms.setDateOfIssueDateValue(ngaycapDate);
         } catch (Exception e) {
            jms.setDateOfIssueDateValue(null); 
         }
        
        try {
            
            String sDate1=jms.getDateOfBirth();
            Date ngaycapDate1=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(sDate1);
            jms.setDateOfBirthDateValue(ngaycapDate1);
             
         } catch (Exception e) {
            jms.setDateOfBirthDateValue(null); 
         }
        
        
        
        dsKq.add(jms);
         return dsKq;
     } catch (Exception e) {
         return null;
     }
     
    }
  
  
 public  List<Customer> getListCustomerCMND(String funmane) {
       
         String linkapi=URLAPI+"api/customer/searchcustomer?Type=2&Keyword="+funmane;
         List<Customer> dsKq;
         dsKq = new ArrayList<>();
     try {
         
         
         NetClientGet clientGet=new NetClientGet();
         String kq=clientGet.getClientJson(linkapi);
         
        Gson gson = new Gson();
        Customer jms=new Customer();
        jms =  gson.fromJson(kq,new TypeToken<Customer>(){}.getType());
        // Convert thong tin ngay  .
       String phone = null;
       String[] listphone=jms.getPhones();
         for (int i = 0; i < listphone.length; i++) {
             
             phone=phone+" "+listphone[i];
             
         }
     //  jms.setPhone(phone);
       try {
            String sDate=jms.getDateOfIssue();
            Date ngaycapDate=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(sDate);
            jms.setDateOfIssueDateValue(ngaycapDate);
         } catch (Exception e) {
            jms.setDateOfIssueDateValue(null); 
         }
        
        try {
            
            String sDate1=jms.getDateOfBirth();
            Date ngaycapDate1=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(sDate1);
            jms.setDateOfBirthDateValue(ngaycapDate1);
             
         } catch (Exception e) {
            jms.setDateOfBirthDateValue(null); 
         }
        
        
        
        dsKq.add(jms);
         return dsKq;
     } catch (Exception e) {
         return null;
     }
     
    }
  
  
  
   public  List<Customer> getListCustomerDienthoai(String funmane) {
        
         String linkapi=linkbasic+"/getcustomerbyphone?Phone="+funmane;
         List<Customer> dsKq;
         dsKq = new ArrayList<>();
     try {
         
         
         NetClientGet clientGet=new NetClientGet();
         String kq=clientGet.getClientJson(linkapi);
         
        Gson gson = new Gson();
        Customer jms=new Customer();
        dsKq =  gson.fromJson(kq,new TypeToken<List<Customer>>(){}.getType());
        dsKq.add(jms);
         return dsKq;
     } catch (Exception e) {
         return null;
     }
     
    }
 
    public String updatekhachhang(Customer inputClass) throws SQLException, IOException {
        
      try {
 
          Gson gson = new Gson();
          
          String cusjson=gson.toJson(inputClass);
          
          
          HttpClient httpclient = new DefaultHttpClient();
          HttpPost httppost = new HttpPost(URLAPI+"api/customer/savecustomer");
        // httppost.addHeader("Content-Type","text/html");
          StringBody stringBody= new StringBody(cusjson, ContentType.APPLICATION_JSON);
          MultipartEntityBuilder builder = MultipartEntityBuilder.create();
          
          builder.addPart("Customer", stringBody);
          HttpEntity entity = builder.build();
          httppost.setEntity(entity);
          HttpResponse response = httpclient.execute(httppost);
          String kq=EntityUtils.toString(response.getEntity());
 
          
           return kq;
      } catch (UnsupportedEncodingException ex) {
 
           return "F";
      }
        
        
    }
      
 
  public  String  getCustomersoCMND(String funmane) {
    
         String linkapi=URLAPI+"api/customer/searchcustomer?Type=1&Keyword="+funmane;
      
        
     try {
         
         
         NetClientGet clientGet=new NetClientGet();
         String kqstring=clientGet.getClientJson(linkapi);
         
        Gson gson = new Gson();
        Customer jms=new Customer();
        jms =  gson.fromJson(kqstring,new TypeToken<Customer>(){}.getType());
       
         return jms.getCustomerCode();
     } catch (Exception e) {
         return "NOVALUE";
     }
     
    }     
  
  
   public String saveCustomer(Customer inputClass) throws SQLException, IOException {
        
      try {
 
          Gson gson = new Gson();
          
          String cusjson=gson.toJson(inputClass);
          
          
          HttpClient httpclient = new DefaultHttpClient();
          HttpPost httppost = new HttpPost(URLAPI+"api/customer/savecustomer");
        // httppost.addHeader("Content-Type","text/html");
          StringBody stringBody= new StringBody(cusjson, ContentType.APPLICATION_JSON);
          MultipartEntityBuilder builder = MultipartEntityBuilder.create();
          
          builder.addPart("Customer", stringBody);
          HttpEntity entity = builder.build();
          httppost.setEntity(entity);
          HttpResponse response = httpclient.execute(httppost);
          String kqjson=EntityUtils.toString(response.getEntity());
          String kq =  gson.fromJson(kqjson,String.class); 
          
           return kq;
      } catch (UnsupportedEncodingException ex) {
 
           return "F";
      }
        
        
    }
       
}
