package com.registration.userregistration.dto;

import com.registration.userregistration.entity.AppUser;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterDto {
    @NotEmpty
    private String fname;

    @NotEmpty
    private String lname;

    @NotEmpty
    @Email
    private String email;

    private String phone; // optional

    private String address; // optional

    @Size(min = 6, message = "Minimum Password length is 6 characters")
    private String password;

    private String confirmPassword;

    private AppUser.Role role; // Use the enum for role

    private Integer studentId;
}
