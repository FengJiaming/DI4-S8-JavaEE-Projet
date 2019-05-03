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
    private int id;
    
    @Column(name = "Weekday")
    private String weeking;
    
    @Column(name = "StartTime")
    private String startTime;
    
    @Column(name = "EndTime")
    private String endTime;        
    
    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getWeeking() {
        return weeking;
    }

    public void setWeeking(String weeking) {
        this.weeking = weeking;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
