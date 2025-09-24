package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //處理CROS(Cross-Origin Resource Sharing)問題，前後端port不同，(不同origin)互打被網頁安全機制擋掉
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**") // 允許 API 路徑
                        .allowedOrigins("http://localhost:5173") // 允許前端來源
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 允許的方法
                        .allowCredentials(true);
            }
        };
    }
}