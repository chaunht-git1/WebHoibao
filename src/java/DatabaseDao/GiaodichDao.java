 
package DatabaseDao;

import ConnectBean.ConnectionProvider;
import LocalModel.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

 
public class GiaodichDao {
 
     String sql="select * from  KHMOBILE.VW_TONDONG_NV_ALL_WEB ";
     
public  String  timkiemsobn(String khoa,String valuetring )   {
      
         try {
             Connection con=ConnectionProvider.getCon();
             String  ketqua=null;
             // Tạo một câu SQL có 1 tham số (?)
             sql =  sql+"Where "+khoa+"=?" ;
             
             // Tạo một đối tượng PreparedStatement.
             PreparedStatement pstm = con.prepareStatement(sql);
             
             // Sét đặt giá trị tham số thứ nhất (Dấu ? thứ nhất)
             pstm.setString(1, valuetring);
             
             ResultSet rs = pstm.executeQuery();
             
             while (rs.next()) {
                 
                 ketqua=rs.getString("SOBN");
                 
             }
             
             pstm.close();
             
             return ketqua;
         } catch (SQLException ex) {
             return null;
         }
}
               
    
}
