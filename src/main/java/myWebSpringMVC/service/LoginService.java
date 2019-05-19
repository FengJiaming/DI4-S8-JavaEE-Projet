/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWebSpringMVC.service;

import myWebSpringMVC.helpers.TokenManagement;
import java.io.UnsupportedEncodingException;
import org.apache.log4j.Logger;
import javax.annotation.Resource;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import myWebSpringMVC.domain.model.UserAccount;
import myWebSpringMVC.bl.concrete.UserAccountManager;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author FENG
 */
@RestController

@RequestMapping("/api/LoginService")

public class LoginService {

    private static final Logger logger = Logger.getLogger(LoginService.class);

    @Resource
    UserAccountManager uamanager;

    public LoginService() {
        
    }

    @RequestMapping(value = "/Login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public Response login(@RequestBody String content) {
        
        logger.info("Start Login in LoginService");
        JSONParser parser = new JSONParser();
 
        try {
            JSONObject obj = (JSONObject)parser.parse(content);
            String email = (String) obj.get("email");
            String password = (String) obj.get("password");
            
            logger.info("Get the login information! Email: " + email);
            
            UserAccount user = uamanager.getUserAccountByEmailPassword(email, password);
            
            logger.info("UserID:" + user.getID());
            int id = 0;
            
            if (user == null) {
                logger.error("User is null");
                throw new SecurityException("Email or password invalid");
            } else {
                id = user.getID();
            }
            
            String token = TokenManagement.generateToken(id, uamanager);
            logger.info("Token of the user " + id + ":" + token);
            
            return Response.status(Response.Status.ACCEPTED).header("authentification Token", token).build();

        } catch (UnsupportedEncodingException | SecurityException | JSONException | ParseException e) {
            logger.error("Exception" + e.getMessage());
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

}
