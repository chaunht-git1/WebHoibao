 
package LocalModel;

import java.io.Serializable;
import java.math.BigInteger;
 
public class VwDshosoCgpSumWeb implements Serializable {
 
    private String idCode;
 
    private String idChinhanh;
 
    private String tenchinhanh;
 
    private String idCity;
 
    private String cityName;
 
    private String districtName;
 
    private String nvhis;
 
    private String idDistrict;
 
    private BigInteger shs;
 
    private String idLoaigiaophieu;
 
    private String desloaigiaophieu;
    
     private BigInteger shsmg;

    public BigInteger getShsmg() {
        return shsmg;
    }

    public void setShsmg(BigInteger shsmg) {
        this.shsmg = shsmg;
    }
 
 
    public VwDshosoCgpSumWeb() {
    }

    public String getIdChinhanh() {
        return idChinhanh;
    }

    public void setIdChinhanh(String idChinhanh) {
        this.idChinhanh = idChinhanh;
    }

    public String getTenchinhanh() {
        return tenchinhanh;
    }

    public void setTenchinhanh(String tenchinhanh) {
        this.tenchinhanh = tenchinhanh;
    }

    public String getIdCity() {
        return idCity;
    }

    public void setIdCity(String idCity) {
        this.idCity = idCity;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getNvhis() {
        return nvhis;
    }

    public void setNvhis(String nvhis) {
        this.nvhis = nvhis;
    }

    public String getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(String idDistrict) {
        this.idDistrict = idDistrict;
    }

    public BigInteger getShs() {
        return shs;
    }

    public void setShs(BigInteger shs) {
        this.shs = shs;
    }

    public String getIdLoaigiaophieu() {
        return idLoaigiaophieu;
    }

    public void setIdLoaigiaophieu(String idLoaigiaophieu) {
        this.idLoaigiaophieu = idLoaigiaophieu;
    }

    public String getDesloaigiaophieu() {
        return desloaigiaophieu;
    }

    public void setDesloaigiaophieu(String desloaigiaophieu) {
        this.desloaigiaophieu = desloaigiaophieu;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }
    
}
