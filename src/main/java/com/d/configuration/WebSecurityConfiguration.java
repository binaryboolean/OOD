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
package com.d.configuration;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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
@ComponentScan({"com.d"})
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select user_email,password,enabled from ood_users where user_email=?")
                .authoritiesByUsernameQuery(
                        "select user_email, user_role from ood_user_roles where user_email=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/**/provider/**").access("hasRole('ROLE_PROVIDER')");
        http.authorizeRequests()
                .antMatchers("/**/consumer/**").access("hasRole('ROLE_CONSUMER')");
        http.authorizeRequests()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");
        
        http.formLogin().loginProcessingUrl("/checkLogin")
                .defaultSuccessUrl("/")
                .loginPage("/welcome")
                .failureUrl("/?error")
                .usernameParameter("email").passwordParameter("password");

        http.logout().logoutUrl("/logout").logoutSuccessUrl("/");

        http.exceptionHandling().accessDeniedPage("/invalidAccess.html");

        http.csrf().disable();

    }

}
