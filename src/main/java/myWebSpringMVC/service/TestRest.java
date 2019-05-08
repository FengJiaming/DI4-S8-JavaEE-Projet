/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWebSpringMVC.service;

/**
 *
 * @author FENG
 */
import myWebSpringMVC.bl.concrete.UserAccountManager;
import myWebSpringMVC.domain.model.UserAccount;
import javax.annotation.Resource;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

 

@RestController

@RequestMapping("/api/testrest")

public class TestRest {

    @Resource

    UserAccountManager uamanager;

    public TestRest() {

    }

    @GetMapping(value = "/getTest", produces = MediaType.APPLICATION_JSON)

    public String getJson() {

        return "Hello REST!";

    }
    
    @RequestMapping(value = "/putTest", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON)

    public String putJson(@RequestBody String content) {

        return content + " Data have been saved!";

    }

    @GetMapping(value = "/mymethod/{id}", produces = MediaType.APPLICATION_JSON)

    public String myMethod(@PathVariable("id") String id) {

        UserAccount ua = uamanager.getUserAccountById(3);

        JSONObject obj = new JSONObject();

        obj.put("msg", "mymethod id = " + id);

        obj.put("msg_uid", "uid = " + ua.getID());

        return obj.toString();

    }

}
