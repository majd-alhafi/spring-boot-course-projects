package com.example.springsecurityjdbc.configurations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET,"/admin").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/user").hasRole("USER")
                        .requestMatchers(HttpMethod.GET,"/").permitAll()
        );
        http.formLogin();
        http.httpBasic();
        http.csrf().disable();
        return http.build();
    }
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        String userQuery = "select username, password, enabled from users where username=?";
        String authoritiesQuery = "select username, authority from authorities where username=?";
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery(userQuery);
        userDetailsManager.setAuthoritiesByUsernameQuery(authoritiesQuery);
        return userDetailsManager;
    }

    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy(roleHierarchyString());
        return roleHierarchy;
    }

    @Bean
    public String roleHierarchyString() {
        return "ROLE_ADMIN > ROLE_USER";
    }

}
