/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWebSpringMVC.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myWebSpringMVC.bl.concrete.StoreManager;
import myWebSpringMVC.domain.model.Store;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author leo
 */
@Controller
public class Store_Controller {
    @Resource
    StoreManager smanager; 
    
    
        @GetMapping(value = "/view_store")
    public void get_viewstore(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
       
        try (PrintWriter out = response.getWriter()) {      
            request.getRequestDispatcher("/WEB-INF/JSP/Home.jsp").include(request, response);
            out.print("<div classe=\"container\" >");
            out.print("<div classe=\"row\">");
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
            out.println("<form class=\"form-signin\" action=\"add_store\" method=\"post\">");
            out.println("<input type=\"submit\" value=\"register\" class=\"btn btn-lg btn-dark btn-block text-uppercase\">");
            out.println("</form>");
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
}
