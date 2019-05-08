
package myWebSpringMVC.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import myWebSpringMVC.bl.concrete.UserAccountManager;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import myWebSpringMVC.bl.concrete.AddressManager;
import myWebSpringMVC.bl.concrete.OpeningHrManager;
import myWebSpringMVC.bl.concrete.PromotionManager;
import myWebSpringMVC.bl.concrete.StoreManager;
import myWebSpringMVC.domain.model.Address;
import myWebSpringMVC.domain.model.Client;
import myWebSpringMVC.domain.model.Owner;
import myWebSpringMVC.domain.model.Store;
import myWebSpringMVC.domain.model.UserAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


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
    
    @GetMapping(value = "/")
    //@Transactional
    public String index(ModelMap map) {
        
      
        return "Home";
    }
    
    @PostMapping(value = "/login")
    public void Post_login(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
       try (PrintWriter out = response.getWriter()) {      
                      
            
            
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            
            Logger logger = Logger.getLogger("User");
            logger.log(Level.FINE,name );
            logger.log(Level.FINE,password);
            
            if(uamanager.verifierLogin(name, password)){
                HttpSession session = request.getSession();
                session.setAttribute("name", name);
                request.getRequestDispatcher("/WEB-INF/JSP/Home.jsp").include(request, response); 
                out.print("<div classe="+"container"+">");
                
                
            }else{
                request.getRequestDispatcher("/WEB-INF/JSP/Home.jsp").include(request, response); 
                out.print("<div classe="+"container"+">");
                request.setAttribute("name", name);
                request.getRequestDispatcher("/WEB-INF/JSP/login.jsp").include(request, response);
                
                
            }
            out.print("</div>");
        }catch(Exception e){
            Logger logger = Logger.getLogger("error");
            logger.log(Level.FINE,e.getMessage() );
            System.out.println(e);
            
        }
       
       
    }
    @GetMapping(value = "/login")
    public void Get_login(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        try (PrintWriter out = response.getWriter()) {      
            request.getRequestDispatcher("/WEB-INF/JSP/Home.jsp").include(request, response);           
            out.print("<div classe="+"container"+">");
            request.getRequestDispatcher("/WEB-INF/JSP/login.jsp").include(request, response);
            out.print("</div>");
        }
    }
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
    @GetMapping(value = "/logout")
    public void get_logout(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        HttpSession session = request.getSession();
        session.invalidate();
        request.getRequestDispatcher("/WEB-INF/JSP/Home.jsp").include(request, response);
    }
    @GetMapping(value = "/view_store")
    public void get_viewstore(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
       
        try (PrintWriter out = response.getWriter()) {      
            request.getRequestDispatcher("/WEB-INF/JSP/Home.jsp").include(request, response);
            out.print("<div classe="+"container"+">");
            out.print("<div classe="+"row"+">");
            List<Store> stores = smanager.all();
            out.print("<ul class=\"list-group col\">");
             for (Store var : stores){
                out.println("<form class=\"list-group-item list-group-item-action list-group-item-dark\" action=\"view_store\" method=\"post\">");
                out.println("<div>");
                out.println("Email:<input name=\"email\" type=\"text\" placeholder=\""+var.getEmail()+"\" value=\""+var.getEmail()+"\">");
                out.println("</div>");
                out.println("<div>");
                out.println("Phone Number:<input name=\"phone\" type=\"text\" placeholder=\""+var.getPhoneNumber()+"\" value=\""+var.getPhoneNumber()+"\">");
                out.println("</div>");
                out.println("<div>");
                out.println("Name:<input name=\"Name\" type=\"text\" placeholder=\""+var.getName()+"\" value=\""+var.getName()+"\">");
                out.println("</div>");
                out.println("<div>");
                out.println("Lattitude:<input name=\"lattitude\" type=\"text\" placeholder=\""+var.getLattitude()+"\" value=\""+var.getLattitude()+"\">");
                out.println("</div>");
                out.println("<div>");
                out.println("Longitude:<input name=\"longitude\" type=\"text\" placeholder=\""+var.getLongitude()+"\" value=\""+var.getLongitude()+"\">");
                out.println("</div>");
                out.println("<input type=\"submit\" value=\"modify\" class=\"btn btn-lg btn-dark btn-block text-uppercase\">  ");
                out.println("</div>");
                out.println("</form>");
            } 
                   
            out.print("</ul>");
            out.print("</div>");
            out.print("</div>");
            
           
        }
        
    }
    @PostMapping(value = "/view_store")
    public void post_viewstore(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{       
        try (PrintWriter out = response.getWriter()) {      
            //request.getRequestDispatcher("/WEB-INF/JSP/Home.jsp").include(request, response);

            
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String name = request.getParameter("Name");
            String lattitude = request.getParameter("lattitude");
            String longitude = request.getParameter("longitude");
            
            Store new_store = new Store();
            new_store.setEmail(email);
            new_store.setPhoneNumber(phone);
            new_store.setName(name);
            new_store.setLattitude(Double.parseDouble(lattitude));
            new_store.setLongitude(Double.parseDouble(longitude));
            smanager.updateStore(new_store);

            
            get_viewstore(request, response);
            
           
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
            out.print("</div>");
        }
        request.getRequestDispatcher("/WEB-INF/JSP/Home.jsp").include(request, response);

        /*
        // UserAccount ua = repo.findByEmail("");
       //UserAccount ua = uamanager.getUserAccountByEmail("907286845@qq.com");
         //int uaid = ua.getID();
        //
          
        Owner ua2 = new Owner();
        ua2.setID(3);
        ua2.setActive("Etudier");
        ua2.setLastName("marie");
        ua2.setPassword("123456");
        ua2.setAddress(addList);
        uamanager.setUserAccount(ua2);
        
        Client client = new Client();
        client.setID(4);
        client.setEmail("1234@gmail.com");
        client.setPassword("123456");
        uamanager.setUserAccount(client);
        
//        UserAccount ua = uamanager.getUserAccountById(2);
        Promotion promo = new Promotion();
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
         
       // uamanager.deleteUserAccountById(1);
        
        map.put("msg", "Hello Spring 5 Web MVC!");
        map.put("userId",  1);//ua.getID());
        map.put("userName", "test");//ua.getFirstName());
        // map.put("cCIty", ua.getAddress().getCity());
*/
        
    }

}
