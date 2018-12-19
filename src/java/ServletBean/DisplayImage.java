package ServletBean;

import ConnectBean.ConnectionProvider;
import DatabaseDao.ImageDao;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayImage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DisplayImage</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DisplayImage at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InputStream sImage;
        Connection con = null;
        BufferedImage bufferedImage = null;
        OutputStream outputStream = null;
        String id = request.getParameter("id") ;
        
  
        try {
           // ConnectionProvider.reconnectdbastatic();

               // Kiem tra xem co hinh hay chua . Neu chua dong bo ra ben ngoai .
               
            ImageDao dao= new ImageDao();
            InputStream is=dao.getimagefromServer(id);
            int length=0;
            try {
               length = is.available();  
            } catch (Exception e) {
               length=0;
            }
           
 
            byte[] imageBytes = null;
            if (length>0)
            {
                 imageBytes=dao.toByteArray(is);
            }
            else{
                 if (con == null) {
                    ConnectionProvider.reconnectdbastatic();
                 }
                 con = ConnectionProvider.getCon();
                 String sql="SELECT KHOA,HINH_BN FROM  KHOUT.DM_QUANLYIMAGE_TODAY where SOBN='"+id+"' OR  KHOA='"+id+"'    ";
                 PreparedStatement statement = con.prepareStatement(sql);
                 ResultSet rs = statement.executeQuery();
                 while (rs.next()) { // This will run only once
                 imageBytes = rs.getBytes("HINH_BN");
                 
                 }
                 statement.close();
            }
 
            //con.close();
            //OutputStream out = response.getOutputStream();
            response.setContentType("image/jpg");
            response.getOutputStream().write(imageBytes); 
            response.getOutputStream().close();

        } catch (Exception e) {

            // Display error message
            response.getWriter().write(e.getMessage());
            response.getWriter().close();
        }
        //processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private InputStream ByteArrayInputStream(byte[] imageBytes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
