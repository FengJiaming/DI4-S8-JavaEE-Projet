/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWebSpringMVC.domain.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mengqingling
 */
@Entity
@Table(name = "OpeningHr")
public class OpeningHr implements Serializable {
    
    @Id
    @Column(name = "ID")
    private int ID;
    
    @Column(name = "Weekday")
    private String Weeking;
    
    @Column(name = "StartTime")
    private String StartTime;
    
    @Column(name = "EndTime")
    private String EndTime;        
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getWeeking() {
        return Weeking;
    }

    public void setWeeking(String Weeking) {
        this.Weeking = Weeking;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String StartTime) {
        this.StartTime = StartTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String EndTime) {
        this.EndTime = EndTime;
    }
}
