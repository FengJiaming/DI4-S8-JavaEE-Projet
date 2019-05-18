/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWebSpringMVC.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import myWebSpringMVC.bl.concrete.AddressManager;
import myWebSpringMVC.bl.concrete.UserAccountManager;
import myWebSpringMVC.domain.model.Address;
import myWebSpringMVC.domain.model.Client;
import myWebSpringMVC.domain.model.Owner;
import myWebSpringMVC.domain.model.UserAccount;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author FENG
 */
@RestController

@RequestMapping("/api/RegisterService")

public class RegisterService {

    private static final Logger logger = Logger.getLogger(RegisterService.class);

    @Resource
    UserAccountManager uamanager;

    @Resource
    AddressManager amanager;

    public RegisterService() {

    }

    @RequestMapping(value = "/Register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public String register(@RequestBody String content) {
        logger.info("Start register in RegisterService");
        JSONParser parser = new JSONParser();
        JSONObject msg = new JSONObject();
        try {
            UserAccount ua = null;
            JSONObject obj = (JSONObject)parser.parse(content);
            String email = (String) obj.get("Email");
            String password = (String) obj.get("Password");
            String firstname = (String) obj.get("FirstName");
            String lastname = (String) obj.get("LastName");
            String phonenumber = (String) obj.get("PhoneNumber");
            String city = (String) obj.get("City");
            String country = (String) obj.get("Country");
            String state = (String) obj.get("State");
            String type = (String) obj.get("Type");
            logger.info("type:" + type);
            if (type.equals("Owner")) {
                ua = new Owner();
            } else if (type.equals("Client")) {
                ua = new Client();
            }
            //logger.debug("type=",user.get)
            ua.setFirstName(firstname);
            ua.setLastName(lastname);
            ua.setEmail(email);
            ua.setPassword(password);
            ua.setPhoneNumber(phonenumber);
            ua.setActive("True");

            Date creationdate = new Date();
            ua.setCreationDate(creationdate.toString());
            ua.setLastModificationDate(creationdate.toString());
            ua.setResetLinkValidateDate("");
            ua.setResetPasswordLink("");

            boolean isRemoved = false;
            ua.setIsRemoved(isRemoved);

            Address address = new Address();
            
            address.setCity(city);
            address.setCountry(country);
            address.setState(state);
            logger.info("User address is set successfully. ID: " + address.getID());
            amanager.setAddress(address);
               
            List<Address> addList = new ArrayList<>();
            addList.add(address);

            ua.setAddress(addList);

            uamanager.setUserAccount(ua);
            logger.info("User is set successfully. ID: " + ua.getID());

        } catch (ParseException e) {
            logger.error("Exception" + e.getMessage());
            msg.put("message", "Register failed");
            return msg.toString();
        }
        
        msg.put("message", "Register success");
        return msg.toString();
        
    }

}
