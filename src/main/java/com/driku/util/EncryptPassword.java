/**
 * ****************************************************************************
 *
 * Copyright (c)  2016, DRIKU Solutions and/or its affiliates. All rights reserved.
 * ___________________________________________________________________________________
 *
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of DRIKU and its suppliers,if any.
 * The intellectual and technical concepts contained
 * herein are proprietary to DRIKU Solutions.
 * and its suppliers and may be covered by us and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from DRIKU Solutions.
 */
package com.driku.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * This class is responsible for encrypting the password. In cryptography, a
 * salt is random data that is used as an additional input to a one-way function
 * that "hashes" a password or passphrase. The primary function of salts is to
 * defend against dictionary attacks versus a list of password hashes and
 * against pre-computed rainbow table attacks.
 *
 * @author Baldeep Singh Kwatra
 * @version 1.0
 * @since JDK8.0
 */
public class EncryptPassword {

    /**
     * SALT field is used as SALT in hashing so it is kept as constant.
     */
    public static final String SALT = "$2a$08$nv8/8OQhGiZ7wzaFB4SoSO6wQeHErBRARhicAjbv0ZMctopyB0F.W";//"DRIKUTECHNOLOGIES@HASH$BALDEEPSINGHKWATRA";
    private static final String ALGORITHM = "SHA-1";

    /**
     * This method is responsible for Hashing user password by using HASH and
     * SALT Technique.
     * <h1>HASHING</h1><br>
     * Hashing is different from encryption in that once the
     * data is encoded, it can't be decoded. Well, at least it's extremely
     * difficult to do so. Unlike encryption, the output is always of a fixed
     * length, depending on the algorithm you use.
     *
     * Using our phrase from before, and the MD5 algorithm we get ...<br><br>
     *
     * <center> Don't drink the wine. = b290557177ec5dd7098d1de84616dd04
     * </center><br><br>
     *<center> If we try a longer phrase ...</center><br><br>
     *
     * <center> Please don't drink the wine, it tastes terrible. =
     * fd870b20869d9ae05d84e3d7fbed0c94</center><br><br>
     * You will see that the results are both the same length. This means, that
     * multiple inputs could result in the same output, called a collision.<br>
     * Hashing is useful when storing things which you don't need to read back,
     * but you need to check. Passwords are the primary example. Instead of
     * storing the clear text, you store the hashed version. Then, when someone
     * types in their password, you apply the same hashing algorithm and compare
     * it with what you have in the database. If they match, then the gates
     * open. <br>Hash functions can also be used to test whether information has
     * been tampered with. When sending an email, you first share a secret value
     * that only you and the receiver know of. Before sending the email, you
     * sign it with your secret value and produce the hash value. Then send your
     * clear text email (without the secret value) along with the hash value.
     * Your friend can then do the same process and if the hashes are the same,
     * then they know your message hasn't been tampered with along the
     * way.<br><br> This technique is called Message Authentication Code or Hash
     * Based Message Authentication Code. The important factor for hashing
     * algorithms is that they only work one way. The only way to work out the
     * original value, is by brute force. Trying multiple values to see if they
     * produce the same hash. This is particularly problematic with passwords
     * which are generally short and use commonly found words. It wouldn't take
     * a modern computer very long to run through a large dictionary (or use
     * existing rainbow tables) and figure out the hashed result of every common
     * password. That's where salting comes in.
     * <br><br>
     * <h1>SALTING</h1><br>
     * Salting Beside clogging up your arteries, salts) can clog up anyone
     * trying to crack a hashed password. They work by adding an extra secret
     * value to the end of the input, extending the length of the original
     * password.<br><br>
     *
     * Say your password is rocky and the salt value is i.love.salt. The hash
     * value would be made up from both of these together rockyi.love.salt. This
     * provides some protection for those people who use common words as their
     * password. However, if someone learns of the salt value you use, then they
     * just add it to the end (or start) of each dictionary word they try in
     * their attack.<br><br>
     *
     * To make this more difficult you can use random salts, one for each
     * password. It obviously needs to be stored in the database somewhere
     * matched up with the user account, but it does make brute force attacking
     * much more difficult. Finally, you can create a salt from multiple parts,
     * you can use the current date-time, the username, a secret phrase, a
     * random value, or a combination of all of these.
     *
     *
     * @param password to be encrypted
     * @return Encrypted Password
     */
    public static String generateHash(String password) {
        StringBuilder hash = new StringBuilder();
        String input = password + SALT;
        try {
            //get the object of MessageDigest and pass algorithm as argument.
            MessageDigest sha = MessageDigest.getInstance(ALGORITHM);
            //convert the input to hashed bytes
            byte[] hashedBytes = sha.digest(input.getBytes());
            char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
            for (int idx = 0; idx < hashedBytes.length; ++idx) {
                byte b = hashedBytes[idx];
                hash.append(digits[(b & 0xf0) >> 4]);
                hash.append(digits[b & 0x0f]);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hash.toString();
    }
}
