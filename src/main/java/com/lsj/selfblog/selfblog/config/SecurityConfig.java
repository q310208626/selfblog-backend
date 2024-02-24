package com.lsj.selfblog.selfblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {

        try {
            http.authorizeHttpRequests((auth) -> {
                auth.requestMatchers("/authticate", "/login","/selfblog/authticate","/selfblog/login").permitAll()
                        .anyRequest().authenticated();

            })
                        .formLogin((formLogin) -> {
                            // formLogin.usernameParameter("username");
                        })
                    .csrf((csrf) -> {
                        csrf.disable();
                    });
            return http.build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
