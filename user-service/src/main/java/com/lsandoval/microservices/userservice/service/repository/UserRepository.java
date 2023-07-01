package com.lsandoval.microservices.userservice.service.repository;

import com.lsandoval.microservices.userservice.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// Anotacion de spring data rest, expone a userEntity y su CRUD como endpoints http, ademas de registrarlo como bean
// Ya no es necesario anotarlo con la anotacion @Repository

@RepositoryRestResource(path = "user")
public interface UserRepository extends CrudRepository<UserEntity, String> {

}
