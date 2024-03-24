package com.esgproject.daaang_univ.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @Bean
        public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
            // Customize your security configuration using http object
            http

                    .authorizeHttpRequests(requests -> requests
                            .requestMatchers("/dmunity/dmunityMainPage").permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/login/**")).permitAll()
                            .requestMatchers("/join/**").permitAll()
                            .anyRequest().authenticated()
                    )
                    .csrf(AbstractHttpConfigurer::disable);

            return http.build();

        }

    }

