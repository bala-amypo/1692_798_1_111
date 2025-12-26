package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Configuration
public class SwaggerConfig {

    // ✅ Primary bean used by SpringDoc
    @Bean
    @Primary
    public OpenAPI api() {
        return new OpenAPI()
                .servers(List.of(
                        new Server().url("https://9217.pro604cr.amypo.ai")
                ));
    }

    // ✅ Secondary bean expected by test cases
    @Bean
    public OpenAPI customOpenAPI() {
        return api();
    }
}
