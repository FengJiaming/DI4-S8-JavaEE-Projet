/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWebSpringMVC.service;

import java.io.IOException;
import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import myWebSpringMVC.domain.model.UserAccount;
import myWebSpringMVC.bl.concrete.UserAccountManager;
import myWebSpringMVC.helpers.TokenManagement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author FENG
 */

@RestController

@RequestMapping("/api/LoginService")

public class LoginService {

    //@Inject
    private static final Log log = LogFactory.getLog(LoginService.class);

    @Inject
    UserAccountManager uamanager;

    public LoginService(UserAccountManager uamanager) {
        this.uamanager = uamanager;
    }

    @GetMapping(value = "/getTestJSON", produces = MediaType.APPLICATION_JSON)
    public String getJson() {

        return "Hello Login!";

    }

    @RequestMapping(value = "/Login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public Response login(@QueryParam("email") String email, @QueryParam("password") String password) {

        try {
            //ObjectMapper mapper = new ObjectMapper();
            //UserAccount user = mapper.readValue(credentials, UserAccount.class);
            UserAccount user = uamanager.getUserAccountByEmailPassword(email, password);
            int id = 0;
            if (user == null) {
                throw new SecurityException("Email or password invalid");
            } else {
                id = user.getID();
            }

            String token = TokenManagement.generateToken(id);
            log.info("token created");
            log.info("token : "+ token);
            
            // Return the token on the response
            return Response.ok().header(AUTHORIZATION, "Token : " + token).build();
            //log.info("log:login" + user.getFirstName());
    /*
                return Response.status(Response.Status.ACCEPTED).entity(credentials).build();
            } else {
                return Response.status(Response.Status.UNAUTHORIZED).entity(credentials).build();
            }*/

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }
    /*
    public boolean login(UserAccount userAccount) {
        log.info("log:login" + userAccount.getFirstName());
        if(uamanager.isValidLogin(userAccount.getFirstName(), userAccount.getPassword())){
            return true;
            //return "entries";
        }
        return false;
        
    }*/

   
}
