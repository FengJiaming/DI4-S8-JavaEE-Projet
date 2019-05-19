
package myWebSpringMVC.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import myWebSpringMVC.bl.concrete.UserAccountManager;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import myWebSpringMVC.bl.concrete.StoreManager;
import myWebSpringMVC.domain.model.Client;
import myWebSpringMVC.domain.model.Owner;
import myWebSpringMVC.domain.model.Store;
import myWebSpringMVC.domain.model.UserAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * @author leo
 */
@Controller
public class DefaultController {
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DefaultController.class);
    @Resource
    UserAccountManager uamanager;
    @Resource
    StoreManager smanager;  
    
    @GetMapping(value = "/")
    //@Transactional
    public String index(ModelMap map) {
        
      
        return "Home";
    }
    
    @GetMapping(value = "/logout")
    public void get_logout(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        HttpSession session = request.getSession();
        session.invalidate();
        request.getRequestDispatcher("/WEB-INF/JSP/Home.jsp").include(request, response);
    }
    
    @GetMapping(value = "/info")
    public void get_info(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        HttpSession session = request.getSession();
        String email = (String)session.getAttribute("name");
        UserAccount user = uamanager.getUserAccountByEmail(email);
        request.getRequestDispatcher("/WEB-INF/JSP/Home.jsp").include(request, response);
        
        try (PrintWriter out = response.getWriter()) {      
     
            out.println("<div classe=\"container\" style=\"margin-top: 50px;\">");
            
            out.print("<ul class=\"list-group col\">");
            out.print("<li class=\"list-group-item\">User:"+user.getEmail()+"</li>");
            out.print("<li class=\"list-group-item\">FirstName:"+user.getFirstName()+"</li>");
            out.print("<li class=\"list-group-item\">LastName:"+user.getLastName()+"</li>");
            out.print("<li class=\"list-group-item\">PhoneNumber:"+user.getPhoneNumber()+"</li>");
           
            //out.print("<li class=\"list-group-item\">Address:"+user.getAddress()+"</li>");
            out.print("<li class=\"list-group-item\">CreationDate:"+user.getCreationDate()+"</li>");
           
            out.print("</ul>");
                
            
            out.print("</div>");
        }catch(Exception e){
            Logger logger = Logger.getLogger("error");
            logger.log(Level.FINE,e.getMessage() );
            System.out.println(e);
            
        }
    }

    @GetMapping(value = "/test")
    public void test(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
       try (PrintWriter out = response.getWriter()) {
            Client client = new Client();
            
            
            client.setLastName("test");
            client.setEmail("123"+Math.random()+"@gmail.com");
            client.setPassword("123456");
            uamanager.setUserAccount(client);
            
            Owner ua2 = new Owner();
            ua2.setID(3);
            ua2.setActive("Etudier");
            ua2.setLastName("marie");
            ua2.setPassword("123456");
            //ua2.setAddress(addList);
            uamanager.setUserAccount(ua2);
            
            Store st1 = new Store();
            st1.setKkey("key1");
            st1.setEmail("90728684566");
            st1.setLattitude(1.1);
            st1.setLongitude(23.15);
            smanager.setStore(st1);
            
        
            request.getRequestDispatcher("/WEB-INF/JSP/Home.jsp").include(request, response);           
            out.print("<div classe="+"container"+">");
            out.print("Page de test");
            request.getRequestDispatcher("/WEB-INF/JSP/Test_JSP.jsp").include(request, response);
            out.print("</div>");
        }
       
    }
}
