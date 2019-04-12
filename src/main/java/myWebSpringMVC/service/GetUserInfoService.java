/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWebSpringMVC.service;

import myWebSpringMVC.bl.concrete.UserAccountManager;
import myWebSpringMVC.domain.model.UserAccount;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author FENG
 */
public class GetUserInfoService {
    @Inject
    private UserAccountManager uamanager;

    
    public GetUserInfoService(UserAccountManager uamanager) {
        this.uamanager = uamanager;
    }
  

    public List<UserAccount> all(){
        return this.uamanager.all();
    }
    
    
}
