package com.aaomile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
public class SecurityConfig {

    // create user
    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user = User
        .withUsername("root@123")
        .password("{noop}root")
        .build();
        

        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user);

        return inMemoryUserDetailsManager;
    }

}
