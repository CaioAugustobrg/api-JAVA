package com.example.demo.repository;

import com.example.demo.model.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);

    List<User> findAll();
    User create(User user);
    void deleteById(Long id);
}