package DatabaseDao;

 
import ApiFunction.ApiFun;
import ConnectBean.ConnectionProvider;
import static ConnectBean.Provider.LINKAPIKHACHHANGBASIC;
import EntitiesBean.CityList;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImageDao {

    String sql = "select * from city_list ";
    private List<CityList> vwdskhtructuyenktList = new ArrayList<>();

    public String uploadImageFromBlob(String id,String sobn  ) throws SQLException {
      
        ConnectionProvider.reconnectdbastatic();
        Connection con = ConnectionProvider.getCon();
        byte[] imageBytes = null;
        // Tạo một câu SQL có 1 tham số (?)
        //   sql = sql;
        // Tạo một đối tượng PreparedStatement.
        sql="SELECT KHOA,HINH_BN FROM  KHOUT.DM_QUANLYIMAGE_TODAY where sobn='"+sobn+"'   ";
        
        PreparedStatement pstm = con.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        InputStream targetStream = null ;
        while (rs.next()) { // This will run only once

                imageBytes = rs.getBytes("HINH_BN");
                targetStream = new ByteArrayInputStream(imageBytes);
       }
 
        pstm.close();
        
        ApiFun apiFun= new ApiFun();
        try {
            Boolean kq=apiFun.uploadimage(sobn, targetStream);
        } catch (IOException ex) {
            //Logger.getLogger(ImageDao.class.getName()).log(Level.SEVERE, null, ex);
            return "F";
        }

        return "T";
    }

     public String checkimagefromServer(String sobn  ){
        
        try {
            String urlstring =LINKAPIKHACHHANGBASIC+"api/receipt/getreceiptimage?ImageName="+sobn+".jpg";
            URL url = new URL(urlstring);
            InputStream is = url.openStream();
            int length = is.available(); 
            if (length==0)
            {
               return "F"; 
                
            }
            else{
                
               return "T";   
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(ImageDao.class.getName()).log(Level.SEVERE, null, ex);
            return "F";
        } catch (IOException ex) {
            Logger.getLogger(ImageDao.class.getName()).log(Level.SEVERE, null, ex);
            return "F";
        }
     }
  
      public InputStream getimagefromServer(String sobn  ){
        
        try {
            String urlstring =LINKAPIKHACHHANGBASIC+"api/receipt/getreceiptimage?ImageName="+sobn+".jpg";
            URL url = new URL(urlstring);
            InputStream is = url.openStream();
            return is;
        } catch (MalformedURLException ex) {
            Logger.getLogger(ImageDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(ImageDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
     }
      
      public InputStream getimageTempfromServer(String filename  ){
        
        try {
            InputStream is = new FileInputStream(filename);
            return is;
        } catch (IOException ex) {
            Logger.getLogger(ImageDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
     }
          
      public  byte[] toByteArray(InputStream in) throws IOException {

		ByteArrayOutputStream os = new ByteArrayOutputStream();

		byte[] buffer = new byte[1024];
		int len;

		// read bytes from the input stream and store them in buffer
		while ((len = in.read(buffer)) != -1) {
			// write bytes from the buffer into output stream
			os.write(buffer, 0, len);
		}

		return os.toByteArray();
	}
}
