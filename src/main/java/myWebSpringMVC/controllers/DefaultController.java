
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
        
        // UserAccount ua = repo.findByEmail("");
       //UserAccount ua = uamanager.getUserAccountByEmail("907286845@qq.com");
         //int uaid = ua.getID();
        //
        /*    
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
        */
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
                //session.setAttribute("name", name);
                
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
            
            
            UserAccount user = new UserAccount();
            user.setEmail(email);
            user.setFirstName(FirstName);
            user.setLastName(LastName);
            user.setPassword(password);
            user.setPhoneNumber(PhoneNNumber);
            user.getAddress().add(address);
            
            uamanager.setUserAccount(user);
            
            
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
       
        request.getRequestDispatcher("/WEB-INF/JSP/Home.jsp").include(request, response);
        request.getRequestDispatcher("/WEB-INF/JSP/view_store.jsp").include(request, response);
        
    }

}
