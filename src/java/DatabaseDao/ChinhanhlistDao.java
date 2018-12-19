 
package DatabaseDao;

import ConnectBean.ConnectionProvider;
import LocalModel.ChinhanhList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 
 
public class ChinhanhlistDao {
    
    
    String sql="select * from chinhanh_list ";
    private List<ChinhanhList> vwdskhtructuyenktList=new ArrayList<>();
    
    
public List<ChinhanhList> findAll( ) throws SQLException{
         ConnectionProvider.reconnectdbastatic();
         Connection con=ConnectionProvider.getCon();
        

            // Tạo một câu SQL có 1 tham số (?)
         //   sql = sql;

            // Tạo một đối tượng PreparedStatement.
            PreparedStatement pstm = con.prepareStatement(sql);

            // Sét đặt giá trị tham số thứ nhất (Dấu ? thứ nhất)        
            //pstm.setString(1, Id);

            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) { 
              ChinhanhList dataClass = new ChinhanhList();
              dataClass.setIdCode(rs.getString("ID_CODE"));
              dataClass.setDescription(rs.getString("DESCRIPTION"));
              dataClass.setIdValidity(rs.getString("ID_VALIDITY"));
              dataClass.setDateModified(rs.getDate("DATE_MODIFIED"));
              dataClass.setDiachi(rs.getString("DIACHI"));
              dataClass.setIdCity(rs.getString("ID_CITY"));
              dataClass.setIdTructhuoc(rs.getString("ID_TRUCTHUOC"));
              dataClass.setTentat(rs.getString("TENTAT"));
              dataClass.setTel(rs.getString("TEL"));
              dataClass.setFax(rs.getString("FAX"));
              dataClass.setIdTructhuoc(rs.getString("ID_TRUCTHUOC"));
              dataClass.setTentat(rs.getString("TENTAT"));
              dataClass.setThumucNhanfile(rs.getString("THUMUC_NHANFILE"));
              dataClass.setIdRegion(rs.getString("ID_REGION"));
              dataClass.setTimeLevel(rs.getShort("TIME_LEVEL"));
              dataClass.setMaSoThue(rs.getString("MA_SO_THUE"));
              dataClass.setIdRole(rs.getString("ID_ROLE"));
              dataClass.setScan(rs.getString("SCAN"));
              dataClass.setFullName(rs.getString("FULL_NAME"));
              dataClass.setMausoHd(rs.getString("MAUSO_HD"));
              dataClass.setTelHd(rs.getString("TEL_HD"));
              dataClass.setMausoHd2(rs.getString("DIACHI_HD"));
              dataClass.setIdTinhtamung(rs.getString("ID_TINHTAMUNG"));
              dataClass.setTentatHd(rs.getString("TENTAT_HD"));
              dataClass.setIdGdTructuyen(rs.getString("ID_GD_TRUCTUYEN"));
              dataClass.setIdGdTq(rs.getString("ID_GD_TQ"));
              dataClass.setIdGdTn(rs.getString("ID_GD_TN"));
              dataClass.setNhomTinhHh(rs.getString("NHOM_TINH_HH"));
              dataClass.setGiaophieuTudong(rs.getString("GIAOPHIEU_TUDONG"));
              dataClass.setIdKhuvucDv(rs.getString("ID_KHUVUC_DV"));
              dataClass.setRecordNote(rs.getString("RECORD_NOTE"));
              dataClass.setIdKhuvucQuayso(rs.getString("ID_KHUVUC_QUAYSO"));
              this.vwdskhtructuyenktList.add(dataClass);
            }
            
           

            pstm.close();
            //con.close();
    return vwdskhtructuyenktList;
}

public List<ChinhanhList> findOneParaString(   String prmname1,String prmvalue1) throws SQLException{
       ConnectionProvider.reconnectdbastatic();
        Connection con=ConnectionProvider.getCon();

            // Tạo một câu SQL có 1 tham số (?)
            sql =  sql+"Where "+prmname1+"=?" ;

            // Tạo một đối tượng PreparedStatement.
            PreparedStatement pstm = con.prepareStatement(sql);

            // Sét đặt giá trị tham số thứ nhất (Dấu ? thứ nhất)        
            pstm.setString(1, prmvalue1);

            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                
              ChinhanhList dataClass = new ChinhanhList();
              dataClass.setIdCode(rs.getString("ID_CODE"));
              dataClass.setDescription(rs.getString("DESCRIPTION"));
              dataClass.setIdValidity(rs.getString("ID_VALIDITY"));
              dataClass.setDateModified(rs.getDate("DATE_MODIFIED"));
              dataClass.setDiachi(rs.getString("DIACHI"));
              dataClass.setIdCity(rs.getString("ID_CITY"));
              dataClass.setIdTructhuoc(rs.getString("ID_TRUCTHUOC"));
              dataClass.setTentat(rs.getString("TENTAT"));
              dataClass.setTel(rs.getString("TEL"));
              dataClass.setFax(rs.getString("FAX"));
              dataClass.setIdTructhuoc(rs.getString("ID_TRUCTHUOC"));
              dataClass.setTentat(rs.getString("TENTAT"));
              dataClass.setThumucNhanfile(rs.getString("THUMUC_NHANFILE"));
              dataClass.setIdRegion(rs.getString("ID_REGION"));
              dataClass.setTimeLevel(rs.getShort("TIME_LEVEL"));
              dataClass.setMaSoThue(rs.getString("MA_SO_THUE"));
              dataClass.setIdRole(rs.getString("ID_ROLE"));
              dataClass.setScan(rs.getString("SCAN"));
              dataClass.setFullName(rs.getString("FULL_NAME"));
              dataClass.setMausoHd(rs.getString("MAUSO_HD"));
              dataClass.setTelHd(rs.getString("TEL_HD"));
              dataClass.setMausoHd2(rs.getString("DIACHI_HD"));
              dataClass.setIdTinhtamung(rs.getString("ID_TINHTAMUNG"));
              dataClass.setTentatHd(rs.getString("TENTAT_HD"));
              dataClass.setIdGdTructuyen(rs.getString("ID_GD_TRUCTUYEN"));
              dataClass.setIdGdTq(rs.getString("ID_GD_TQ"));
              dataClass.setIdGdTn(rs.getString("ID_GD_TN"));
              dataClass.setNhomTinhHh(rs.getString("NHOM_TINH_HH"));
              dataClass.setGiaophieuTudong(rs.getString("GIAOPHIEU_TUDONG"));
              dataClass.setIdKhuvucDv(rs.getString("ID_KHUVUC_DV"));
              dataClass.setRecordNote(rs.getString("RECORD_NOTE"));
              dataClass.setIdKhuvucQuayso(rs.getString("ID_KHUVUC_QUAYSO"));
             
              vwdskhtructuyenktList.add(dataClass);
              
            }

            pstm.close();
            //con.close();
    return vwdskhtructuyenktList;
}
    
 


    
    
    
}
 
 


