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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author baldeep
 */
@Configuration
@EnableWebSecurity
@ComponentScan({"com.driku"})
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthenticationProvider authenticationProvider;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/provider/**").access("hasRole('ROLE_PROVIDER')");
        http.authorizeRequests()
                .antMatchers("/consumer/**").access("hasRole('ROLE_CONSUMER')");
        http.authorizeRequests()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");

        http.formLogin().loginProcessingUrl("/checkLogin")
                .defaultSuccessUrl("/")
                .loginPage("/")
                .failureUrl("/?error")
                .usernameParameter("email").passwordParameter("password");

        http.logout().logoutUrl("/logout").logoutSuccessUrl("/");
        http.exceptionHandling().accessDeniedPage("/invalidAccess");
        http.csrf().disable();

    }
}
