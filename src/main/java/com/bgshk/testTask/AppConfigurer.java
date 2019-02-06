package com.bgshk.testTask;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class AppConfigurer implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/departments")
                .allowedOrigins("http://localhost:8080", "http://localhost:3000")
                .allowedHeaders("Access-Control-Allow-Origin", "*")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE");
    }
}
