package com.tabeldata.pln.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/webjars/**", "/home", "/user/new", "/user/role", "/error").permitAll()
                .antMatchers("/pelanggan/list", "/pelanggan/new","/pelanggan/add-saldo","/pelanggan/add-token","/jasper/**").access("hasRole('USER') or hasRole('ADMIN')")
                .antMatchers("/pelanggan/list", "/user/list","/user/aktivasi","/user/role").access("hasRole('ADMIN')")
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login-form").defaultSuccessUrl("/home").permitAll()
                .and().logout().logoutSuccessUrl("/home").permitAll();
    }
}
