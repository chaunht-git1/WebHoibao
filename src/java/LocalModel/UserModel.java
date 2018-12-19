 
package LocalModel;

import java.util.Date;

 
public class UserModel {
    
    
    public  UserModel(){
        
        this.userid=null;
        this.password=null;
        
    }
    
    private  String userid ;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

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

    public String getHomebranch() {
        return homebranch;
    }

    public void setHomebranch(String homebranch) {
        this.homebranch = homebranch;
    }

    public String getSocm() {
        return socm;
    }

    public void setSocm(String socm) {
        this.socm = socm;
    }

    public Date getNgaycap() {
        return ngaycap;
    }

    public void setNgaycap(Date ngaycap) {
        this.ngaycap = ngaycap;
    }

    public String getNoicap() {
        return noicap;
    }

    public void setNoicap(String noicap) {
        this.noicap = noicap;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    private  String username;
    private  String password  ; 
    private  String homebranch ;
    private  String socm ;
    private  Date   ngaycap ;
    private  String noicap ; 
    private  String diachi ;
    private  String dienthoai;
    private  String email ;
    private String tenhethong;

    public String getTenhethong() {
        return tenhethong;
    }

    public void setTenhethong(String tenhethong) {
        this.tenhethong = tenhethong;
    }
    
}
