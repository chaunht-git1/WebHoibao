 
package ConnectBean;
import static ConnectBean.Provider.CONNECTION_URL;
import static ConnectBean.Provider.DRIVER;
import static ConnectBean.Provider.PASSWORD;
import static ConnectBean.Provider.USERNAME;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
 
 
public class ConnectionProvider {
   
private static Connection con=null;

public static Connection getCon(){
    
    try {
        con=DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);
    } catch (SQLException ex) {
        Logger.getLogger(ConnectionProvider.class.getName()).log(Level.SEVERE, null, ex);
    }
	return con;
        
}

 
 

public static boolean isDbConnected(String sessionid) {
       
    try {
           
            String fnCall = "{call ? :=  KH.SMPKS.CHECK_SESSION_WEB(?)}";
            CallableStatement stm = con.prepareCall(fnCall);
            stm.registerOutParameter(1, Types.VARCHAR);
            stm.registerOutParameter(2, Types.VARCHAR);
            stm.setString(2, sessionid);      
            stm.execute();
            String ketqua = (String) stm.getString(1);
            stm.close();
         
            if (ketqua.equalsIgnoreCase("T")){
                return true; 
            }
            else{
                
                return false; 
            }
          
    } catch (SQLException | NullPointerException e) {
           
          
           return false;
        
    }

}

 public static void reconnectdbastatic (){
    
try{
// Kill cac session khac tren database .

Class.forName(DRIVER);

 
   con=DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);

}catch(ClassNotFoundException | SQLException e){}

}
 
 
 
}
