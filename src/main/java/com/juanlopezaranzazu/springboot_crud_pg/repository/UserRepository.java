package com.juanlopezaranzazu.springboot_crud_pg.repository;

import com.juanlopezaranzazu.springboot_crud_pg.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // validar si el correo existe
    boolean existsByEmail(String email);

    // validar si el correo existe y es diferente al correo actual del usuario
    boolean existsByEmailAndIdNot(String email, Long id);
}
