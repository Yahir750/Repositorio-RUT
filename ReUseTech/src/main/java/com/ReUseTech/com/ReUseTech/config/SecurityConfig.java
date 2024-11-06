package com.ReUseTech.com.ReUseTech.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/public/**", "/login").permitAll()  // Rutas públicas, sin login
                .anyRequest().authenticated()  // Resto de las rutas requieren autenticación
                .and()
                .formLogin()
                .loginPage("/login").permitAll();  // Página de login predeterminada
    }
}
