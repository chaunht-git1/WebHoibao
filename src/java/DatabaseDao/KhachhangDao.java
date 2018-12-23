 
package DatabaseDao;

import ConnectBean.ConnectionProvider;
import Global.SessionBean;
import LocalModel.Customer;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

 
public class KhachhangDao {
 
     String sql="select * from KH.VW_KHACHHANGTT_LIST_11 ";
     
public  Customer  timkiemkhachhangcmnd(String socmnd,String valuetring )  throws SQLException{
      
        Connection con=ConnectionProvider.getCon();
        Customer ketqua= new Customer();
            // Tạo một câu SQL có 1 tham số (?)
            sql =  sql+"Where "+socmnd+"=?" ;

            // Tạo một đối tượng PreparedStatement.
            PreparedStatement pstm = con.prepareStatement(sql);

            // Sét đặt giá trị tham số thứ nhất (Dấu ? thứ nhất)        
            pstm.setString(1, valuetring);

            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                
              Customer dataClass = new Customer();
              dataClass.setCustomerCode(rs.getString("ID_KHACHHANG"));
                try {
                  dataClass.setDateOfIssueDateValue(rs.getDate("NGAYCAP_CMND"));  
                } catch (Exception e) {
                  String abc=null;   
                }
                 dataClass.setIdCardNumber(rs.getString("SOCHUNGMINH"));
             
                try {
                    dataClass.setIdCardTypeCode("001");
                } catch (Exception e) {
                  String abc=null;   
                }
                try {
                    dataClass.setPlaceOfIssue(rs.getString("ID_NOICAPCMND"));
                } catch (Exception e) {
                  String abc=null;   
                }
            
              ketqua=dataClass;
            }
 
            pstm.close();
 
    return ketqua;
}

   public String updatettkh(Customer customer,String sobn) throws SQLException {
       
        Connection con = ConnectionProvider.getCon();
        String kq = null;
        String userid = SessionBean.getUserId();

        String fnCall = "{?= call KH.PKS_HOIBAO_WEB_2018.CAPNHAT_KHACHHANG_2018(?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            CallableStatement stm = con.prepareCall(fnCall);

            stm.setQueryTimeout(1800);
            stm.registerOutParameter(1, oracle.jdbc.OracleTypes.VARCHAR);
            stm.registerOutParameter(5, oracle.jdbc.OracleTypes.DATE);
            stm.registerOutParameter(6, oracle.jdbc.OracleTypes.DATE);
            
            stm.setString(2, sobn);
            stm.setString(3, customer.getCustomerCode());
            stm.setString(4, customer.getIdCardNumber());
            stm.setDate(5, new java.sql.Date(customer.getDateOfIssueDateValue().getTime()));
            stm.setDate(6, new java.sql.Date(customer.getDateOfBirthDateValue().getTime()));
            stm.setString(7,customer.getPlaceOfIssue());
            stm.setString(8, customer.getJobCode());
            stm.setString(9, customer.getGender());
            stm.setString(10, customer.getFullname());
            stm.setString(11, customer.getPhone());
            stm.setString(12, customer.getAddress());
            stm.setString(13, userid);
            stm.executeUpdate();
            kq = stm.getString(1);
            stm.close();
            //con.close();
            return kq;
        } catch (Exception e) {
            return kq;
        }
    }

  public String createttkh(Customer customer,String sobn) throws SQLException {
       
        Connection con = ConnectionProvider.getCon();
        String kq = null;
        String userid = SessionBean.getUserId();

        String fnCall = "{?= call KH.PKS_HOIBAO_WEB_2018.TAO_KHACHHANGTEMP_2018(?,?,?,?,?,? )}";
        try {
            CallableStatement stm = con.prepareCall(fnCall);

            stm.setQueryTimeout(1800);
            stm.registerOutParameter(1, oracle.jdbc.OracleTypes.VARCHAR);
            stm.registerOutParameter(5, oracle.jdbc.OracleTypes.DATE);
          
            
            stm.setString(2, sobn);
            stm.setString(3, customer.getCustomerCode());
            stm.setString(4, customer.getIdCardNumber());
            stm.setDate(5, new java.sql.Date(customer.getDateOfIssueDateValue().getTime()));      
            stm.setString(6,customer.getPlaceOfIssue());
            stm.setString(7,userid);
   

            stm.executeUpdate();
            kq = stm.getString(1);
            stm.close();
            //con.close();
            return "T";
        } catch (Exception e) {
            return kq;
        }
    }
}
