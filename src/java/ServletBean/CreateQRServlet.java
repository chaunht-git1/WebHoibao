 
package ServletBean;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import LocalFuntionGlobal.FunctionLocal;
import java.io.OutputStream;
import static java.lang.System.out;

 
public class CreateQRServlet extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateQRServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateQRServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        try {
            
        byte[] imageBytes = null;
        byte[] buffer = new byte[8192];
        int bytesRead;
        String id=request.getParameter("id") ;            
      //  String imageUrlString = "http://emoney-in.dongamoneytransfer.com.vn/PQcodeExplem/qrservlet?qrtext="+id;
        String imageUrlString = "https://maps.googleapis.com/maps/api/staticmap?center="+id+"&zoom=17&size=600x400&maptype=roadmap&markers=color:red%7Clabel:A%7C10.7676,106.6834&key=AIzaSyDLSiZPw0DhzOLGQSeT6PhWYTkyH8LWq6g";
         // Read the image ...
        URL urlConn = new URL(imageUrlString);
        InputStream inputStream      = urlConn.openStream();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        while ((bytesRead = inputStream.read(buffer)) != -1)
        {
            output.write(buffer, 0, bytesRead);
        }

        imageBytes=output.toByteArray();
        response.getOutputStream().write(imageBytes);
        response.getOutputStream().close();
  
            
        } catch (Exception e) {
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
