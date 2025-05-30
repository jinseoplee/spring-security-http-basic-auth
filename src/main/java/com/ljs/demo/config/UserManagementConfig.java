package com.ljs.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserManagementConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        var userDetailsManager = new InMemoryUserDetailsManager();

        var admin = User.withUsername("admin")
                .password("1234")
                .roles("ADMIN")
                .build();

        var manager = User.withUsername("manager")
                .password("1234")
                .roles("MANAGER")
                .build();

        var user = User.withUsername("user")
                .password("1234")
                .roles("USER")
                .build();

        userDetailsManager.createUser(admin);
        userDetailsManager.createUser(manager);
        userDetailsManager.createUser(user);

        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
