package com.hup.basic.gateway.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SecurityFilterConfiguration {

    @Bean
    public SecurityFilter getSecurityFilter(){
        return new SecurityFilter();
    }
}
