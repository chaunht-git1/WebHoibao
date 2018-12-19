package DatabaseDao;

import Global.SessionBean;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import javax.servlet.http.HttpSession;
import ConnectBean.ConnectionProvider;

public class LoginDao {

 

    public static boolean validate(String user, String password) {
        boolean status = false;
        String ketqua;
        HttpSession session = SessionBean.getSession();
        String sessionid = session.getId();

        try {

            // Kiem tra trang thai reload hay moi khoi tao  .   
           // ConnectionProvider.reconnectdbastatic();
            Connection con=ConnectionProvider.getCon();
            String fnCall = "{ ? = call KH.SMPKS.fn_sign_on_java(?,?,?)}";
            CallableStatement stm = con.prepareCall(fnCall);
            stm.registerOutParameter(1, Types.VARCHAR);
            stm.registerOutParameter(2, Types.VARCHAR);
            stm.registerOutParameter(3, Types.VARCHAR);
            stm.setString(2, user.toUpperCase());
            stm.setString(3, password.toUpperCase());
            stm.setString(4, sessionid);
            stm.execute();
            ketqua = (String) stm.getString(1);
            stm.close();

            // stm.close();
            if (ketqua.equalsIgnoreCase("T")) {
 
    
                return true;

            } else {
     
                return false;
            }

        } catch (SQLException ex) {

         
            return false;

        }

    }

}
