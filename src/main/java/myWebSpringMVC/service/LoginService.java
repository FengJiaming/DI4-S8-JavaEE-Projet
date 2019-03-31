/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWebSpringMVC.service;

import myWebSpringMVC.domain.model.UserAccount;
import myWebSpringMVC.bl.concrete.UserAccountManager;
/**
 *
 * @author FENG
 */
public class LoginService {
    
    UserAccountManager uamanager;
    
    public boolean login(UserAccount userAccount) {

        if(uamanager.isValidLogin(userAccount.getFirstName(), userAccount.getPassword())){
            return true;
            //return "entries";
        }
        return false;
    }
}
