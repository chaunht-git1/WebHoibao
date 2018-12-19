 
package ServletBean;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.servlet.FilterChain;

 
public class LoginServlet extends HttpServlet {
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        // Lấy ra đối tượng HttpSession
       HttpSession session = request.getSession();   
       Object outvalue= session.getAttribute("g_userid");
       
     //  filterChain.doFilter(request, response);
       /*if(session =null){
          
         //  session.invalidate();
           String redirectURI = request.getContextPath() + "/faces/login.xhtml";
           response.sendRedirect(redirectURI);

       }
       else{
           
           String redirectURI = request.getContextPath() + "/faces/login.xhtml";
           response.sendRedirect(redirectURI);
           
       }*/
        
  
   // response.sendRedirect(this.getServletContext().getContextPath()  );
        /*
         RequestDispatcher dispatcher = request.getServletContext()
                 .getRequestDispatcher("/login");
         dispatcher.forward(request, response);
        */
      //  ServletOutputStream out = response.getOutputStream();
     //  ServletOutputStream out = response.getOutputStream();  
         // Lấy ra đối tượng HttpSession
      /*   Object loginedInfo =   session.getAttribute("g_userid"); 
         String abc=loginedInfo.toString();
         
          
       
       // Lưu trữ thông tin người dùng vào Session theo 1 thuộc tính.
       // Bạn có thể lấy lại thông tin người dùng theo thuộc tính này.
       session.setAttribute("g_userid", "CHAUNHT"); 
              */
        
      //Object loginedInfo =   session.getAttribute("g_userid"); 
       
       
       
       
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
