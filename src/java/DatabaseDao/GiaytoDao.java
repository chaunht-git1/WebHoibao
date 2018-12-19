package DatabaseDao;
 
import ConnectBean.ConnectionProvider;
import EntitiesBean.GiaytoList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GiaytoDao {

    String sql = "select * from Giayto_list ";
    private List<GiaytoList> giaytolist = new ArrayList<>();

    public List<GiaytoList> findAll() throws SQLException {

        Connection con = ConnectionProvider.getCon();

        // Tạo một câu SQL có 1 tham số (?)
        //   sql = sql;
        // Tạo một đối tượng PreparedStatement.
        PreparedStatement pstm = con.prepareStatement(sql);

        // Sét đặt giá trị tham số thứ nhất (Dấu ? thứ nhất)        
        //pstm.setString(1, Id);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {

            GiaytoList dataClass = new GiaytoList();
            dataClass.setMaGiayto(rs.getString("MA_GIAYTO"));
            dataClass.setTenGiayto(rs.getString("TEN_GIAYTO"));
            dataClass.setIdValidity(rs.getString("ID_VALIDITY"));
            dataClass.setDateModified(rs.getDate("DATE_MODIFIED"));

            this.giaytolist.add(dataClass);
        }

        pstm.close();

        return giaytolist;
    }

    public List<GiaytoList> findOneParaString(String prmname1, String prmvalue1) throws SQLException {

        Connection con = ConnectionProvider.getCon();

        // Tạo một câu SQL có 1 tham số (?)
        sql = sql + "Where " + prmname1 + "=?";

        // Tạo một đối tượng PreparedStatement.
        PreparedStatement pstm = con.prepareStatement(sql);

        // Sét đặt giá trị tham số thứ nhất (Dấu ? thứ nhất)        
        pstm.setString(1, prmvalue1);

        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {

            GiaytoList dataClass = new GiaytoList();
            dataClass.setMaGiayto(rs.getString("MA_GIAYTO"));
            dataClass.setTenGiayto(rs.getString("TEN_GIAYTO"));
            dataClass.setIdValidity(rs.getString("ID_VALIDITY"));
            dataClass.setDateModified(rs.getDate("DATE_MODIFIED"));

            giaytolist.add(dataClass);

        }

        pstm.close();

        return giaytolist;
    }

    public List<GiaytoList> findTwoParaString(String prmname1, String prmvalue1, String prmname2, String prmvalue2) throws SQLException {

        Connection con = ConnectionProvider.getCon();

        // Tạo một câu SQL có 2 tham số (?)
        sql = sql + "Where " + prmname1 + "=? and " + prmname2 + " not in ?" ;

        // Tạo một đối tượng PreparedStatement.
        PreparedStatement pstm = con.prepareStatement(sql);

        // Sét đặt giá trị tham số thứ nhất (Dấu ? thứ nhất)        
        pstm.setString(1, prmvalue1);
        // Sét đặt giá trị tham số thứ hai (Dấu ? thứ hai)        
        pstm.setString(2, prmvalue2);

        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {

            GiaytoList dataClass = new GiaytoList();
            dataClass.setMaGiayto(rs.getString("MA_GIAYTO"));
            dataClass.setTenGiayto(rs.getString("TEN_GIAYTO"));
            dataClass.setIdValidity(rs.getString("ID_VALIDITY"));
            dataClass.setDateModified(rs.getDate("DATE_MODIFIED"));

            giaytolist.add(dataClass);

        }

        pstm.close();

        return giaytolist;
    }

}
