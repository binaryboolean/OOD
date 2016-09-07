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
/**
 *
 * @author baldeep
 */

package com.d.constants;
public interface UserConstants {

    String QUERY_SELECT_USER_BY_MOBILE="SELECT * FROM OOD_USERS WHERE MOBILE_NUMBER=?";
    String QUERY_SELECT_USER_BY_EMAIL="SELECT * FROM OOD_USERS WHERE USER_EMAIL=?";
    
    String QUERY_SELECT_ALL_USER="SELECT * FROM OOD_USERS WHERE ROLE<>'ADMIN'";
    
    
    String COLUMN_USER_NAME="USER_NAME";
    String COLUMN_USER_EMAIL="USER_EMAIL";
    String COLUMN_MOBILE_NUMBER="MOBILE_NUMBER";
    String COLUMN_USER_ROLE="ROLE";
    String COLUMN_USER_ID="ID";
}
