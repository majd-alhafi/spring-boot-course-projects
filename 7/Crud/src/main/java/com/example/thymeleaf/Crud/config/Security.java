package com.example.thymeleaf.Crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Security {
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        User majd = (User) User.builder()
                .username("majd")
                .password("{noop}123")
                .authorities("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(majd);
    }
}
