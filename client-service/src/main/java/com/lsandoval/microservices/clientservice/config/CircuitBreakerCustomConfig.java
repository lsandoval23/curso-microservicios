package com.lsandoval.microservices.clientservice.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class CircuitBreakerCustomConfig {

    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> overrideDefaultConfig(){
        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
                .circuitBreakerConfig(CircuitBreakerConfig.custom()
                        .slidingWindowSize(15)      //  Default 100
                        .failureRateThreshold(30)   // Default 50%
                        .waitDurationInOpenState(Duration.ofSeconds(20L))       // Default 60s
                        .permittedNumberOfCallsInHalfOpenState(10)              // Default 10
                        .slowCallDurationThreshold(Duration.ofMillis(1500L))    // Default 1s
                        .slowCallRateThreshold(10)
                        .build())
                .timeLimiterConfig(TimeLimiterConfig.custom()
                        .timeoutDuration(Duration.ofSeconds(3L))
                        .build())
                .build());
    }


}
