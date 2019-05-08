/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWebSpringMVC.service;

import java.io.IOException;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import myWebSpringMVC.bl.concrete.UserAccountManager;
import myWebSpringMVC.domain.model.UserAccount;
import org.codehaus.jackson.map.ObjectMapper;
/**
 *
 * @author FENG
 */
public class RegisterService {
    @Inject
    UserAccountManager uamanager;
    
    public RegisterService(UserAccountManager uamanager) {
        this.uamanager = uamanager;
    }
    
    
    
    
    @POST
    @Path("/register/{newUser}")
    public void register(@PathParam("newUser") String newUser) {
        System.out.println("IN LOGIN SERVICE");
        ObjectMapper mapper = new ObjectMapper();
        try {
            UserAccount user = mapper.readValue(newUser, UserAccount.class);
            //USERDAO
            System.out.println(user);
            if (user.getFirstName() == "root") {

            } else {
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
          
        }
    }
    
    public void register(UserAccount userAccount){
        if (uamanager.getUserAccountById(userAccount.getID())!=userAccount) {
            uamanager.setUserAccount(userAccount);
        }
    }
    
}
