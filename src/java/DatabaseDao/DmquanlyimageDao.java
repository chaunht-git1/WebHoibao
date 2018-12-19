 
package DatabaseDao;

import ConnectBean.ConnectionProvider;
import EntitiesBean.VwDmQuanlydotimagectietWeb;
import Global.SessionBean;
import LocalFuntionGlobal.HamUserAll;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

 
public class DmquanlyimageDao {
    
    
     public String updatettkhtodate(VwDmQuanlydotimagectietWeb vdqw,String reupdate ) throws SQLException {
       
        Connection con = ConnectionProvider.getCon();
        String kq = null;
        String userid = SessionBean.getUserId();

        String fnCall = "{?= call KH.PKS_HOIBAO_WEB_2018.CAPNHAT_DKHTTODAY_2018(?,?,?,?,?,?,?,?)}";
        try {
            CallableStatement stm = con.prepareCall(fnCall);

            stm.setQueryTimeout(1800);
            stm.registerOutParameter(1, oracle.jdbc.OracleTypes.VARCHAR);
            stm.registerOutParameter(5, oracle.jdbc.OracleTypes.DATE);
            stm.setString(2, vdqw.getSobn().toString());
            stm.setString(3, vdqw.getIdCtTuythan());
            stm.setString(4, vdqw.getSoCtTuythan());
            stm.setDate(5, new java.sql.Date(vdqw.getNgaycap().getTime()));
            stm.setString(6,vdqw.getIdnoicap());
            stm.setString(7,userid);
            stm.setString(8, vdqw.getMakhachhang());
            stm.setString(9, reupdate);
 

            stm.executeUpdate();
            kq = stm.getString(1);
            stm.close();
            //con.close();
            return kq;
        } catch (Exception e) {
            return kq;
        }
    }

    
     public String updatecmndtodate(String khoa, String loaict,String soct,String sobn,String reupdate) throws SQLException {
        ConnectionProvider.reconnectdbastatic();
        Connection con = ConnectionProvider.getCon();
        String kq = null;
        String userid = SessionBean.getUserId();

        String fnCall = "{?= call KH.PKS_HOIBAO_WEB.CAPNHATCMND_IMAGETODAY(?,?,?,?,?)}";
        try {
            CallableStatement stm = con.prepareCall(fnCall);

            stm.setQueryTimeout(1800);
            stm.registerOutParameter(1, oracle.jdbc.OracleTypes.VARCHAR);
            stm.setString(2, khoa);
            stm.setString(3, loaict);
            stm.setString(4, soct);
            stm.setString(5, sobn);
            stm.setString(6, reupdate);
 

            stm.executeUpdate();
            kq = stm.getString(1);
            stm.close();
            //con.close();
            return kq;
        } catch (Exception e) {
            return kq;
        }
    }

    
public String updatebiennhanerror(String khoa, String loaict,String soct,String sobn,String reupdate,Date ngaycap,String makhachhang ,String  ncap) throws SQLException {
      //  ConnectionProvider.reconnectdbastatic();
        Connection con = ConnectionProvider.getCon();
        String kq = null;
        String userid = SessionBean.getUserId();

        String fnCall = "{?= call KH.PKS_HOIBAO_WEB_2018.CAPNHATBIENNHANERROR_2018(?,?,?,?,?,?,?,?,?)}";
        try {
            CallableStatement stm = con.prepareCall(fnCall);

            stm.setQueryTimeout(1800);
            stm.registerOutParameter(1, oracle.jdbc.OracleTypes.VARCHAR);
            stm.setString(2, khoa);
            stm.setString(3, loaict);
            stm.setString(4, soct);
            stm.setString(5, userid);
            stm.setString(6, reupdate);
            stm.setString(7, sobn);
            stm.setDate(8, new java.sql.Date(ngaycap.getTime()));
            stm.setString(9, ncap);
            stm.setString(10, makhachhang);

            stm.executeUpdate();
            kq = stm.getString(1);
            stm.close();
            //con.close();
            // Di chuyen hinh 
         //    HamUserAll sa=new HamUserAll();
         //    Boolean kq1=sa.moveImageServer(khoa, sobn);
            

            return kq;
        } catch (Exception e) {
            return kq;
        }
    }

       
     public String  updatebiennhantheodothb(String khoa  ) throws SQLException {
        ConnectionProvider.reconnectdbastatic();
        Connection con = ConnectionProvider.getCon();
        String kq = null;
        String userid = SessionBean.getUserId();

        String fnCall = "{?= call KH.PKS_HOIBAO_WEB.INSERT_IMAGE_TODAY_2018(?,?) }";
        try {
            CallableStatement stm = con.prepareCall(fnCall);

            stm.setQueryTimeout(1800);
            stm.registerOutParameter(1, oracle.jdbc.OracleTypes.VARCHAR);
            stm.setString(2, khoa);
            stm.setString(3, userid);

            stm.executeUpdate();
            kq = stm.getString(1);
            stm.close();
           // con.close();

            return kq;
        } catch (Exception e) {
            return kq;
        }
    }

      public String deletebnchuaduyet(String khoa, String loaict,String soct,String sobn,String reupdate) throws SQLException {
       ConnectionProvider.reconnectdbastatic();
        Connection con = ConnectionProvider.getCon();
        String kq = null;
        String userid = SessionBean.getUserId();

        String fnCall = "{?= call KH.PKS_HOIBAO_WEB.DELETEBIENNHANCHUADUYET(?,?,?,?,?,?)}";
        try {
            CallableStatement stm = con.prepareCall(fnCall);

            stm.setQueryTimeout(1800);
            stm.registerOutParameter(1, oracle.jdbc.OracleTypes.VARCHAR);
            stm.setString(2, khoa);
            stm.setString(3, loaict);
            stm.setString(4, soct);
            stm.setString(5, userid);
            stm.setString(6, reupdate);
            stm.setString(7, sobn);

            stm.executeUpdate();
            kq = stm.getString(1);
            stm.close();
          //  con.close();

            return kq;
        } catch (Exception e) {
            return kq;
        }
    }

           
    
}
