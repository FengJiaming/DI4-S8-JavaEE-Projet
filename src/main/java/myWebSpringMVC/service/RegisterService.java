/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWebSpringMVC.service;

import myWebSpringMVC.bl.concrete.UserAccountManager;
import myWebSpringMVC.domain.model.UserAccount;
/**
 *
 * @author FENG
 */
public class RegisterService {
    UserAccountManager uamanager;
    
    public void register(UserAccount userAccount){
        uamanager.setUserAccount(userAccount);
    }
}
