/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWebSpringMVC.service;


import javax.inject.Inject;
import myWebSpringMVC.domain.model.UserAccount;
import myWebSpringMVC.bl.concrete.UserAccountManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 *
 * @author FENG
 */

public class LoginService {
    
    //@Inject
    private static final Log log = LogFactory.getLog(LoginService.class);
    @Inject
    UserAccountManager uamanager;
    
    public LoginService(UserAccountManager uamanager){
        this.uamanager = uamanager;
    }
    
    public boolean login(UserAccount userAccount) {
        log.info("log:login" + userAccount.getFirstName());
        if(uamanager.isValidLogin(userAccount.getFirstName(), userAccount.getPassword())){
            return true;
            //return "entries";
        }
        return false;
        
    }
}
