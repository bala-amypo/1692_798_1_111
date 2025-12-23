package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication", description = "Endpoints for public registration and login")
public class AuthController {

    // Note: Implementation logic usually goes to a AuthService/SecurityManager
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest request) {
        // Logic for user registration
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        // Logic for JWT generation
        return ResponseEntity.ok(new AuthResponse("mock-jwt-token"));
    }
}