/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWebSpringMVC.domain.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import static javax.persistence.DiscriminatorType.STRING;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author mengqingling
 */
@Entity
@Table(name = "Stores")
public class Store {
    @Id
    @Column(name = "ID")
    private int ID;
    
    @Column(name = "Name")
    private String Name;
    
    @Column(name = "Key")
    private String Key;  
    
    @Column(name = "PhoneNumber")
    private String PhoneNumber;
        
    @Column(name = "Email")
    private String Email;
            
    @Column(name = "Lattitude")
    private double Lattitude;
    
    @Column(name = "Longitude")
    private double Longitude;   
    
    @Column( name = "Address")
    private Address Address;
    
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

    public String getKey() {
        return Key;
    }

    public void setKey(String Key) {
        this.Key = Key;
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

    public Address getAddress() {
        return Address;
    }

    public void setAddress(Address Address) {
        this.Address = Address;
    }
    
    
    
}
