 
package Apimodel;

import java.util.Date;

 
public class Customer {
    
    private String CustomerCode ;
    private String Fullname;
    private String   DateOfBirth;
    private Date   DateOfBirthDateValue;
    private String Gender;
    private String Phone;
    private String JobCode;
    private String CityId;
    private String DistrictId;
    private String Address;
    private Number Longitude;
    private Number Latitude;
    private String IdCardNumber;
    private String IdCardTypeCode;
    private String PlaceOfIssue;
    private String   DateOfIssue;
    private Date   DateOfIssueDateValue;
    private Boolean IsHasFrontImage;
    private Boolean IsHasBackImage; 
    private Number Amount;

    public Date getDateOfBirthDateValue() {
        return DateOfBirthDateValue;
    }

    public void setDateOfBirthDateValue(Date DateOfBirthDateValue) {
        this.DateOfBirthDateValue = DateOfBirthDateValue;
    }

    public Date getDateOfIssueDateValue() {
        return DateOfIssueDateValue;
    }

    public void setDateOfIssueDateValue(Date DateOfIssueDateValue) {
        this.DateOfIssueDateValue = DateOfIssueDateValue;
    }
    
    
    
    

    public Number getAmount() {
        return Amount;
    }

    public void setAmount(Number Amount) {
        this.Amount = Amount;
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

    public Boolean getIsHasFrontImage() {
        return IsHasFrontImage;
    }

    public void setIsHasFrontImage(Boolean IsHasFrontImage) {
        this.IsHasFrontImage = IsHasFrontImage;
    }

    public Boolean getIsHasBackImage() {
        return IsHasBackImage;
    }

    public void setIsHasBackImage(Boolean IsHasBackImage) {
        this.IsHasBackImage = IsHasBackImage;
    }
    
  
 
 
 
    public String getCustomerCode() {
        return CustomerCode;
    }

    public void setCustomerCode(String CustomerCode) {
        this.CustomerCode = CustomerCode;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    
   

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getJobCode() {
        return JobCode;
    }

    public void setJobCode(String JobCode) {
        this.JobCode = JobCode;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Number getLongitude() {
        return Longitude;
    }

    public void setLongitude(Number Longitude) {
        this.Longitude = Longitude;
    }

    public Number getLatitude() {
        return Latitude;
    }

    public void setLatitude(Number Latitude) {
        this.Latitude = Latitude;
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

    public String getPlaceOfIssue() {
        return PlaceOfIssue;
    }

    public void setPlaceOfIssue(String PlaceOfIssue) {
        this.PlaceOfIssue = PlaceOfIssue;
    }

    public String getDateOfIssue() {
        return DateOfIssue;
    }

    public void setDateOfIssue(String DateOfIssue) {
        this.DateOfIssue = DateOfIssue;
    }

 
    
    
    
}
