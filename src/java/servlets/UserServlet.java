/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Role;
import models.User;
import services.RoleService;
import services.UserService;

/**
 *
 * @author Xavier
 */
public class UserServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UserService userService = new UserService();
        String action = request.getParameter("action");

        try{
            if (action != null && action.equals("edit")){
                String email = request.getParameter("email");
                User selUser = userService.get(email);
                request.setAttribute("selUser", selUser);
                request.setAttribute("email", selUser.getEmail());
            } else if (action != null && action.equals("delete")){
                String email = request.getParameter("email");
                User selUser = userService.get(email);
                userService.delete(selUser);
                List<User> users = userService.getAll();
                    if(users.isEmpty()){
                        request.setAttribute("errorMessage", "No users found. Please add a user.");
                    }
            }
            
            List<User> users = userService.getAll();
            request.setAttribute("users", users);
            
        } catch (Exception ex){
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("errorMessage", "error");
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/user.jsp")
                .forward(request,response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService userService = new UserService();   
        String action = request.getParameter("action");
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String roleName = request.getParameter("role");
        Role role = new Role(roleName);
        User user = new User(email,firstName,lastName,password,role);

        try{
            switch (action){
                case "add":
                    userService.insert(user);
                    break;
                case "update":
                    userService.update(user);
                    break;
            }
            
            List<User> users = userService.getAll();
            request.setAttribute("users", users);
 
        } catch (Exception ex){
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("errorMessage", "error");
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/user.jsp").forward(request, response);
    }

}
