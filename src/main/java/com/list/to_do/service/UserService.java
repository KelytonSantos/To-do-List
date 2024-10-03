package com.list.to_do.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
