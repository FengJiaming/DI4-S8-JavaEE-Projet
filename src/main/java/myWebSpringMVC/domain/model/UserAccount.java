package myWebSpringMVC.domain.model;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UserAccounts")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type", discriminatorType = STRING, length = 50)
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

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> address = new ArrayList<>();

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public UserAccount() {
        this.address = new ArrayList<>();
    }

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

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

}
