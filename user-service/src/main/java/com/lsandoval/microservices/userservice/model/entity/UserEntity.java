package com.lsandoval.microservices.userservice.model.entity;


import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "user")
public class UserEntity {

    @Id
    private String id;
    @NonNull
    private String name;
    @NonNull
    private String lastname;
    @NonNull
    private String username;
    private String email;
    private String password;
    private String[] roles;
}
