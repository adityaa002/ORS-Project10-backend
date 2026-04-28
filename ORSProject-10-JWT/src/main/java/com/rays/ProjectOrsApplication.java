package com.rays;

 import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
 import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ProjectOrsApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProjectOrsApplication.class, args);
		System.out.println("Project-10 has been started on http://localhost:8080");

	}

	@Bean
	public WebMvcConfigurer corsConfig() {
		
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:4200", "http://localhost:8081" ,"http://localhost:8080" )
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS").allowedHeaders("*")
						.allowCredentials(true);
			}

		};

	}
}