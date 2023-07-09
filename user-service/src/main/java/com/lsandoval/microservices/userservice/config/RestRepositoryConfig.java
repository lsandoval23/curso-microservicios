package com.lsandoval.microservices.userservice.config;

import com.lsandoval.microservices.userservice.model.entity.UserEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

// Implementamos la interfaz RepositoryRestConfigurer para configurar comportamientos del rest repository
@Configuration
public class RestRepositoryConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        // Exponemos el id en la respuesta HTTP para la clase UserEntity
        config.exposeIdsFor(UserEntity.class);
    }
}
