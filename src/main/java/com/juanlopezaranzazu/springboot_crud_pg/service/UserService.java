package com.juanlopezaranzazu.springboot_crud_pg.service;

import com.juanlopezaranzazu.springboot_crud_pg.dto.UserDTO;
import com.juanlopezaranzazu.springboot_crud_pg.entity.User;
import com.juanlopezaranzazu.springboot_crud_pg.exception.BadRequestException;
import com.juanlopezaranzazu.springboot_crud_pg.exception.ResourceNotFoundException;
import com.juanlopezaranzazu.springboot_crud_pg.mapper.UserMapper;
import com.juanlopezaranzazu.springboot_crud_pg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    // obtener todos los usuarios
    public List<UserDTO> getAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(userMapper::mapToUserDTO)
                .collect(Collectors.toList());
    }

    // obtener un usuario por su id
    public UserDTO getUserById(Long id) {
        // verificar si el usuario existe
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario con ID " + id + " no encontrado"));
        return userMapper.mapToUserDTO(user);
    }

    // crear un usuario
    public UserDTO createUser(UserDTO userDTO){
        // verificar si el correo existe
        if(userRepository.existsByEmail(userDTO.getEmail())){
            throw new BadRequestException("El email " + userDTO.getEmail() + " ya está en uso");
        }
        User user = userMapper.mapToUser(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.mapToUserDTO(savedUser);
    }

    // editar un usuario por su id
    public UserDTO updateUser(Long id, UserDTO userDTO){
        // verificar si el usuario existe
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario con ID " + id + " no encontrado"));
        // verificar si el correo existe
        if (userRepository.existsByEmailAndIdNot(userDTO.getEmail(), id)) {
            throw new BadRequestException("El email " + userDTO.getEmail() + " ya está en uso");
        }
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        User updatedUser = userRepository.save(user);
        return userMapper.mapToUserDTO(updatedUser);
    }

    // eliminar un usuario por su id
    public void deleteUser(Long id) {
        // verificar si el usuario existe
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario con ID " + id + " no encontrado"));
        userRepository.delete(user);
    }
}
