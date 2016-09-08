/**
 * ****************************************************************************
 *
 * Copyright (c) 2016, DRIKU Technologies and/or its affiliates. All rights
 * reserved.
 * ___________________________________________________________________________________
 *
 *
 * NOTICE: All information contained herein is, and remains the property of
 * DRIKU and its suppliers,if any. The intellectual and technical concepts
 * contained herein are proprietary to DRIKU Technologies. and its suppliers and
 * may be covered by us and Foreign Patents, patents in process, and are
 * protected by trade secret or copyright law. Dissemination of this information
 * or reproduction of this material is strictly forbidden unless prior written
 * permission is obtained from DRIKU Technologies
 */
package com.driku.ood.controller;

import com.driku.constants.AdminConstants;
import com.driku.model.User;
import com.driku.ood.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author baldeep
 */
@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @RequestMapping(value = AdminConstants.URL_GET_USER_BY_MOBILE, method = RequestMethod.GET)
    @ResponseBody
    public User getUserByMobile(@PathVariable String mobileNumber, ModelMap model) {
        return userService.getUserByMobile(mobileNumber);

    }

    @RequestMapping(value = AdminConstants.URL_GET_ALL_USERS, method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }
}
