package com.example.demo.repository;

import com.example.demo.model.entities.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class UserRepositoryImp implements UserRepository {
    private List<User> users = new ArrayList<>();
    private long nextId = 1;
    @Override
    public Optional<User> findById(Long id) {
        return users.stream()
        .filter(user -> user.getId().equals(id))
        .findFirst();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return users.stream()
        .filter(user -> user.getEmail().equals(email))
        .findFirst();
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User create(User user) {
        if (user.getId() == null) {
            user.setId(nextId++);
        } else {
            users.removeIf(existingUser -> existingUser.getId().equals(user.getId()));
        }
        users.add(user);
        return user;
    }

    @Override
    public void deleteById(Long id) {
        users.removeIf(user ->user.getId().equals(id));
    }
}
