package com.registration.userregistration.controller;

import com.registration.userregistration.dto.RegisterDto;
import com.registration.userregistration.entity.AppUser;
import com.registration.userregistration.repo.AppUserRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    @Autowired
    private AppUserRepo appUserRepo;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        RegisterDto registerDto = new RegisterDto();
        model.addAttribute("registerDto", registerDto);
        model.addAttribute("success", false);
        return "register"; // Ensure this matches your Thymeleaf template name
    }

    @PostMapping("/register")
    public String register(Model model, @Valid @ModelAttribute RegisterDto registerDto, BindingResult result) {
        // Validate passwords and check for existing users
        if (!registerDto.getPassword().equals(registerDto.getConfirmPassword())) {
            result.addError(new FieldError("registerDto", "confirmPassword", "Passwords do not match"));
        }

        // Check if the email is already used
        AppUser existingUser  = appUserRepo.findByEmail(registerDto.getEmail());
        if (existingUser  != null) {
            result.addError(new FieldError("registerDto", "email", "Email is already used"));
        }

        if (result.hasErrors()) {
            return "register"; // Return to the form with errors
        }

        try {
            // Create a new user based on the role
            AppUser  newUser  = new AppUser ();
            newUser .setFname(registerDto.getFname());
            newUser .setLname(registerDto.getLname());
            newUser .setEmail(registerDto.getEmail());
            newUser .setPhone(registerDto.getPhone());
            newUser .setAddress(registerDto.getAddress());
            newUser .setPassword(new BCryptPasswordEncoder().encode(registerDto.getPassword())); // Use the password from the form
            newUser .setRole(registerDto.getRole()); // Set the role directly from RegisterDto

            // Save the user
            appUserRepo.save(newUser );

            model.addAttribute("registerDto", new RegisterDto());
            model.addAttribute("success", true);
        } catch (Exception e) {
            result.addError(new FieldError("registerDto", "fname", e.getMessage()));
        }

        return "register"; // Return to the registration form
    }
}