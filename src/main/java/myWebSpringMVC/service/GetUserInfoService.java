/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWebSpringMVC.service;

import java.util.List;
import myWebSpringMVC.helpers.TokenManagement;
import javax.annotation.Resource;
import myWebSpringMVC.bl.concrete.UserAccountManager;
import myWebSpringMVC.domain.model.Address;
import myWebSpringMVC.domain.model.UserAccount;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author FENG
 */
@RestController

@RequestMapping("/api/UserInfoService")

public class GetUserInfoService {

    private static final Logger logger = Logger.getLogger(LoginService.class);

    @Resource
    UserAccountManager uamanager;

    public GetUserInfoService(UserAccountManager uamanager) {
        this.uamanager = uamanager;
    }

    @GetMapping(value = "/GetUserInfo/{id}", produces = MediaType.APPLICATION_JSON)
    public String getUserInfo(@PathVariable("id") int id, @RequestHeader(value = "authentificationToken") String token) {

        UserAccount ua = uamanager.getUserAccountById(id);
        logger.info("token is " + token);
        
        String UUID = ua.getUUID();
        try {
            if (!TokenManagement.verifyToken(token, UUID)) {
                throw new NotAuthorizedException("Invalid token");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        
        JSONObject objUser = new JSONObject();
        JSONArray ArrayAddress = new JSONArray();
        try {
            objUser.put("Id", ua.getID());
            objUser.put("Active", ua.getActive());
            objUser.put("CreationDate", ua.getCreationDate());
            objUser.put("Email", ua.getEmail());
            objUser.put("FirstName", ua.getFirstName());
            objUser.put("LastName", ua.getLastName());
            objUser.put("Password", ua.getPassword());
            objUser.put("isRemoved", ua.isIsRemoved());
            objUser.put("LastModificationDate", ua.getLastModificationDate());
            objUser.put("PhoneNumber", ua.getPhoneNumber());
            objUser.put("ResetPasswordLink", ua.getResetPasswordLink());
            objUser.put("ResetLinkValidateDate", ua.getResetLinkValidateDate());
            
            List<Address> ListAddress = ua.getAddress();
            for (int i = 0; i < ListAddress.size(); i++) {
                JSONObject obj = new JSONObject();
                obj.put("state", ListAddress.get(i).getState());
                obj.put("city", ListAddress.get(i).getCity());
                obj.put("country", ListAddress.get(i).getCountry()); 
                obj.put("street", ListAddress.get(i).getStreet()); 
                obj.put("zipcode", ListAddress.get(i).getZipCode()); 
                ArrayAddress.add(i,obj);
            }
            objUser.put("address", ArrayAddress);
            
        } catch (JSONException e) {
            logger.error("Exception" + e.getMessage());
        }
        return objUser.toString();
    }

}
