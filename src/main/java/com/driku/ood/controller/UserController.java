/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.driku.ood.controller;

import com.driku.constants.UserConstants;
import com.driku.model.User;
import com.driku.ood.service.UserService;
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

    @RequestMapping(value = UserConstants.DEFAULT_URL, method = RequestMethod.GET)
    public String welcomePage(ModelMap model) {
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
                    case UserConstants.ROLE_ADMIN:
                        model.addAttribute(UserConstants.WELCOME_GREETING_KEY, UserConstants.WELCOME_GREETING_ADMIN + userName);
                        return UserConstants.WELCOME_PAGE_ADMIN;
                    case UserConstants.ROLE_PROVIDER:
                        model.addAttribute(UserConstants.WELCOME_GREETING_KEY, UserConstants.WELCOME_GREETING_PROVIDER + userName);
                        return UserConstants.WELCOME_PAGE_PROVIDER;
                    case UserConstants.ROLE_CONSUMER:
                        model.addAttribute(UserConstants.WELCOME_GREETING_KEY, UserConstants.WELCOME_GREETING_CONSUMER + userName);
                        return UserConstants.WELCOME_PAGE_CONSUMER;
                    default:
                        break;
                }
            }
        }
        return UserConstants.LOGIN_PAGE;
    }

    @RequestMapping(value = UserConstants.INVALID_ACCESS_PAGE)
    public ModelAndView invalidAccess() {
        return new ModelAndView(UserConstants.INVALID_ACCESS_PAGE);

    }
}
