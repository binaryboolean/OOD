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
package com.driku.dao;

import com.driku.model.User;
import java.util.List;

/**
 *
 * @author baldeep
 */
public interface UserDAO {

    /**
     * Finds user based on matching mobile number
     * @param mobileNumber of User
     * @return 
     */
    public User getUserByMobile(String mobileNumber);

    /**
     * Finds user based on matching email
     * @param userEmail
     * @return 
     */
    public User getUserByEmail(String userEmail);

    /**
     * Finds all users.
     * @return 
     */
    public List<User> getAllUsers();
    
    /**
     * Authenticate user based on email and password
     * @param userEmail
     * @param userPassword
     * @return 
     */
    public User authenticateUser(String userEmail,String userPassword);

}
