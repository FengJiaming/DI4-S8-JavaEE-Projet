/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWebSpringMVC.service;

import javax.annotation.Resource;
import myWebSpringMVC.bl.concrete.UserAccountManager;
import myWebSpringMVC.domain.model.UserAccount;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

@RequestMapping("/api/UserInfoService")

public class GetUserInfoService {

    private static final Logger logger = Logger.getLogger(LoginService.class);

    @Resource
    UserAccountManager uamanager;

    public GetUserInfoService(UserAccountManager uamanager) {
        this.uamanager = uamanager;
    }

    @GetMapping(value = "/GetUserInfo/{id}", produces = MediaType.APPLICATION_JSON)
    public String getUserInfo(@PathVariable("id") String id) {

        UserAccount ua = uamanager.getUserAccountById(Integer.parseInt(id));
/*
        if (!TokenManagement.verifyToken(headers.get("authentificationToken"))) {
            throw new NotAuthorizedException("Invalid token");
        }*/
        JSONObject obj = new JSONObject();

        obj.put("Id", ua.getID());
        obj.put("Active", ua.getActive());
        obj.put("CreationDate", ua.getCreationDate());
        obj.put("Email", ua.getEmail());
        obj.put("FirstName", ua.getFirstName());
        obj.put("LastName", ua.getLastName());
        obj.put("Password", ua.getPassword());
        obj.put("isRemoved", ua.isIsRemoved());
        obj.put("LastModificationDate", ua.getLastModificationDate());
        obj.put("PhoneNumber", ua.getPhoneNumber());
        obj.put("ResetPasswordLink", ua.getResetPasswordLink());
        obj.put("ResetLinkValidateDate", ua.getResetLinkValidateDate());

        return obj.toString();
    }

}
