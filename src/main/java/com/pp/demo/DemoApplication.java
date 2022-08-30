package com.pp.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pp.demo.data.NBAPlayer;
import com.pp.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/players/list")
                        .allowedOrigins("*")
                        .allowedMethods("*")
                        .allowedHeaders("*");
            }
        };
    }

    @Bean
    CommandLineRunner runner(PlayerService playerService) {
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<NBAPlayer>> typeReference = new TypeReference<List<NBAPlayer>>() {
            };
            InputStream inputStream = TypeReference.class.getResourceAsStream("/response.json");
            try {
                List<NBAPlayer> users = mapper.readValue(inputStream, typeReference);
                playerService.save(users);
                System.out.println("Users Saved:)");
            } catch (IOException e) {
                System.out.println("Unable to save users: " + e.getMessage());
            }
        };
    }
}
