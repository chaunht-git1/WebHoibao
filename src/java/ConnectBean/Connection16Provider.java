 
package ConnectBean;

import static ConnectBean.Provider16.CONNECTION_URL;
import static ConnectBean.Provider16.PASSWORD;
import static ConnectBean.Provider16.USERNAME;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
 
 
public class Connection16Provider {
   
private static Connection con=null;

public static Connection getCon(){
    
    try {
        con=DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);
    } catch (SQLException ex) {
        Logger.getLogger(Connection16Provider.class.getName()).log(Level.SEVERE, null, ex);
    }
	return con;
        
}

 
 
}
