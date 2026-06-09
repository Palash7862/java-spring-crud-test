package com.sam.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {

        return new OpenAPI()
                .info(
                        new Info()
                                .title("Ecommerce Store API")
                                .version("2.5")
                                .description("Ecommerce Spring Boot 4 Learning Project")
                );
    }
}
