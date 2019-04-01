package myWebSpringMVC.domaine.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import static javax.persistence.DiscriminatorType.STRING;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UserAccounts")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type", discriminatorType = STRING, length=50)
//@DiscriminatorValue("1")
public class UserAccount implements Serializable {

    @Id
    @Column(name = "ID")
    private int ID;

    @Column(name = "FirstName")
    private String FirstName;

    @Column(name = "LastName")
    private String LastName;

    @Column(name = "Email")
    private String Email;

    @Column(name = "Password")
    private String Password;

    @Column(name = "PhoneNumber")
    private String PhoneNumber;

    @Column(name = "Active")
    private String Active;

    @Column(name = "CreationDate")
    private String CreationDate;

    @Column(name = "LastModificationDate")
    private String LastModificationDate;

    @Column(name = "ResetPasswordLink")
    private String ResetPasswordLink;

    @Column(name = "ResetLinkValidateDate")
    private String ResetLinkValidateDate;
    @Column(name = "IsRemoved")
    private boolean IsRemoved;
    
    //@Column(name = "Address")
        @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Address> address;
  //  private Address Address;

    public UserAccount() {
        this.address = new ArrayList<>();
    }

/*
    @Column(name = "Street")
    private String Street;

    @Column(name = "City")
    private String City;

    @Column(name = "State")
    private String State;

    @Column(name = "ZipCode")
    private String ZipCode;

    @Column(name = "Country")
    private String Country;

   // @Column(name = "Type")
    //private String Type;
    */
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getActive() {
        return Active;
    }

    public void setActive(String Active) {
        this.Active = Active;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(String CreationDate) {
        this.CreationDate = CreationDate;
    }

    public String getLastModificationDate() {
        return LastModificationDate;
    }

    public void setLastModificationDate(String LastModificationDate) {
        this.LastModificationDate = LastModificationDate;
    }

    public String getResetPasswordLink() {
        return ResetPasswordLink;
    }

    public void setResetPasswordLink(String ResetPasswordLink) {
        this.ResetPasswordLink = ResetPasswordLink;
    }

    public String getResetLinkValidateDate() {
        return ResetLinkValidateDate;
    }

    public void setResetLinkValidateDate(String ResetLinkValidateDate) {
        this.ResetLinkValidateDate = ResetLinkValidateDate;
    }

    public boolean isIsRemoved() {
        return IsRemoved;
    }

    public void setIsRemoved(boolean IsRemoved) {
        this.IsRemoved = IsRemoved;
    }
/*
    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String ZipCode) {
        this.ZipCode = ZipCode;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }
*/
//    public String getType() {
//        return Type;
//    }
//
//    public void setType(String Type) {
//        this.Type = Type;
//    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }



//    @Column(name = "DISCOUNT_CODE")
//    private String DiscountCode;
//    
//    @Column(name = "ZIP")
//    private String Zip;
//    
//    @Column(name = "NAME")
//    private String Name;
////    
//    @Column(name = "ADDRESSLINE1")
//    private String AddressLine1;
//    
//    @Column(name = "ADDRESSLINE2")
//    private String AddressLine2;
//    
//    @Column(name = "CITY")
//    private String City;
//    
//    @Column(name = "STATE")
//    private String State;
//    
//    @Column(name = "PHONE")
//    private String Phone;
//    
//    @Column(name = "FAX")
//    private String Fax;
//    
//
//    
//    @Column(name = "CREDIT_LIMIT")
//    private String CreditLimit;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getDiscountCode() {
//        return DiscountCode;
//    }
//
//    public void setDiscountCode(String DiscountCode) {
//        this.DiscountCode = DiscountCode;
//    }
//
//    public String getZip() {
//        return Zip;
//    }
//
//    public void setZip(String Zip) {
//        this.Zip = Zip;
//    }
//
//    public String getName() {
//        return Name;
//    }
//
//    public void setName(String Name) {
//        this.Name = Name;
//    }
//
//    public String getAddressLine1() {
//        return AddressLine1;
//    }
//
//    public void setAddressLine1(String AddressLine1) {
//        this.AddressLine1 = AddressLine1;
//    }
//
//    public String getAddressLine2() {
//        return AddressLine2;
//    }
//
//    public void setAddressLine2(String AddressLine2) {
//        this.AddressLine2 = AddressLine2;
//    }
//
//    public String getCity() {
//        return City;
//    }
//
//    public void setCity(String City) {
//        this.City = City;
//    }
//
//    public String getState() {
//        return State;
//    }
//
//    public void setState(String State) {
//        this.State = State;
//    }
//
//    public String getPhone() {
//        return Phone;
//    }
//
//    public void setPhone(String Phone) {
//        this.Phone = Phone;
//    }
//
//    public String getFax() {
//        return Fax;
//    }
//
//    public void setFax(String Fax) {
//        this.Fax = Fax;
//    }
//
//    public String getEmail() {
//        return Email;
//    }
//
//    public void setEmail(String Email) {
//        this.Email = Email;
//    }
//
//    public String getCreditLimit() {
//        return CreditLimit;
//    }
//
//    public void setCreditLimit(String CreditLimit) {
//        this.CreditLimit = CreditLimit;
//    }
}
