package com.rays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Main entry point for Project ORS Application.
 * <p>
 * This class bootstraps the Spring Boot application and configures global CORS
 * settings to allow requests from specified origins.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
@SpringBootApplication
public class ProjectOrsApplication {

    /**
     * Main method to start the Spring Boot application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ProjectOrsApplication.class, args);
        System.out.println("Project-10 has been started on http://localhost:8080");
    }

    /**
     * Configures Cross-Origin Resource Sharing (CORS) for the application.
     * <p>
     * Allows requests from Angular frontend (localhost:4200) and other specified
     * origins with common HTTP methods and headers.
     * </p>
     *
     * @return WebMvcConfigurer instance with CORS mappings
     */
    @Bean
    public WebMvcConfigurer corsConfig() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200", "http://localhost:8081", "http://localhost:8080")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
