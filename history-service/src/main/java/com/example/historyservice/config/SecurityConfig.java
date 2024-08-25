package com.example.historyservice.config;

import com.example.libs.common.EnableCors;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableCors
@EnableWebSecurity
@Configuration
public class SecurityConfig { }