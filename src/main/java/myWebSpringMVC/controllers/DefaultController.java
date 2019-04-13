
package myWebSpringMVC.controllers;

import myWebSpringMVC.bl.concrete.UserAccountManager;
import myWebSpringMVC.domain.model.UserAccount;
import javax.annotation.Resource;
import myWebSpringMVC.bl.concrete.OpeningHrManager;
import myWebSpringMVC.bl.concrete.PromotionManager;
import myWebSpringMVC.bl.concrete.StoreManager;
import myWebSpringMVC.domain.model.OpeningHr;
import myWebSpringMVC.domain.model.Owner;
import myWebSpringMVC.domain.model.Store;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {

 //   @Resource
   // UserAccountRepository repo;
    
    @Resource
    UserAccountManager uamanager;
    @Resource
    StoreManager smanager;  
    @Resource
    OpeningHrManager ohmanager;
    @Resource
    PromotionManager pmanager;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    //@Transactional
    public String index(ModelMap map) {
        
        //UserAccount ua = repo.findById(1).get();
       // UserAccount ua = uamanager.getUserAccountById(1);
        
        //
        
        Owner ua2 = new Owner();
        ua2.setID(3);
        //ua1.setCity("Tours");
        ua2.setActive("Etudier");
        //ua1.setCountry("France");
        ua2.setLastName("marie");
        
        ua2.setFirstName("feng");
        uamanager.setUserAccount(ua2);
        
//        UserAccount ua = uamanager.getUserAccountById(2);
        
        Store st1 = new Store();
        st1.setID(2);
        st1.setKkey("key1");
        st1.setEmail("907286845");
        st1.setLattitude(1.1);
        st1.setLongitude(23.15);
        //st1.setLastModifiedBy(ua.getID());
        
//        smanager.setStore(st1);
        /*
        OpeningHr oh = new OpeningHr();
        oh.setID(2);
        oh.setWeeking("Mon.");
        oh.setStartTime("07:00");
        oh.setEndTime("21:00");
       // oh.setClosed(false);
        //oh.setTwentyFourH(false);
        ohmanager.setOpeningHr(oh);
        */
       // uamanager.deleteUserAccountById(1);
        
        map.put("msg", "Hello Spring 5 Web MVC!");
        map.put("userId",  1);//ua.getID());
        map.put("userName", "test");//ua.getFirstName());
        // map.put("cCIty", ua.getAddress().getCity());

        return "index";
    }
}
