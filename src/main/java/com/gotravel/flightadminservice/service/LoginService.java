package com.gotravel.flightadminservice.service;

import com.gotravel.flightadminservice.entity.Admin;
import com.gotravel.flightadminservice.exception.ValueNotFoundException;
import com.gotravel.flightadminservice.model.LoginRequest;
import com.gotravel.flightadminservice.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin verifyAdmin(final LoginRequest loginRequest) throws ValueNotFoundException {
        Optional<Admin> admin = adminRepository.findByUsernameAndPassword(loginRequest.getUsername(),
                loginRequest.getPassword());
        if (admin.isPresent()) {
            return admin.get();
        }
        throw new ValueNotFoundException("Wrong credentials. Admin not found.");
    }
}
