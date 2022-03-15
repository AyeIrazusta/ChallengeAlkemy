/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.disney.challenge.auth.controller;

import com.disney.challenge.auth.dto.AuthenticationRequest;
import com.disney.challenge.auth.dto.AuthenticationResponse;
import com.disney.challenge.auth.dto.UserDTO;
import com.disney.challenge.auth.service.UserDetailsCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/auth")
public class UserAuthController {

    private final UserDetailsCustomService userDetailsCustomService;
      

    @Autowired 
    public UserAuthController(UserDetailsCustomService userDetailsCustomService){ 
        this.userDetailsCustomService = userDetailsCustomService; }
 
    @PostMapping("/signup") 
    public ResponseEntity<AuthenticationResponse> signUp(@Valid @RequestBody UserDTO dto) { 
        userDetailsCustomService.save(dto); 
        return ResponseEntity.status(HttpStatus.CREATED).build(); }

    @PostMapping("/signin") 
    public ResponseEntity<AuthenticationResponse> signIn(@RequestBody AuthenticationRequest authRequest) throws Exception {
        final String jwt = userDetailsCustomService.signIn(authRequest); 
        return ResponseEntity.ok(new AuthenticationResponse(jwt)); }
}

