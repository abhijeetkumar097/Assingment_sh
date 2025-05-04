package com.example.Assignment.config;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.Assignment.entity.Incident;
import com.example.Assignment.enums.Severity;
import com.example.Assignment.repository.IncidentRepo;

@Configuration
public class DataSeeder {
    
    @Bean
    CommandLineRunner seedDatabase(IncidentRepo incidentRepo) {
        return args -> {
            if(incidentRepo.count() == 0) {
                incidentRepo.save(new Incident("Server Down", "Main server is not responding", Severity.HIGH, LocalDateTime.now()));
                incidentRepo.save(new Incident("Login Failure", "User unable to login", Severity.MEDIUM, LocalDateTime.now()));
                System.out.println("Database seeded successfully");
            }
        };
    }
}
