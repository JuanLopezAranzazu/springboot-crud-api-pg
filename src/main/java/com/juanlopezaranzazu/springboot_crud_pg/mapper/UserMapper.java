package com.juanlopezaranzazu.springboot_crud_pg.mapper;

import com.juanlopezaranzazu.springboot_crud_pg.dto.UserDTO;
import com.juanlopezaranzazu.springboot_crud_pg.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO mapToUserDTO(User user){
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    public User mapToUser(UserDTO userDTO){
        return new User(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getEmail()
        );
    }
}
