/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWebSpringMVC.service;

import myWebSpringMVC.bl.concrete.StoreManager;
/**
 *
 * @author FENG
 */
public class GetStoreInfoService {
    
    StoreManager storeManager;
    public GetStoreInfoService(StoreManager storeManager) {
        this.storeManager = storeManager;
    }
}
