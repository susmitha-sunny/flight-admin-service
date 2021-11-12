/**
 * Package for controllers
 */
package com.gotravel.flightadminservice.controller;

import com.gotravel.flightadminservice.entity.Admin;
import com.gotravel.flightadminservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping(value = "/testadmin")
    public Admin execute() throws Exception{
        int i = 4;
            return adminService.getAdmin(i);
    }
}
