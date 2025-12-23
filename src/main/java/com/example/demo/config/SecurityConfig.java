package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // 1. Disable CSRF for API development
            .csrf(AbstractHttpConfigurer::disable)
            
            // 2. Allow specific public paths
            .authorizeHttpRequests(auth -> auth
                // Authentication endpoints
                .requestMatchers("/auth/**").permitAll()
                
                // Swagger UI and OpenAPI documentation paths
                .requestMatchers(
                    "/v3/api-docs/**",
                    "/v3/api-docs.yaml",
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/webjars/**",
                    "/swagger-resources/**",
                    "/configuration/ui",
                    "/configuration/security"
                ).permitAll()
                
                // Root path (often used for health checks or initial preview)
                .requestMatchers("/").permitAll()
                
                // Everything else under /api/ must be authenticated
                .anyRequest().authenticated()
            )
            
            // 3. Handle Iframe headers (Needed for many Cloud IDE previews)
            .headers(headers -> headers.frameOptions(frame -> frame.disable()))
            
            // 4. Set session management to stateless
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        
        return http.build();
    }
}