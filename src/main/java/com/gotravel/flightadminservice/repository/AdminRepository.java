package com.gotravel.flightadminservice.repository;

import com.gotravel.flightadminservice.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Optional<Admin> findByUsernameAndPassword(String username, String password);

    //@Cacheable(value = "adminCache", key = "#username")
    Optional<Admin> findByUsername(String username);
}
