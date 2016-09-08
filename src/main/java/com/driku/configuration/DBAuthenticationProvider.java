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
package com.driku.configuration;

/**
 *
 * @author Baldeep Singh Kwatra
 */
import com.driku.constants.UserConstants;
import com.driku.ood.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component("authenticationProvider")
public class DBAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private UserService userService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        try {
            String password = (String) authentication.getCredentials();
            password = BCrypt.hashpw(password, UserConstants.SALT);

            com.driku.model.User user = userService.authenticateUser(username, password);
            if (user != null) {
                final List<GrantedAuthority> auths;
                if (!user.getUserRole().isEmpty()) {
                    auths = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getUserRole());
                } else {
                    auths = AuthorityUtils.NO_AUTHORITIES;
                }
                return new User(user.getUserEmail(), password, auths);
            }

        } catch (Exception repositoryProblem) {
            throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        }

        throw new InternalAuthenticationServiceException(
                "UserDetailsService returned null, which is an interface contract violation");
    }
}