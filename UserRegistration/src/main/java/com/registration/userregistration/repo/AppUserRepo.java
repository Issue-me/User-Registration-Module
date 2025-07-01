package com.registration.userregistration.repo;

import com.registration.userregistration.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, Integer> {
    public AppUser findByEmail(String email);
}

