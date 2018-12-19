 
package DatabaseDao;
  
import ConnectBean.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import EntitiesBean.DistrictList;

 
 
public class DistrictlistDao {
    
    
    String sql="SELECT * FROM DISTRICT_LIST ";
    private List<DistrictList> districtList=new ArrayList<>();
    
    
public List<DistrictList> findAll( ) throws SQLException{
        DistrictList dataClass = new DistrictList();
        Connection con=ConnectionProvider.getCon();
        

            // Tạo một câu SQL có 1 tham số (?)
         //   sql = sql;

            // Tạo một đối tượng PreparedStatement.
            PreparedStatement pstm = con.prepareStatement(sql);

            // Sét đặt giá trị tham số thứ nhất (Dấu ? thứ nhất)        
            //pstm.setString(1, Id);

            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                
              dataClass.setIdDistrict(rs.getString("ID_DISTRICT"));
              dataClass.setIdCity(rs.getString("ID_CITY"));
              dataClass.setDistrictName(rs.getString("DISTRICT_NAME"));
              dataClass.setIdValidity(rs.getString("ID_VALIDITY"));
              
              this.districtList.add(dataClass);
            }

            pstm.close();
    
    return districtList;
}

public List<DistrictList> findOneParaString(   String prmname1,String prmvalue1) throws SQLException{
       
            Connection con=ConnectionProvider.getCon();

            // Tạo một câu SQL có 1 tham số (?)
            sql =  sql+"Where "+prmname1+"=? order by DISTRICT_NAME asc" ;

            // Tạo một đối tượng PreparedStatement.
            PreparedStatement pstm = con.prepareStatement(sql);

            // Sét đặt giá trị tham số thứ nhất (Dấu ? thứ nhất)        
            pstm.setString(1, prmvalue1);

            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                
              DistrictList dataClass = new DistrictList();
              dataClass.setIdDistrict(rs.getString("ID_DISTRICT"));
              dataClass.setIdCity(rs.getString("ID_CITY"));
              dataClass.setDistrictName(rs.getString("DISTRICT_NAME"));
              dataClass.setIdValidity(rs.getString("ID_VALIDITY"));
             
              districtList.add(dataClass);
              
            }
           
            pstm.close();
    
    return districtList;
}
    
 


    
    
    
}
 
 


