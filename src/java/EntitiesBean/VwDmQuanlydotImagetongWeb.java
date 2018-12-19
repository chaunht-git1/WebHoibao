 
package EntitiesBean;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

 
public class VwDmQuanlydotImagetongWeb implements Serializable {
 
    private String idChinhanh;
    private String tenchinhanh;
    private String deserror;
    private String idcode;
    private String markerId;
    private String iderror;
    private Date dateModified;
    private Number shs;
    private String kiemtra;
    private String dotbn;
    //Du lieu them vao  .
    
 

    public VwDmQuanlydotImagetongWeb() {
    }

    public Number getShs() {
        return shs;
    }

    public void setShs(Number shs) {
        this.shs = shs;
    }

    public String getDotbn() {
        return dotbn;
    }

    public void setDotbn(String dotbn) {
        this.dotbn = dotbn;
    }
    
    
    

    public String getIdcode() {
        return idcode;
    }

    public void setIdcode(String idcode) {
        this.idcode = idcode;
    }

    public String getMarkerId() {
        return markerId;
    }

    public void setMarkerId(String markerId) {
        this.markerId = markerId;
    }

    public String getIderror() {
        return iderror;
    }

    public void setIderror(String iderror) {
        this.iderror = iderror;
    }

  

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

 

    public String getKiemtra() {
        return kiemtra;
    }

    public void setKiemtra(String kiemtra) {
        this.kiemtra = kiemtra;
    }

    public String getDeserror() {
        return deserror;
    }

    public void setDeserror(String deserror) {
        this.deserror = deserror;
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
    
}
