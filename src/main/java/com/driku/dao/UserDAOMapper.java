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

import com.driku.constants.UserConstants;
import com.driku.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author baldeep
 */
public class UserDAOMapper implements RowMapper<User> {

    /**
     * Used to map database row with User Model
     * @param rs resultset reference
     * @param i
     * @return
     * @throws SQLException 
     */
    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User user = new User();
        user.setUserEmail(rs.getString(UserConstants.COLUMN_USER_EMAIL));
        user.setUserId(rs.getString(UserConstants.COLUMN_USER_ID));
        user.setUserMobile(rs.getString(UserConstants.COLUMN_MOBILE_NUMBER));
        user.setUserName(rs.getString(UserConstants.COLUMN_USER_NAME));
        user.setUserRole(rs.getString(UserConstants.COLUMN_USER_ROLE));
        return user;
    }
}
