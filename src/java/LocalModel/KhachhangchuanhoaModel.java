package LocalModel;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Date;

public class KhachhangchuanhoaModel {

    private String ReceiptCode;
    private String QrCode;
    private String BatchNumber;
    private String ReceiverName;
    private String ReceiverPhone ;
    private Number Amount;
    private String CurrencyCode ;
    private String   ReceiverCode;
    private String    ReceiverAddress;
    private String    PartnerCode;
     private String   PartnerName;
       private String SenderName;
      private String   CityId;
       private String  DistrictId;
       private String  WardId;
       private String  IsReceive;
      private Boolean   IsTrans;
      private Boolean   IsVerif ;
      private Boolean  IsPaid;
      private String   IdCardNumber;
      private String   IdCardTypeCode ;
      private String  Username ;
       private String  Latitude ;
       private String  Longitude ;
       private String  CreatedDate ;
      private String   CustomerCode ;
      private String   RemoveReason ;
      private String   VerificationContent ;
      private Boolean   IsHasImage ;
      private String CustomerInfoStatus ;
    

    public String getReceiptCode() {
        return ReceiptCode;
    }

    public void setReceiptCode(String ReceiptCode) {
        this.ReceiptCode = ReceiptCode;
    }

    public Number getAmount() {
        return Amount;
    }

    public void setAmount(Number Amount) {
        this.Amount = Amount;
    }

    public String getCurrencyCode() {
        return CurrencyCode;
    }

    public void setCurrencyCode(String CurrencyCode) {
        this.CurrencyCode = CurrencyCode;
    }

    public String getReceiverCode() {
        return ReceiverCode;
    }

    public void setReceiverCode(String ReceiverCode) {
        this.ReceiverCode = ReceiverCode;
    }

    public String getReceiverAddress() {
        return ReceiverAddress;
    }

    public void setReceiverAddress(String ReceiverAddress) {
        this.ReceiverAddress = ReceiverAddress;
    }

    public String getPartnerCode() {
        return PartnerCode;
    }

    public void setPartnerCode(String PartnerCode) {
        this.PartnerCode = PartnerCode;
    }

    public String getPartnerName() {
        return PartnerName;
    }

    public void setPartnerName(String PartnerName) {
        this.PartnerName = PartnerName;
    }

    public String getSenderName() {
        return SenderName;
    }

    public void setSenderName(String SenderName) {
        this.SenderName = SenderName;
    }

    public String getCityId() {
        return CityId;
    }

    public void setCityId(String CityId) {
        this.CityId = CityId;
    }

    public String getDistrictId() {
        return DistrictId;
    }

    public void setDistrictId(String DistrictId) {
        this.DistrictId = DistrictId;
    }

    public String getWardId() {
        return WardId;
    }

    public void setWardId(String WardId) {
        this.WardId = WardId;
    }

    public String getIsReceive() {
        return IsReceive;
    }

    public void setIsReceive(String IsReceive) {
        this.IsReceive = IsReceive;
    }

    public Boolean getIsTrans() {
        return IsTrans;
    }

    public void setIsTrans(Boolean IsTrans) {
        this.IsTrans = IsTrans;
    }

    public Boolean getIsVerif() {
        return IsVerif;
    }

    public void setIsVerif(Boolean IsVerif) {
        this.IsVerif = IsVerif;
    }

    public Boolean getIsPaid() {
        return IsPaid;
    }

    public void setIsPaid(Boolean IsPaid) {
        this.IsPaid = IsPaid;
    }

    public String getIdCardNumber() {
        return IdCardNumber;
    }

    public void setIdCardNumber(String IdCardNumber) {
        this.IdCardNumber = IdCardNumber;
    }

    public String getIdCardTypeCode() {
        return IdCardTypeCode;
    }

    public void setIdCardTypeCode(String IdCardTypeCode) {
        this.IdCardTypeCode = IdCardTypeCode;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String Latitude) {
        this.Latitude = Latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String Longitude) {
        this.Longitude = Longitude;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String CreatedDate) {
        this.CreatedDate = CreatedDate;
    }

    public String getCustomerCode() {
        return CustomerCode;
    }

    public void setCustomerCode(String CustomerCode) {
        this.CustomerCode = CustomerCode;
    }

    public String getRemoveReason() {
        return RemoveReason;
    }

    public void setRemoveReason(String RemoveReason) {
        this.RemoveReason = RemoveReason;
    }

    public String getVerificationContent() {
        return VerificationContent;
    }

    public void setVerificationContent(String VerificationContent) {
        this.VerificationContent = VerificationContent;
    }

    public Boolean getIsHasImage() {
        return IsHasImage;
    }

    public void setIsHasImage(Boolean IsHasImage) {
        this.IsHasImage = IsHasImage;
    }

    public String getCustomerInfoStatus() {
        return CustomerInfoStatus;
    }

    public void setCustomerInfoStatus(String CustomerInfoStatus) {
        this.CustomerInfoStatus = CustomerInfoStatus;
    }
    
    

    public String getQrCode() {
        return QrCode;
    }

    public void setQrCode(String QrCode) {
        this.QrCode = QrCode;
    }

    public String getBatchNumber() {
        return BatchNumber;
    }

    public void setBatchNumber(String BatchNumber) {
        this.BatchNumber = BatchNumber;
    }

    public String getReceiverName() {
        return ReceiverName;
    }

    public void setReceiverName(String ReceiverName) {
        this.ReceiverName = ReceiverName;
    }

    public String getReceiverPhone() {
        return ReceiverPhone;
    }

    public void setReceiverPhone(String ReceiverPhone) {
        this.ReceiverPhone = ReceiverPhone;
    }
     
 
}
