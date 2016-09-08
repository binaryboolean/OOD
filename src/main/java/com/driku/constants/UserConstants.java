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
/**
 *
 * @author baldeep
 */

package com.driku.constants;
public interface UserConstants {

    /**
     * Constants for SQL Queries
     */
    String QUERY_SELECT_USER_BY_MOBILE="SELECT * FROM OOD_USERS WHERE MOBILE_NUMBER=?";
    String QUERY_SELECT_USER_BY_EMAIL="SELECT * FROM OOD_USERS WHERE USER_EMAIL=?";
    String QUERY_AUTHENTICATE_USER="SELECT * FROM OOD_USERS WHERE USER_EMAIL=? AND PASSWORD=?";
    String QUERY_SELECT_ALL_USER="SELECT * FROM OOD_USERS WHERE ROLE<>'ADMIN'";
    
    /**
     * Constants for Column Names
     */
    String COLUMN_USER_NAME="USER_NAME";
    String COLUMN_USER_EMAIL="USER_EMAIL";
    String COLUMN_MOBILE_NUMBER="MOBILE_NUMBER";
    String COLUMN_USER_ROLE="ROLE";
    String COLUMN_USER_ID="ID";
    
    /**
     * Constants for User Roles
     */
    String ROLE_ADMIN="ROLE_ADMIN";
    String ROLE_CONSUMER="ROLE_CONSUMER";
    String ROLE_PROVIDER="ROLE_PROVIDER";
    
    /**
     * Constants for Welcome page User Role Wise
     */
    String WELCOME_PAGE_ADMIN="/admin/welcome";
    String WELCOME_PAGE_CONSUMER="/consumer/welcome";
    String WELCOME_PAGE_PROVIDER="/provider/welcome";
    
    /**
     * Login Page Constants
     */
    String LOGIN_PAGE="/userLogin";
    /**
     * Invalid Access Page
     */
    String INVALID_ACCESS_PAGE="/invalidAccess";
    
    /**
     * Default URL
     */
    String DEFAULT_URL="/";
    
    /**
     * Greeting Constants
     */
    String WELCOME_GREETING_KEY="greeting";
    String WELCOME_GREETING_ADMIN="Admin: ";
    String WELCOME_GREETING_CONSUMER="Consumer: ";
    String WELCOME_GREETING_PROVIDER="Provider: ";
    
    /**
     * SALT for HASH
     */
    public static final String SALT = "$2a$08$nv8/8OQhGiZ7wzaFB4SoSO6wQeHErBRARhicAjbv0ZMctopyB0F.W";
}
