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
import LocalModel.UserModel;

public class NhanvienDao {

    String sql = "select * from KH.SMTB_USER ";
    private List<CityList> vwdskhtructuyenktList = new ArrayList<>();

 
    public UserModel findOneParaString(String prmname1, String prmvalue1) throws SQLException {

        Connection con = ConnectionProvider.getCon();

        // Tạo một câu SQL có 1 tham số (?)
        sql = sql + "Where " + prmname1 + "=?";

        // Tạo một đối tượng PreparedStatement.
        PreparedStatement pstm = con.prepareStatement(sql);

        // Sét đặt giá trị tham số thứ nhất (Dấu ? thứ nhất)        
        pstm.setString(1, prmvalue1);

        ResultSet rs = pstm.executeQuery();
        UserModel dataClass = new UserModel();
        while (rs.next()) {
 
            dataClass.setHomebranch(rs.getString("HOME_BRANCH"));
 
        }

        pstm.close();

        return dataClass;
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
