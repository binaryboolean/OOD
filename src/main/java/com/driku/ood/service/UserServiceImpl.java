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
package com.driku.ood.service;

import com.driku.dao.UserDAO;
import com.driku.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author baldeep
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public User getUserByEmail(String userEmail) {
        return userDAO.getUserByEmail(userEmail);
    }

    @Override
    public User getUserByMobile(String mobileNumber) {
        return userDAO.getUserByMobile(mobileNumber);
    }

    @Override
    public List<User> getAllUsers() {
      return userDAO.getAllUsers();
    }
}
