/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWebSpringMVC.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import myWebSpringMVC.bl.concrete.UserAccountManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author leo
 */
@Controller
public class login_controller {
    @Resource
    UserAccountManager uamanager;
    
    @PostMapping(value = "/login")
    public void Post_login(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
       try (PrintWriter out = response.getWriter()) {      
                      
            
            
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            Logger logger = Logger.getLogger("User");
            logger.log(Level.FINE,email );
            logger.log(Level.FINE,password);
            
            if(uamanager.verifierEmailExist(email) && uamanager.verifierLogin(email, password)){
                HttpSession session = request.getSession();
                session.setAttribute("name", email);
                request.getRequestDispatcher("/WEB-INF/JSP/Home.jsp").include(request, response); 
                out.print("<div classe="+"container"+">");
                
                
            }else{
                request.getRequestDispatcher("/WEB-INF/JSP/Home.jsp").include(request, response); 
                out.print("<div classe="+"container"+">");
                request.setAttribute("name", email);
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
}
