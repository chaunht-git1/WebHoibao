 
package Controller;

 
import ApiFunction.ApiDao.ApiDanhmucDao;
import Apimodel.JobModel;
import Apimodel.LoaitienList;
 
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
 
import DatabaseDao.CitylistDao;
import DatabaseDao.DistrictlistDao;
import DatabaseDao.DoitacListDao;
import DatabaseDao.GiaytoDao;
import EntitiesBean.CityList;
import EntitiesBean.DistrictList;
import EntitiesBean.DmBankList;
import EntitiesBean.DoitacList;
import EntitiesBean.GiaytoList;
import LocalModel.GioitinhModel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 

 
@Named(value = "globalManagedBean")
@ApplicationScoped
public class GlobalManagedBean {

   private String description = "Alto has power windows";
   private  List<DoitacList> doitacLists= new ArrayList<>();
   private  List<LoaitienList> loaitienList= new ArrayList<>();
   private  List<GiaytoList> giaytoLists= new ArrayList<>();
   private  List<CityList> cityLists=new ArrayList<>();
   private  List<DistrictList>  districtLists=new ArrayList<>();
   private  List<JobModel> jobModels= new ArrayList<>();
   private  List<GioitinhModel> listGioitinhModel= new ArrayList<>();

   
    public GlobalManagedBean()  {
        
       try {
           this.init();
       } catch (SQLException ex) {
           Logger.getLogger(GlobalManagedBean.class.getName()).log(Level.SEVERE, null, ex);
       }
    
        
    }
   
   
   public   void init() throws SQLException{
       ApiDanhmucDao dao= new ApiDanhmucDao();
       doitacLists =this.laydsdoitac();
       jobModels=dao.getListJob();
       cityLists=this.laydscity();
       giaytoLists=laydsgiayto();
       dsgioitinh();
  
   }
   
    public void dsgioitinh( ) {
            listGioitinhModel= new ArrayList<>();
            GioitinhModel gioitinhModel= new GioitinhModel();
      
            gioitinhModel.setLabel("Nam");
            gioitinhModel.setValue(1);
            listGioitinhModel.add(gioitinhModel);
            
            gioitinhModel= new GioitinhModel();
            gioitinhModel.setLabel("Nu");
            gioitinhModel.setValue(0);
            listGioitinhModel.add(gioitinhModel);
 
    }
   
 public   List<DistrictList> dsquanhuyen(String idcity) throws SQLException {

        districtLists = new ArrayList<>();
        if (idcity != null) {
            DistrictlistDao dmDa = new DistrictlistDao();

            districtLists = dmDa.findOneParaString("ID_CITY", idcity);
            return districtLists;
        } else {
            return null;
        }

    }

 
   
   public List<DoitacList> laydsdoitac(){
       
       List<DoitacList> ketqua = new ArrayList<>();
       DoitacListDao dao= new DoitacListDao();
              
       //ketqua=dao.getdoitacimportweb();
       
       return ketqua;        
               
   }

    public List<DistrictList> getDistrictLists() {
        return districtLists;
    }

    public void setDistrictLists(List<DistrictList> districtLists) {
        this.districtLists = districtLists;
    }
   
     
  
      
      public List<GiaytoList> laydsgiayto() {
        giaytoLists = new ArrayList<>();
        GiaytoDao giayto = new GiaytoDao();

        try { 
            giaytoLists = giayto.findOneParaString("ID_VALIDITY", "O");
        } catch (Exception e) {
        }
        return giaytoLists;
    }
   
    public List<CityList> laydscity() {
        List<CityList> citylist = new ArrayList<>();
        ApiDanhmucDao dmDa = new ApiDanhmucDao();

        try {
            citylist = dmDa.dscitylist();
        } catch (Exception e) {
        }
        return citylist;
    }  
    
      public List<DistrictList> laydsdistrict() {
        List<DistrictList> districtlist = new ArrayList<>();
        DistrictlistDao district = new DistrictlistDao();
        try {
            String macity = null;
            //   macity = this.citys.getIdCode();
            districtlist = district.findOneParaString("ID_CITY", macity);
        } catch (Exception e) {
        }
        return districtlist;
    }

    public List<CityList> getCityLists() {
        return cityLists;
    }

    public void setCityLists(List<CityList> cityLists) {
        this.cityLists = cityLists;
    }
   
   
    public List<DoitacList> getDoitacLists() {
        return doitacLists;
    }

    public void setDoitacLists(List<DoitacList> doitacLists) {
        this.doitacLists = doitacLists;
    }
 
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<GioitinhModel> getListGioitinhModel() {
        return listGioitinhModel;
    }

    public void setListGioitinhModel(List<GioitinhModel> listGioitinhModel) {
        this.listGioitinhModel = listGioitinhModel;
    }
 

    public List<LoaitienList> getLoaitienList() {
        return loaitienList;
    }

    public void setLoaitienList(List<LoaitienList> loaitienList) {
        this.loaitienList = loaitienList;
    }

    public List<JobModel> getJobModels() {
        return jobModels;
    }

    public void setJobModels(List<JobModel> jobModels) {
        this.jobModels = jobModels;
    }

    public List<GiaytoList> getGiaytoLists() {
        return giaytoLists;
    }

    public void setGiaytoLists(List<GiaytoList> giaytoLists) {
        this.giaytoLists = giaytoLists;
    }
    
   
   
   
    
}
