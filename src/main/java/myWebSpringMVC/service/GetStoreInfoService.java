/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWebSpringMVC.service;

import java.util.List;
import javax.inject.Inject;
import myWebSpringMVC.bl.concrete.StoreManager;
import myWebSpringMVC.domain.model.Store;

/**
 *
 * @author FENG
 */
public class GetStoreInfoService {
    
    @Inject
    StoreManager storeManager;
    
    public GetStoreInfoService(StoreManager storeManager) {
        this.storeManager = storeManager;
    }
    
    public List<Store> all(){
        return this.storeManager.all();
    }
    
}
