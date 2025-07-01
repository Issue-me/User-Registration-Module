package com.registration.userregistration.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class AppUser  implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fname;
    private String lname;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role; // Use the enum for role

    private String phone;
    private String address;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date(); // Initialize to current date

    // New fields for account management
    private boolean accountNonExpired = true; // Default to true
    private boolean accountNonLocked = true; // Default to true
    private boolean credentialsNonExpired = true; // Default to true
    private boolean enabled = true; // Default to true

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> role.name()); // Assuming role is a String like "ROLE_USER"
    }

    @Override
    public String getUsername() {
        return email; // or return the username if you have one
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired; // Return the actual value
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked; // Return the actual value
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired; // Return the actual value
    }

    @Override
    public boolean isEnabled() {
        return enabled; // Return the actual value
    }

    public enum Role {
        STUDENT,
        ADMIN,
        TEACHER,
        PARENT
    }
}