package com.list.to_do.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.list.to_do.DTO.UserDTO;
import com.list.to_do.entities.User;
import com.list.to_do.exceptions.ResourceNotFound;
import com.list.to_do.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<List<User>> findAllActive() {
        return userRepository.findAllActive();
    }

    public User findActiveById(UUID id) {
        return userRepository.findActiveById(id).orElseThrow(() -> new ResourceNotFound(id));
    }

    public User insert(UserDTO userDTO) {
        userRepository.findActiveByEmail(userDTO.email()).orElseThrow(() -> new ResourceNotFound(userDTO.email()));
        User userToSave = new User(userDTO.name(), userDTO.email(), userDTO.password(), Instant.now());

        return userRepository.save(userToSave);
    }

    public User deleteById(UUID id) {
        User userToDelete = userRepository.findActiveById(id).orElseThrow(() -> new ResourceNotFound(id));

        userToDelete.setDeletedAt(Instant.now());

        return userRepository.save(userToDelete);
    }
}
