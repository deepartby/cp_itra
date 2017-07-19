package com.itransition.security.config;

import com.itransition.security.details.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.vkontakte.connect.VKontakteConnectionFactory;
import org.springframework.stereotype.Component;
import ru.simplex_software.security.ulogin.UloginAuthenticationFilter;
import ru.simplex_software.security.ulogin.UloginAuthentifiactionProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/index.html").permitAll()
            .antMatchers("/sign-up/**").permitAll()
            .antMatchers("/paint/**").authenticated()
            .antMatchers("/info/**").authenticated()
            .antMatchers("/info").authenticated()
            .and()
            .formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/info").failureHandler(new AuthFailureHandler())
            .and()
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll()
            .and()
            .csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
    }

    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Component
    public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {

        private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        @Override
        public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
                throws IOException, ServletException {
            redirectStrategy.sendRedirect(request, response, "/login");
        }
    }
    @Autowired
    private ConnectionFactoryLocator connectionFactoryLocator;

}
