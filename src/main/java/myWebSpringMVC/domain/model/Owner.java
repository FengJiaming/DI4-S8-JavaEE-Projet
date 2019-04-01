/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWebSpringMVC.domain.model;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 *
 * @author mengqingling
 */
@Entity
//@Table(name = "Owner")
//@DiscriminatorValue("4")
public class Owner  extends UserAccount{
   // private int Id =2;
}
