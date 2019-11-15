package com.sda.spring.boot.mvc.security.jdbcauth;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
public class JdbcSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity)
        throws Exception {
        httpSecurity.authorizeRequests()
            .antMatchers("/h2-console/**")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin();

        httpSecurity.csrf()
            .ignoringAntMatchers("/h2-console/**");
        httpSecurity.headers()
            .frameOptions()
            .sameOrigin();
    }
}
