
package myWebSpringMVC.controllers;

import java.util.ArrayList;
import java.util.List;
import myWebSpringMVC.bl.concrete.UserAccountManager;
import javax.annotation.Resource;
import myWebSpringMVC.bl.concrete.AddressManager;
import myWebSpringMVC.bl.concrete.OpeningHrManager;
import myWebSpringMVC.bl.concrete.PromotionManager;
import myWebSpringMVC.bl.concrete.StoreManager;
import myWebSpringMVC.domain.model.Address;
import myWebSpringMVC.domain.model.OpeningHr;
import myWebSpringMVC.domain.model.Owner;
import myWebSpringMVC.domain.model.Promotion;
import myWebSpringMVC.domain.model.Store;
import myWebSpringMVC.domain.repository.UserAccountRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {

    @Resource
    UserAccountManager uamanager;
    @Resource
    StoreManager smanager;  
    @Resource
    OpeningHrManager ohmanager;
    @Resource
    PromotionManager pmanager;
    @Resource
    AddressManager amanager;   
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    //@Transactional
    public String index(ModelMap map) {
        
        // UserAccount ua = repo.findByEmail("");
       //UserAccount ua = uamanager.getUserAccountByEmail("907286845@qq.com");
         //int uaid = ua.getID();
        //
        /*
        Address add = new Address();
        add.setID(1);
        add.setCity("Tours");
        add.setCountry("France");
        add.setState("Indre-et-loire");
        amanager.setAddress(add);
        add.setCity("Toulouse");
        amanager.updateAddress(add);
        //Address add1 = new Address();
        //add1 = amanager.getAddressById(2);
        //amanager.deleteAddressById(3);
        
        List<Address> addList = new ArrayList<>();
        addList.add(add);
        Owner ua2 = new Owner();
        ua2.setID(3);
        ua2.setActive("Etudier");
        ua2.setLastName("marie");
        ua2.setAddress(addList);
        uamanager.setUserAccount(ua2);
        */
//        UserAccount ua = uamanager.getUserAccountById(2);
        /*Promotion promo = new Promotion();
        promo.setID(1);
        promo.setImageURL("url");
        promo.setPosition("Tours");
        promo.setTitle("title1");
        pmanager.setPromotion(promo);
        
        List<Promotion> proList = new ArrayList<>();
        proList.add(promo);
        
        Store st1 = new Store();
        st1.setID(2);
        st1.setKkey("key1");
        st1.setEmail("907286845");
        st1.setLattitude(1.1);
        st1.setLongitude(23.15);
        st1.setPromotions(proList);
        Address add = new Address();
        add.setID(1);
        add.setCity("Tours");
        add.setCountry("France");
        add.setState("Indre-et-loire");
        st1.setAddress(add);
        //st1.setLastModifiedBy(ua.getID());   
        smanager.setStore(st1);
        
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
        //map.put("cCIty", ua.getAddress().getCity());
        //map.put("ID",ua.getID());
        return "index";
    }
}
