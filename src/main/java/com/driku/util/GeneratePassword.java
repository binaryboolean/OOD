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
package com.driku.util;

import java.util.Random;

/**
 *
 * @author Baldeep Singh Kwatra
 */
public class GeneratePassword {

    
    private static final String RAW_CHARACTERS = "23456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz";
    static Random rnd = new Random();

    /**
     * Method for generating random password
     * @param length
     * @return 
     */
    public static String randomPassword(int length) {
        StringBuilder stringBuilder = new StringBuilder(10);
        for (int i = 0; i < length; i++) {
            stringBuilder.append(RAW_CHARACTERS.charAt(rnd.nextInt(RAW_CHARACTERS.length())));
        }
        return stringBuilder.toString();
    }
}
