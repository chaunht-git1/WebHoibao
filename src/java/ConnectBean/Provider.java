package ConnectBean;

public interface Provider {

    String DBS_NAME = "kieuhoi";
    String URL_REPORT = "http://192.168.2.90/reports/rwservlet?config=";
    String SERVERNAME_REPORT = "rep_chitrakh_oracleas1";
    String REPORT_PATH = "/u05/kieuhoi/reports/VIE/";
 
      String URL_API_KH=  "http://192.168.42.10/ApiServerJava/api";
      String URL_API =  "http://10.11.51.27/ApiServerJava/api";
//    
    String DRIVER = "oracle.jdbc.driver.OracleDriver";
    String CONNECTION_URL = "jdbc:oracle:thin:@192.168.2.70:1521:kieuhoi";
    String USERNAME = "kh";
    String PASSWORD = "2014nobody";
    String TENHETHONG = "Live";
 
    
//     String DRIVER = "oracle.jdbc.driver.OracleDriver";
//     String CONNECTION_URL = "jdbc:oracle:thin:@192.168.42.35:1521:khuat";
//     String USERNAME = "kh";
//     String PASSWORD = "2014nobody";
//     String TENHETHONG = "Test";
//
     String DADABASEVW = "DatabaseView";
     String DADABASEKH = "DatabaseKieuhoi";
    
     String URLAPI="http://10.11.51.17:7889/";
     String LINKAPIKHACHHANGBASIC="http://10.11.51.17:6778/";
     String URLAPIJAVA="http://10.11.51.27/ApiServerJava/";
 
    
//    String URLAPI="http://10.11.51.12:8899/";
//    String URLAPIJAVA="http://10.11.51.27/ApiServerJava/";
//    String LINKAPIKHACHHANGBASIC="http://10.11.51.12:6778/";
    
    
    // Fpt.
//    String hostname="10.11.51.12";
//    String userftp="chaunht";
//    String passftp="123456";
    
     // Fpt.
    String hostname="10.11.51.17";
    String userftp="ftpuploadimage";
    String passftp="damtc@ftp";
    
}
 
