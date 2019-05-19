package myWebSpringMVC.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mengqingling
 */
@Entity
@Table(name = "Promotion")
public class Promotion implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "store_key")
    private String store_key;

    @Column(name = "Title")
    private String title;
    
    @Column(name = "ShortDescription")
    private String shortDescription;
    
    @Column(name = "LongDescription")
    private String longDescription;
    
    @Column(name = "Position")
    private String position;
    
    @Column(name = "Disabled")
    private boolean disabled;
    
    @Column(name = "StartDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startDate;
    
    @Column(name = "EndDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endDate;
    
    @Column(name = "ImageURL")
    private String imageURL;

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

        public String getStore_key() {
        return store_key;
    }

    public void setStore_key(String store_key) {
        this.store_key = store_key;
    }


}
