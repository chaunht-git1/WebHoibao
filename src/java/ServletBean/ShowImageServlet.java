 
package ServletBean;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
public class ShowImageServlet extends HttpServlet {
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShowImageServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShowImageServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String  rootpathimage=request.getParameter("pathfile");;
        response.setContentType("image/jpeg"); 
        ServletOutputStream out;  
        out = response.getOutputStream();  
          
        BufferedOutputStream bout = new BufferedOutputStream(out);  
        try {
        
          FileInputStream sourceimage = new FileInputStream(rootpathimage);  
          BufferedInputStream bin = new BufferedInputStream(sourceimage);
          int ch =0; ;  
          while((ch=bin.read())!=-1)  
          {  
             bout.write(ch);  
           }  
            bin.close();  
            sourceimage.close();  
            bout.close();  
            out.close();  
          
 
          
        } catch (IOException e) {
        	e.printStackTrace();
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
    }// </editor-fold>

}
