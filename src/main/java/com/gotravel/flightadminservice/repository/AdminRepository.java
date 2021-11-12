package com.gotravel.flightadminservice.repository;

import com.gotravel.flightadminservice.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    @Query(value = "SELECT * FROM admin a where a.admin_id = ?1", nativeQuery = true)
    Optional<Admin> getAdmin(int i);
}
