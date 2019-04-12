
package myWebSpringMVC.controllers;

import myWebSpringMVC.bl.concrete.UserAccountManager;
import myWebSpringMVC.domain.model.UserAccount;
import javax.annotation.Resource;

import myWebSpringMVC.bl.concrete.StoreManager;
import myWebSpringMVC.domain.model.Owner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {

//    @Resource
//    UserAccountRepository repo;
    
    @Resource
    UserAccountManager uamanager;
    @Resource
    StoreManager smanager;  
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    //@Transactional
    public String index(ModelMap map) {
        
        //UserAccount ua = repo.findById(1).get();
       // UserAccount ua = uamanager.getUserAccountById(1);
        
        //
        /*
        Owner ua1 = new Owner();
        ua1.setID(2);
        ua1.setCity("Tours");
        ua1.setActive("Etudier");
        ua1.setCountry("France");
        ua1.setLastName("xiaoming");
        
        ua1.setFirstName("feng");
        uamanager.updateUserAccount(ua1);*/
        
        //UserAccount ua = uamanager.getUserAccountById(2);
        
       // uamanager.deleteUserAccountById(1);
        
        map.put("msg", "Hello Spring 5 Web MVC!");
        //map.put("userId", ua.getID());
        //map.put("userName", ua.getFirstName());
        // map.put("cCIty", ua.getAddress().getCity());

        return "index";
    }
}
