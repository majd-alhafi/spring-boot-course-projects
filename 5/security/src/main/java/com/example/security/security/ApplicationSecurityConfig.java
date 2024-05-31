package com.example.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.security.Security;

@Configuration
public class ApplicationSecurityConfig {
    /*@Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder()
                .username("majd")
                .password("{noop}123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("omar")
                .password("{noop}123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails lana = User.builder()
                .username("lana")
                .password("{noop}lana")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john,mary,lana); //
        //This Method will be used by Spring, to create 3 users with their passwords and roles.
    }*/
    /*@Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
        //This Method will be used by Spring, to get the users defined in the database (default schema)
    }*/

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        String userQuery = "select user_id, pw, active from members where user_id=?";
        String authoritiesQuery = "select user_id, role from roles where user_id=?";
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery(userQuery);
        userDetailsManager.setAuthoritiesByUsernameQuery(authoritiesQuery);
        return userDetailsManager;
        ////This Method will be used by Spring, to get the users defined in the database (custom schema)
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
            configurer
                    .requestMatchers(HttpMethod.GET,"/api/members").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.GET,"/api/members/**").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.POST,"/api/members").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.PUT,"/api/members/**").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.DELETE,"/api/members/**").hasRole("ADMIN")
        );
        http.httpBasic();
        http.csrf().disable();
        return http.build();
    }
}
