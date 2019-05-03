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
    @Column(name = "ID")
    private int ID;

    @Column(name = "store_key")
    private String store_key;

    @Column(name = "Title")
    private String Title;
    
    @Column(name = "ShortDescription")
    private String ShortDescription;
    @Column(name = "LongDescription")
    private String LongDescription;
    @Column(name = "Position")
    private String Position;
    @Column(name = "Disabled")
    private boolean Disabled;
    @Column(name = "StartDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date StartDate;
    @Column(name = "EndDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date EndDate;
    
    @Column(name = "ImageURL")
    private String ImageURL;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getShortDescription() {
        return ShortDescription;
    }

    public void setShortDescription(String ShortDescription) {
        this.ShortDescription = ShortDescription;
    }

    public String getLongDescription() {
        return LongDescription;
    }

    public void setLongDescription(String LongDescription) {
        this.LongDescription = LongDescription;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }

    public boolean isDisabled() {
        return Disabled;
    }

    public void setDisabled(boolean Disabled) {
        this.Disabled = Disabled;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String ImageURL) {
        this.ImageURL = ImageURL;
    }

        public String getStore_key() {
        return store_key;
    }

    public void setStore_key(String store_key) {
        this.store_key = store_key;
    }


}
