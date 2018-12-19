package Controller;


 
import DatabaseDao.LoginDao;
import DatabaseDao.NhanvienDao;
import Global.SessionBean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.servlet.http.HttpSession;
import LocalModel.UserModel;
import com.google.gson.Gson;
import java.io.IOException;

@Named(value = "loginManagerBean")
@SessionScoped
public class LoginManagerBean implements Serializable {

    private String username;
    private String password;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    private String msg;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public String logout() {
      HttpSession sess= SessionBean.getSession();
      sess.invalidate();
      return "login" + "?faces-redirect=true";
     }

    //validate login
    public String validateUsernamePassword() throws IOException {

        // Kiem tra dang nhap
     
        Boolean valid=null;      
        LoginDao databasedao = new LoginDao();
        valid= databasedao.validate(username, password);
        
       if (!valid)
       {
            LocalFuntionGlobal.SystemBean.proMessError("Lỗi đăng nhập");
            return null;
       }
       else{
        try {
            if (valid!=null) {
                Gson gson= new Gson();
                String hethog=System.getProperty("os.name").substring(0,3).toLowerCase();
                HttpSession session = SessionBean.getSession();
                String sessionid = session.getId();
                UserModel useMD = new UserModel();
                NhanvienDao nhanvienDao= new NhanvienDao();
                useMD=nhanvienDao.findOneParaString("USER_ID", username);
                String user_id=username;
                useMD.setTenhethong("");
                session.setAttribute("g_userid", user_id.toUpperCase());
                session.setAttribute("g_tenht", sessionid);
                session.setAttribute("device", SessionBean.getDeviceName());  
                session.setAttribute("systemname", hethog);
                session.setAttribute("g_chinhanhid", useMD.getHomebranch());
              
                // Lay data danh muc .
              //  createArrayList(useMD.getHomebranch());
 
                    return "index" + "?faces-redirect=true";
             
                }
          
        }
        catch (Exception e) {
                 LocalFuntionGlobal.SystemBean.proMessError(e.getMessage());
            return null;
        }
            
        }
        
            LocalFuntionGlobal.SystemBean.proMessError("Lỗi đăng nhập");
            return null;
    }
 

 

    public LoginManagerBean() {
    }

}
