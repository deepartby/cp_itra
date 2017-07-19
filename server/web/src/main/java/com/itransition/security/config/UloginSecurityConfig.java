package com.itransition.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import ru.simplex_software.security.ulogin.UloginAuthenticationFilter;
import ru.simplex_software.security.ulogin.UloginAuthentifiactionProvider;

/**
 * Created by top_user on 7/10/2017.
 */

public class UloginSecurityConfig extends WebSecurityConfigurerAdapter {

    AuthenticationManager authManager;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new UloginAuthentifiactionProvider("example.org"))
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        UloginAuthenticationFilter uloginFilter = new UloginAuthenticationFilter("/ulogin");
        uloginFilter.setAuthenticationManager(authenticationManager());

        HttpSecurity httpSecurity = http.
                addFilterBefore(uloginFilter, AnonymousAuthenticationFilter.class);
        httpSecurity.authorizeRequests().antMatchers("/login.html").permitAll()
                .anyRequest().authenticated() ;
        httpSecurity.formLogin().loginPage("/login.html");

    }
}
