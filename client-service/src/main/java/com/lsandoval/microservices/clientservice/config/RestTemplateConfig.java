package com.lsandoval.microservices.clientservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean("default")
    public RestTemplate configRestTemplate(){
        return  new RestTemplate();
    }

}
