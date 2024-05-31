package com.example.security.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfiguration  {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails majd = User.builder()
                .username("majd")
                .password("{noop}123")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(majd);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET,"/").permitAll()
                        .requestMatchers(HttpMethod.GET,"/user").hasRole("USER")
                        .requestMatchers(HttpMethod.GET,"/admin").hasRole("ADMIN")

        );
        http.httpBasic();
        http.formLogin();
        http.csrf().disable();
        return http.build();
    }
}
