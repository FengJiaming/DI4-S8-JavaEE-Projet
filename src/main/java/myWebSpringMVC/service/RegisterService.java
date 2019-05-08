/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWebSpringMVC.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import myWebSpringMVC.bl.concrete.UserAccountManager;
import myWebSpringMVC.domain.model.UserAccount;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.json.simple.JSONObject;
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

    public RegisterService(UserAccountManager uamanager) {
        this.uamanager = uamanager;
    }

    @RequestMapping(value = "/Register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public String register(@QueryParam("type") String type, @QueryParam("email") String email,
            @QueryParam("firstname") String firstname, @QueryParam("lastname") String lastname, @QueryParam("password") String password,
            @QueryParam("phonenumber") String phonenumber) throws Exception {

        try {
            UserAccount user = new UserAccount();

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

            //Cherche si type Existe
            /*Type typeUser = tymanager.getTypeByName(type);
            if (typeUser == null) {
                typeUser = new Type(type);
                tymanager.addType(typeUser);
            }*/

            //Cherche si country Existe
            /*
            Country countryUser = comanager.getCountryByName(country);
            if (countryUser == null) {
                countryUser = new Country(country);
                comanager.addCountry(countryUser);
            }

            //Cherche si address Existe
            Address addressUser = new Address(address, city, state, zipCode, countryUser);
            //admanager.AddressExiste(addressUser);//regarde si l'address existe ou pas sinon on le créé
            admanager.addAddress(addressUser); // en attendant implémentation on considère que c'est toujours une nouvelle adresse
            UserAccount newUser = new UserAccount(firstName, lastName, email, password, phoneNumber, active, creationDate, lastModificationDate, resetPasswordLink, resetLinkValidateDate, isRemoved, "", typeUser, addressUser);

            */
            uamanager.setUserAccount(user);
            

            //Récupérer user creer et l'afficher
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new Exception("Le compte utilisateur n a pas pu etre cree");
        }

        //obj.toString(2)
        return "Register success";
    }

}
