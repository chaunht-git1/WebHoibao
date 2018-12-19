package ServletBean;

import ConnectBean.ConnectionProvider;
import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageDecoder;
import com.sun.media.jai.codec.TIFFDecodeParam;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BiennhanServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BiennhanServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BiennhanServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        InputStream sImage;
        Connection con = null;
//        BufferedImage bufferedImage = null;
//        OutputStream outputStream = null;

        try {
            if(con==null)
            {
             ConnectionProvider.reconnectdbastatic();
            }
            con = ConnectionProvider.getCon();
            String khoa = request.getParameter("khoa");

            byte[] imageBytes = null;
           

            String sql = " SELECT HINH_BN FROM KH.DM_QUANLY_IMAGE WHERE KHOA='" + khoa + "'";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
             
                imageBytes  =rs.getBytes("HINH_BN");
             
            }
  
                statement.close();
              //  con.close();
                InputStream in = new ByteArrayInputStream(imageBytes);
                TIFFDecodeParam param = null;
                ImageDecoder dec = ImageCodec.createImageDecoder("tiff", in, null);
                RenderedImage op = dec.decodeAsRenderedImage(0);
                OutputStream fos =  response.getOutputStream() ;
                ImageIO.write(op, "jpg", fos);
                response.getOutputStream().close();
                

        } catch (Exception e) {

            // Display error message
            response.getWriter().write(e.getMessage());
            response.getWriter().close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
