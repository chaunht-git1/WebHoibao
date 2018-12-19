package DatabaseDao;

 
import ConnectBean.ConnectionProvider;
import EntitiesBean.CityList;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CitylistDao {

    String sql = "select * from city_list ";
    private List<CityList> vwdskhtructuyenktList = new ArrayList<>();

    public List<CityList> findAll() throws SQLException {
        Connection con = ConnectionProvider.getCon();

        // Tạo một câu SQL có 1 tham số (?)
        //   sql = sql;
        // Tạo một đối tượng PreparedStatement.
        sql += "order by city_name asc";
        PreparedStatement pstm = con.prepareStatement(sql);

        // Sét đặt giá trị tham số thứ nhất (Dấu ? thứ nhất)        
        //pstm.setString(1, Id);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            
            CityList dataClass = new CityList();
            dataClass.setIdCode(rs.getString("ID_CODE"));
            dataClass.setCityName(rs.getString("CITY_NAME"));
            dataClass.setIdValidity(rs.getString("ID_VALIDITY"));
            dataClass.setDistrictDefault(rs.getString("DISTRICT_DEFAULT"));
            dataClass.setIdNvUpdate(rs.getString("ID_NV_UPDATE"));
            dataClass.setIdCityOmex(rs.getString("ID_CITY_OMEX"));
            dataClass.setIdArea(rs.getString("ID_AREA"));
            dataClass.setIdHoiso(rs.getString("ID_HOISO"));
           
            this.vwdskhtructuyenktList.add(dataClass);
        }

        pstm.close();

        return vwdskhtructuyenktList;
    }

    public List<CityList> findOneParaString(String prmname1, String prmvalue1) throws SQLException {

        Connection con = ConnectionProvider.getCon();

        // Tạo một câu SQL có 1 tham số (?)
        sql = sql + "Where " + prmname1 + "=? order by city_name asc";

        // Tạo một đối tượng PreparedStatement.
        PreparedStatement pstm = con.prepareStatement(sql);

        // Sét đặt giá trị tham số thứ nhất (Dấu ? thứ nhất)        
        pstm.setString(1, prmvalue1);

        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {

            CityList dataClass = new CityList();
            dataClass.setIdCode(rs.getString("ID_CODE"));
            dataClass.setCityName(rs.getString("CITY_NAME"));
            dataClass.setIdValidity(rs.getString("ID_VALIDITY"));
            dataClass.setDistrictDefault(rs.getString("DISTRICT_DEFAULT"));
            dataClass.setIdNvUpdate(rs.getString("ID_NV_UPDATE"));
            dataClass.setIdCityOmex(rs.getString("ID_CITY_OMEX"));
            dataClass.setIdArea(rs.getString("ID_AREA"));
            dataClass.setIdHoiso(rs.getString("ID_HOISO"));
        

            vwdskhtructuyenktList.add(dataClass);

        }

        pstm.close();

        return vwdskhtructuyenktList;
    }

    public CityList findIdMavung(String thuoctinh, String giatri) throws SQLException {
        Connection con = ConnectionProvider.getCon();
        CityList c = new CityList();
        // Tạo một câu SQL có 1 tham số (?)
        sql = sql + "Where " + thuoctinh + "=?";

        // Tạo một đối tượng PreparedStatement.
        PreparedStatement pstm = con.prepareStatement(sql);

        // Sét đặt giá trị tham số thứ nhất (Dấu ? thứ nhất)        
        pstm.setString(1, giatri);

        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            c.setIdCode(rs.getString("ID_CODE"));
            c.setCityName(rs.getString("CITY_NAME"));
            c.setIdValidity(rs.getString("ID_VALIDITY"));
            c.setDistrictDefault(rs.getString("DISTRICT_DEFAULT"));
            c.setIdNvUpdate(rs.getString("ID_NV_UPDATE"));
            c.setIdCityOmex(rs.getString("ID_CITY_OMEX"));
            c.setIdArea(rs.getString("ID_AREA"));
            c.setIdHoiso(rs.getString("ID_HOISO"));
           
        }

        pstm.close();

        return c;
    }

}
