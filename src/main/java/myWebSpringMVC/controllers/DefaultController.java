
package myWebSpringMVC.controllers;

import myWebSpringMVC.bl.concrete.UserAccountManager;
import myWebSpringMVC.domaine.model.UserAccount;
import javax.annotation.Resource;
import myWebSpringMVC.domaine.model.Owner;
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
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    //@Transactional
    public String index(ModelMap map) {  
        return "index";
    }
        @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String test(){
        return "register";
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String test1(){
        return "login";
    }
}
