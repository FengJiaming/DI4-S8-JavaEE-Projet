/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWebSpringMVC.service;

import java.util.List;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import myWebSpringMVC.bl.concrete.StoreManager;
import myWebSpringMVC.bl.concrete.OpeningHrManager;
import myWebSpringMVC.domain.model.OpeningHr;
import myWebSpringMVC.domain.model.Store;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author FENG
 */
@RestController

@RequestMapping("/api/StoreService")

public class GetStoreInfoService {

    private static final Logger logger = Logger.getLogger(LoginService.class);
    
    @Resource
    StoreManager storemanager;
    @Resource
    OpeningHrManager ophrmanager;

    public GetStoreInfoService(StoreManager storeManager, OpeningHrManager ophrmanager) {
        this.storemanager = storeManager;
        this.ophrmanager = ophrmanager;
    }

    @GetMapping(value = "/getStoreInfo/{id}", produces = MediaType.APPLICATION_JSON)
    public String getStoreInfo(@PathVariable("id") int id) throws Exception {
        
        JSONObject obj = new JSONObject();
        
        try {

            Store store = storemanager.getStoreById(id);
            logger.debug("ID Store" + store.getID());
            obj.put("key", store.getKkey());
            obj.put("openinghours", store.getOpeningHr());
            obj.put("name", store.getName());
            obj.put("phonenumber", store.getPhoneNumber());
            obj.put("email", store.getEmail());
            obj.put("lattitude", store.getLattitude());
            obj.put("longitude", store.getLongitude());
            obj.put("lastmodificationdate", store.getLastModifiedDate());
            obj.put("lastmodificationby", store.getLastModifiedBy());
            
            obj.put("street", store.getAddress().getStreet());
            obj.put("city", store.getAddress().getCity());
            obj.put("state", store.getAddress().getState());
            obj.put("zipcode", store.getAddress().getZipCode());
            obj.put("Country", store.getAddress().getCountry());
            
        } catch (Exception e) {
            logger.error("Exception" + e.getMessage());
        }
        return obj.toString();
    }

}
