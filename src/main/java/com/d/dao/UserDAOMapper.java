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
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author baldeep
 */
public class UserDAOMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User user = new User();
        user.setUserEmail(rs.getString(UserConstants.COLUMN_USER_EMAIL));
        user.setUserId(rs.getString(UserConstants.COLUMN_USER_ID));
        user.setUserMobile(rs.getString(UserConstants.COLUMN_MOBILE_NUMBER));
        user.setUserName(rs.getString(UserConstants.COLUMN_USER_NAME));
        user.setUserRole(rs.getString(UserConstants.COLUMN_USER_ROLE));
        System.out.println(user);
        return user;
    }
}
