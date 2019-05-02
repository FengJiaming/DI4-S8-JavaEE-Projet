
package myWebSpringMVC.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import myWebSpringMVC.bl.concrete.UserAccountManager;
import myWebSpringMVC.domaine.model.UserAccount;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myWebSpringMVC.domaine.model.Owner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {

//    @Resource
//    UserAccountRepository repo;
    
    @Resource
    UserAccountManager uamanager;
    @Resource
    UserAccount user;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    //@Transactional
    public String index(ModelMap map) {  
        return "Home";
    }
    @PostMapping(value = "/login")
    public void Post_login(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
       try (PrintWriter out = response.getWriter()) {      
            request.getRequestDispatcher("/WEB-INF/JSP/Home.jsp").include(request, response);           
            out.print("<div classe="+"container"+">");
            
            
            if(true){
                request.getParameter("name");
                request.getParameter("password");
                
            }else{
                request.getRequestDispatcher("/WEB-INF/JSP/login.jsp").include(request, response);
                //user or password false
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
}
