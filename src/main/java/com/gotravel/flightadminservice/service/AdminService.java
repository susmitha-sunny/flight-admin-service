package com.gotravel.flightadminservice.service;

import com.gotravel.flightadminservice.entity.Admin;
import com.gotravel.flightadminservice.exception.ValueNotFoundException;
import com.gotravel.flightadminservice.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    //@Cacheable(value = "adminCache", key = "#id")
    public Admin getAdmin(final int id) throws ValueNotFoundException {
        Optional<Admin> admin = adminRepository.findById(id);
        if (admin.isPresent()) {
            return admin.get();
        }
        throw new ValueNotFoundException("Admin not found");

    }
}
