package com.ljs.demo.config;

import com.ljs.demo.security.CustomAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebAuthorizationConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .requestMatchers("/manager").hasAnyRole("ADMIN", "MANAGER")
                        .anyRequest().authenticated()
                )
                .httpBasic(httpBasic -> httpBasic
                        .authenticationEntryPoint(new CustomAuthenticationEntryPoint("MyApp")));

        return http.build();
    }
}
