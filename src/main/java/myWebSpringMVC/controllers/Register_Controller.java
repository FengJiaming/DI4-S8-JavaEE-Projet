package myWebSpringMVC.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myWebSpringMVC.bl.concrete.UserAccountManager;
import myWebSpringMVC.domain.model.Address;
import myWebSpringMVC.domain.model.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leo
 */
@Controller
public class Register_Controller {
        @Resource
    UserAccountManager uamanager;
    @GetMapping(value = "/register")
    public void get_register(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
       try (PrintWriter out = response.getWriter()) {      
            request.getRequestDispatcher("/WEB-INF/JSP/Home.jsp").include(request, response);
            out.print("<div classe="+"container"+">");
            request.getRequestDispatcher("/WEB-INF/JSP/register.jsp").include(request, response);
            
            out.print("</div>");
        }
    }
    @PostMapping(value = "/register")
    public void post_register(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
       try (PrintWriter out = response.getWriter()) {      
            request.getRequestDispatcher("/WEB-INF/JSP/Home.jsp").include(request, response);
            
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String LastName = request.getParameter("LastName");
            String FirstName = request.getParameter("FirstName");
            String PhoneNNumber = request.getParameter("PhoneNNumber");
            String Street = request.getParameter("Street");
            String City = request.getParameter("City");
            String State = request.getParameter("State");
            String ZipCode = request.getParameter("ZipCode");
            String Country = request.getParameter("Country");
            
            
            Address address = new Address();
            address.setCity(City);
            address.setState(State);
            address.setStreet(Street);
            address.setZipCode(ZipCode);
            address.setCountry(Country);
            
            
            Client user = new Client();
            user.setEmail(email);
            user.setFirstName(FirstName);
            user.setLastName(LastName);
            user.setPassword(password);
            user.setPhoneNumber(PhoneNNumber);
            user.getAddress().add(address);
            
            
            
            uamanager.setUserAccount(user);
            out.print("<div classe="+"container"+">");
            out.print("<p class=\"alert alert-success\"> Client add</p>");
            out.print("</div>");
            
            
        }catch(Exception e){
            
            Logger logger = Logger.getLogger("error");
            logger.log(Level.FINE,e.getMessage() );
            request.setAttribute("name", "test");
        }
    }
}
