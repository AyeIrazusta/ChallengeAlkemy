/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.disney.challenge.auth.config;

import com.disney.challenge.auth.filter.JwtRequestFilter;
import com.disney.challenge.auth.service.UserDetailsCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsCustomService userDetailsCustomService;
    private JwtRequestFilter jwtRequestFilter;

    @Autowired 
    public void setAttributes(UserDetailsCustomService userDetailsCustomService, @Lazy JwtRequestFilter jwtRequestFilter) 
    { this.userDetailsCustomService = userDetailsCustomService; this.jwtRequestFilter = jwtRequestFilter; }
   
    //DETALLE DE USUARIOS
    @Override 
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { auth.userDetailsService(userDetailsCustomService); }

    //ACA NO ESTOY ENCRIPTANDO LA CONTRASEÑA
    @Bean 
    public PasswordEncoder passwordEncoder() { return NoOpPasswordEncoder.getInstance(); }
      
    //MANEJADOR DE LA AUTENTIFICACIÓN
    //SPRING SECURITY
    @Override 
    @Bean 
    public AuthenticationManager authenticationManagerBean() throws Exception { return super.authenticationManagerBean(); }
    
    //CONFIGURARA EL HTTP SECURITY
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests().antMatchers("/auth/*" ).permitAll()// CONFIGURO A QUE ENDPOINT NO LE APLICO SEGURIDAD 
                .anyRequest().authenticated()
                .and().exceptionHandling()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);//POR DEFECTO SPRING SECURITY ES STATEFULL, POR LO QUE NO VUELVE A PEDIR AUTENTIFICACIÓN CADA VEZ QUE SE INGRESA A UN ENDPOINT

        
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
    
}

