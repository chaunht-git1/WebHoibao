package DatabaseDao;

import ConnectBean.ConnectionProvider;
import EntitiesBean.DoitacList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoitacListDao {

    private String sql = " SELECT * FROM KH.DOITAC_LIST ";
    private List<DoitacList> doitacLists = new ArrayList<>();

    public List<DoitacList> getdoitacimportweb() throws SQLException {
        
        ConnectionProvider.reconnectdbastatic();
        Connection con = ConnectionProvider.getCon();
        sql += " WHERE ID_VALIDITY='O' AND IMPORT_WEB='Y'";

        PreparedStatement ps = con.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            DoitacList d = new DoitacList();
            d.setIdCode(rs.getString("ID_CODE"));
            d.setDescription(rs.getString("DESCRIPTION"));
            d.setDiachi(rs.getString("DIACHI"));
            d.setIdCity(rs.getString("ID_CITY"));
            d.setTel(rs.getString("TEL"));
            d.setFax(rs.getString("FAX"));
            d.setIdValidity(rs.getString("ID_VALIDITY"));
            d.setDateModified(rs.getDate("DATE_MODIFIED"));
            d.setIdNational(rs.getString("ID_NATIONAL"));
            d.setSotaikhoan(rs.getString("SOTAIKHOAN"));
            d.setIdKyhopdong(rs.getString("ID_KYHOPDONG"));
            d.setNguoidaidien(rs.getString("NGUOIDAIDIEN"));
            d.setChucdanh(rs.getString("CHUCDANH"));
            d.setIdDanghoahong(rs.getString("ID_DANGHOAHONG"));
            d.setIdCongnoCodinh(rs.getString("ID_CONGNO_CODINH"));
        
            d.setTinhnguyente(rs.getString("TINHNGUYENTE"));
            d.setTachhoahong(rs.getString("TACHHOAHONG"));
          
            d.setThitruong(rs.getString("THITRUONG"));
        
            d.setTygiatheobank(rs.getString("TYGIATHEOBANK"));
           
            d.setTentiengviet(rs.getString("TENTIENGVIET"));
            d.setTentienganh(rs.getString("TENTIENGANH"));
      
            d.setMasothue(rs.getString("MASOTHUE"));
        
   

            doitacLists.add(d);
        }
        ps.close();
        con.close();
        return doitacLists;
    }
 


     
}
