/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWebSpringMVC.service;

import javax.inject.Inject;
import myWebSpringMVC.bl.concrete.UserAccountManager;
import myWebSpringMVC.domain.model.UserAccount;
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
    
    public void register(UserAccount userAccount){
        if (uamanager.getUserAccountById(userAccount.getID())!=userAccount) {
            uamanager.setUserAccount(userAccount);
        }
    }
    
}
