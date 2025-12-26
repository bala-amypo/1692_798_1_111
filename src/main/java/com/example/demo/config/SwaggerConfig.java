package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    // ✅ ONLY OpenAPI bean (required by SpringDoc + tests)
    @Bean
    public OpenAPI api() {
        return buildOpenAPI();
    }

    // ❌ NOT a bean — helper method only
    private OpenAPI buildOpenAPI() {
        return new OpenAPI()
                .servers(List.of(
                        new Server().url("https://9217.pro604cr.amypo.ai")
                ));
    }
}
