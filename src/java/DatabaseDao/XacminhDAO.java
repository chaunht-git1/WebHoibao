 
package DatabaseDao;

import ConnectBean.ConnectionProvider;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import LocalModel.XacminhModel;

 
 
public class XacminhDAO {
    
  public String updatexacminhtodate( XacminhModel xacminhModel,String reupdate,String userid) throws SQLException {
        ConnectionProvider.reconnectdbastatic();
        Connection con = ConnectionProvider.getCon();
       
        String kq = null;
      //  String userid = SessionBean.getUserId();
        
  

        String fnCall = "{?= call KH.PKS_HOIBAO_WEB.FUNC_UPDATE_XM_CHINHA(?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            CallableStatement stm = con.prepareCall(fnCall);

            stm.setQueryTimeout(1800);
            stm.registerOutParameter(1, oracle.jdbc.OracleTypes.VARCHAR);
            stm.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
            stm.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
            stm.registerOutParameter(12, oracle.jdbc.OracleTypes.VARCHAR);
            
            stm.setString(2, xacminhModel.getId_chinhanh());
            stm.setString(3, xacminhModel.getSophieu());
            stm.setString(4, xacminhModel.getStt().toString());
            stm.setString(5, xacminhModel.getLydoxm());
            stm.setString(6, userid);
            stm.setString(7, xacminhModel.getLoaixm());
            stm.setString(8, "");
            stm.setString(9,xacminhModel.getXmdoitac());
            stm.setString(10,xacminhModel.getManguoinhan());
            stm.setString(11,xacminhModel.getNvchitra());
            stm.setString(12,xacminhModel.getSobiennhan());
 
 
             stm.executeUpdate();
             kq = stm.getString(1);
             stm.close();
             con.close();
            return kq;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    
    
   public String updatechitratodate( XacminhModel xacminhModel,String reupdate,String userid) throws SQLException {
        ConnectionProvider.reconnectdbastatic();
        Connection con = ConnectionProvider.getCon();
        String kq = null;
      //  String userid = SessionBean.getUserId();
 
        String fnCall = "{?= call KH.PKS_HOIBAO_WEB.UPDATE_CHITRAKHONGBN_TODAY(?,?,?,?,?,?)}";
      
        try {
            CallableStatement stm = con.prepareCall(fnCall);

            stm.setQueryTimeout(1800);
            stm.registerOutParameter(1, oracle.jdbc.OracleTypes.VARCHAR);
            stm.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
            stm.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
            stm.registerOutParameter(5, oracle.jdbc.OracleTypes.VARCHAR);
            
            stm.setString(2, xacminhModel.getId_chinhanh());
            stm.setString(3, xacminhModel.getSophieu());
            stm.setString(4, xacminhModel.getStt().toString());
            stm.setString(5, "001");
            stm.setString(6, xacminhModel.getSocmnd().toString());
            stm.setString(7, userid);

             stm.executeUpdate();
             kq = stm.getString(1);
             stm.close();
             con.close();
            return kq;
        } catch (Exception e) {
            return "";
        }
    }

   public String updatecmnddate( XacminhModel xacminhModel,String reupdate,String userid) throws SQLException {
        ConnectionProvider.reconnectdbastatic();
        Connection con = ConnectionProvider.getCon();
        String kq = null;
      //  String userid = SessionBean.getUserId();
 
        String fnCall = "{?= call KH.PKS_HOIBAO_WEB.UPDATE_CMNDKHONGBN(?,?,?,?,?)}";
 
        try {
            CallableStatement stm = con.prepareCall(fnCall);

            stm.setQueryTimeout(1800);
            stm.registerOutParameter(1, oracle.jdbc.OracleTypes.VARCHAR);
            stm.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
            stm.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
            stm.registerOutParameter(5, oracle.jdbc.OracleTypes.VARCHAR);
            
            stm.setString(2, xacminhModel.getId_chinhanh());
            stm.setString(3, xacminhModel.getSobiennhan());
            stm.setString(4, "001");
            stm.setString(5, xacminhModel.getSocmnd().toString());
            stm.setString(6, userid);

             stm.executeUpdate();
             kq = stm.getString(1);
             stm.close();
             con.close();
            return kq;
        } catch (Exception e) {
            return "";
        }
    }
  
    public String updatechuyentoday( XacminhModel xacminhModel,String reupdate,String userid) throws SQLException {
        ConnectionProvider.reconnectdbastatic();
        Connection con = ConnectionProvider.getCon();
        String kq = null;
      //  String userid = SessionBean.getUserId();
 
        String fnCall = "{?= call KH.PKS_HOIBAO_WEB.UPDATE_CHUYENKHONGBN(?,?,?,?,?)}";
 
        try {
            CallableStatement stm = con.prepareCall(fnCall);

            stm.setQueryTimeout(1800);
            stm.registerOutParameter(1, oracle.jdbc.OracleTypes.VARCHAR);
            stm.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
            stm.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
            stm.registerOutParameter(5, oracle.jdbc.OracleTypes.VARCHAR);
            
            stm.setString(2, xacminhModel.getId_chinhanh());
            stm.setString(3, xacminhModel.getSobiennhan());
            stm.setString(4, "001");
            stm.setString(5, xacminhModel.getSocmnd().toString());
            stm.setString(6, userid);

             stm.executeUpdate();
             kq = stm.getString(1);
             stm.close();
             con.close();
            return kq;
        } catch (Exception e) {
            return "";
        }
    }
    
      public String updatechuyenchinhanh( XacminhModel xacminhModel,String reupdate,String userid) throws SQLException {
        ConnectionProvider.reconnectdbastatic();
        Connection con = ConnectionProvider.getCon();
        String kq = null;
      //  String userid = SessionBean.getUserId();
        
  

        String fnCall = "{?= call KH.PKS_HOIBAO_WEB.FUNC_INSERT_MESS(?,?,?,?,?,?,?,?,?)}";
        try {
            CallableStatement stm = con.prepareCall(fnCall);

            stm.setQueryTimeout(1800);
            stm.registerOutParameter(1, oracle.jdbc.OracleTypes.VARCHAR);
            stm.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
            stm.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
            stm.registerOutParameter(9, oracle.jdbc.OracleTypes.VARCHAR);
            
            stm.setString(2, xacminhModel.getId_chinhanh());
            stm.setString(3, xacminhModel.getSophieu());
            stm.setString(4, xacminhModel.getStt().toString());
            stm.setString(5,"00001");
            stm.setString(6, userid);
            stm.setString(7, xacminhModel.getIdnvchitrachuyen());
            stm.setString(8,xacminhModel.getManguoinhan());
            stm.setString(9,xacminhModel.getSobiennhan());
            stm.setString(10,xacminhModel.getLydoxm());
 
             stm.executeUpdate();
             kq = stm.getString(1);
             stm.close();
             con.close();
            return kq;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

  public String updateTrangthaigd( String sbn,Number valueva) throws SQLException {
        ConnectionProvider.reconnectdbastatic();
        Connection con = ConnectionProvider.getCon();
        String kq = null;
      //  String userid = SessionBean.getUserId();
 
        String fnCall = "{?= call KH.PKS_HOIBAO_WEB.UPDATE_TRANGTHAIGD(?,?)}";
 
        try {
            CallableStatement stm = con.prepareCall(fnCall);

            stm.setQueryTimeout(1800);
            stm.registerOutParameter(1, oracle.jdbc.OracleTypes.VARCHAR);
            stm.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
            stm.registerOutParameter(3, oracle.jdbc.OracleTypes.NUMBER);
           
            
            stm.setString(2, sbn);
            stm.setLong(3,valueva.intValue());
 
             stm.executeUpdate();
             kq = stm.getString(1);
             stm.close();
             con.close();
            return kq;
        } catch (Exception e) {
            return "";
        }
    }
  
    
      
}

  
     
 
 


