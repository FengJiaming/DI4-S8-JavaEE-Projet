/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWebSpringMVC.domain.model;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author mengqingling
 */
public class Address {
 

    @Id
    @Column(name = "ID")
    private int ID;
    
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
    
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

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
    
    
    
}
