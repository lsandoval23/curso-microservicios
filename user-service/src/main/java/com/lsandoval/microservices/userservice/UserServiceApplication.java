package com.lsandoval.microservices.userservice;

import com.lsandoval.microservices.userservice.model.entity.UserEntity;
import com.lsandoval.microservices.userservice.service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@RequiredArgsConstructor
@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    // Se ejecuta el metodo run antes de la aplicacion principal
    @Override
    public void run(String... args) throws Exception {
        // Creamos dos usuarios en nuestro documento antes de iniciar la aplicacion, esto crea de manera automatica
        // la base de datos configurada en el uri y la coleccion

        userRepository.deleteAll();

        userRepository.save(UserEntity.builder()
                                        .name("Jonathan")
                                        .lastname("Choy")
                                        .email("springcloud@mitocodenetwork.com")
                                        .username("jchoy")
                                        .password("mitocode")
                                        .roles(new String[]{"ROLE_USER"})
                                        .build());

        userRepository.save(UserEntity.builder()
                                        .name("Mitocode")
                                        .lastname("Network")
                                        .email("admin@mitocodenetwork.com")
                                        .username("mitocode")
                                        .password("mitocode")
                                        .roles(new String[]{"ROLE_ADMIN"})
                                        .build());

    }
}
