package com.uts.saberpro.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping({"/", "/home"})
    public String home(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            // Redirigir según el rol
            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_COORDINADOR"))) {
                return "redirect:/estudiantes";
            } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ESTUDIANTE"))) {
                return "redirect:/estudiante";
            }
        }
        return "redirect:/login";
    }
}