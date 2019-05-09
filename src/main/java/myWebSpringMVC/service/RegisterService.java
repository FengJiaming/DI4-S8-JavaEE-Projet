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

    private static final Logger logger = Logger.getLogger(LoginService.class);

    @Inject
    UserAccountManager uamanager;

    @Resource
    AddressManager amanager;

    public RegisterService(UserAccountManager uamanager, AddressManager amanager) {
        this.uamanager = uamanager;
        this.amanager = amanager;
    }

    @RequestMapping(value = "/Register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public String register(@QueryParam("type") String type, @QueryParam("email") String email,
            @QueryParam("firstname") String firstname, @QueryParam("lastname") String lastname, @QueryParam("password") String password,
            @QueryParam("phonenumber") String phonenumber, @QueryParam("city") String city, @QueryParam("country") String country,
             @QueryParam("state") String state
    ) throws Exception {

        try {
            UserAccount user = null;
            if (type.equals("Owner")) {
                user = new Owner();
            } else if (type.equals("Client")) {
                user = new Client();
            }

            user.setFirstName(firstname);
            user.setLastName(lastname);
            user.setEmail(email);
            user.setPassword(password);
            user.setPhoneNumber(phonenumber);
            user.setActive("True");

            Date creationdate = new Date();
            user.setCreationDate(creationdate.toString());
            user.setLastModificationDate(creationdate.toString());
            user.setResetLinkValidateDate("");
            user.setResetPasswordLink("");

            boolean isRemoved = false;
            user.setIsRemoved(isRemoved);

            Address address = new Address();
            
            address.setCity(city);
            address.setCountry(country);
            address.setState(state);
            logger.info("idadress"+address.getID());
            amanager.setAddress(address);
               
            List<Address> addList = new ArrayList<>();
            addList.add(address);

            user.setAddress(addList);

            uamanager.setUserAccount(user);

        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new Exception("Register failed");
        }

        return "Register success";
    }

}
