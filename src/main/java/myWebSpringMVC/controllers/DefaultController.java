
package myWebSpringMVC.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import myWebSpringMVC.bl.concrete.UserAccountManager;
import myWebSpringMVC.domaine.model.UserAccount;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller

public class DefaultController {

//    @Resource
//    UserAccountRepository repo;
    /*
    @Resource
    UserAccountManager uamanager;
    @Resource
    UserAccount user;
*/
    
    
    @GetMapping(value = "/")
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
            
            if(true){
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
            
        }
    }
    @GetMapping(value = "/logout")
    public void get_logout(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        HttpSession session = request.getSession();
        session.invalidate();
        request.getRequestDispatcher("/WEB-INF/JSP/Home.jsp").include(request, response);
    }

}
