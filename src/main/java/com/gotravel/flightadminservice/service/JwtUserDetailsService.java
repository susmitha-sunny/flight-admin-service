package com.gotravel.flightadminservice.service;

import java.util.ArrayList;
import java.util.Optional;

import com.gotravel.flightadminservice.entity.Admin;
import com.gotravel.flightadminservice.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        Optional<Admin> admin = adminRepository.findByUsername(username);
        if (admin.isPresent()) {
            return new User(admin.get().getUsername(), admin.get().getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("Admin User not found with username: " + username);
        }
    }
}
