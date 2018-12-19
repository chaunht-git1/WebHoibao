package LocalFuntionGlobal;

import ApiFunction.ApiKhachHangDao;
import EntitiesBean.VwDsUploadImagehbWeb;
import LocalModel.Customer;
import LocalModel.KhachhangchuanhoaModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

 
public class FunctionCustomer {
    
  
    
    public  String kiemtraKhachhang(KhachhangchuanhoaModel km)
    {
      
         
         try {
             
            ApiKhachHangDao akhd= new ApiKhachHangDao();
            Customer  khachhangnew= new Customer();
            String khdk=akhd.getCustomersoCMND(km.getIdCardNumber());
            if (khdk.equalsIgnoreCase("NOVALUE"))
            {
                // Tao khach hang moi
                VwDsUploadImagehbWeb imagehbWeb= new VwDsUploadImagehbWeb();
                 // Lay thong tin bien nhan .
                imagehbWeb= HamUserAll.getchitietgdformnvandsobn2018(km.getReceiptCode(),"A");
                khachhangnew=this.getInforKhachhang(imagehbWeb);
                khdk=akhd.saveCustomer(khachhangnew);
                return khdk;
            }
            else{
                
                //Gan thong tin khach hang vao id_khachhang . 
                return khdk;
                
            }

        } catch (Exception e) {
               return "NOVALUE";
        }
         
       
    }
    
 
    public  Customer getInforKhachhang(VwDsUploadImagehbWeb km){
  
        
                     Customer  khachhangnew= new Customer();
                     khachhangnew.setCustomerCode("");
                     khachhangnew.setFullname(km.getHoten());
                     khachhangnew.setDateOfBirth("");
                     khachhangnew.setGender("1");
                     khachhangnew.setJobCode("null");
                     khachhangnew.setCityId("null");
                     khachhangnew.setDistrictId("null");
                     khachhangnew.setAddress("null");
                     khachhangnew.setLongitude(0);
                     khachhangnew.setLatitude(0);
                     
                     khachhangnew.setIdCardNumber(km.getSoCtTuythan());
                     khachhangnew.setIdCardTypeCode(km.getIdCtTuythan());
                     khachhangnew.setPlaceOfIssue(km.getNoicap());
                     DateFormat dateFormat;
                     dateFormat=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                     khachhangnew.setDateOfIssue(dateFormat.format(km.getNgayCap()) );
                     khachhangnew.setIsHasBackImage(false);
                     khachhangnew.setIsHasBackImage(false);
                     khachhangnew.setCurrencyCode("null");
                     khachhangnew.setAmount(0);
                     String[] dsdienthoai= new String[1];
                     dsdienthoai[0]="";
                     khachhangnew.setPhones(dsdienthoai);
                     khachhangnew.setUsername("null");
                     khachhangnew.setInfoStatus(1);
                     khachhangnew.setIdCardFrontImage("");
                     khachhangnew.setIdCardBackImage("");
                     return khachhangnew;
                     
    }
     
}
