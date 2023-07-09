package com.lsandoval.microservices.userservice.service.repository;

import com.lsandoval.microservices.userservice.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

// Anotacion de spring data rest, expone a userEntity y su CRUD como endpoints http, ademas de registrarlo como bean
// Ya no es necesario anotarlo con la anotacion @Repository

@RepositoryRestResource(path = "user")
public interface UserRepository extends CrudRepository<UserEntity, String>, PagingAndSortingRepository<UserEntity, String> {

    // Podemos definir nuevos endpoints, para querys específicos, en este caso para obtener users en base al email
    @RestResource(path = "email")
    List<UserEntity> getAllByEmail(String email);

    @RestResource(path = "role")
    List<UserEntity> getAllByRoles(String roles);

    // De esta manera bloqueamos el endpoint para poder eliminar elementos.
    @RestResource(exported = false)
    void deleteById(String id);
}
