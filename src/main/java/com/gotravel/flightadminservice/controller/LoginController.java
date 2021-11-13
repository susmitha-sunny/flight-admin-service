package com.gotravel.flightadminservice.controller;

import com.gotravel.flightadminservice.entity.Admin;
import com.gotravel.flightadminservice.model.LoginRequest;
import com.gotravel.flightadminservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping(value = "/flight-admin-service/login")
    public Admin execute(@RequestBody final LoginRequest loginRequest) throws Exception {
            return loginService.verifyAdmin(loginRequest);
    }
}
