 
package ApiFunction;

 
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

 
public class NetClientGet {
    
//    public static void main(String[] args) {
//
//	 NetClientGet clientGet=new NetClientGet();
//         String kq=clientGet.getClientJson("http://emoney-web.dongamoneytransfer.com.vn/ServerRestKieuhoi/webresources/vwtondongnvallweb");
//         List kq2 ;
//         kq2=clientGet.ConvertJsonToJava(kq);
//         LinkedTreeMap bientam = new LinkedTreeMap();
//         bientam=(LinkedTreeMap) kq2.get(0);
//          
//        
//	}
    
    public  String getClientJson(String link){
        
        try {

		URL url = new URL(link);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
                conn.setRequestProperty("Accept-Charset", "UTF-8"); 

		if (conn.getResponseCode() != 200) {
			 return "Failed : HTTP error code : "+ conn.getResponseCode();
		}
              
		BufferedReader br;
                br = new BufferedReader(new InputStreamReader((conn.getInputStream()), "UTF-8"));
                String kq = null;
		String output;
		while ((output = br.readLine()) != null) {
                        kq=output;
		}

		conn.disconnect();
                return kq;

	  } catch (MalformedURLException e) {

                return "Error";
	  } catch (IOException e) {

                return null;
	  }
        
      
    }
    
    public  List ConvertJsonToJava(String jsonInString){
     
        Gson gson = new Gson();
        List listdata = gson.fromJson(jsonInString, List.class);
        return listdata;
        
    }
}
