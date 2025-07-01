package com.registration.userregistration.repo;

import com.registration.userregistration.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<AppUser, Integer> {
    Optional<AppUser> findByEmail(String email); // Method to find user by email
}