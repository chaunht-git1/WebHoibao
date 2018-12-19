
package EntitiesBean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "DM_BANK_LIST")
@Cacheable
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DmBankList.findAll", query = "SELECT d FROM DmBankList d"),
    @NamedQuery(name = "DmBankList.findByMaBank", query = "SELECT d FROM DmBankList d WHERE d.maBank = :maBank"),
    @NamedQuery(name = "DmBankList.findByTenBank", query = "SELECT d FROM DmBankList d WHERE d.tenBank = :tenBank"),
    @NamedQuery(name = "DmBankList.findByIdValidity", query = "SELECT d FROM DmBankList d WHERE d.idValidity = :idValidity"),
    @NamedQuery(name = "DmBankList.findByDateModified", query = "SELECT d FROM DmBankList d WHERE d.dateModified = :dateModified")})
public class DmBankList implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "MA_BANK")
    private String maBank;
    @Size(max = 100)
    @Column(name = "TEN_BANK")
    private String tenBank;
    @Size(max = 20)
    @Column(name = "ID_VALIDITY")
    private String idValidity;
    @Column(name = "DATE_MODIFIED")
    @Temporal(TemporalType.DATE)
    private Date dateModified;

    public DmBankList() {
    }

    public DmBankList(String maBank) {
        this.maBank = maBank;
    }

    public String getMaBank() {
        return maBank;
    }

    public void setMaBank(String maBank) {
        this.maBank = maBank;
    }

    public String getTenBank() {
        return tenBank;
    }

    public void setTenBank(String tenBank) {
        this.tenBank = tenBank;
    }

    public String getIdValidity() {
        return idValidity;
    }

    public void setIdValidity(String idValidity) {
        this.idValidity = idValidity;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maBank != null ? maBank.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DmBankList)) {
            return false;
        }
        DmBankList other = (DmBankList) object;
        if ((this.maBank == null && other.maBank != null) || (this.maBank != null && !this.maBank.equals(other.maBank))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConnectBean.DmBankList[ maBank=" + maBank + " ]";
    }
    
}
