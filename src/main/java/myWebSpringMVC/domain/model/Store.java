/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWebSpringMVC.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author mengqingling
 */
@Entity
@Table(name = "Store")
public class Store implements Serializable {

    @Id
    @Column(name = "ID")
    private int ID;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Promotion> promotions = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OpeningHr> openingHr = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Kkey")
    private String Kkey;

    @Column(name = "PhoneNumber")
    private String PhoneNumber;

    @Column(name = "Email")
    private String Email;

    @Column(name = "Lattitude")
    private double Lattitude;

    @Column(name = "Longitude")
    private double Longitude;

    @Column(name = "LastModifiedDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date LastModifiedDate;

    @Column(name = "LastModifiedBy")
    private int LastModifiedBy;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getLastModifiedDate() {
        return LastModifiedDate;
    }

    public void setLastModifiedDate(Date LastModifiedDate) {
        this.LastModifiedDate = LastModifiedDate;
    }

    public int getLastModifiedBy() {
        return LastModifiedBy;
    }

    public void setLastModifiedBy(int LastModifiedBy) {
        this.LastModifiedBy = LastModifiedBy;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public double getLattitude() {
        return Lattitude;
    }

    public void setLattitude(double Lattitude) {
        this.Lattitude = Lattitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double Longitude) {
        this.Longitude = Longitude;
    }
    
    public String getKkey() {
        return Kkey;
    }

    public void setKkey(String Kkey) {
        this.Kkey = Kkey;
    }

}
