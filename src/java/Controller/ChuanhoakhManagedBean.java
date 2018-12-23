 
package Controller;

 
import ApiFunction.ApiDao.ApiDanhmucDao;
import ApiFunction.ApiDao.Apichuanhoakh;
import ApiFunction.ApiKhachHangDao;
import DatabaseDao.KhachhangDao;
import DatabaseDao.XacminhDAO;
import EntitiesBean.DistrictList;
import LocalFuntionGlobal.FunctionCustomer;
import LocalFuntionGlobal.SessionBean;
import LocalModel.Customer;
import LocalModel.KhachhangchuanhoaModel;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
 
@Named(value = "chuanhoakhManagedBean")
@SessionScoped
public class ChuanhoakhManagedBean implements Serializable  {
    
    private List<KhachhangchuanhoaModel> listdata = new ArrayList<>();
    private List<Customer> listkh=new ArrayList<>();
    private Customer khachhangmodel=new  Customer();
    private KhachhangchuanhoaModel khachhangchuanhoaModel=new KhachhangchuanhoaModel();
    private List<DistrictList>  districtLists= new ArrayList<>();
    private List<String> phoneList= new ArrayList<>();
 
    public ChuanhoakhManagedBean() {
        
 
    }
 
    
    public  void  dskhachhangchuachuan(String userid){
        
        listdata= new ArrayList<>();
        Apichuanhoakh apichuanhoakh=new Apichuanhoakh();
        FunctionCustomer functionCustomer= new FunctionCustomer();
        listdata=apichuanhoakh.dskhchuachuanhoa(userid);

        
    }
    
     public  void  taokh( ){
         
         KhachhangDao khachhangDao= new KhachhangDao();
         Customer customer=new Customer();
         customer.setIdCardNumber("999888777666557");
         customer.setIdCardTypeCode("001");
         customer.setDateOfIssueDateValue(new Date());
        try {
            String makhachhang = khachhangDao.createttkh(customer, "17821356");
        } catch (SQLException ex) {
            Logger.getLogger(ChuanhoakhManagedBean.class.getName()).log(Level.SEVERE, "taokh", ex);
        }
        
    }
    
      public String timtheoloaigiayto(String makh,KhachhangchuanhoaModel km) throws SQLException {
         // Lay thong tin khach hang . 
          khachhangchuanhoaModel=new KhachhangchuanhoaModel();
          khachhangchuanhoaModel=km;
          KhachhangDao khachhangDao= new KhachhangDao();
          khachhangmodel= new Customer();
          String makhachhang=null;
    
              if(km.getIdCardNumber() != null)
              {
                  khachhangmodel=khachhangDao.timkiemkhachhangcmnd("SOCHUNGMINH",km.getIdCardNumber());
                  if (khachhangmodel.getCustomerCode()==null){
                      
                      khachhangmodel.setFullname(km.getReceiverName());
                      khachhangmodel.setIdCardNumber(km.getIdCardNumber());
                      khachhangmodel.setIdCardTypeCode(km.getIdCardTypeCode());
                      //khachhangmodel.setDateOfIssueDateValue(km.get);
                      //khachhangmodel.setPlaceOfIssue(km.get);
                      makhachhang = khachhangDao.createttkh(khachhangmodel, km.getReceiptCode());
                      
                      return "capnhatttkhachhang"+ "?faces-redirect=true";
                  }
                  else{
                      
                      return "capnhatttkhachhang"+ "?faces-redirect=true";
                  }
               
              }
              else{
                  
                  return null;
                  
              }
             
      
 
    }
      
    public String capnhatkhachhang2018(Customer customer,String userid ,String sobn ) {
          
          Customer customertemp= new Customer();
          customertemp=customer;
          DateFormat dateFormat;
          KhachhangDao khachhangDao= new KhachhangDao();
          String kqgd=null;
        try {
            
              kqgd=khachhangDao.updatettkh(customer, userid);    
                    
         } catch (SQLException ex) {
            Logger.getLogger(ChuanhoakhManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  
        try {
        
          if(!kqgd.equalsIgnoreCase("F"))
          {   
              XacminhDAO xdao= new XacminhDAO();
              // Cap nhat giao dich .
              String kq=xdao.updateTrangthaigd(khachhangchuanhoaModel.getReceiptCode(), 3);
              if (kq.equalsIgnoreCase("T"))
              {
                 this.dskhachhangchuachuan(userid);
                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cập nhật  thành công", ""));
                 return "chuanhoakh"+ "?faces-redirect=true";
              }
              else{
                
                  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cập nhật  thất bại", ""));
                  return null;
              }
              
          }
        } catch (SQLException ex) {
            Logger.getLogger(ChuanhoakhManagedBean.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }
        
         return null;
        
    }
    
    
     public   void dsquanhuyen(String idcity) throws SQLException {

           districtLists = new ArrayList<>();
 
            ApiDanhmucDao dmDa = new ApiDanhmucDao();

          //  districtLists = dmDa.findOneParaString("ID_CITY", idcity);
           districtLists =dmDa.getDistrictList(idcity);
       

    }
    
    private Customer  taokhachhangmoi(KhachhangchuanhoaModel km  ){
           // Tao khach hang moi. 
                 Customer  khachhangnew= new Customer();
                 khachhangnew.setCustomerCode("");
                 khachhangnew.setIdCardNumber(km.getIdCardNumber());
                 khachhangnew.setFullname(km.getReceiverName());
                 khachhangnew.setIdCardTypeCode(km.getIdCardTypeCode());
                 khachhangnew.setAddress(km.getReceiverAddress());
                 khachhangnew.setCityId(km.getCityId());
                 khachhangnew.setDistrictId(km.getDistrictId());
                 ApiKhachHangDao akhd= new ApiKhachHangDao();
                  try {
                      ApiKhachHangDao apiKhachHangDao= new ApiKhachHangDao();
                      String makhachhang=akhd.updatekhachhang(khachhangnew);
                      listkh=apiKhachHangDao.getListCustomerMaKH(makhachhang);
                      khachhangmodel=listkh.get(0);
                      return khachhangmodel;
                  } catch (SQLException ex) {
                      return null;
                  } catch (IOException ex) {
                        return null;
                  }
                 
    }
     
     
    public List<KhachhangchuanhoaModel> getListdata() {
        return listdata;
    }

    public void setListdata(List<KhachhangchuanhoaModel> listdata) {
        this.listdata = listdata;
    }

    public List<Customer> getList() {
        return listkh;
    }

    public void setList(List<Customer> list) {
        this.listkh = list;
    }

    public List<Customer> getListkh() {
        return listkh;
    }

    public void setListkh(List<Customer> listkh) {
        this.listkh = listkh;
    }

    public Customer getKhachhangmodel() {
        return khachhangmodel;
    }

    public void setKhachhangmodel(Customer khachhangmodel) {
        this.khachhangmodel = khachhangmodel;
    }

    public KhachhangchuanhoaModel getKhachhangchuanhoaModel() {
        return khachhangchuanhoaModel;
    }

    public void setKhachhangchuanhoaModel(KhachhangchuanhoaModel khachhangchuanhoaModel) {
        this.khachhangchuanhoaModel = khachhangchuanhoaModel;
    }

    public List<DistrictList> getDistrictLists() {
        return districtLists;
    }

    public void setDistrictLists(List<DistrictList> districtLists) {
        this.districtLists = districtLists;
    }

    public List<String> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<String> phoneList) {
        this.phoneList = phoneList;
    }
 
 
    
    
    
}
