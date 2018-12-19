
package ApiFunction.ApiDao;

import ApiFunction.NetClientGet;
import static ConnectBean.Provider.LINKAPIKHACHHANGBASIC;
import static ConnectBean.Provider.URLAPI;
import LocalModel.KhachhangchuanhoaModel;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

public class Apichuanhoakh {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = LINKAPIKHACHHANGBASIC+"api/receipt/getlistreceiptmisscustomer?Username=";

    public Apichuanhoakh() {
        
    }

  public   List<KhachhangchuanhoaModel> dskhchuachuanhoa(String userid) {

         List<KhachhangchuanhoaModel> dsKq;
         dsKq = new ArrayList<>();
     try {
         String urlstring = LINKAPIKHACHHANGBASIC+"api/receipt/getlistreceiptmisscustomer?Username=" ;
         Gson gson=new Gson();
         NetClientGet clientGet=new NetClientGet();
         LinkedTreeMap bientam = new LinkedTreeMap();
         String kq=clientGet.getClientJson(urlstring+userid);
         dsKq =  gson.fromJson(kq,new TypeToken<List<KhachhangchuanhoaModel> >(){}.getType());
         
         
 
         return dsKq;
     } catch (Exception e) {
         return dsKq;
     }
     
    }

    

 

  
 
    
}
