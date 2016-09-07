/**
 * ****************************************************************************
 *
 * Copyright (c) 2016, Mindfire Solutions and/or its affiliates. All rights
 * reserved.
 * ___________________________________________________________________________________
 *
 *
 * NOTICE: All information contained herein is, and remains the property of
 * Mindfire and its suppliers,if any. The intellectual and technical concepts
 * contained herein are proprietary to Mindfire Solutions. and its suppliers and
 * may be covered by us and Foreign Patents, patents in process, and are
 * protected by trade secret or copyright law. Dissemination of this information
 * or reproduction of this material is strictly forbidden unless prior written
 * permission is obtained from Mindfire Solutions
 */
package com.d.dao;

import com.d.constants.UserConstants;
import com.d.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author baldeep
 */
@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User getUserByMobile(String mobileNumber) {
        try {
            return jdbcTemplate.queryForObject(UserConstants.QUERY_SELECT_USER_BY_MOBILE, new UserDAOMapper(), mobileNumber);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("User not found");
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        try {

            return jdbcTemplate.query(UserConstants.QUERY_SELECT_ALL_USER, new UserDAOMapper());
        } catch (EmptyResultDataAccessException e) {
        }
        return null;
    }

    @Override
    public User getUserByEmail(String userEmail) {
        try {
            return jdbcTemplate.queryForObject(UserConstants.QUERY_SELECT_USER_BY_EMAIL, new UserDAOMapper(), userEmail);
        } catch (EmptyResultDataAccessException e) {
        }
        return null;
    }

}
