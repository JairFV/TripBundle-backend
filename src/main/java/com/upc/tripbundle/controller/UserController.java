package com.upc.tripbundle.controller;

import com.upc.tripbundle.dtos.UserDto;
import com.upc.tripbundle.security.JwtResponse;
import com.upc.tripbundle.security.JwtTokenUtil;
import com.upc.tripbundle.serviceimplements.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trip")
@CrossOrigin
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticateUser(@RequestBody UserDto user) throws Exception {
        authenticateUser(user.getUsername(), user.getPassword());
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(user.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }
    private void authenticateUser(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch(DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        }catch(BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

    }
}
