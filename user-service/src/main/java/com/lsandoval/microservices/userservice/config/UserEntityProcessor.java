package com.lsandoval.microservices.userservice.config;

import com.lsandoval.microservices.userservice.model.entity.UserEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;

@Configuration
public class UserEntityProcessor implements RepresentationModelProcessor<EntityModel<UserEntity>> {


    // Solo devolvemos lo correspondiente al modelo UserEntity en las consultas (Eliminamos datos innecesarios)
    @Override
    public EntityModel<UserEntity> process(EntityModel<UserEntity> model) {
        return EntityModel.of(model.getContent());
    }
}
