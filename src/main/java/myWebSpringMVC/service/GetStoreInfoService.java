/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWebSpringMVC.service;

import java.util.List;
import javax.annotation.Resource;
import javax.ws.rs.core.MediaType;
import myWebSpringMVC.bl.concrete.StoreManager;
import myWebSpringMVC.domain.model.OpeningHr;
import myWebSpringMVC.domain.model.Store;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
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

    public GetStoreInfoService() {

    }

    @GetMapping(value = "/getStoreInfo/{id}", produces = MediaType.APPLICATION_JSON)
    public String getStoreInfo(@PathVariable("id") int id) {
        
        JSONObject objStore = new JSONObject();
        JSONArray ArrayOpeningHours = new JSONArray();
        try {

            Store store = storemanager.getStoreById(id);
            logger.debug("ID Store" + store.getID());
            objStore.put("key", store.getKkey());
            
            objStore.put("name", store.getName());
            objStore.put("phonenumber", store.getPhoneNumber());
            objStore.put("email", store.getEmail());
            objStore.put("lattitude", store.getLattitude());
            objStore.put("longitude", store.getLongitude());
            objStore.put("lastmodificationdate", store.getLastModifiedDate());
            objStore.put("lastmodificationby", store.getLastModifiedBy());
            
            objStore.put("street", store.getAddress().getStreet());
            objStore.put("city", store.getAddress().getCity());
            objStore.put("state", store.getAddress().getState());
            objStore.put("zipcode", store.getAddress().getZipCode());
            objStore.put("country", store.getAddress().getCountry());
            
            List<OpeningHr> storeOpeningHr = store.getOpeningHr();
            for (int i = 0; i < storeOpeningHr.size(); i++) {
                JSONObject obj = new JSONObject();
                obj.put("weekday", storeOpeningHr.get(i).getWeeking());
                obj.put("starttime", storeOpeningHr.get(i).getStartTime());
                obj.put("endtime", storeOpeningHr.get(i).getEndTime()); 
                
                ArrayOpeningHours.add(i,obj);
            }
            objStore.put("openinghour", ArrayOpeningHours);
            
        } catch (Exception e) {
            logger.error("Exception" + e.getMessage());
        }
        return objStore.toString();
    }

}
