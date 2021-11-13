package com.gotravel.flightadminservice.controller;

import com.gotravel.flightadminservice.entity.Admin;
import com.gotravel.flightadminservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping(value = "/admin/{id}")
    public Admin execute(@PathVariable("id") final int id) throws Exception {
            return adminService.getAdmin(id);
    }
}
