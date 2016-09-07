/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.driku.ood.controller;

import com.driku.model.User;
import com.driku.ood.service.UserService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author baldeep
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcomePage(ModelMap model, Principal principal) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = auth.getName();
        if (userEmail != null) {
            User user = userService.getUserByEmail(userEmail);
            String userName = "";
            if (user != null) {
                userName = user.getUserName();
                String userRole = "";
                for (GrantedAuthority authority : auth.getAuthorities()) {
                    userRole = authority.getAuthority();
                }
                switch (userRole) {
                    case "ROLE_ADMIN":
                        model.addAttribute("greeting", "Hello " + userName);
                        return "/admin/welcome";
                    case "ROLE_PROVIDER":
                        model.addAttribute("greeting", "Hello " + userName);
                        return "/provider/welcome";
                    case "ROLE_CONSUMER":
                        model.addAttribute("greeting", "Hello " + userName);
                        return "/consumer/welcome";
                    default:
                        break;
                }
            }
        }
        return "/userLogin";
    }
    
     @RequestMapping(value = "invalidAccess")
    public ModelAndView invalidAccess() {
        return new ModelAndView("invalidAccess");
        
    }
}
