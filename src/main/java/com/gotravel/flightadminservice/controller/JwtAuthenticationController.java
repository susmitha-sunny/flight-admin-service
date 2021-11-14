package com.gotravel.flightadminservice.controller;

import com.gotravel.flightadminservice.exception.JwtException;
import com.gotravel.flightadminservice.model.JwtRequest;
import com.gotravel.flightadminservice.model.JwtResponse;
import com.gotravel.flightadminservice.service.JwtUserDetailsService;
import com.gotravel.flightadminservice.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<JwtResponse> execute(@RequestBody final JwtRequest authenticationRequest) throws JwtException {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(final String username, final String password) throws JwtException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new JwtException("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new JwtException("INVALID_CREDENTIALS", e);
        }
    }
}
