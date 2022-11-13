package com.epam.beautysalonspring.repository.impl;

import com.epam.beautysalonspring.model.User;
import com.epam.beautysalonspring.model.enums.Role;
import com.epam.beautysalonspring.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class UserRepositoryImpl implements UserRepository {

    private static HashMap<Long, User> users = new HashMap<>();
    private Long entityId = 0L;

    @Override
    public User findById(Long userId) {
        log.info("Layer: {}, Searching for user with id: {} ", this.getClass().getSimpleName(), userId);
        return users.values().stream()
                .filter(user ->
                        user.getId().equals(userId))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public User findByEmail(String email) {
        log.info("Layer: {}, Searching for user with email: {}", this.getClass().getSimpleName(), email);
        return users.values().stream()
                .filter(user ->
                        user.getEmail().equals(email))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public List<User> findByRole(Role role) {
        log.info("Layer: {}, Searching for users with Role: {}", this.getClass().getSimpleName(), role);
        return users.values().stream()
                .filter(user ->
                        user.getRole().equals(role))
                .collect(Collectors.toList());
    }

    @Override
    public User create(User user) {
        log.info("Layer: {}, Creating user: {}", this.getClass().getSimpleName(), user);
        user.setId(entityId++);
        users.put(user.getId(), user);
        return users.get(user.getId());
    }

    @Override
    public User update(User user) {
        log.info("Layer: {}, Updating User: {}", this.getClass().getSimpleName(), user);
        users.put(user.getId(), user);
        return users.get(user.getId());
    }
}
