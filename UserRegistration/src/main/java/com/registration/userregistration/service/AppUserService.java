package com.registration.userregistration.service;

import com.registration.userregistration.entity.AppUser;
import com.registration.userregistration.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {
    @Autowired
    private AppUserRepo appUserRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser  = appUserRepo.findByEmail(email);

        if (appUser  == null) {
            throw new UsernameNotFoundException("User  not found with email: " + email);
        }

        // Log the user details for debugging
        System.out.println("User  found: " + appUser .getEmail() + " with role: " + appUser .getRole());

        return User.withUsername(appUser .getEmail())
                .password(appUser .getPassword())
                .roles(appUser .getRole().name()) // Ensure this is a string
                .build();
    }
}